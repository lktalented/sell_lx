package com.xhh.sell_lx.service;

import com.xhh.sell_lx.dto.OrderDTO;

/**
 * 买家
 * Administrator
 * 2018/11/1 0001 上午 9:47
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
