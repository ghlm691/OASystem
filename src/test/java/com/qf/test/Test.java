package com.qf.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: liu
 * date: 2019/7/15 19:11
 * info :
 */
public class Test {

    @org.junit.Test
    public void test(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_dao.xml");

        RepositoryService repositoryService = (RepositoryService) classPathXmlApplicationContext.getBean("repositoryService");

        repositoryService.createDeployment().addClasspathResource("leave.bpmn").name("请假").deploy();

    }

    @org.junit.Test
    public void test2(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_dao.xml");
        TaskService taskService = (TaskService) classPathXmlApplicationContext.getBean("taskService");

        taskService.complete("35004");

    }



}
