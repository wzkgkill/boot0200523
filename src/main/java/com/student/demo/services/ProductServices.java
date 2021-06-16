package com.student.demo.services;

import com.student.demo.model.dao.ProductDao;
import com.student.demo.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServices {
    @Autowired

    private ProductDao dao;

    /*
    * 产品新增，列表编号只能以实体类的主键形式 添加尽量
    * */
    public Integer doInsert(Product product){
        product=dao.save(product);
        return product.getId();


    }

    public Integer doDelte(Product product){
        dao.delete(product);
        return 1;
    }


}
