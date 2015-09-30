// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: irc.proto

package ircservice;

/**
 * Protobuf type {@code ircservice.PostMessageRequest}
 */
public  final class PostMessageRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ircservice.PostMessageRequest)
    PostMessageRequestOrBuilder {
  // Use PostMessageRequest.newBuilder() to construct.
  private PostMessageRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private PostMessageRequest() {
    channelName_ = "";
    nick_ = "";
    theMessage_ = "";
    timestamp_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private PostMessageRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            channelName_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            nick_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            theMessage_ = s;
            break;
          }
          case 32: {

            timestamp_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ircservice.Irc.internal_static_ircservice_PostMessageRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ircservice.Irc.internal_static_ircservice_PostMessageRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ircservice.PostMessageRequest.class, ircservice.PostMessageRequest.Builder.class);
  }

  public static final int CHANNELNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object channelName_;
  /**
   * <code>optional string channelName = 1;</code>
   */
  public java.lang.String getChannelName() {
    java.lang.Object ref = channelName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      channelName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string channelName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getChannelNameBytes() {
    java.lang.Object ref = channelName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      channelName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NICK_FIELD_NUMBER = 2;
  private volatile java.lang.Object nick_;
  /**
   * <code>optional string nick = 2;</code>
   */
  public java.lang.String getNick() {
    java.lang.Object ref = nick_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nick_ = s;
      return s;
    }
  }
  /**
   * <code>optional string nick = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNickBytes() {
    java.lang.Object ref = nick_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nick_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int THEMESSAGE_FIELD_NUMBER = 3;
  private volatile java.lang.Object theMessage_;
  /**
   * <code>optional string theMessage = 3;</code>
   */
  public java.lang.String getTheMessage() {
    java.lang.Object ref = theMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      theMessage_ = s;
      return s;
    }
  }
  /**
   * <code>optional string theMessage = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTheMessageBytes() {
    java.lang.Object ref = theMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      theMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 4;
  private long timestamp_;
  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getChannelNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, channelName_);
    }
    if (!getNickBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, nick_);
    }
    if (!getTheMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, theMessage_);
    }
    if (timestamp_ != 0L) {
      output.writeInt64(4, timestamp_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getChannelNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, channelName_);
    }
    if (!getNickBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, nick_);
    }
    if (!getTheMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, theMessage_);
    }
    if (timestamp_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, timestamp_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static ircservice.PostMessageRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ircservice.PostMessageRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ircservice.PostMessageRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ircservice.PostMessageRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ircservice.PostMessageRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ircservice.PostMessageRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static ircservice.PostMessageRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static ircservice.PostMessageRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static ircservice.PostMessageRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ircservice.PostMessageRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ircservice.PostMessageRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ircservice.PostMessageRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ircservice.PostMessageRequest)
      ircservice.PostMessageRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ircservice.Irc.internal_static_ircservice_PostMessageRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ircservice.Irc.internal_static_ircservice_PostMessageRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ircservice.PostMessageRequest.class, ircservice.PostMessageRequest.Builder.class);
    }

    // Construct using ircservice.PostMessageRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      channelName_ = "";

      nick_ = "";

      theMessage_ = "";

      timestamp_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ircservice.Irc.internal_static_ircservice_PostMessageRequest_descriptor;
    }

    public ircservice.PostMessageRequest getDefaultInstanceForType() {
      return ircservice.PostMessageRequest.getDefaultInstance();
    }

    public ircservice.PostMessageRequest build() {
      ircservice.PostMessageRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ircservice.PostMessageRequest buildPartial() {
      ircservice.PostMessageRequest result = new ircservice.PostMessageRequest(this);
      result.channelName_ = channelName_;
      result.nick_ = nick_;
      result.theMessage_ = theMessage_;
      result.timestamp_ = timestamp_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ircservice.PostMessageRequest) {
        return mergeFrom((ircservice.PostMessageRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ircservice.PostMessageRequest other) {
      if (other == ircservice.PostMessageRequest.getDefaultInstance()) return this;
      if (!other.getChannelName().isEmpty()) {
        channelName_ = other.channelName_;
        onChanged();
      }
      if (!other.getNick().isEmpty()) {
        nick_ = other.nick_;
        onChanged();
      }
      if (!other.getTheMessage().isEmpty()) {
        theMessage_ = other.theMessage_;
        onChanged();
      }
      if (other.getTimestamp() != 0L) {
        setTimestamp(other.getTimestamp());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ircservice.PostMessageRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ircservice.PostMessageRequest) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object channelName_ = "";
    /**
     * <code>optional string channelName = 1;</code>
     */
    public java.lang.String getChannelName() {
      java.lang.Object ref = channelName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        channelName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string channelName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getChannelNameBytes() {
      java.lang.Object ref = channelName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        channelName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string channelName = 1;</code>
     */
    public Builder setChannelName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      channelName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string channelName = 1;</code>
     */
    public Builder clearChannelName() {
      
      channelName_ = getDefaultInstance().getChannelName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string channelName = 1;</code>
     */
    public Builder setChannelNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      channelName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object nick_ = "";
    /**
     * <code>optional string nick = 2;</code>
     */
    public java.lang.String getNick() {
      java.lang.Object ref = nick_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nick_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string nick = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNickBytes() {
      java.lang.Object ref = nick_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nick_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string nick = 2;</code>
     */
    public Builder setNick(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nick_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string nick = 2;</code>
     */
    public Builder clearNick() {
      
      nick_ = getDefaultInstance().getNick();
      onChanged();
      return this;
    }
    /**
     * <code>optional string nick = 2;</code>
     */
    public Builder setNickBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nick_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object theMessage_ = "";
    /**
     * <code>optional string theMessage = 3;</code>
     */
    public java.lang.String getTheMessage() {
      java.lang.Object ref = theMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        theMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string theMessage = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTheMessageBytes() {
      java.lang.Object ref = theMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        theMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string theMessage = 3;</code>
     */
    public Builder setTheMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      theMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string theMessage = 3;</code>
     */
    public Builder clearTheMessage() {
      
      theMessage_ = getDefaultInstance().getTheMessage();
      onChanged();
      return this;
    }
    /**
     * <code>optional string theMessage = 3;</code>
     */
    public Builder setTheMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      theMessage_ = value;
      onChanged();
      return this;
    }

    private long timestamp_ ;
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public Builder setTimestamp(long value) {
      
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public Builder clearTimestamp() {
      
      timestamp_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:ircservice.PostMessageRequest)
  }

  // @@protoc_insertion_point(class_scope:ircservice.PostMessageRequest)
  private static final ircservice.PostMessageRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ircservice.PostMessageRequest();
  }

  public static ircservice.PostMessageRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PostMessageRequest>
      PARSER = new com.google.protobuf.AbstractParser<PostMessageRequest>() {
    public PostMessageRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new PostMessageRequest(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<PostMessageRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PostMessageRequest> getParserForType() {
    return PARSER;
  }

  public ircservice.PostMessageRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

