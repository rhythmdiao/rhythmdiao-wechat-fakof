package com.github.rhythmdiao.controller.inner;

import com.github.rhythmdiao.controller.BaseController;
import com.github.rhythmdiao.service.MsgDispatcher;
import com.github.rhythmdiao.util.MsgConverter;
import com.github.rhythmdiao.domain.msg.response.TextResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author rhyth
 * 微信消息接口
 */
@RestController
public class InnerController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(InnerController.class);
    @Resource
    private MsgDispatcher msgDispatcher;

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echoGet(@RequestParam(value = "echostr") String echostr) {
        return echostr;
    }

    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public String echoPost(HttpServletRequest request) {
        Map<String, String> map;
        try {
            map = MsgConverter.xmlToMap(request);
        } catch (IOException e) {
            LOG.error(e.toString());
            return "";
        }

        TextResponseMsg textResponseMsg = msgDispatcher.dispatch(map);
        String result = MsgConverter.textMessageToXml(textResponseMsg);
        LOG.info("result:{}", result);
        return result;
    }
}