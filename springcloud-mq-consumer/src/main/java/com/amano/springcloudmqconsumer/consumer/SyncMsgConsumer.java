package com.amano.springcloudmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "test", consumerGroup = "${rocketmq.consumer.group}", selectorExpression = "sync")
@Slf4j
public class SyncMsgConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info(s);
    }
}
