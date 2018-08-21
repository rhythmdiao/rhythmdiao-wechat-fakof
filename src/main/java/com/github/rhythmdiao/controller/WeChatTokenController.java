package com.github.rhythmdiao.controller;

import com.github.rhythmdiao.util.MsgConverter;
import com.github.rhythmdiao.domain.wechat.response.TextResponseMsg;
import com.github.rhythmdiao.util.CheckUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author rhyth
 */
@RestController
public class WeChatTokenController {
    private static final Logger LOG = LoggerFactory.getLogger(WeChatTokenController.class);

    @Value("${wechat.token}")
    private String token;

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echoGet(@RequestParam(value = "signature") String signature,
                          @RequestParam(value = "timestamp") String timestamp,
                          @RequestParam(value = "nonce") String nonce,
                          @RequestParam(value = "echostr") String echostr) {
        if (Strings.isBlank(signature) || Strings.isBlank(timestamp) || Strings.isBlank(nonce) || Strings.isBlank(echostr)) {
            return "";
        }
        boolean result = CheckUtil.checkSignature(token, signature, timestamp, nonce);
        return result ? echostr : "";
    }

    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public String echoPost(HttpServletRequest request,
                           @RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce) {
        if (Strings.isBlank(signature) || Strings.isBlank(timestamp) || Strings.isBlank(nonce)) {
            LOG.info("Empty request parameters");
            return "";
        }
        boolean result = CheckUtil.checkSignature(token, signature, timestamp, nonce);
        if (!result) {
            LOG.info("Check signature failed");
            return "";
        }
        Map<String, String> map;
        try {
            map = MsgConverter.xmlToMap(request);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        TextResponseMsg textResponseMsg = new TextResponseMsg();
        textResponseMsg.setFromUserName(map.get("ToUserName"));
        textResponseMsg.setToUserName(map.get("FromUserName"));
        textResponseMsg.setMsgType(map.get("MsgType"));
        textResponseMsg.setContent("哈哈");
        textResponseMsg.setCreateTime(Integer.valueOf(map.get("CreateTime")));
        return MsgConverter.textMessageToXml(textResponseMsg);
    }
}