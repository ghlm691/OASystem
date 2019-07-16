package com.qf.service.Impl;

import com.qf.mapper.LeaveMapper;
import com.qf.pojo.Leave;
import com.qf.service.LeaveService;
import com.qf.service.StudentService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        map.put("role", "employee");
        map.put("teacher", leave.getUser().getUsername());
        map.put("boss", leaveMapper.queryBoss());

        runtimeService.startProcessInstanceByKey("leave", leave.getLid()+"", map);

        Task task = taskService.createTaskQuery().taskAssignee(leave.getUser().getUsername()).singleResult();

        taskService.complete(task.getId());

        return i;
    }

    @Override
    public List<Leave> queryLeaveList(String name) {

        List<Task> tasks = taskService.createTaskQuery().taskAssignee(name).list();

        List<String> ids = new ArrayList<>();

        for (Task task : tasks) {

            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();

            ids.add(processInstance.getBusinessKey());

        }

        List<Leave> leaves = leaveMapper.queryLeaveList(ids);

        return leaves;
    }

    @Override
    public int updateLeave(Integer lid) {

        int i = leaveMapper.updateLeave(lid);

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(lid + "").singleResult();

        String id = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getId();

        taskService.complete(id);

        return i;
    }

    @Override
    public String getPasswordByUname(String uname) {

        String password = leaveMapper.getPasswordByUname(uname);

        return password;
    }
}
