package cn.it.xiaodongbei.shopproduct.controller;

import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
import cn.it.xiaodongbei.shopproduct.service.ProductService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cxc
 * @Date 2023/7/18 9:58 PM
 * @Version 1.0
 * @Description:
 */

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{pid}")
    public ShopProduct product(@PathVariable("pid") Integer pid) {
        ShopProduct product = productService.findByPid(pid);
        log.info("查询到商品:" + JSON.toJSONString(product));
        return product;
    }

    //减少库存
    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(Integer pid, int num) {
        productService.reduceInventory(pid, num);
    }
}
