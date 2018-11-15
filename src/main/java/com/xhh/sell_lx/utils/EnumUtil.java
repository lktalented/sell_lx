package com.xhh.sell_lx.utils;

import com.xhh.sell_lx.enums.CodeEnum;

/**
 * Created by luokai
 * 2017-07-16 18:36
 */
public class EnumUtil {

    public  static <T extends CodeEnum> T getByCode(Integer code,Class<T>enumClass ){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
