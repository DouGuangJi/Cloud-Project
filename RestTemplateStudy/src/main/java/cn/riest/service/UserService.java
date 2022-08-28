package cn.riest.service;

import cn.riest.model.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate template;

    String url = "http://127.0.0.1:8083/test";

    public List<User> getUserList() throws InterruptedException {
//        Thread.sleep(6 * 1000);
        String forObject = template.getForObject(url, String.class);
        List<User> user = (List<User>) JSONObject.parse(forObject);
        return user;
    }

    public List<User> getUserList2() throws InterruptedException {
        ResponseEntity<String> forEntity = template.getForEntity(url, String.class);
//        System.out.println(forEntity.getStatusCode());
//        System.out.println(forEntity.getStatusCodeValue());
//        System.out.println(forEntity.getBody());
        List<User> user = (List<User>) JSONObject.parse(forEntity.getBody());
        return user;
    }

}
