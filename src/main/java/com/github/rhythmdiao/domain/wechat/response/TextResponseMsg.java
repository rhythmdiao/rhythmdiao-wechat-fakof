package com.github.rhythmdiao.domain.wechat.response;

import com.github.rhythmdiao.domain.wechat.BaseMsg;

public class TextResponseMsg extends BaseMsg {
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
                '}';
    }
}
