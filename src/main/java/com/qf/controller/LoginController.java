package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.vo.UserVO;
import com.qf.service.StudentService;
import com.qf.service.UserService;
import com.qf.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
@SessionAttributes("user")
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private SecurityManager securityManager;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(UserVO userVO, Model model, HttpSession session){

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = null;
        try {
            token = new UsernamePasswordToken(userVO.getUname(), MD5Utils.getMD5Str(userVO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            subject.login(token);
            if (subject.isAuthenticated()){
                if (subject.hasRole("teacher") || subject.hasRole("leader") || subject.hasRole("boss")){

                    User user = userService.getStudentByUnamePwd(userVO.getUname(), userVO.getPassword());

                    session.setAttribute("user", user);
                    session.setAttribute("oldPassword",userVO.getPassword());

                    return "redirect:../Staff";
                } else {
                    if (subject.hasRole("admin")){
                        User user = userService.getStudentByUnamePwd(userVO.getUname(), userVO.getPassword());
                        session.setAttribute("user", user);
                        session.setAttribute("oldPassword",userVO.getPassword());
                        return "admin";
                    }
                    Student student = studentService.getStudentByUnamePwd(userVO.getUname(), userVO.getPassword());
                    model.addAttribute("student", student);
                    session.setAttribute("student", student);
                    return "student";
                }
            }else {
                return "login";
            }
        } catch (AuthenticationException e){
            System.out.println("登录失败");
        }
        return "login";
    }

}
