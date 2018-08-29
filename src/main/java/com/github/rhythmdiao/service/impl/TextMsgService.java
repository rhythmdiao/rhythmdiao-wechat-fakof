package com.github.rhythmdiao.service.impl;

import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import com.github.rhythmdiao.service.BaseMsgService;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * @author rhyth
 */
@Component
public class TextMsgService extends BaseMsgService {
    TextMsgService() {
        this.msgType = "text";
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <T extends BaseMsg> T initResponseMsg(Map<String, String> map) {
        TextResponseMsg textResponseMsg = new TextResponseMsg();
        textResponseMsg.setFromUserName(map.get(KEYWORD_TO_USER_NAME));
        textResponseMsg.setToUserName(map.get(KEYWORD_FROM_USER_NAME));
        Integer createTime = (int) (Calendar.getInstance().getTimeInMillis() / 1000L);
        textResponseMsg.setCreateTime(createTime);
        return (T) textResponseMsg;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(Map<String, String> map, String msgType) {
        TextResponseMsg textResponseMsg = this.initResponseMsg(map);
        textResponseMsg.setMsgType(this.msgType);
        textResponseMsg.setContent("Hello World");
        return (T) textResponseMsg;
    }
}