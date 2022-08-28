package riest.springplatform.service;

import org.apache.dubbo.config.annotation.Service;
import riest.springplatform.ApiService;

@Service
public class DubboProvider implements ApiService {
    @Override
    public String getUserInfo(String name) {
        return "收到生产者消息";
    }
}
