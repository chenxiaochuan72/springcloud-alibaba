package cn.it.xiaodongbei.controller;

import cn.it.xiaodongbei.eneity.MyStuednt;
import cn.it.xiaodongbei.mapper.MyStuedntMapper;
import cn.it.xiaodongbei.thread.ViThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author cxc
 * @Date 2023/8/27 9:01 PM
 * @Version 1.0
 * @Description:
 */
@RestController
public class StudentController {
    @Resource
    private MyStuedntMapper myStuedntMapper;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @GetMapping("/insertStuendt")
    public void insertStuendt(){
        List<MyStuednt> list=new ArrayList<>();
        for(int i=0;i<100;i++) {
            MyStuednt myStuednt = new MyStuednt();
            int age = new Random().nextInt(100);
            myStuednt.setAge(age);
            myStuednt.setName("cxc"+age);
            myStuednt.setInsertTime(new Date());
            list.add(myStuednt);
        }
        try {
            ViThreadPoolManager.getInstance().execute(new InsertStudent(myStuedntMapper,list,dataSourceTransactionManager,transactionDefinition));
        } catch (Exception e) {
            System.out.println("发发现了异常");
        }
    }
}

class InsertStudent implements Runnable{

    private MyStuedntMapper myStuedntMapper;
    private List<MyStuednt> stuednts;

    private DataSourceTransactionManager dataSourceTransactionManager;

    private TransactionDefinition transactionDefinition;

    public InsertStudent(MyStuedntMapper myStuedntMapper, List<MyStuednt> stuednts, DataSourceTransactionManager dataSourceTransactionManager, TransactionDefinition transactionDefinition) {
        this.myStuedntMapper = myStuedntMapper;
        this.stuednts = stuednts;
        this.dataSourceTransactionManager = dataSourceTransactionManager;
        this.transactionDefinition = transactionDefinition;
    }

    @Override
    public void run() {
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            for (int i=0;i<stuednts.size();i++) {

                myStuedntMapper.insert(stuednts.get(i));
                if (i==2){
                    int l=1/0;
                }
            }
            dataSourceTransactionManager.commit(transaction);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transaction);
            throw new RuntimeException(e);
        }

    }
}
