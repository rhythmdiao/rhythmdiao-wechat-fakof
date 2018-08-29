package com.github.rhythmdiao.service.impl;

import com.github.rhythmdiao.domain.fun.Player;
import com.github.rhythmdiao.domain.fun.Room;
import com.github.rhythmdiao.service.RoomService;
import com.github.rhythmdiao.util.LocalCache;
import org.springframework.stereotype.Component;

/**
 * @author rhyth
 * 一个操作应该放在一个pipeline或者transaction里去做，先搞简单点
 * 房间
 */
@Component
public class RoomServiceImpl implements RoomService {

    @Override
    public void create(Player player) {
        Player cachedPlayer = (Player) LocalCache.get(player.getPlayerID());
        if (cachedPlayer == null) {
            Room room = (Room) LocalCache.get("creator_" + player.getPlayerID());
        }
    }

    @Override
    public void join(Player player, Room room) {

    }

    @Override
    public void leave(Player player, Room room) {

    }

    @Override
    public void destroy(Player player, Room room) {

    }
}
