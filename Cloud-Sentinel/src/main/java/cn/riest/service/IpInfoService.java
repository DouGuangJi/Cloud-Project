package cn.riest.service;

import cn.riest.model.ResultModel;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class IpInfoService {

//    @SentinelResource(value = "ip_info", blockHandler = "exceptionHandler")
    public ResultModel getIpInfo() {
        String result = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            result = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ResultModel.ok(result);
    }

////     Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
//    public ResultModel exceptionHandler(BlockException ex) {
//        ex.printStackTrace();
//        return ResultModel.error("请求过于频繁");
//    }
}
