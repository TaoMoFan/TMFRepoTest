package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entry.UserEntry;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author taomofan
 * @Date 2021/2/1 8:27 下午
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    protected UserMapper userMapper;

    @Override
    public List<UserEntry> findUserList() {
        return userMapper.findUserList();
    }
}
