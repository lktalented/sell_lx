package com.xhh.sell_lx.utils;

import java.util.Random;

/**
 * 生成主键
 * luokai
 * 2018/10/29 0029 下午 5:49
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式： 时间 + 随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
