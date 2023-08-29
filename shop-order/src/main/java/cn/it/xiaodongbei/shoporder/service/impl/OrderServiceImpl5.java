package cn.it.xiaodongbei.shoporder.service.impl;

import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
import cn.it.xiaodongbei.shoporder.mapper.ShopOrderMapper;
import cn.it.xiaodongbei.shoporder.openFeignService.ProductService;
import com.alibaba.fastjson.JSON;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cxc
 * @Date 2023/8/15 10:31 PM
 * @Version 1.0
 * @Description:
 */
@Service
@Slf4j
public class OrderServiceImpl5 {
    @Resource
    private ShopOrderMapper shopOrderMapper;
    @Resource
    private ProductService productService;
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GlobalTransactional
    public ShopOrder createOrder(Integer pid) {
        //1 调用商品微服务,查询商品信息
        ShopProduct product = productService.findById(pid);
        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));

        //2 下单(创建订单)
        ShopOrder order = new ShopOrder();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        shopOrderMapper.insertSelective(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        //3 扣库存
        productService.reduceInventory(pid, order.getNumber());
        //4 向mq中投递一个下单成功的消息
        rocketMQTemplate.convertAndSend("order-topic", order);
        return order;
    }

}
