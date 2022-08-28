package cn.riest.controller;

import cn.riest.config.ApiResult;
import cn.riest.config.NoRepeatSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class RepeatController {


    private Object data;

    @GetMapping(value = "/stop/repeat")
    @NoRepeatSubmit()
    public Object getContent() {
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        System.out.println("web请求:" + sessionId);
        data = "程序逻辑返回,假设是一大堆DB来的数据。。。";
        return new ApiResult(200, "请求成功", data);
    }
}
