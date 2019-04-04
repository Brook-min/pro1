package com.dexian.pro1.controller;

import com.dexian.pro1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Brook_min
 * @date 2019/3/26 0026 - 13:31
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List findAll(){
        List stuList=studentService.findAll();
        return stuList;
    }
}
