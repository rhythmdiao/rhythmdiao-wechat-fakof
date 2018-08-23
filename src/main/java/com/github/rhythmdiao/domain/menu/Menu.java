package com.github.rhythmdiao.domain.menu;

import java.util.List;

/**
 * @author rhyth
 */
public class Menu {
    List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "button=" + button +
                '}';
    }

    public static class Button {
        String name;
        String type;
        String key;
        String url;
        String media_id;
        String appid;
        String pagepath;
        List<Button> sub_button;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagepath() {
            return pagepath;
        }

        public void setPagepath(String pagepath) {
            this.pagepath = pagepath;
        }

        public List<Button> getSub_button() {
            return sub_button;
        }

        public void setSub_button(List<Button> sub_button) {
            this.sub_button = sub_button;
        }

        @Override
        public String toString() {
            return "Button{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", key='" + key + '\'' +
                    ", url='" + url + '\'' +
                    ", media_id='" + media_id + '\'' +
                    ", appid='" + appid + '\'' +
                    ", pagepath='" + pagepath + '\'' +
                    ", sub_button=" + sub_button +
                    '}';
        }
    }
}
