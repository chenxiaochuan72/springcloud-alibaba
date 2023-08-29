package cn.it.xiaodongbei.shoporder.log;

import lombok.Data;

import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/8/14 5:36 PM
 * @Version 1.0
 * @Description:
 */

//事物日志
@Data
public class TxLog {
    private String txLogId;
    private String content;
    private Date date;
}
