package cn.it.xiaodongbei.shoporder.controller;

import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
import cn.it.xiaodongbei.shoporder.service.impl.OrderServiceImpl5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cxc
 * @Date 2023/8/15 10:28 PM
 * @Version 1.0
 * @Description:
 */
@RestController
@Slf4j
public class OrderController5 {
    @Autowired
    private OrderServiceImpl5 serviceImpl;

    //下单
    @RequestMapping("/order/prod/{pid}")
    public ShopOrder order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        return serviceImpl.createOrder(pid);
    }
}
