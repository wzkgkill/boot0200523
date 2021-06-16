package com.student.demo.model.dao;

import com.student.demo.pojo.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeDao extends CrudRepository<Grade,Integer> {
}
