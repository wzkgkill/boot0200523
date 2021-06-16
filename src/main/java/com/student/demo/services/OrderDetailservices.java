package com.student.demo.services;


import com.student.demo.model.dao.OrdersDao;
import com.student.demo.model.dao.OrdetailsDao;
import com.student.demo.pojo.Orders;
import com.student.demo.pojo.Ordetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class OrderDetailservices {
    @Autowired
    private OrderDetailservices detailDao;
    @Autowired
    OrdersDao os;
    @Autowired
    OrdetailsDao ordetailsDao;

    Orders orders=null;
    BigDecimal total=new BigDecimal(0);
    /*
    * 一次添加一条订单
    * */

    public Integer doInsert(Ordetails ordetails){

        //首先添加订单 （判断订单是否存在）
        if(ordetails.getMyorder()!=null && ordetails.getMyorder().getOid() ==null){
            Orders orders=os.save(ordetails.getMyorder());
            ordetails.setMyorder(orders);
        }

        return -1;


    }

    /*
    * 一次 添加多条订单详情
    * */
    public boolean doInser(List<Ordetails>list){
            //判断订单是否已经添加
        if(list.size()>0&& list.get(0).getMyorder()!=null){
            Orders orders=list.get(0).getMyorder();
            if(orders.getOid()==null){
                orders=os.save(orders);
            }
        }

        //所有订单详情 都必须关联一个订单编号 （订单实体类）

        for (Ordetails od : list) {
            od.setMyorder(orders);
            ordetailsDao.save(od);
        }
        return true;


    }

    public boolean doInsert(Orders orders1){
        if(orders1.getOid()==null){
            orders1=os.save(orders1);
        }

        BigDecimal total=new BigDecimal("0");

        for(Ordetails ordetails:orders1.getDetails()){
            ordetails.setMyorder(orders1);
            BigDecimal sum=ordetails.getgPrice().multiply(new BigDecimal(ordetails.getNum()));
             total =total.add(sum);


        }
        orders1.setoRental(total);

        return true;
    }




}
