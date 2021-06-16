package com.student.demo.model.mapper;

import com.student.demo.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    List<Orders>selectAll();
    List<Orders>selectFen();
    List<Orders>selectZuhe();

}
