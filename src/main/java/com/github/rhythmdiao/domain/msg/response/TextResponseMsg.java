package com.github.rhythmdiao.domain.msg.response;

/**
 * @author rhyth
 */
public class TextResponseMsg extends ResponseMsg {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "TextResponseMsg{" +
                "Content='" + Content + '\'' +
                ", ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                '}';
    }
}
