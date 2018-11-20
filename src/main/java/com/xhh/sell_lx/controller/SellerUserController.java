package com.xhh.sell_lx.controller;

import com.xhh.sell_lx.config.ProjectUrlConfig;
import com.xhh.sell_lx.constant.CookieConstant;
import com.xhh.sell_lx.constant.RedisConstant;
import com.xhh.sell_lx.dataobject.SellerInfo;
import com.xhh.sell_lx.enums.ResultEnum;
import com.xhh.sell_lx.service.SellerService;
import com.xhh.sell_lx.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 卖家用户
 * luokai
 * 2018/11/20 0020 下午 12:00
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String,Object>map){
        //1. openid和数据库中的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null){
            map.put("msg",ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/seller_lx/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire,TimeUnit.SECONDS);
        //3. 设置token至redis
        CookieUtil.set(response,CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:"+ projectUrlConfig.getSell() + "/seller_lx/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String,Object>map){
        //1. 从cookie 里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null ){
            //2.  清除redis
            stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3. 清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/seller_lx/seller/order/list");
        return new ModelAndView("common/success",map);
    }

}
