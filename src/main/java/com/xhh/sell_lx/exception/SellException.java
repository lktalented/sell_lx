package com.xhh.sell_lx.exception;

import com.xhh.sell_lx.enums.ResultEnum;
import lombok.Getter;

/**
 * 异常处理对象
 * luokai
 * 2018/10/29 0029 下午 5:31
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
