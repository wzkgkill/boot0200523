package com.student.demo.services;


import com.student.demo.model.mapper.GraderMapper;
import com.student.demo.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServices {

    @Autowired
    GraderMapper graderMapper;
    public List<Grade>selectall(){
        return graderMapper.selectAll();
    }
}
