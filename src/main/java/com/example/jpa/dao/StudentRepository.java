package com.example.jpa.dao;

import com.example.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 演示了2种自定义接口的策略：
 *
 * 1. 基于SpringData JPA的命名规范，直接定义接口
 * 2. 使用自定义的SQL语句进行个性化定制，这种适用于一些需要高度定制化处理的场景
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByName(String name);

    @Query(value = "select * from student where name like %?1%", nativeQuery = true)
    List<Student> fuzzyQueryByName(String name);

    @Query(value = "from com.example.jpa.entity.Student", nativeQuery = false)
    List<Student> fuzzyQueryByName2();

}
