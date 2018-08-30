package com.github.rhythmdiao.service.msg;

import com.github.rhythmdiao.WechatConfig;
import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import com.github.rhythmdiao.service.BaseMsgService;
import com.github.rhythmdiao.service.fakof.RoomService;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author rhyth
 */
@Component
public class TextMsgService extends BaseMsgService {
    @Resource
    private WechatConfig wechatConfig;

    @Resource
    private RoomService roomService;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BaseMsg> T handleMsg(Map<String, String> map) {
        final String userMsg = map.get(BaseMsgService.KEYWORD_CONTENT);
        if (Strings.isNullOrEmpty(userMsg)) {
            return null;
        }
        switch (userMsg) {
            case "杀人游戏":
                break;
            case "阿瓦隆":
                break;
            case "退出房间":
                break;
            default:
                break;
        }
        TextResponseMsg textResponseMsg = super.initTextResponseMsg(map);
        textResponseMsg.setContent(wechatConfig.getSubscribe());
        return (T) textResponseMsg;
    }
}