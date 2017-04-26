package com.jobshouse.blog.mapper;

import com.jobshouse.blog.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yang on 17-4-3.
 */
public interface UserMapper {
    @Select(
            "SELECT id, username as userName, password as passWord, userrole as userRole " +
                    "FROM users "
    )
    List<User> getAll();

    @Select(
            "SELECT id, username as userName, password as passWord, userrole as userRole " +
                    "FROM users " +
                    "WHERE username = #{username}"
    )
    User getByUserName(String username);

    @Insert(
            "INSERT INTO users(username, password, userrole) " +
                    "VALUES (#{userName}, #{passWord}, #{userRole})"
    )
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    void insert(User user);
}
