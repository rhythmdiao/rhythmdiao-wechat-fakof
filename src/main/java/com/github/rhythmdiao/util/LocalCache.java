package com.github.rhythmdiao.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rhyth
 */

public enum LocalCache {
    ;
    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    public static Object get(String key) {
        return map.get(key);
    }

    public static void set(String key, Object value) {
        map.put(key, value);
    }
}
