package com.amano.springcloudmqproducer.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class RocketMqTestController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @GetMapping("/send")
    public String testSendMsg(@RequestParam("msg") String msg) {
        rocketMQTemplate.convertAndSend("test", msg);
        return "success";
    }

    @GetMapping("/send/sync")
    public String testSendSync(@RequestParam("msg") String msg) {
        SendResult test = rocketMQTemplate.syncSend("test", msg);
        return JSONObject.toJSONString(test);
    }

    @GetMapping("/send/async")
    public String testSendAsync(@RequestParam("msg") String msg) {
        rocketMQTemplate.asyncSend("test:async", msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(JSONObject.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("", throwable);
            }
        },1000);
        log.info("发送延迟消息");
        rocketMQTemplate.asyncSend("test:async", MessageBuilder.withPayload(msg).build() ,new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(JSONObject.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("", throwable);
            }
        }, 1000L, 2);
        return "success";
    }
}
