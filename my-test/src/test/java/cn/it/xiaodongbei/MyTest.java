package cn.it.xiaodongbei;

import cn.it.xiaodongbei.eneity.MyStuednt;
import cn.it.xiaodongbei.mapper.MyStuedntMapper;
import cn.it.xiaodongbei.mapper.TestDateMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/8/27 8:50 PM
 * @Version 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Resource
    private MyStuedntMapper myStuedntMapper;
    @Resource
    private TestDateMapper testDateMapper;
    @org.junit.Test
    public void insert(){
        MyStuednt myStuednt=new MyStuednt();
        myStuednt.setAge(1);
        myStuednt.setName("cxc");
        myStuednt.setInsertTime(new Date());
        myStuedntMapper.insertSelective(myStuednt);

    }
    @org.junit.Test
    public void dateTest() throws ParseException {
        System.out.println(testDateMapper.selectFrom(new Date()).toString());

    }
}
