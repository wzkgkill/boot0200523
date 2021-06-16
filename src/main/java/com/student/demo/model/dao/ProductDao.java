package com.student.demo.model.dao;

import com.student.demo.pojo.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {
    //产品表有一个外键cid 关联的类别表
    //新增时候不能指定cid，只能转换成关系字段，Category实体类对象


}
