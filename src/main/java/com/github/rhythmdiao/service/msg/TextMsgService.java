package com.github.rhythmdiao.service.msg;

import com.github.rhythmdiao.domain.wechat.msg.BaseMsg;
import com.github.rhythmdiao.domain.wechat.msg.request.WechatMsg;
import com.github.rhythmdiao.domain.wechat.msg.response.TextResponseMsg;
import com.github.rhythmdiao.service.BaseMsgService;
import com.github.rhythmdiao.service.fakof.RoomService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author rhyth
 */
@Component
public class TextMsgService extends BaseMsgService {
    @Resource
    private RoomService roomService;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(WechatMsg wechatMsg) {
        String content = "TEST";
        TextResponseMsg textResponseMsg = super.initTextResponseMsg(wechatMsg);
        textResponseMsg.setContent(content);
        return (T) textResponseMsg;
    }
}