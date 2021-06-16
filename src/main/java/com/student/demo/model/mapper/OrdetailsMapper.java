package com.student.demo.model.mapper;

import com.student.demo.pojo.Ordetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdetailsMapper {
    List<Ordetails>selectByid(Integer id);
}
