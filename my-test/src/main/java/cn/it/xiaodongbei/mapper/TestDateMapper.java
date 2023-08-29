package cn.it.xiaodongbei.mapper;

import cn.it.xiaodongbei.eneity.TestDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
* @author cxc
* @description 针对表【test_date】的数据库操作Mapper
* @createDate 2023-08-28 23:03:16
* @Entity eneity.TestDate
*/
@Mapper
public interface TestDateMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TestDate record);

    int insertSelective(TestDate record);

    TestDate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestDate record);

    int updateByPrimaryKey(TestDate record);
    @Select("select * from test_date where date1  < #{date}")
    List<TestDate> selectFrom(Date date);

}
