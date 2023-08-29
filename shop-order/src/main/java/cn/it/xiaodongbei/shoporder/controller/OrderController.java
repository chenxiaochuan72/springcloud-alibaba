//package cn.it.xiaodongbei.shoporder.controller;
//
//import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
//import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
//import cn.it.xiaodongbei.shoporder.openFeignService.ProductService;
//import cn.it.xiaodongbei.shoporder.service.OrderService;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//
///**
// * @Author cxc
// * @Date 2023/8/1 11:07 AM
// * @Version 1.0
// * @Description:
// */
//
//@RestController
//@Slf4j
//public class OrderController {
//    @Resource
//    private RestTemplate restTemplate;
//    @Autowired
//    private OrderService orderService;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/order/prod/{pid}")
//    public ShopOrder order(@PathVariable("pid") Integer pid) {
//        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
////        //通过restTemplate调用商品微服务
////        ShopProduct product = restTemplate.getForObject("http://localhost:8081/product/" + pid, ShopProduct.class);
//
//        // nacos调用
////        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
////        int index= new Random().nextInt(instances.size());
////        ServiceInstance serviceInstance = instances.get(index);
////        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
////        log.info(">>从nacos中获取到的微服务地址为:" + url);
////        ShopProduct product = restTemplate.getForObject("http://" + url + "/product/" + pid, ShopProduct.class);
//
////        //直接使用微服务名字， 从nacos中获取服务地址
////        String url = "service-product";
////        ShopProduct product = restTemplate.getForObject("http://" + url + "/product/" + pid, ShopProduct.class);
//        ShopProduct product = productService.findById(pid);
//        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
//        ShopOrder order = new ShopOrder();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(product.getPid());
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.saveOrder(order);
//        return order;
//    }
//}
