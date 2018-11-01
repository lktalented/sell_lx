package com.xhh.sell_lx.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.xhh.sell_lx.dataobject.OrderDetail;
import com.xhh.sell_lx.dto.OrderDTO;
import com.xhh.sell_lx.enums.ResultEnum;
import com.xhh.sell_lx.exception.SellException;
import com.xhh.sell_lx.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 表单对象转换为数据传输对象
 * luokai
 * 2018/10/31 0031 下午 3:16
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail>orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误,String={}",orderForm.getItems());
            throw new SellException(ResultEnum.OBJECT_CONVERT_FAIL);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
