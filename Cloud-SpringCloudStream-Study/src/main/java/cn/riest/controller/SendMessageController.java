package cn.riest.controller;

import cn.riest.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider provider;

    @GetMapping(value = "/sendMessage")
    public String send(){
        return  provider.send();
//        return  "ok";
    }

    @GetMapping(value = "/test/send")
    public void TestSend(){
        System.out.println("---->{}测试发送");
    }
}
