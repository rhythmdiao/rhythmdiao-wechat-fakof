package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.fun.Player;
import com.github.rhythmdiao.domain.fun.Room;

/**
 * @author rhyth
 * 房间逻辑
 */
public interface RoomService {
    /**
     * 创建房间
     */
    void create(Player player);

    /**
     * 加入房间
     */
    void join(Player player, Room room);

    /**
     * 退出房间
     */
    void leave(Player player, Room room);

    /**
     * 关闭房间
     */
    void destroy(Player player, Room room);
}
