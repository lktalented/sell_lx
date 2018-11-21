package com.xhh.sell_lx.service;

import com.xhh.sell_lx.dto.OrderDTO;

/**
 * 推送消息
 * luokai
 * 2018/11/21 22:14
 */
public interface PushMessageService {
    /**
     * 订单完结状态变更消息
     * @param orderDTO
     */
    void changeOrderFinishStatus(OrderDTO orderDTO);
}
