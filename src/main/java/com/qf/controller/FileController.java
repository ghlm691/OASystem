package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.utils.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * author: liu
 * date: 2019/7/17 23:30
 * info :
 */
@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping(value = "goinout",method = RequestMethod.GET)
    public String go(){

        return "inoutput";

    }

    @RequestMapping("in")
    public ModelAndView in(@RequestParam("infile") CommonsMultipartFile file, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        try {
            InputStream inputStream = file.getInputStream();
            List<Student> students = ExcelUtils.parseExcel(inputStream);
            modelAndView.setViewName("inoutput");
            modelAndView.addObject("students", students);
            inputStream.close();
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelAndView;

    }

}
