import cn.it.xiaodongbei.shoporder.OrderApplication;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author cxc
 * @Date 2023/8/14 5:26 PM
 * @Version 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class MessageTypeTest {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testSyncSend() {
        //参数一: topic， 如果想添加tag 可以使用"topic:tag"的写法 //参数二: 消息内容
        SendResult sendResult = rocketMQTemplate.syncSend("test-topic-1", "这是一条同步消息");
        System.out.println(sendResult);
    }
    // 异步消息
    @Test
    public void testAsyncSend() throws InterruptedException {
        //参数一: topic, 如果想添加tag 可以使用"topic:tag"的写法
        // 参数二: 消息内容
        // 参数三: 回调函数, 处理返回结果
        rocketMQTemplate.asyncSend("test-topic-1", "这是一条异步消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println(throwable);
            }
        });
        Thread.sleep(300000000);

    }
}
