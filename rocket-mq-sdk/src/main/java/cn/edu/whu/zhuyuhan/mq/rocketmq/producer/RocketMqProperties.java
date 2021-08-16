package cn.edu.whu.zhuyuhan.mq.rocketmq.producer;

import com.aliyun.openservices.ons.api.MQType;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/8/7 15:42
 **/
@ConfigurationProperties("mq.properties")
public class RocketMqProperties {

    private String producerGroup;

    private String ak;

    private String sk;

    private String onsChannel;

    private String timeoutMillis;

    private String instanceId;

    private String nameServerDomain;

    public RocketMqProperties() {
    }

    public Properties getMqProperties() {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.AccessKey, this.ak);
        properties.setProperty(PropertyKeyConst.SecretKey, this.sk);
        properties.setProperty(PropertyKeyConst.GROUP_ID, this.producerGroup);
        properties.setProperty(PropertyKeyConst.INSTANCE_ID, this.instanceId);
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, this.nameServerDomain);
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, this.timeoutMillis);
        properties.setProperty(PropertyKeyConst.OnsChannel, this.onsChannel);
        properties.setProperty(PropertyKeyConst.MQType, MQType.METAQ.getName());
        return properties;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getOnsChannel() {
        return onsChannel;
    }

    public void setOnsChannel(String onsChannel) {
        this.onsChannel = onsChannel;
    }

    public String getTimeoutMillis() {
        return timeoutMillis;
    }

    public void setTimeoutMillis(String timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getNameServerDomain() {
        return nameServerDomain;
    }

    public void setNameServerDomain(String nameServerDomain) {
        this.nameServerDomain = nameServerDomain;
    }
}
