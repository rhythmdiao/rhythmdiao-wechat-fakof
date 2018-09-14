package com.github.rhythmdiao.fakof.service.fakof.impl;

import com.github.rhythmdiao.fakof.WechatConfig;
import com.github.rhythmdiao.fakof.domain.fakof.Player;
import com.github.rhythmdiao.fakof.domain.fakof.Room;
import com.github.rhythmdiao.fakof.domain.wechat.msg.request.WechatMsg;
import com.github.rhythmdiao.fakof.service.fakof.RoomService;
import com.github.rhythmdiao.fakof.util.LocalCache;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rhyth
 * 一个操作应该放在一个pipeline或者transaction里去做，先搞简单点
 * 房间
 */
@Component
public class RoomServiceImpl implements RoomService {
    private static final Logger LOG = LoggerFactory.getLogger(RoomServiceImpl.class);

    private AtomicInteger increasedID = new AtomicInteger(0);
    @Resource
    private WechatConfig wechatConfig;

    @Override
    public String create(Player player) {
        final Integer roomID = player.getRoomID();
        if (roomID > 0) {
            return "您已加入房间:" + roomID;
        }
        Room room = (Room) LocalCache.get(String.valueOf(roomID));
        if (room == null) {
            room = new Room();
            room.setCreator(player.getPlayerID());
            room.setType(Room.Type.KILLING);
            room.setCreateTime(Calendar.getInstance().getTimeInMillis());
            room.setStatus(Room.Status.INIT);
            room.setRoomID(increasedID.getAndAdd(1));
            player.setHost(true);
            player.setSeatNO(1);
            player.setRoomID(room.getRoomID());
            room.setPlayerList(Lists.newArrayList(player));
        }
        return null;
    }

    @Override
    public String join(Player player) {
        return null;
    }

    @Override
    public String leave(Player player) {
        return null;
    }

    @Override
    public String destroy(Player player, Room room) {
        return null;
    }

    @Override
    public String handle(WechatMsg wechatMsg) {
        final String userMsg = wechatMsg.getContent();
        if (Strings.isNullOrEmpty(userMsg)) {
            LOG.info("empty msg content");
            return null;
        }
        final String userID = wechatMsg.getFromUserName();
        if (Strings.isNullOrEmpty(userID)) {
            LOG.info("empty user id");
            return null;
        }
        Player player = (Player) LocalCache.get(userID);

        if (player == null) {
            LOG.info("new player and player id is {}", userID);
        } else {
            player = new Player();
            player.setPlayerID(userID);
        }

        switch (userMsg) {
            case "杀人游戏":
                create(player);
                break;
            case "退出房间":
                leave(player);
                break;
            default:
                return null;
        }
        return null;
    }
}
