package com.github.rhythmdiao.domain.wechat.request;

import com.github.rhythmdiao.domain.wechat.BaseMsg;

/**
 * @author rhyth
 */
public class RequestMsg extends BaseMsg {
    private String Content;

    private Long MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

    @Override
    public String toString() {
        return "RequestMsg{" +
                "Content='" + Content + '\'' +
                ", MsgId=" + MsgId +
                '}';
    }
}
