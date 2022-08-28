package cn.riest.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/kafka/test")
    public Object SendMsg() {
        JSONObject object = new JSONObject();
        object.put("key","value");
        kafkaTemplate.send("test", object.toJSONString());
        return "ok";
    }

    @GetMapping("/kafka/sync")
    public Object sync() throws Exception{
        JSONObject object = new JSONObject();
        object.put("key","value");
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("test", object.toJSONString());
        //注意，可以设置等待时间，超出后，不再等候结果
        SendResult<String, Object> result = future.get(3,TimeUnit.SECONDS);
        System.err.println("发送消息:"+result.getProducerRecord().value());
        return "ok";
    }
}
