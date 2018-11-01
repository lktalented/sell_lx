package com.xhh.sell_lx.converter;

import com.xhh.sell_lx.dataobject.OrderMaster;
import com.xhh.sell_lx.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据库对象转换为数据传输对象
 * luokai
 * 2018/10/30 0030 下午 2:46
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public  static List<OrderDTO> convert(List<OrderMaster>orderMasterList){
        return orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }

}
