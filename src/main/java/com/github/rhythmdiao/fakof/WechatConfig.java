package com.github.rhythmdiao.fakof;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author rhyth
 */
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {
    private String token;
    private String appid;
    private String appsercet;
    private String url;
    private String subscribe;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsercet() {
        return appsercet;
    }

    public void setAppsercet(String appsercet) {
        this.appsercet = appsercet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }
}
