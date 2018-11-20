package com.xhh.sell_lx.handler;

import com.xhh.sell_lx.config.ProjectUrlConfig;
import com.xhh.sell_lx.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截登录异常
 * luokai
 * 2018/11/20 22:36
 */
@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return  new ModelAndView("redirect:".concat(projectUrlConfig.getSell()).concat("/seller_lx/seller/login?openid=abc") );
    }
}
