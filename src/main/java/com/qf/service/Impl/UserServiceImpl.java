package com.qf.service.Impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.vo.UserVO;
import com.qf.service.UserService;
import com.qf.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:赖文熙
 * date:2019/7/15 12:02
 * description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getStudentByUnamePwd(String username, String password) {
        System.out.println(username);
        User user = new User();
        try {

            UserVO userVo = userMapper.getUserByUnamePwd(username, MD5Utils.getMD5Str(password));

            user.setId(userVo.getUid());
            user.setUsername(userVo.getUname());
            user.setPassword(userVo.getPassword());
            user.setName(userVo.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
