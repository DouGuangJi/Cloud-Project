package cn.riest.filter;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan
public class NacosLoadBalanceRule {

    @Bean
    @Scope(value = "prototype")
    public IRule loadBalanceRule() {
        return new NacosRule();
    }
}
