package com.github.rhythmdiao.service.impl;

import com.github.rhythmdiao.domain.wechat.BaseMsg;
import com.github.rhythmdiao.domain.wechat.response.TextResponseMsg;
import com.github.rhythmdiao.service.IWechatService;
import com.github.rhythmdiao.util.MsgConverter;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * @author rhyth
 */
@Component
public class WechatService implements IWechatService {
    private static final String KEYWORD_TO_USER_NAME = "ToUserName";
    private static final String KEYWORD_FROM_USER_NAME = "FromUserName";
    private static final String KEYWORD_CREATE_TIME = "CreateTime";
    private static final String KEYWORD_MSG_TYPE = "MsgType";

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(Map<String, String> map) {
        if (map == null) {
            return null;
        }

        if (!map.get(KEYWORD_MSG_TYPE).equals(MsgConverter.TEXT_MSG)) {
            return null;
        }

        TextResponseMsg textResponseMsg = new TextResponseMsg();
        textResponseMsg.setFromUserName(map.get(KEYWORD_TO_USER_NAME));
        textResponseMsg.setToUserName(map.get(KEYWORD_FROM_USER_NAME));
        textResponseMsg.setMsgType(map.get(KEYWORD_MSG_TYPE));
        //TODO
        textResponseMsg.setContent("Hello World");
        Integer createTime = (int) (Calendar.getInstance().getTimeInMillis() / 1000L);
        textResponseMsg.setCreateTime(createTime);
        return (T) textResponseMsg;
    }
}
