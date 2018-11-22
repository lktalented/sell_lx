package com.xhh.sell_lx.service.impl;

import com.xhh.sell_lx.config.WechatAccountConfig;
import com.xhh.sell_lx.dto.OrderDTO;
import com.xhh.sell_lx.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 模板消息实现类
 * luokai
 * 2018/11/21 22:18
 */

@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public void changeOrderFinishStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(wechatAccountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","亲，请记得收货。"),
                new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","18868812345"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","$"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎下次光临！")
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}",e);
        }

    }
}
