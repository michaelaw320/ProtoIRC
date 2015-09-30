package ircservice;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class IRCServiceGrpc {

  private IRCServiceGrpc() {}

  public static final String SERVICE_NAME = "ircservice.IRCService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ircservice.JoinRequest,
      ircservice.JoinReply> METHOD_JOIN_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ircservice.IRCService", "joinChannel"),
          io.grpc.protobuf.ProtoUtils.marshaller(ircservice.JoinRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ircservice.JoinReply.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ircservice.RetrieveRequest,
      ircservice.RetrieveReply> METHOD_GET_MESSAGES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ircservice.IRCService", "getMessages"),
          io.grpc.protobuf.ProtoUtils.marshaller(ircservice.RetrieveRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ircservice.RetrieveReply.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ircservice.PostMessageRequest,
      ircservice.PostMessageReply> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ircservice.IRCService", "sendMessage"),
          io.grpc.protobuf.ProtoUtils.marshaller(ircservice.PostMessageRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ircservice.PostMessageReply.getDefaultInstance()));

  public static IRCServiceStub newStub(io.grpc.Channel channel) {
    return new IRCServiceStub(channel);
  }

  public static IRCServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new IRCServiceBlockingStub(channel);
  }

  public static IRCServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new IRCServiceFutureStub(channel);
  }

  public static interface IRCService {

    public void joinChannel(ircservice.JoinRequest request,
        io.grpc.stub.StreamObserver<ircservice.JoinReply> responseObserver);

    public void getMessages(ircservice.RetrieveRequest request,
        io.grpc.stub.StreamObserver<ircservice.RetrieveReply> responseObserver);

    public void sendMessage(ircservice.PostMessageRequest request,
        io.grpc.stub.StreamObserver<ircservice.PostMessageReply> responseObserver);
  }

  public static interface IRCServiceBlockingClient {

    public ircservice.JoinReply joinChannel(ircservice.JoinRequest request);

    public ircservice.RetrieveReply getMessages(ircservice.RetrieveRequest request);

    public ircservice.PostMessageReply sendMessage(ircservice.PostMessageRequest request);
  }

  public static interface IRCServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<ircservice.JoinReply> joinChannel(
        ircservice.JoinRequest request);

    public com.google.common.util.concurrent.ListenableFuture<ircservice.RetrieveReply> getMessages(
        ircservice.RetrieveRequest request);

    public com.google.common.util.concurrent.ListenableFuture<ircservice.PostMessageReply> sendMessage(
        ircservice.PostMessageRequest request);
  }

  public static class IRCServiceStub extends io.grpc.stub.AbstractStub<IRCServiceStub>
      implements IRCService {
    private IRCServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void joinChannel(ircservice.JoinRequest request,
        io.grpc.stub.StreamObserver<ircservice.JoinReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_JOIN_CHANNEL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getMessages(ircservice.RetrieveRequest request,
        io.grpc.stub.StreamObserver<ircservice.RetrieveReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void sendMessage(ircservice.PostMessageRequest request,
        io.grpc.stub.StreamObserver<ircservice.PostMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
    }
  }

  public static class IRCServiceBlockingStub extends io.grpc.stub.AbstractStub<IRCServiceBlockingStub>
      implements IRCServiceBlockingClient {
    private IRCServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public ircservice.JoinReply joinChannel(ircservice.JoinRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_JOIN_CHANNEL, getCallOptions()), request);
    }

    @java.lang.Override
    public ircservice.RetrieveReply getMessages(ircservice.RetrieveRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES, getCallOptions()), request);
    }

    @java.lang.Override
    public ircservice.PostMessageReply sendMessage(ircservice.PostMessageRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }
  }

  public static class IRCServiceFutureStub extends io.grpc.stub.AbstractStub<IRCServiceFutureStub>
      implements IRCServiceFutureClient {
    private IRCServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<ircservice.JoinReply> joinChannel(
        ircservice.JoinRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_JOIN_CHANNEL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<ircservice.RetrieveReply> getMessages(
        ircservice.RetrieveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<ircservice.PostMessageReply> sendMessage(
        ircservice.PostMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final IRCService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_JOIN_CHANNEL,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ircservice.JoinRequest,
              ircservice.JoinReply>() {
            @java.lang.Override
            public void invoke(
                ircservice.JoinRequest request,
                io.grpc.stub.StreamObserver<ircservice.JoinReply> responseObserver) {
              serviceImpl.joinChannel(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_MESSAGES,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ircservice.RetrieveRequest,
              ircservice.RetrieveReply>() {
            @java.lang.Override
            public void invoke(
                ircservice.RetrieveRequest request,
                io.grpc.stub.StreamObserver<ircservice.RetrieveReply> responseObserver) {
              serviceImpl.getMessages(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_SEND_MESSAGE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ircservice.PostMessageRequest,
              ircservice.PostMessageReply>() {
            @java.lang.Override
            public void invoke(
                ircservice.PostMessageRequest request,
                io.grpc.stub.StreamObserver<ircservice.PostMessageReply> responseObserver) {
              serviceImpl.sendMessage(request, responseObserver);
            }
          })).build();
  }
}
