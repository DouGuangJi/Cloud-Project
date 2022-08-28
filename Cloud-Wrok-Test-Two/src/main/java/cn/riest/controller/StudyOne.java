package cn.riest.controller;


import cn.riest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StudyOne {

    @GetMapping(value = "/getuser")
    public String getUsername() {
        return "dgj_02";
    }

    @GetMapping(value = "/test")
    public ArrayList<User> readStr() throws InterruptedException {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new User(i + 1L,"张三"+ i));
        }
//        list.add(new User(1L,"张三"));
//        list.add(new User(2L,"李四"));
//        list.add(new User(3L,"王五"));
//        list.add(new User(4L,"马六"));
        return list;
    }
}
