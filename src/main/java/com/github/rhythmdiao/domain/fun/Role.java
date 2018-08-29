package com.github.rhythmdiao.domain.fun;

/**
 * @author rhyth
 */
public enum Role {
    Villager("村民");

    String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    enum Killing {
        Police("警察"),
        Killer("匪徒");

        String roleName;

        Killing(String roleName) {
            this.roleName = roleName;
        }
    }


    enum AVALON {
        Merlin("梅林"),
        Percival("派西维尔"),
        Morgana("莫甘娜"),
        Mordred("莫德雷德"),
        Oberon("奥伯伦"),
        Killer("刺客");

        String roleName;

        AVALON(String roleName) {
            this.roleName = roleName;
        }
    }


}
