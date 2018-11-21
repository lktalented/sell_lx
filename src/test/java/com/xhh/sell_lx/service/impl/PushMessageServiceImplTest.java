package com.xhh.sell_lx.service.impl;

import com.xhh.sell_lx.dto.OrderDTO;
import com.xhh.sell_lx.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {
    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void changeOrderFinishStatus(){
        OrderDTO orderDTO = orderService.findOne("1537455530609708785") ;
        pushMessageService.changeOrderFinishStatus(orderDTO);

    }


}