package cn.edu.whu.zhuyuhan.mq.rocketmq.config;

import cn.edu.whu.zhuyuhan.mq.rocketmq.constant.PropertiesConstants;
import cn.edu.whu.zhuyuhan.mq.rocketmq.producer.Producer;
import cn.edu.whu.zhuyuhan.mq.rocketmq.producer.RocketMqProperties;
import com.aliyun.openservices.ons.api.MQType;
import com.aliyun.openservices.ons.api.ONSFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/8/7 15:42
 **/
@Configuration
@EnableConfigurationProperties({RocketMqProperties.class})
public class ProducerPropertiesAutoConfigure {

    @Autowired
    private RocketMqProperties producerProperties;

    // producer 是单例的
    @ConditionalOnMissingBean(Producer.class)
    @Bean
    public Producer producer() {
        Properties properties = new Properties();
        properties.setProperty(PropertiesConstants.GROUP_ID, producerProperties.getProducerGroup());
        properties.setProperty(PropertiesConstants.ACCESS_KEY, producerProperties.getAk());
        properties.setProperty(PropertiesConstants.SECRET_KEY, producerProperties.getSk());
        properties.setProperty(PropertiesConstants.ONS_CHANNEL, producerProperties.getOnsChannel());
        properties.setProperty(PropertiesConstants.INSTANCE_ID, producerProperties.getInstanceId());
        properties.setProperty(PropertiesConstants.TIME_OUT, producerProperties.getTimeoutMillis());
        properties.setProperty(PropertiesConstants.NAMESRV_ADDR, producerProperties.getNameServerDomain());
        properties.setProperty(PropertiesConstants.MQ_TYPE, MQType.METAQ.getName());
        com.aliyun.openservices.ons.api.Producer producer = ONSFactory.createProducer(properties);
        Producer producerWrapper = new Producer(producer);
        producerWrapper.start();
        return producerWrapper;
    }
}
