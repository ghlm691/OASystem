package com.qf.service;

import com.qf.pojo.Weekly;

import java.util.List;

public interface StaffService {

    //查看所有周报
    List<Weekly> queryAll();
}
