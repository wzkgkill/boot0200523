package com.student.demo.model.mapper;

import com.student.demo.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GraderMapper  {
    List<Grade>selectAll();
    List<Grade>selectByID(Integer id);
}
