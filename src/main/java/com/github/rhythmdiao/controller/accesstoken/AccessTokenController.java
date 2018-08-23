package com.github.rhythmdiao.controller.accesstoken;

import com.github.rhythmdiao.controller.BaseController;
import com.github.rhythmdiao.util.LocalCache;
import com.github.rhythmdiao.util.client.HttpGetClient;
import com.github.rhythmdiao.util.client.HttpProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rhyth
 * access token中控器
 */
@Configuration
@EnableScheduling
public class AccessTokenController extends BaseController {
    @Value("${wechat.appid}")
    private String appID;

    @Value("${wechat.appsercet}")
    private String appSercet;

    @Value("${wechat.url}")
    private String url;

    private static final String GRANT_TYPE = "client_credential";

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Scheduled(cron = "* 0/120 * * * ?")
    public void getToken() {
        HttpGetClient httpGetClient = new HttpGetClient("https", url);
        HttpProperty httpProperty = new HttpProperty();
        String response = httpGetClient.execute("/cgi-bin/token?grant_type=" + GRANT_TYPE + "&appid=" + appID + "&secret=" + appSercet, httpProperty);
        Map map = GSON.fromJson(response, HashMap.class);
        if (map != null && map.get("access_token") != null) {
            LocalCache.set("access_token", map.get("access_token"));
        }
    }
}