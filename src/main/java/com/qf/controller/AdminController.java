package com.qf.controller;

import com.qf.pojo.Classes;
import com.qf.pojo.Course;
import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import com.qf.pojo.vo.CourseVO;
import com.qf.pojo.vo.PermissionVO;
import com.qf.pojo.vo.RoleVO;
import com.qf.pojo.vo.UserVO;
import com.qf.service.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/17 17:39
 * description:超级管理员
 */

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    //跳转课程管理
    @RequestMapping("admin_course")
    public ModelAndView toCourse(){
        ModelAndView modelAndView = new ModelAndView();
        List<Course> courses = adminService.queryCourse();
        List<UserVO> teachers = adminService.getTeacher();
        modelAndView.addObject("teachers",teachers);
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("ad_course");
        return modelAndView;
    }

    //跳转用户管理
    @RequestMapping("admin_user")
    public ModelAndView toUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserAndRole> users = adminService.getUser();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("ad_user");
        return modelAndView;
    }

    //跳转角色管理
    @RequestMapping("admin_role")
    public ModelAndView toRole(){
        ModelAndView modelAndView = new ModelAndView();
        List<RoleVO> rList = adminService.getRole();
        modelAndView.addObject("rList",rList);
        modelAndView.setViewName("ad_role");
        return modelAndView;
    }

    //跳转员工管理
    @RequestMapping("admin_show")
    public ModelAndView toShow(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ad_show");
        return modelAndView;
    }

    //跳转班级管理
    @RequestMapping("admin_class")
    public ModelAndView toClass(){
        ModelAndView modelAndView = new ModelAndView();
        List<Classes> list = adminService.getClasses();
        modelAndView.addObject("cList",list);
        modelAndView.setViewName("ad_class");
        return modelAndView;
    }

    //跳转权限管理
    @RequestMapping("admin_permission")
    public ModelAndView toPermission(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ad_permission");
        return modelAndView;
    }

    //删除角色
    @RequestMapping("delRole")
    public ModelAndView delRole(int rid){
        ModelAndView modelAndView = new ModelAndView();
        adminService.delRole(rid);
        List<RoleVO> rList = adminService.getRole();
        modelAndView.addObject("rList",rList);
        modelAndView.setViewName("ad_role");
        return modelAndView;
    }

    //添加角色
    @RequestMapping("addRole")
    public ModelAndView addRole(String roleName){
        ModelAndView modelAndView = new ModelAndView();
        adminService.addRole(roleName);
        List<RoleVO> rList = adminService.getRole();
        modelAndView.addObject("rList",rList);
        modelAndView.setViewName("ad_role");
        return modelAndView;
    }

    //查询账户对应权限
    @RequestMapping("getRole")
    public ModelAndView getRole(String name){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        User user = adminService.getUserByName(name);
        System.out.println(user.toString());
        int id = user.getId();
        List<PermissionVO> pList = adminService.getPermission(id);
        modelAndView.addObject("pList",pList);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("ad_permission");
        return modelAndView;
    }

    //跳转添加班级
    @RequestMapping("toAddClass")
    public ModelAndView toAddClass(){
        ModelAndView modelAndView = new ModelAndView();
        List<CourseVO> course = adminService.getCourse();
        modelAndView.addObject("course",course);
        modelAndView.setViewName("add_class");
        return modelAndView;
    }

    //添加班级
    @RequestMapping("addClass")
    public ModelAndView addClass(String cName,int courseId){
        ModelAndView modelAndView = new ModelAndView();
        adminService.addClass(cName,courseId);
        List<Classes> list = adminService.getClasses();
        modelAndView.addObject("cList",list);
        modelAndView.setViewName("ad_class");
        return modelAndView;
    }



    //返回超级管理员页面
    @RequestMapping("backAdmin")
    public String goBack(){
        return "admin";
    }







    /*-----------------------------以下是Ajax方法-------------------------------*/

    //模板自取
    @RequestMapping(value = "",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String doWhat(){
        JSONObject json = new JSONObject();
        return json.toString();
    }



    //添加课程
    @RequestMapping(value = "addCourse",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addCourse(int tid,String cname){
        JSONObject json = new JSONObject();
        if(adminService.checkTeacher(tid)){
            //讲师已有课程
            json.element("message","该讲师已有课程");
            List<Course> cList = adminService.queryCourse();
            json.element("cList",cList);
            return json.toString();
        }
        //添加课程
        if(adminService.isNullCourse(cname)){
            //不存在
            CourseVO courseVO = new CourseVO();
            courseVO.setCourseName(cname);
            courseVO.setUid(tid);
            adminService.addCourse(courseVO);
            json.element("message","添加成功");
        }else{
            //已存在
            json.element("message","已存在该用户");
        }
        //查询课程列表
        List<Course> cList = adminService.queryCourse();
        json.element("cList",cList);
        return json.toString();
    }

    //添加用户
    @RequestMapping(value = "addUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addUser(int role,String name){
        JSONObject json = new JSONObject();
        //添加用户
        if(adminService.addUser(name)){
            //添加成功
            json.element("message","添加成功");
            if (role == 4){
                //讲师
                //查询ID
                int tid = adminService.getTidByName(name).getUid();
                System.out.println("-------------------------------------------------------------------");
                //加入角色表
                adminService.addTeacher(tid);
            }
        }else{
            //添加失败
            json.element("message","已存在该用户");
        }
        List<UserAndRole> users = adminService.getUser();//重新获取用户列表
        System.out.println("users = " + users.toString());
        json.element("user",users);
        return json.toString();
    }

    //删除用户
    @RequestMapping(value = "delUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delUser(int uid){
        JSONObject json = new JSONObject();
        System.out.println(uid);
        if(adminService.delUser(uid)){
            //删除成功
            json.element("message","删除成功");
        }else{
            json.element("message","删除失败");
        }
        List<UserAndRole> users = adminService.getUser();
        json.element("users",users);
        return json.toString();
    }

    //重置密码
    @RequestMapping(value = "updatePwd",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updatePwd(int uid){
        JSONObject json = new JSONObject();
        adminService.setPassword(uid);
        json.element("message","密码为123456");
        return json.toString();
    }

    //删除课程
    @RequestMapping(value = "delCourse",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delCourse(int id){
        JSONObject json = new JSONObject();
        System.out.println("12312312313212132132");
        //是否有班级学本课程
        if(adminService.delCourse(id)){
            //可以删除
            json.element("message","删除成功");
            json.element("del",id);
        }else{
            json.element("message","删除失败");
        }
        return json.toString();
    }

    //查询员工
    @RequestMapping(value = "getUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUser(String name){
        JSONObject json = new JSONObject();
        List<UserAndRole> user = adminService.getUser();
        UserAndRole userAndRole = new UserAndRole();
        for (UserAndRole u:user){
            if(u.getName().equals(name)){
                userAndRole.setId(u.getId());
                userAndRole.setUsername(u.getUsername());
                userAndRole.setName(name);
                userAndRole.setRname(u.getRname());
            }
        }
        json.element("user",userAndRole);
        return json.toString();
    }

    @RequestMapping(value = "delClass",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delClass(int cid){
        JSONObject json = new JSONObject();
        if(adminService.delClass(cid)){
            json.element("message","删除成功");
            json.element("cid",cid);
        }else{
            json.element("message","删除失败");
        }
        return json.toString();
    }

    @RequestMapping(value = "delPermission",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delPermission(int pid){
        JSONObject json = new JSONObject();
        adminService.delPermission(pid);
        json.element("message","删除成功");
        return json.toString();
    }

    //添加权限
    @RequestMapping(value = "/addPermission",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addPermission(String pname){
        JSONObject json = new JSONObject();
        if (adminService.addPermission(pname)){
            PermissionVO permission = adminService.getPermissionByPname(pname);
            json.element("permission",permission);
        }
        return json.toString();
    }

}
