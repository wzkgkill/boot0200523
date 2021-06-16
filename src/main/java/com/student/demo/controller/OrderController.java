package com.student.demo.controller;


import com.github.pagehelper.PageInfo;
import com.student.demo.model.mapper.OrdersMapper;
import com.student.demo.pojo.Orders;
import com.student.demo.pojo.Ordetails;
import com.student.demo.services.OrderDetailservices;
import com.student.demo.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailservices ods;

    @Autowired
    OrdersMapper ordersMapper;

    BigDecimal total=new BigDecimal(0);
    @GetMapping
    public String test(){
        //订单
        System.out.println("开始调用");
        Orders orders = new Orders();//没有主键和总金额，也没有用户
        orders.setoAddress("湖南省株洲市芦淞区石宋路1059号");
        orders.setoPhone("15677889900");
        orders.setoConsignee("刘老师");
        orders.setoState("待付款");
        //订单详情  价格和数量
        Ordetails od1 = new Ordetails();//忽略了产品
        od1.setgPrice(new BigDecimal("2.5"));
        od1.setNum(10);
        Ordetails od2 = new Ordetails();//忽略了产品
        od2.setgPrice(new BigDecimal("50"));
        od2.setNum(2);

       BigDecimal s1= od1.getgPrice().multiply(new BigDecimal(od1.getNum()));
        BigDecimal s2= od2.getgPrice().multiply(new BigDecimal(od2.getNum()));
       double shu=s1.doubleValue()+s2.doubleValue();

            total=new BigDecimal(shu);
        System.out.println("总计"+total);
        //将订单详情添加到订单中
        List<Ordetails> details = new ArrayList<>();
        details.add(od1);
        details.add(od2);
        orders.setDetails(details);
        orders.setoRental(total);
        //最后请求新增订单
        ordersService.doInsert(orders);

        return "新增订单完毕";

    }

    @GetMapping("fen2")
    public PageInfo<Orders>fen3(Integer pageNo,Integer pageSize){
//        List<Orders> list = ordersMapper.selectAll();
        PageInfo<Orders> pageInfo = ordersService.selectFen(1, 3);
        System.out.println("进入分页"+pageInfo);
        return pageInfo;

    }



}
