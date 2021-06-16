package com.student.demo.model.mapper;

import com.student.demo.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> selectAll(Integer id);
}
