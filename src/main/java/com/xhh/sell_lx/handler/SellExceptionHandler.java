package com.xhh.sell_lx.handler;

import com.xhh.sell_lx.config.ProjectUrlConfig;
import com.xhh.sell_lx.exception.ResponseBankException;
import com.xhh.sell_lx.exception.SellException;
import com.xhh.sell_lx.exception.SellerAuthorizeException;
import com.xhh.sell_lx.utils.ResultVOUtil;
import com.xhh.sell_lx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return  ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){

    }
}
