package cn.edu.whu.zhuyuhan.mq.rocketmq.producer;

import cn.edu.whu.zhuyuhan.mq.rocketmq.producer.callback.DefaultCallback;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendCallback;

import java.util.Date;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/8/14 19:37
 **/
public class Producer {

    private com.aliyun.openservices.ons.api.Producer producer;

    public Producer(com.aliyun.openservices.ons.api.Producer producer) {
        this.producer = producer;
    }

    public void start() {
        this.producer.start();
    }

    public void send(Message message) {
        this.producer.send(message);
    }

    public void sendAsync(Message message, SendCallback sendCallback) {
        this.producer.sendAsync(message, sendCallback);
    }

    public void sendDelay(Message message, Long delay) {
        message.setStartDeliverTime(System.currentTimeMillis() + delay);
        this.producer.send(message);
    }

    public void sendDelayAsync(Message message, Long delay) {
        message.setStartDeliverTime(System.currentTimeMillis() + delay);
        this.producer.sendAsync(message, new DefaultCallback());
    }

    public void sendAtFixedTime(Message message, Long timeStamp) {
        if (new Date().getTime() >= timeStamp) {
            return;
        }
        message.setStartDeliverTime(timeStamp);
        this.producer.send(message);
    }

    public void sendAtFixedTimeAsync(Message message, Long timeStamp) {
        if (new Date().getTime() >= timeStamp) {
            return;
        }
        message.setStartDeliverTime(timeStamp);
        this.producer.sendAsync(message, new DefaultCallback());
    }

    public void shutdown() {
        this.producer.shutdown();
    }

}
