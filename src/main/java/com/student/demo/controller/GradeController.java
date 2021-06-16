package com.student.demo.controller;


import com.student.demo.model.mapper.GraderMapper;
import com.student.demo.model.mapper.StudentMapper;
import com.student.demo.model.mapper.TremMapper;
import com.student.demo.pojo.Grade;
import com.student.demo.pojo.Student;
import com.student.demo.pojo.Term;
import com.student.demo.services.GradeServices;
import com.student.demo.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bj")
@Controller
public class GradeController {
    @Autowired
    GradeServices gradeServices;
    @Autowired
    StudentServices studentServices;
    @Autowired
    TremMapper tremMapper;

    @Autowired
    GraderMapper graderMapper;

    @GetMapping()
    public List<Grade>test(){
        System.out.println("开始进入访问");
        return gradeServices.selectall();
    }

    @GetMapping("xs")
    public List<Student>test2(){
        System.out.println("开始进入访问233");
        return studentServices.selectAll();
    }
    @GetMapping("xs2")
    public List<Student>test3(){
        System.out.println("开始进入访问2334");
        return studentServices.selectAll2();
    }
    @GetMapping("xs3")
    public List<Student>test4(){
        System.out.println("开始进入访问23345");
        return studentServices.selectAll3();
    }

    @GetMapping("xs4")
    public Term test5(){
        System.out.println("开始进入访问科目");

        return  tremMapper.selectByid(1);
    }

    @GetMapping("xs5")
    public List<Grade> test6(){
        System.out.println("开始进入访问科目");

        return  graderMapper.selectByID(1);
    }

}
