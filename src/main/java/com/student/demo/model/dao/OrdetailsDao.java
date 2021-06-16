package com.student.demo.model.dao;

import com.student.demo.pojo.Ordetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdetailsDao extends CrudRepository<Ordetails,Integer> {
    //订单详情是非常重要的主控方
    //包含二个外键字段，所以需要委会二处关系（产品和订单）
}
