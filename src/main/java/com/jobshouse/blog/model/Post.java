package com.jobshouse.blog.model;

import java.util.Date;

/**
 * Created by yang on 17-3-31.
 */
public class Post {
    private Long id;
    private String creator;
    private String title;
    private String content;
    private Date createTime;
    private Date modifyTime;
    private int readTimes;
    private int likeTimes;

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Post setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Post setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public Post setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public Post setReadTimes(int readTimes) {
        this.readTimes = readTimes;
        return this;
    }

    public int getLikeTimes() {
        return likeTimes;
    }

    public Post setLikeTimes(int likeTimes) {
        this.likeTimes = likeTimes;
        return this;
    }
}
