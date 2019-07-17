package com.qf.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * author: liu
 * date: 2019/7/17 23:52
 * info :
 */
public interface FileService {

   //文件上传
    int uploadFile(MultipartFile file, String path);

}
