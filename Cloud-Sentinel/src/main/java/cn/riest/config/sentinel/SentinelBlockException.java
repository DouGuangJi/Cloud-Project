package cn.riest.config.sentinel;

import cn.riest.model.ResultModel;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SentinelBlockException implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ResultModel responseDate = null;
        if (e instanceof FlowException) {
            responseDate = ResultModel.error("接口被限流了");
        } else if (e instanceof DegradeException) {
            responseDate = ResultModel.error( "接口被降级了");
        } else if (e instanceof ParamFlowException) {
            responseDate = ResultModel.error("接口被热点限流了");
        } else if (e instanceof AuthorityException) {
            responseDate = ResultModel.error("接口被授权规则限制访问了");
        } else if (e instanceof SystemBlockException) {
            responseDate = ResultModel.error("接口被系统规则限制了了");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(responseDate));
    }
}
