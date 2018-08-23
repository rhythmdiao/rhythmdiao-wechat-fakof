package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.wechat.BaseMsg;

import java.util.Map;

/**
 * @author rhyth
 * 处理回复用户消息
 */
public interface IWechatService {
    <T extends BaseMsg> T handleMsg(Map<String, String> map);
}
