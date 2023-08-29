package cn.it.xiaodongbei.shopproduct.mapper;

import cn.it.xiaodongbei.shopcommon.eneity.ShopProduct;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxc
* @description 针对表【shop_product】的数据库操作Mapper
* @createDate 2023-07-18 22:51:11
* @Entity eneity.ShopProduct
*/
@Mapper
public interface ShopProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ShopProduct record);

    int insertSelective(ShopProduct record);
    ShopProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopProduct record);

    int updateByPrimaryKey(ShopProduct record);

}
