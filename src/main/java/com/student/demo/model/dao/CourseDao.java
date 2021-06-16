package com.student.demo.model.dao;

import com.student.demo.pojo.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Course,Integer> {


}
