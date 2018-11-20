package com.xhh.sell_lx.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie工具类
 * luokai
 * 2018/11/20 0020 下午 1:51
 */
public class CookieUtil {

    /**
     * 设置
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     */
    public static Cookie get(HttpServletRequest request,
                             String name){
        Map<String,Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }

    }


    /**
     * 将cookie封装成Map
     * @param request
     * @return
     */
    private static Map readCookieMap(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String,Cookie> cookieMap = new HashMap<>();
        if (cookies != null){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }


}
