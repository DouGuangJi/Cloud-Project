package com.riest.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProcessFirst implements JavaDelegate{

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("测试流程执行第一步");
    }
}
