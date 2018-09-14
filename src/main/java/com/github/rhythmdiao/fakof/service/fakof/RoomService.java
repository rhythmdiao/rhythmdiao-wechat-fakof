package com.github.rhythmdiao.fakof.service.fakof;

import com.github.rhythmdiao.fakof.domain.fakof.Player;
import com.github.rhythmdiao.fakof.domain.fakof.Room;
import com.github.rhythmdiao.fakof.domain.wechat.msg.request.WechatMsg;

/**
 * @author rhyth
 * 房间逻辑
 */
public interface RoomService {
    /**
     * 创建房间
     */
    String create(Player player);

    /**
     * 加入房间
     */
    String join(Player player);

    /**
     * 退出房间
     */
    String leave(Player player);

    /**
     * 关闭房间
     */
    String destroy(Player player, Room room);

    /**
     * 指令分发
     *
     * @param wechatMsg 用户消息对象
     * @return 结果描述
     */
    String handle(WechatMsg wechatMsg);
}
