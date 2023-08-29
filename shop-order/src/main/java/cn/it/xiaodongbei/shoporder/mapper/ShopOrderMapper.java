package cn.it.xiaodongbei.shoporder.mapper;

import cn.it.xiaodongbei.shopcommon.eneity.ShopOrder;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxc
* @description 针对表【shop_order】的数据库操作Mapper
* @createDate 2023-07-18 22:51:11
* @Entity eneity.ShopOrder
*/
@Mapper
public interface ShopOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    ShopOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);

}
