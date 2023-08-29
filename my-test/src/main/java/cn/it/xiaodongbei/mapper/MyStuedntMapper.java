package cn.it.xiaodongbei.mapper;

import cn.it.xiaodongbei.eneity.MyStuednt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
* @author cxc
* @description 针对表【my_stuednt(学生表)】的数据库操作Mapper
* @createDate 2023-08-27 20:47:59
* @Entity eneity.MyStuednt
*/
@Mapper
public interface MyStuedntMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MyStuednt record);

    int insertSelective(MyStuednt record);

    MyStuednt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MyStuednt record);

    int updateByPrimaryKey(MyStuednt record);
    @Select("select * from my_stuednt where insert_time")
    MyStuednt selectByInsertTime(Date insertTime);

}
