package com.riest.controller;

import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * 测试service task
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/start1")
    public String StartTest1(String id) {

        //0、获取流程引擎
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RuntimeService runtimeService = processEngine.getRuntimeService();
        //1、获取流程ID
        String processDefinitionkey = id;
        //2、开始执行流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionkey);
        //流程实例ID
        System.out.println("流程实例ID：" + processInstance.getId());
        //流程定义ID
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());
        // 自定义参数
        System.out.println(processInstance.getBusinessKey());

        return "流程启动";
    }

    /**
     * 测试 usertask+gateway
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/start2")
    public String StartTest2(String id) {

        //0、获取流程引擎
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RuntimeService runtimeService = processEngine.getRuntimeService();
        //1、获取流程ID
        String processDefinitionkey = id;
        //2、开始执行流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionkey);
        //流程实例ID
        System.out.println("流程实例ID：" + processInstance.getId());
        //流程定义ID
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());
        // 自定义参数
        System.out.println(processInstance.getBusinessKey());

        System.out.println("流程开始");

        return "流程启动";
    }

    /**
     * 测试service task
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/start3")
    public String StartTest3(String id) {

        //0、获取流程引擎
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RuntimeService runtimeService = processEngine.getRuntimeService();
        //1、获取流程ID
        String processDefinitionkey = id;
        //2、开始执行流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionkey);
        //流程实例ID
        System.out.println("流程实例ID：" + processInstance.getId());
        //流程定义ID
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());
        // 自定义参数
        System.out.println(processInstance.getBusinessKey());

        System.out.println("流程开始");

        return "流程启动";
    }


    /**
     * 测试service task
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/start5")
    public String StartTest5(String id) {

        //0、获取流程引擎
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RuntimeService runtimeService = processEngine.getRuntimeService();
        //1、获取流程ID
        String processDefinitionkey = id;
        //2、开始执行流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionkey);
        //流程实例ID
        System.out.println("流程实例ID：" + processInstance.getId());
        //流程定义ID
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());
        // 自定义参数
        System.out.println(processInstance.getBusinessKey());

        System.out.println("流程开始");

        return "流程启动";
    }

    /**
     * 判断流程是否在运行
     *
     * @param processInstanceId
     * @return
     */
    @GetMapping(value = "/check/process/isexec")
    public String checkProcessIsExectue(String processInstanceId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("85def19f-2297-11ed-9c4a-764ca1c1475d")
                // 结果唯一的，可以用single，如果大于1，则会报错
                .singleResult();
        if (processInstance == null) {
            return "当前实例已经结束了";
        } else {
            return "当前实例正在运转";

        }
    }

    /**
     * 暂停一个流程
     *
     * @param processInstanceId
     * @return
     */
    @GetMapping(value = "/stop/process")
    public String stopProcess(String processInstanceId) {
        runtimeService.suspendProcessInstanceById(processInstanceId);
        return "流程已经暂停";
    }

    /**
     * 重启(激活)一个流程
     *
     * @param processInstanceId
     * @return
     */
    @GetMapping(value = "/active/process")
    public String activeProcerss(String processInstanceId) {
        runtimeService.activateProcessInstanceById(processInstanceId);
        return "流程已经重新启动";
    }

    /**
     * 删除一个流程
     *
     * @param processInstanceId
     * @return
     */
    @GetMapping(value = "/delete/process")
    public String deleteProcerss(String processInstanceId) {
        String reason = "流程异常";
        runtimeService.deleteProcessInstance(processInstanceId, reason);
        return "流程删除成功";
    }


    /**
     * 查询用户已经完成的任务
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/query/exec/task")
    public List<HistoricTaskInstance> queryAlearyExecTask(String username) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 历史任务Service
        List<HistoricTaskInstance> list = processEngine.getHistoryService()
                // 创建历史任务实例查询
                .createHistoricTaskInstanceQuery()
                // 指定办理人
                .taskAssignee(username)
                // 查询已经完成的任务
                .finished()
                .list();
        return list;
    }




    /**
     * 查询用户代办任务
     * https://codeleading.com/article/5742412640/
     *
     * @param username
     * @param processInstanceId
     * @return
     */
    @GetMapping(value = "/query/Agency/task")
    public ArrayList<String> queryAgencyTask(String username, String processInstanceId) {
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(username)
                .processInstanceId(processInstanceId).list();
        System.out.println(list.size());

        ArrayList<String> strings = new ArrayList<>();

        if (!Objects.isNull(list)) {
            list.forEach(item -> {
                strings.add(item.getId());
            });
        }
        return strings;
    }

    /**
     * 用户完成任务
     *
     * @param taskId
     * @param username
     * @return
     */
    @GetMapping(value = "/complete/task")
    public String completeTask(String taskId, String username, String flag, String idae) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        System.out.println(task);
        String processInstancesId = task.getProcessInstanceId();
        IdentityService identityService = processEngine.getIdentityService();
        //这设置的时审批人及查询意见时的userId。
        identityService.setAuthenticatedUserId(username);
        String idea = "通过";
        taskService.addComment(taskId, processInstancesId, idea);
        //idea意思是完成时的审批意见，可在Act_Hi_Comment里的massge查询到

        Map<String, Object> map = new HashMap<>();
        //这个map根据bpmn情况定，传入complete方法
        map.put(flag, idae);
        // 完成任务
        taskService.complete(taskId, map);
        return "完成任务";
    }

}
