package com.github.rhythmdiao.domain.wechat.request;

/**
 * @author rhyth
 */
public class TextRequestMsg extends RequestMsg {
    @Override
    public String toString() {
        return "TextRequestMsg{" +
                "Content='" + Content + '\'' +
                ", MsgId=" + MsgId +
                ", ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                '}';
    }
}
