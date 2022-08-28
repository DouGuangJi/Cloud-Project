package cn.riest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyOne {

    @GetMapping(value = "/getuser")
    public String getUsername() {
        return "dgj_01";
    }
}
