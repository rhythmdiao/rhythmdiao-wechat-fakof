package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * @author rhyth
 */
@Component
public abstract class BaseMsgService {
    public static final String KEYWORD_TO_USER_NAME = "ToUserName";
    public static final String KEYWORD_FROM_USER_NAME = "FromUserName";
    public static final String KEYWORD_CREATE_TIME = "CreateTime";
    public static final String KEYWORD_MSG_TYPE = "MsgType";
    public static final String KEYWORD_EVENT = "Event";
    public static final String KEYWORD_CONTENT = "Content";

    /**
     * 初始化公共响应参数
     *
     * @param map 消息映射
     * @return BaseMsg
     */
    @SuppressWarnings("unchecked")
    protected TextResponseMsg initTextResponseMsg(Map<String, String> map) {
        TextResponseMsg textResponseMsg = new TextResponseMsg();
        textResponseMsg.setFromUserName(map.get(KEYWORD_TO_USER_NAME));
        textResponseMsg.setToUserName(map.get(KEYWORD_FROM_USER_NAME));
        textResponseMsg.setMsgType("text");
        Integer createTime = (int) (Calendar.getInstance().getTimeInMillis() / 1000L);
        textResponseMsg.setCreateTime(createTime);
        return textResponseMsg;
    }

    /**
     * 微信消息处理函数
     *
     * @param map 请求消息映射
     * @return T extends BaseMsg
     */
    public abstract <T extends BaseMsg> T handleMsg(Map<String, String> map);
}
