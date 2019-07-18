package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.FileService;
import com.qf.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private FileService fileService;


    @RequestMapping(value = "goinout",method = RequestMethod.GET)
    public String go(){

        return "inoutput";

    }

    @RequestMapping("stuInfo")
    public ModelAndView goStuInfo(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");

        List<Student> students = fileService.getStudentsById(user);

        modelAndView.setViewName("stu_info");
        session.setAttribute("students", students);
        modelAndView.addObject("students", students);

        return modelAndView;


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

    @RequestMapping("out")
    public String out(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileService.exportFile(user, outputStream);

        return null;
    }

}
