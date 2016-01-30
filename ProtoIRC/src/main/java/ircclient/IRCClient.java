/*
 * Copyright (C) 2015 Michael
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package ircclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ircservice.IRCMessage;
import ircservice.IRCServiceGrpc;
import ircservice.JoinReply;
import ircservice.JoinRequest;
import ircservice.PostMessageReply;
import ircservice.PostMessageRequest;
import ircservice.RetrieveReply;
import ircservice.RetrieveRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class IRCClient {

    private static final Logger logger = Logger.getLogger(IRCClient.class.getName());

    private final ManagedChannel channel;
    private final IRCServiceGrpc.IRCServiceBlockingStub blockingStub;

    private Thread updaterThread;
    private static volatile boolean updater = true;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public IRCClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();
        blockingStub = IRCServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public boolean join(String roomName) {
        try {
            JoinRequest joinReq = JoinRequest.newBuilder().setChannelName(roomName).build();
            JoinReply reply = blockingStub.joinChannel(joinReq);
            return reply.getIsNew();
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return false;
        }
    }

    public boolean sendMessage(String chatRoom, String nickName, String message, long timestamp) {
        try {
            PostMessageRequest postReq = PostMessageRequest.newBuilder().setChannelName(chatRoom).setNick(nickName).setTheMessage(message).setTimestamp(timestamp).build();
            PostMessageReply reply = blockingStub.sendMessage(postReq);
            return reply.getIsSuccess();
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return false;
        }
    }

    public List<String> retrieveMsg(String channelName, long timestamp) {
        try {
            List<String> ret = new ArrayList<>();
            RetrieveRequest retReq = RetrieveRequest.newBuilder().setChannelName(channelName).setTimestamp(timestamp).build();
            RetrieveReply reply = blockingStub.getMessages(retReq);
            for (IRCMessage m : reply.getMsgsList()) {
                    String build;
                    build = "[" + channelName + "]" + "(" + m.getNick() + ") " + m.getContent();
                    ret.add(build);
                    if (ClientData.getChannelState(channelName).LastMsgTimestamp < m.getTimestamp()) {
                        ClientData.getChannelState(channelName).LastMsgTimestamp = m.getTimestamp();
                    }
            }
            return ret;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }

    public void clientUpdater() {
        //New thread to run periodic check
        //check whether important thing has been set else do not run

        updaterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (updater) {
                    try {
                        if (!ClientData.NICKNAME.equals("")) {
                            for (ChannelState currentChannel : ClientData.JOINED_CHANNELS) {
                                List<String> recv;
                                try {
                                    //RPC and display message to stdout
                                    recv = retrieveMsg(currentChannel.ChannelName, currentChannel.LastMsgTimestamp);

                                    for (String currentString : recv) {
                                        System.out.println(currentString);
                                    }
                                } catch (Exception ex) {
                                    System.err.println("Exception in updater");
                                    updater = false;
                                }
                            }
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        updaterThread.start();
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name
     * to use in the greeting.
     */
    public static void main(String[] args) throws Exception {
        IRCClient client = new IRCClient("localhost", 50051);
        try {

            //TODO periodic thread for pulling messages
            System.out.println("Input command:_");
            Scanner userInput;
            boolean exit = false;
            String input;
            client.clientUpdater();
            //Run the main loop here
            userInput = new Scanner(System.in);
            while (!exit) {
                input = userInput.nextLine();
                if (input.equalsIgnoreCase("/EXIT")) {
                    exit = true;
                } else if (input.matches("(?i)/NICK(.*)?")) {
                    String nickname = input.substring(5).trim();
                    if (nickname == "") {
                        //randomize name
                        Random ran = new Random();
                        int x = ran.nextInt(50000) + 0;
                        ClientData.NICKNAME = Integer.toString(x);
                    } else {
                        ClientData.NICKNAME = nickname;
                        System.out.println("Hi " + nickname);
                    }
                } else if (input.matches("(?i)/JOIN .*") && ClientData.NICKNAME != "") {
                    String roomName = input.substring(6);
                    if (ClientData.isAlreadyJoin(roomName)) {
                        System.out.println("Anda sudah join ke room " + roomName);
                    } else {
                        ClientData.JOINED_CHANNELS.add(new ChannelState(roomName));
                        if (client.join(roomName)) {
                            System.out.println("Anda membuat room baru bernama " + roomName);
                        } else {
                            System.out.println("Berhasil bergabung ke dalam room " + roomName);
                        }
                    }
                } else if (input.matches("(?i)/LEAVE .*") && ClientData.NICKNAME != "") {
                    String roomName = input.substring(7);
                    if (ClientData.removeChannel(roomName)) {
                        System.out.println("Anda berhasil leave room " + roomName);
                    } else {
                        System.out.println("Anda tidak pernah bergabung di room " + roomName);
                    }
                } else if (input.matches("(?i)@.*? .+") && ClientData.NICKNAME != "") {
                    //send message to room here
                    String chatRoom;
                    String message;
                    int timestamp = (int) (System.currentTimeMillis() / 1000);
                    chatRoom = input.substring(1, input.indexOf(" "));
                    message = input.substring(input.indexOf(" ") + 1);
                    if (!client.sendMessage(chatRoom, ClientData.NICKNAME, message, timestamp)) {
                        System.out.println("Ruangan chat yang anda masukkan tidak ada");
                    } else {
                        ClientData.getChannelState(chatRoom).LastMsgTimestamp = timestamp;
                        String build;
                        build = "[" + chatRoom + "]" + "(" + ClientData.NICKNAME + ")" + message;
                        System.out.println(build);
                    }
                } else if (ClientData.NICKNAME != "") {
                    //Broadcast to all room
                    String message;
                    String chatRoom;
                    int timestamp = (int) (System.currentTimeMillis() / 1000);
                    message = input;
                    for (ChannelState currentChannel : ClientData.JOINED_CHANNELS) {
                        chatRoom = currentChannel.ChannelName;
                        if (!client.sendMessage(chatRoom, ClientData.NICKNAME, message, timestamp)) {
                            System.out.println("Send to " + chatRoom + " failed");
                        } else {
                            ClientData.getChannelState(chatRoom).LastMsgTimestamp = timestamp;
                            String build;
                            build = "[" + chatRoom + "]" + "(" + ClientData.NICKNAME + ")" + message;
                            System.out.println(build);
                        }
                    }
                }
            }

        } finally {
            updater = false; //shuts thread
            client.shutdown();
        }
    }
}
