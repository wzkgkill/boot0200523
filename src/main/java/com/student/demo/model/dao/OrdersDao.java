package com.student.demo.model.dao;

import com.student.demo.pojo.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends CrudRepository<Orders,Integer> {


}
