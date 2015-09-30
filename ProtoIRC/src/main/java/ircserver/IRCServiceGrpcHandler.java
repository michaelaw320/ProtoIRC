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

/**
 *
 * @author Michael
 */
public class IRCServiceGrpcHandler implements IRCServiceGrpc.IRCService {

    @Override
    public void joinChannel(JoinRequest request, StreamObserver<JoinReply> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getMessages(RetrieveRequest request, StreamObserver<RetrieveReply> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessage(PostMessageRequest request, StreamObserver<PostMessageReply> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
