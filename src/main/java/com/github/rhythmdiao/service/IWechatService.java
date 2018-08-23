package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.menu.Menu;
import com.github.rhythmdiao.domain.msg.BaseMsg;

import java.util.Map;

/**
 * @author rhyth
 * 微信订阅号服务
 */
public interface IWechatService {
    /**
     * 用户消息处理
     *
     * @param map 消息请求参数映射
     * @param <T> 拓展于消息请求参数对象
     * @return 响应消息参数对象
     */
    <T extends BaseMsg> T handleMsg(Map<String, String> map);

    /**
     * 自定义菜单处理
     *
     * @param menu
     * @return
     */
    String handleMenu(Menu menu, String cmd);
}
