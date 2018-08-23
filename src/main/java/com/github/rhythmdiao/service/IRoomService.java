package com.github.rhythmdiao.service;

/**
 * @author rhyth
 * 房间逻辑
 */
public interface IRoomService {
    /**
     * 创建房间
     */
    void create();

    /**
     * 加入房间
     */
    void join();

    /**
     * 退出房间
     */
    void leave();

    /**
     * 关闭房间
     */
    void destory();
}
