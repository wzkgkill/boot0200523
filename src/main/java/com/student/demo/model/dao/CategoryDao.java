package com.student.demo.model.dao;

import com.student.demo.pojo.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category,Integer> {
    //保留了外键字段 pid
    //关系字段child 只和查询有关，增删改 不守影响（增伤该都是 单表模式）
    //关系字段 products 之和关系查询有关

}
