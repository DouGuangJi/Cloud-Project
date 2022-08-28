package cn.riest.config.sentinel.flowconfig;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllFlowResource {

    /**
     * 流控规则
     */
    @PostConstruct
    public void InitFlow() {
        List<FlowRule> rules = new ArrayList<>();
        //新建一个规则
        FlowRule rule = new FlowRule();
        //保护的资源
        rule.setResource("/ip");
        //设置为QPS的规则类型
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //值为2,则表示每秒只能访问此资源两次
        rule.setCount(2);
        //strategy：流控模式，0：直接，1：关联，2：链路
        rule.setStrategy(0);
        //流控效果，0：快速失败，1：warmUp，2：排队等待
        rule.setControlBehavior(0);
        //是否集群
        rule.setClusterMode(false);
        rules.add(rule);
        //加载此资源
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 熔断/降级规则
     */
//    @PostConstruct
    public void InitDegread(){
        System.out.println("执行该方法");
        ArrayList<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("/ip");
        rule.setGrade(0);
        rule.setCount(100);
        rule.setTimeWindow(5);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }
}
