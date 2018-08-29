package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.domain.msg.response.ResponseMsg;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import com.github.rhythmdiao.util.MsgConverter;
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

    protected String msgType;

    /**
     * 初始化公共响应参数
     *
     * @param map 消息映射
     * @return BaseMsg
     */
    protected abstract <T extends BaseMsg> T initResponseMsg(Map<String, String> map);

    /**
     * 根据msgtype处理消息
     *
     * @param map     消息映射
     * @param msgType 消息类型
     * @return BaseMsg
     */
    public abstract <T extends BaseMsg> T handleMsg(Map<String, String> map, String msgType);
}
