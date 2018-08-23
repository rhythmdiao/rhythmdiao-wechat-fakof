package com.github.rhythmdiao.domain.msg.request;

import com.github.rhythmdiao.domain.msg.BaseMsg;

/**
 * @author rhyth
 * 时间推送请求
 */
public class EventMsg extends BaseMsg {
    String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    @Override
    public String toString() {
        return "EventMsg{" +
                "Event='" + Event + '\'' +
                ", ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                '}';
    }
}
