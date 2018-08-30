package com.github.rhythmdiao.controller.accesstoken;

import com.github.rhythmdiao.WechatConfig;
import com.github.rhythmdiao.controller.BaseController;
import com.github.rhythmdiao.util.LocalCache;
import com.github.rhythmdiao.util.client.HttpGetClient;
import com.github.rhythmdiao.util.client.HttpProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rhyth
 * access token中控器
 */
@Configuration
@EnableScheduling
public class AccessTokenController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenController.class);

    @Resource
    private WechatConfig wechatConfig;

    private static final String GRANT_TYPE = "client_credential";

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * 每隔1小时刷新一次access token
     */
    @Scheduled(fixedDelay = 3600000, initialDelay = 0)
    public void getToken() {
        HttpGetClient httpGetClient = new HttpGetClient("https", wechatConfig.getUrl());
        HttpProperty httpProperty = new HttpProperty();
        String response = httpGetClient.execute("/token?grant_type=" + GRANT_TYPE + "&appid=" + wechatConfig.getAppid() + "&secret=" + wechatConfig.getAppsercet(), httpProperty);
        Map map = GSON.fromJson(response, HashMap.class);
        if (map != null && map.get("access_token") != null) {
            LOG.info("access_token:{}", map.get("access_token"));
            LocalCache.set("access_token", map.get("access_token"));
        }
    }
}
