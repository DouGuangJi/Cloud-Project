package cn.riest.sonsumer;


import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class MeaasgeRece {

    @StreamListener(Sink.INPUT)
    public void getMessage(Object message) {

        System.out.println("收到消息:" + message);
    }
}
