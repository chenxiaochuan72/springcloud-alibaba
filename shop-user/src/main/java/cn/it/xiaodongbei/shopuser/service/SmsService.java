package cn.it.xiaodongbei.shopuser.service;

import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Author cxc
 * @Date 2023/8/14 4:25 PM
 * @Version 1.0
 * @Description:
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "shop-user",topic = "order-topic")
public class SmsService implements RocketMQListener<ShopOrder> {
    @Override
    public void onMessage(ShopOrder shopOrder) {
        log.info("收到一个订单信息{},接下来发送短信", JSON.toJSONString(shopOrder));
    }
}
