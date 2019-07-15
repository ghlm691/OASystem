package com.qf.service;

public interface BossService {

    //校长审批
    void bossCheck();

    //修改密码
    int updatePassword(int uid,String password);




}
