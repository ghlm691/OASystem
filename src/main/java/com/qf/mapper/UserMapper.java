package com.qf.mapper;

import com.qf.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    UserVO getUserByUnamePwd(@Param("uname") String uname, @Param("password") String password);

}
