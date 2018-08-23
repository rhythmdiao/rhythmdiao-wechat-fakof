package com.github.rhythmdiao.domain.fun;

import java.util.List;

/**
 * @author rhyth
 * 游戏房间对象
 * 创建房间指令：Type,Maxmembers(阿瓦隆,5)
 * 加入房间指令：roomID(89751)
 * 退出房间指令：退出房间
 * 关闭房间指令：暂无
 */
public class Room {
    /**
     * 房间编号
     */
    private Integer roomID;

    /**
     * 房间创建者id
     */
    private String creator;

    /**
     * 房间创建时间
     */
    private Integer createTime;

    /**
     * 房间销毁时间
     */
    private Integer destroyTime;

    /**
     * 当前成员数
     */
    private List<String> members;

    /**
     * 最多成员数
     */
    private Integer maxMembers;

    /**
     * 房间类型
     */
    private Type type;

    /**
     * 房间状态
     */
    private Status status;

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Integer destroyTime) {
        this.destroyTime = destroyTime;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public Integer getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        /**
         * 初始化
         */
        INIT(1),
        /**
         * 可用，未满
         */
        AVAILABLE(2),
        /**
         * 满员，游戏开始
         */
        FULL(3),
        /**
         * 房间已销毁
         */
        DESTORYED(9),
        /**
         * 未知房间
         */
        UNKNOWN(0);

        private int roomStatus;

        Status(int roomStatus) {
            this.roomStatus = roomStatus;
        }

        public int getRoomStatus() {
            return roomStatus;
        }
    }

    public enum Type {
        /**
         * 杀人游戏
         */
        KILLING(1),
        /**
         * 阿瓦隆
         */
        AVALON(2);

        private int roomType;

        Type(int roomType) {
            this.roomType = roomType;
        }

        public int getRoomType() {
            return roomType;
        }
    }
}
