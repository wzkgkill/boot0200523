package com.student.demo.model.mapper;

import com.student.demo.pojo.Term;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TremMapper {
    Term selectByid(Integer id);
}
