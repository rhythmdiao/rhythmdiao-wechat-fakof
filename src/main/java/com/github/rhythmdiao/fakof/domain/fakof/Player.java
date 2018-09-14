package com.github.rhythmdiao.fakof.domain.fakof;

/**
 * @author rhyth
 */
public class Player {
    /**
     * 玩家ID
     */
    private String playerID;
    /**
     * 玩家昵称
     */
    private String playerName;
    /**
     * 所在房间ID
     */
    private Integer roomID;
    /**
     * 是否房主
     */
    private boolean isHost;
    /**
     * 所在房间座位ID
     */
    private Integer seatNO;
    /**
     * 当前角色
     */
    private Role role;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean host) {
        isHost = host;
    }

    public Integer getSeatNO() {
        return seatNO;
    }

    public void setSeatNO(Integer seatNO) {
        this.seatNO = seatNO;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", playerName='" + playerName + '\'' +
                ", roomID='" + roomID + '\'' +
                ", isHost=" + isHost +
                ", seatNO='" + seatNO + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
