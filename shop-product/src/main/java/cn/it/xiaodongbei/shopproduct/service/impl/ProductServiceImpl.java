package cn.it.xiaodongbei.shopproduct.service.impl;

import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
import cn.it.xiaodongbei.shopproduct.mapper.ShopProductMapper;
import cn.it.xiaodongbei.shopproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cxc
 * @Date 2023/7/18 9:57 PM
 * @Version 1.0
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ShopProductMapper shopProductMapper;

    @Override
    public ShopProduct findByPid(Integer pid) {
        return shopProductMapper.selectByPrimaryKey(Long.valueOf(pid));
    }

    @Override
    public void reduceInventory(Integer pid, int number) {
        ShopProduct product = shopProductMapper.selectByPrimaryKey(Long.valueOf(pid));
        if (product.getStock() < number) {
            throw new RuntimeException("库存不足");
        }
        int i = 1 / 0;
        product.setStock(product.getStock() - number);
        //减库存
        shopProductMapper.updateByPrimaryKeySelective(product);
    }
}
