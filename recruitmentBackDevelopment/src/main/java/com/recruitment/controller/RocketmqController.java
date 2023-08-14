package com.recruitment.controller;

//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/rocketmq")
//public class RocketmqController {
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//    /**
//     * 同步消息生产者发送 rockettemplate 模板
//     */
//    @PostMapping("/sendmessage")
//    public Result creatProducer(String consumerId,String message){
//        SendResult res = rocketMQTemplate.syncSend(consumerId, message);
//        if (res!=null) {
//            return new Result(Code.creatProducer_ok, res, Code.creatProducer_ok_msg);
//        } else {
//            return new Result(Code.creatProducer_err, res, Code.creatProducer_err_msg);
//        }
//    }
//}
