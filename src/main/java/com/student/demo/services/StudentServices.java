package com.student.demo.services;

import com.student.demo.model.mapper.StudentMapper;
import com.student.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    StudentMapper studentMapper;
    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }
    public List<Student> selectAll2(){
        return studentMapper.selectAll2();
    }
    public List<Student> selectAll3(){
        return studentMapper.selectAll3();
    }
}
