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
package ircserver;

import io.grpc.stub.StreamObserver;
import ircservice.IRCServiceGrpc;
import ircservice.JoinReply;
import ircservice.JoinRequest;
import ircservice.PostMessageReply;
import ircservice.PostMessageRequest;
import ircservice.RetrieveReply;
import ircservice.RetrieveRequest;
import ircserver.ServerData;
import ircservice.IRCMessage;

/**
 *
 * @author Michael
 */
public class IRCServiceGrpcHandler implements IRCServiceGrpc.IRCService {

    @Override
    public void joinChannel(JoinRequest request, StreamObserver<JoinReply> responseObserver) {
        responseObserver.onNext(mJoinChannel(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getMessages(RetrieveRequest request, StreamObserver<RetrieveReply> responseObserver) {
        responseObserver.onNext(mGetMessages(request));
        responseObserver.onCompleted();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessage(PostMessageRequest request, StreamObserver<PostMessageReply> responseObserver) {
        responseObserver.onNext(mSendMessage(request));
        responseObserver.onCompleted();
    }

    private JoinReply mJoinChannel(JoinRequest request) {
        String channelName = request.getChannelName();
        if (ServerData.isChannelExist(channelName)) {
            return JoinReply.newBuilder().setIsNew(false).build();
        } else {
            Channel chan = new Channel(channelName);
            ServerData.CHANNELS.add(chan);
            return JoinReply.newBuilder().setIsNew(true).build();
        }
    }

    private PostMessageReply mSendMessage(PostMessageRequest request) {
        String channelName = request.getChannelName();
        String nick = request.getNick();
        String theMessage = request.getTheMessage();
        long timestamp = request.getTimestamp();
        Channel chan = ServerData.getChannel(channelName);
        if (chan.Name.equals("NX")) {
            //Channel not exist, return error
            return PostMessageReply.newBuilder().setIsSuccess(false).build();
        } else {
            IRCMessage msg = IRCMessage.newBuilder().setNick(nick).setContent(theMessage).setTimestamp(timestamp).build();
            chan.Messages.add(msg);
            return PostMessageReply.newBuilder().setIsSuccess(true).build();
        }
    }

    private RetrieveReply mGetMessages(RetrieveRequest request) {
        String channelName = request.getChannelName();
        long timestamp = request.getTimestamp();
        Channel chan = ServerData.getChannel(channelName);
        if (chan.Name.equals("NX")) {
            //ignore it for the time being
            IRCMessage nil = IRCMessage.newBuilder().setContent("NX").setNick("NX").setTimestamp(0).build();
            return RetrieveReply.newBuilder().addMsgs(nil).build();
        } else {
            //return messages in channel that is newer than specified timestamp
            RetrieveReply.Builder ret = RetrieveReply.newBuilder();
            for (IRCMessage m : chan.Messages) {
                if (m.getTimestamp() > timestamp)
                    ret.addMsgs(m);
            }
            return ret.build();
        }
    }
    
}
