package com.github.rhythmdiao.domain.msg.request;

public class MenuEventMsg extends EventMsg {
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    @Override
    public String toString() {
        return "MenuEventMsg{" +
                "EventKey='" + EventKey + '\'' +
                ", Event='" + Event + '\'' +
                ", ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                '}';
    }
}
