package com.github.rhythmdiao.service.impl;

import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.service.BaseMsgService;

import java.util.Map;

/**
 * @author rhyth
 */
public class EventMsgService extends BaseMsgService {
    EventMsgService() {
        this.msgType = "event";
    }

    @Override
    protected <T extends BaseMsg> T initResponseMsg(Map<String, String> map) {
        return null;
    }

    @Override
    public <T extends BaseMsg> T handleMsg(Map<String, String> map, String msgType) {
        return null;
    }
}
