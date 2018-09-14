package com.github.rhythmdiao.fakof.service.msg;

import com.github.rhythmdiao.fakof.domain.wechat.msg.BaseMsg;
import com.github.rhythmdiao.fakof.domain.wechat.msg.request.WechatMsg;
import com.github.rhythmdiao.fakof.domain.wechat.msg.response.TextResponseMsg;
import com.github.rhythmdiao.fakof.service.BaseMsgService;
import com.github.rhythmdiao.fakof.service.fakof.RoomService;
import com.github.rhythmdiao.qqai.api.NlpAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author rhyth
 */
@Component
public class TextMsgService extends BaseMsgService {
    @Value("${qqai.appid}")
    private String appID;
    @Value("${qqai.appkey}")
    private String appKey;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(WechatMsg wechatMsg) {
        NlpAPI nlpAPI = new NlpAPI(appID, appKey);
        TextResponseMsg textResponseMsg = super.initTextResponseMsg(wechatMsg);
        textResponseMsg.setContent(nlpAPI.wordSeg(wechatMsg.getContent()));
        return (T) textResponseMsg;
    }
}