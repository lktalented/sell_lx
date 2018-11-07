package com.xhh.sell_lx.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.xhh.sell_lx.dto.OrderDTO;

/**
 * 支付
 * Administrator
 * 2018/11/6 0006 上午 9:23
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
