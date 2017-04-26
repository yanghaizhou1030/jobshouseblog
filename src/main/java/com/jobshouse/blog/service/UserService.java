package com.jobshouse.blog.service;

import com.jobshouse.blog.mapper.UserMapper;
import com.jobshouse.blog.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by yang on 17-4-3.
 */
public class UserService {
    private SqlSessionFactory sqlSessionFactory;

    public UserService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            userList = mapper.getAll();
        } finally {
            session.close();
        }
        return userList;
    }

    public User getByUserName(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = null;
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            user = mapper.getByUserName(username);
        } finally {
            session.close();
        }
        return user;
    }

    public void addUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insert(user);
            session.commit();
        } finally {
            session.close();
        }
    }
}
