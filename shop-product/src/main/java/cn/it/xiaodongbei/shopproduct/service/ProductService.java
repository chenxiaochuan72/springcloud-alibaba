package cn.it.xiaodongbei.shopproduct.service;


import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;

/**
 * @Author cxc
 * @Date 2023/7/18 9:57 PM
 * @Version 1.0
 * @Description:
 */

public interface ProductService {
    public ShopProduct findByPid(Integer pid);

    void reduceInventory(Integer pid, int num);
}
