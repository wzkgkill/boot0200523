package com.student.demo.model.mapper;

import com.student.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student>selectAll();
    List<Student>selectAll2();
    List<Student>selectAll3();
}
