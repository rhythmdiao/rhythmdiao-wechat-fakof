package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.service.msg.EventMsgService;
import com.github.rhythmdiao.service.msg.TextMsgService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author rhyth
 */
@Component
public class MsgDispatcher {
    @Resource
    private TextMsgService textMsgService;

    @Resource
    private EventMsgService eventMsgService;

    private static final Logger LOG = LoggerFactory.getLogger(MsgDispatcher.class);

    public <T extends BaseMsg> T dispatch(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            LOG.info("empty request");
            return null;
        }
        String msgType = map.get(BaseMsgService.KEYWORD_MSG_TYPE);
        if (Strings.isNullOrEmpty(msgType)) {
            LOG.info("invalid msg type");
            return null;
        }
        switch (msgType) {
            case "text":
                return textMsgService.handleMsg(map);
            case "event":
                return eventMsgService.handleMsg(map);
            default:
                LOG.info("unknown msg type:{}", msgType);
                return null;
        }
    }
}
