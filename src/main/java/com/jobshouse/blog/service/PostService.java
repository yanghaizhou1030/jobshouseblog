package com.jobshouse.blog.service;

import com.jobshouse.blog.mapper.PostMapper;
import com.jobshouse.blog.model.Post;
import com.jobshouse.blog.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yang on 17-4-5.
 */
public class PostService {
    private SqlSessionFactory sqlSessionFactory;

    public PostService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void addPost(Post post) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = session.getMapper(PostMapper.class);
            mapper.insert(post);
            session.commit();
        } finally {
            session.close();
        }
    }

    public List<Post> getAllPosts() {
        List<Post> postList = new ArrayList<Post>();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = session.getMapper(PostMapper.class);
            postList = mapper.getAll();
        } finally {
            session.close();
        }
        return postList;
    }

    static public Post createPost(String title, String content, User user)
    {
        Post post = new Post();
        post.setCreator(user.getUserName()).setTitle(title).setContent(content).setCreateTime(new Date())
        .setModifyTime(new Date()).setReadTimes(0).setLikeTimes(0);
        return post;
    }
}
