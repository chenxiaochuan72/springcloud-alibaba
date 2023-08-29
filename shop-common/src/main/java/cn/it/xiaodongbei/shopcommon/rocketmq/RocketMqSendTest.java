package cn.it.xiaodongbei.shopcommon.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Author cxc
 * @Date 2023/8/14 3:57 PM
 * @Version 1.0
 * @Description:
 */

public class RocketMqSendTest {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        Message msg = new Message("myTopic", "myTag", ("RocketMQ Message").getBytes());
        SendResult sendResult = producer.send(msg, 10000);
        System.out.println(sendResult);
        producer.shutdown();


    }
}
