package com.dexian.pro1.dao;


import com.dexian.pro1.pojo.Student;
import com.dexian.pro1.pojo.StudentExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(String code);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}