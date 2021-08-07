package cn.edu.whu.zhuyuhan.mq.rocketmq.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
