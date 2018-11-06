package com.xhh.sell_lx.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 格式化json字符串
 * luokai
 * 2018/11/6 0006 上午 9:48
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder =new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
