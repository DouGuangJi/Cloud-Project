package cn.riest.service.impl;

import cn.riest.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

//    @Autowired
//    private StreamBridge streamBridge;

    @Autowired
    private Source source;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        source.output().send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: " + serial);
        return "OK";
    }
}


