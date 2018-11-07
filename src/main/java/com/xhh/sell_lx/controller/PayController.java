package com.xhh.sell_lx.controller;

import com.lly835.bestpay.model.PayResponse;
import com.xhh.sell_lx.dto.OrderDTO;
import com.xhh.sell_lx.enums.ResultEnum;
import com.xhh.sell_lx.exception.SellException;
import com.xhh.sell_lx.service.OrderService;
import com.xhh.sell_lx.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付
 * luokai
 * 2018/11/6 0006 下午 2:42
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId")String orderId,
                               @RequestParam("returnUrl")String returnUrl,
                               Map<String,Object>map){
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);
        return new ModelAndView("pay/create",map);

    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);
        //返回微信处理结果
        return new ModelAndView("/pay/success");
    }



}
