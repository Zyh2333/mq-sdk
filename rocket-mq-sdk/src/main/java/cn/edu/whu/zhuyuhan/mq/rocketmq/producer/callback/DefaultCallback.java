package cn.edu.whu.zhuyuhan.mq.rocketmq.producer.callback;

import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;

/**
 * Author: Zhu yuhan
 * Email: zhuyuhan2333@qq.com
 * Date: 2021/8/15 12:00
 **/
public class DefaultCallback implements SendCallback {

    @Override
    public void onSuccess(SendResult sendResult) {

    }

    @Override
    public void onException(OnExceptionContext context) {

    }
}
