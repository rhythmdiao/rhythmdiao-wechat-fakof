package com.github.rhythmdiao.service.impl;

import com.github.rhythmdiao.WechatConfig;
import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import com.github.rhythmdiao.service.BaseMsgService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Map;

/**
 * @author rhyth
 */
@Component
public class TextMsgService extends BaseMsgService {
    @Resource
    private WechatConfig wechatConfig;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(Map<String, String> map) {
        TextResponseMsg textResponseMsg = super.initTextResponseMsg(map);
        textResponseMsg.setContent(wechatConfig.getSubscribe());
        return (T) textResponseMsg;
    }
}