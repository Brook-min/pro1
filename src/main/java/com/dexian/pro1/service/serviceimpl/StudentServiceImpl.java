package com.dexian.pro1.service.serviceimpl;

import com.dexian.pro1.dao.StudentMapper;
import com.dexian.pro1.pojo.StudentExample;
import com.dexian.pro1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Brook_min
 * @date 2019/3/26 0026 - 13:27
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentMapper studentMapper;


    @Override
    public List findAll() {
        StudentExample example=new StudentExample();
        return this.studentMapper.selectByExample(example);
    }
}
