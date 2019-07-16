package com.qf.controller;

import com.qf.pojo.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private SecurityManager securityManager;

    @RequestMapping("login")
    public String login(UserVO userVO, HttpSession session){

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getUname(), userVO.getPassword());

        try {

            subject.login(token);
            if (subject.isAuthenticated()){
                if (subject.hasRole("教师") & subject.hasRole("班主任") & subject.hasRole("校长")){
                    return "staff";
                } else {
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
