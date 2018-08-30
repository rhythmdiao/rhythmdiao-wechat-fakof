package com.github.rhythmdiao.service.fakof;

import com.github.rhythmdiao.domain.fakof.Player;
import com.github.rhythmdiao.domain.fakof.Room;

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
