package cn.it.xiaodongbei.shoporder.service.impl;

import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
import cn.it.xiaodongbei.shoporder.mapper.ShopOrderMapper;
import cn.it.xiaodongbei.shoporder.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cxc
 * @Date 2023/8/1 11:06 AM
 * @Version 1.0
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ShopOrderMapper shopOrderMapper;
    @Override
    public void saveOrder(ShopOrder shopOrder) {
        shopOrderMapper.insert(shopOrder);
    }
}
