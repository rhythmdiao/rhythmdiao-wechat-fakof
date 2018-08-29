package com.github.rhythmdiao.controller.proxy;

import com.github.rhythmdiao.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rhyth
 * 代理控制器，调用微信服务器进行自定义设置
 * 暂时只能本机调用
 */
@RestController
public class ProxyController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(ProxyController.class);

    @Value("${wechat.appid}")
    private String appID;

    @Value("${wechat.appsercet}")
    private String appSercet;

    @Value("${wechat.url}")
    private String url;
}
