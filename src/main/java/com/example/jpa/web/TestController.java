package com.example.jpa.web;

import com.example.jpa.dao.StudentRepository;
import com.example.jpa.entity.Student;
import com.example.jpa.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JpaService jpaService;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/echo")
    public Object test(){

//        jpaService.updateStudent();
        jpaService.testTrans();
        List<Student> allByName = studentRepository.findAllByName("");
        List<Student> allByName1 = studentRepository.fuzzyQueryByName("ja");
        List<Student> allByName2 = studentRepository.fuzzyQueryByName2();
        return "success";

    }
}
