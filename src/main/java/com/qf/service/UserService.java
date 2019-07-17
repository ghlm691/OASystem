package com.qf.service;

import com.qf.pojo.User;
import com.qf.pojo.vo.UserVO;

public interface UserService {

    User getStudentByUnamePwd(String username, String password);

}
