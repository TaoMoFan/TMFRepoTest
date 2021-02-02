package com.example.demo.dao;

import com.example.demo.entry.UserEntry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author taomofan
 * @Date 2021/2/1 8:16 下午
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Select("select emp_no as empno,birth_date as birthdate,first_name as firstname,last_name as lastname,gender as gender,hire_date as hiredate from employees")
    List<UserEntry> findUserList();
}

