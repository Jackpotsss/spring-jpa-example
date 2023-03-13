package com.example.jpa.service;

import com.example.jpa.config.HibernateProperties;
import com.example.jpa.dao.StudentRepository;
import com.example.jpa.entity.Student;
import com.example.jpa.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JpaService {

    @Autowired
    private StudentRepository studentRepository;
//    @Autowired
    private HibernateProperties hibernateProperties;

    public JpaService(HibernateProperties hibernateProperties) {
        this.hibernateProperties = hibernateProperties;
    }

    @Autowired
    public void test(HibernateProperties hibernateProperties) {
        this.hibernateProperties = hibernateProperties;
    }

    public void testTrans(){

        ApplicationContext context = ContextUtil.getContext();
        String str =  "file:E:/beecode/new-platform/test-war/metadata/build/**/*.hbm.xml";
        Resource[] resource = new Resource[0];
        try {
            resource = context.getResources(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudent(){

        Student student = new Student();
        student.setId(1L);
        student.setName("jack");
        student.setAge(18);
        studentRepository.save(student);
    }
}
