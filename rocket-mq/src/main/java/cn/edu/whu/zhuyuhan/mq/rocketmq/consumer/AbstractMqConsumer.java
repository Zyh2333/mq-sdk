package cn.edu.whu.zhuyuhan.mq.rocketmq.consumer;

import cn.edu.whu.zhuyuhan.mq.rocketmq.constant.PropertiesConstants;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

/**
 * consumer是多例的
 * <p>
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/8/7 16:11
 **/
public abstract class AbstractMqConsumer implements InitializingBean {

    @Value("${mq.properties.ak}")
    private String ak;

    @Value("${mq.properties.sk}")
    private String sk;

    @Value("${mq.properties.onsChannel}")
    private String onsChannel;

    @Value("${mq.properties.timeoutMills}")
    private String timeoutMillis;

    @Value("${mq.properties.instanceId}")
    private String instanceId;

    @Value("${mq.properties.nameServerDomain}")
    private String nameServerDomain;

    protected Consumer consumer;


    @Override
    public void afterPropertiesSet() throws Exception {
        Properties properties = new Properties();
        properties.setProperty(PropertiesConstants.GROUP_ID, this.consumerGroup());
        properties.setProperty(PropertiesConstants.ACCESS_KEY, this.ak);
        properties.setProperty(PropertiesConstants.SECRET_KEY, this.sk);
        properties.setProperty(PropertiesConstants.ONS_CHANNEL, this.onsChannel);
        properties.setProperty(PropertiesConstants.INSTANCE_ID, this.instanceId);
        properties.setProperty(PropertiesConstants.TIME_OUT, this.timeoutMillis);
        properties.setProperty(PropertiesConstants.NAMESRV_ADDR, this.nameServerDomain);
//        properties.setProperty(PropertiesConstants.MQ_TYPE, "");
        this.consumer = ONSFactory.createConsumer(properties);
        this.subscribe();
    }

    public abstract String consumerGroup();

    public abstract void subscribe();

}
