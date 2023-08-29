package cn.it.xiaodongbei.shoporder.controller;

import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
import cn.it.xiaodongbei.shoporder.openFeignService.ProductService;
import cn.it.xiaodongbei.shoporder.service.OrderService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author cxc
 * @Date 2023/8/1 4:11 PM
 * @Version 1.0
 * @Description:
 */
@RestController
@Slf4j
public class OrderController2 {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/order/prod/{pid}")
    public ShopOrder order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        // 通过feign调用商品微服务
        ShopProduct product = productService.findById(pid);
        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ShopOrder order = new ShopOrder();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
//        orderService.saveOrder(order);

        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));

        rocketMQTemplate.convertAndSend("order-topic",order);
        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }
}
