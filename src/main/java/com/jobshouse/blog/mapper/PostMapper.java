package com.jobshouse.blog.mapper;

import com.jobshouse.blog.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yang on 17-4-5.
 */
public interface PostMapper {
    @Insert(
            "INSERT INTO posts(creator, title, content, create_time, modify_time, read_times, like_times) " +
                    "VALUES (#{creator}, #{title}, #{content}, #{createTime}, #{modifyTime}, #{readTimes}, #{likeTimes})"
    )
    void insert(Post post);

    @Select(
            "SELECT id, creator as creator, title as title, content as content, create_time as createTime, " +
                    "modify_time as modifyTime, read_times as readTimes, like_times as likeTimes " +
                    "FROM posts "
    )
    List<Post> getAll();
}
