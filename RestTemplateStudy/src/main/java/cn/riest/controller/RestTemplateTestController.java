package cn.riest.controller;

import cn.riest.model.User;
import cn.riest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class RestTemplateTestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;


    @GetMapping(value = "/calltest")
    public List<User> CallTest() throws InterruptedException {
        return userService.getUserList2();
//        ResponseEntity<User> forEntity = null;
//        ResponseEntity<String> res = null;
//        try {
//
//            res = restTemplate.getForEntity(url, String.class);
//            System.out.println(res);
//
////            //        User forObject = restTemplate.getForObject(url, User.class);
////            forEntity = restTemplate.getForEntity(url, User.class);
//////        ResponseEntity<User> response = restTemplate.getForEntity(url,User.class);
////            System.out.println(forEntity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return res;

    }

    public static void main(String[] args) {
//        String url = "http://127.0.0.1:8083/getuser";
//        ResponseEntity<String> res = null;
        RestTemplate template = new RestTemplate();
//        res = template.getForEntity(url, String.class);
//        System.out.println(res);
        String url = "http://127.0.0.1:8082/test";
        User forObject = template.getForObject(url, User.class);
        System.out.println(forObject);

    }
}
