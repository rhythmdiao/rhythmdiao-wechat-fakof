package com.github.rhythmdiao.domain.msg.request;

/**
 * @author rhyth
 */
public class UserTextMsg extends UserMsg {
    @Override
    public String toString() {
        return "UserTextMsg{" +
                "Content='" + Content + '\'' +
                ", MsgId=" + MsgId +
                ", ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                '}';
    }
}
