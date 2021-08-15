package cn.edu.whu.zhuyuhan.mq.rocketmq.producer;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendCallback;
import org.springframework.beans.factory.annotation.Autowired;

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

}
