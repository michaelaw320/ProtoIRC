// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: irc.proto

package ircservice;

public interface RetrieveReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ircservice.RetrieveReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .ircservice.IRCMessage msgs = 1;</code>
   */
  java.util.List<ircservice.IRCMessage> 
      getMsgsList();
  /**
   * <code>repeated .ircservice.IRCMessage msgs = 1;</code>
   */
  ircservice.IRCMessage getMsgs(int index);
  /**
   * <code>repeated .ircservice.IRCMessage msgs = 1;</code>
   */
  int getMsgsCount();
  /**
   * <code>repeated .ircservice.IRCMessage msgs = 1;</code>
   */
  java.util.List<? extends ircservice.IRCMessageOrBuilder> 
      getMsgsOrBuilderList();
  /**
   * <code>repeated .ircservice.IRCMessage msgs = 1;</code>
   */
  ircservice.IRCMessageOrBuilder getMsgsOrBuilder(
      int index);
}