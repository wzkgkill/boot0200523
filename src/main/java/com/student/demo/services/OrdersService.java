package com.student.demo.services;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.demo.model.dao.OrdersDao;
import com.student.demo.model.dao.OrdetailsDao;
import com.student.demo.model.mapper.OrdersMapper;
import com.student.demo.pojo.Orders;
import com.student.demo.pojo.Ordetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class OrdersService {

    @Autowired
    OrdersDao dao;

    @Autowired
    OrdetailsDao detaiDao;
    @Autowired
    OrdersMapper ordersMapper;


    public PageInfo<Orders>selectFen(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
//        List<Orders>list= (List<Orders>) dao.findAll();
        List<Orders>list= (List<Orders>) ordersMapper.selectFen();
        System.out.println(list+"结果是");
        PageInfo<Orders>pageInfo=new PageInfo<>(list);
        System.out.println(pageInfo+"分页结果");
        return pageInfo;


    }

    /*
    * 订单新增和修改，
    * */
    public Integer doUpdate(Orders orders){
        orders=dao.save(orders);
        return orders.getOid();
    }


    //新增订单的同时新增详情
    public boolean doInsert(Orders orders){
        //新增订单
        if(orders.getOid()==null){
            orders = dao.save(orders);
        }
        //再遍历详情
        BigDecimal total = new BigDecimal("0");
        for (Ordetails detail : orders.getDetails()) {
            detail.setMyorder(orders);
            BigDecimal sum = detail.getgPrice().multiply(new BigDecimal(detail.getNum()));
            total = total.add(sum);
           detaiDao.save(detail);
        }
        orders.setoRental(total);
        return true;
    }
}
