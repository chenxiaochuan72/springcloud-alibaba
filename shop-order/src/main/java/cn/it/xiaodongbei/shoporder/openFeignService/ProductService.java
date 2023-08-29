package cn.it.xiaodongbei.shoporder.openFeignService;

import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author cxc
 * @Date 2023/8/1 4:01 PM
 * @Version 1.0
 * @Description:
 */
@FeignClient("service-product")
public interface ProductService {
    @GetMapping(value = "/product/{pid}")
    ShopProduct findById(@PathVariable("pid") Integer id);
    //减库存
    @RequestMapping("/product/reduceInventory")
    void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") int num);
}
