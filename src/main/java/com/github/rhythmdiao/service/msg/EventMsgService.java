package com.github.rhythmdiao.service.msg;

import com.github.rhythmdiao.WechatConfig;
import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import com.github.rhythmdiao.service.BaseMsgService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author rhyth
 * 事件推送消息处理器
 */
@Component
public class EventMsgService extends BaseMsgService {
    private static final Logger LOG = LoggerFactory.getLogger(EventMsgService.class);

    @Resource
    private WechatConfig wechatConfig;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(Map<String, String> map) {
        final String event = map.get(BaseMsgService.KEYWORD_EVENT);
        if (Strings.isNullOrEmpty(event)) {
            LOG.info("empty event");
            return null;
        }
        switch (event) {
            case "subscribe":
                TextResponseMsg textResponseMsg = super.initTextResponseMsg(map);
                textResponseMsg.setContent(wechatConfig.getSubscribe());
                return (T) textResponseMsg;
            case "unsubscribe":
                return null;
            default:
                LOG.info("unknown event:{}", event);
                return null;
        }
    }
}
