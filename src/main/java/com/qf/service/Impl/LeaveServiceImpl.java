package com.qf.service.Impl;

import com.qf.mapper.LeaveMapper;
import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.LeaveService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: liu
 * date: 2019/7/16 14:08
 * info :
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private LeaveMapper leaveMapper;


    @Override
    public int addLeave(Leave leave) {

        int i = leaveMapper.addLeave(leave);

        Map<String, Object> map = new HashMap<>();
        map.put("role", 1);
        map.put("employee", leave.getUser().getName());
        map.put("boss", leaveMapper.queryBoss());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", leave.getLid() + "", map);

        Task task = taskService.createTaskQuery().taskAssignee(leave.getUser().getName()).processInstanceId(processInstance.getId()).singleResult();

        taskService.complete(task.getId());

        return i;
    }

    @Override
    public List<Leave> queryLeaveList(String name) {

        List<Task> tasks = taskService.createTaskQuery().taskAssignee(name).list();

        List<String> ids = new ArrayList<>();
        List<Leave> leaves = null;
        for (Task task : tasks) {

            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();

            ids.add(processInstance.getBusinessKey());

        }

        if (ids.size() > 0){
            leaves = leaveMapper.queryLeaveList(ids);
        }else {
            leaves = new ArrayList<>();
        }



        return leaves;
    }

    @Override
    public int updateLeave(Integer lid, String name) {

        int i = leaveMapper.updateLeave(lid);

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(lid + "").singleResult();

        System.out.println(processInstance.getId());

        System.out.println(name);
        String id = taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskAssignee(name).singleResult().getId();

        taskService.complete(id);

        return i;
    }

    @Override
    public String getPasswordByUname(String uname) {

        String password = leaveMapper.getPasswordByUname(uname);

        return password;
    }

    @Override
    public List<String> getRoleList(String uname) {
        return leaveMapper.getRoleList(uname);
    }

    @Override
    public List<String> getPermissionList(String rname) {
        return leaveMapper.getPermissionList(rname);
    }

    @Override
    public List isApproved(User user) {

        List<Integer> businessKeys = leaveMapper.getLidByUid(user.getId());

        List<HistoricProcessInstance> hiprocinses = new ArrayList<>();

        for (Integer businessKey : businessKeys) {

            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey + "").singleResult();

            hiprocinses.add(historicProcessInstance);

        }

        return hiprocinses;
    }
}
