package cn.riest.controller;

import cn.riest.model.ResultModel;
import cn.riest.service.IpInfoService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class SentinelRest {

    @Autowired
    IpInfoService ipInfoService;

//    @SentinelResource(value = "flow", blockHandler = "flowBlockHandler")

    //    @SentinelResource(value = "ip_info", blockHandler = "exceptionHandler")
    @RequestMapping(value = "/ip", method = {RequestMethod.GET})
    public ResultModel welCome() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ipInfoService.getIpInfo();
    }

    //Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public ResultModel exceptionHandler(BlockException ex) {
        ex.printStackTrace();
        return ResultModel.error("请求过于频繁");
    }

    public ResultModel flowBlockHandler(BlockException blockException) {
//        blockException.printStackTrace();
        return ResultModel.error("接口被流控了");
    }

    @RequestMapping(value = "/get/menulist", method = {RequestMethod.GET})
    public ResultModel GetRestaurantMenu() {
        JSONObject menulist = new JSONObject();
        menulist.put("青椒炒蛋", "20元");
        menulist.put("蒜苔炒肉", "30元");
        menulist.put("京酱肉丝", "50元");
        menulist.put("麻婆豆腐", "20元");
        return new ResultModel("0", "success", menulist.toJSONString());

    }
}
