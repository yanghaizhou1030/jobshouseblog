<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JobsHouseBlog</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <!--TOP------------------------------------------------------------------------>
    <div class="top">
        <div class="top_jh">
            <img src="/images/jh_logo.png" />@JobsHouseBlog
        </div>
        <div class="top_nav">
            <a href="#">首页1</a>
            <a href="#">首页2</a>
            <a href="#">首页3</a>
        </div>
        <div class="top_search">
            <form action="" method="post">
                <input type="text" class="search_text" />
            </form>
        </div>
        <div class="top_user">
            <%@ page import="com.jobshouse.blog.model.User" %>
            <%
                User user = (User)session.getAttribute("user");
                if (user != null) {
                    out.println(user.getUserName());
                } else {
                    out.println("Guest");
                }
            %>
            <a href="/signup">注册</a>|
            <%
                if(user != null) {
                    out.println("<a href=\"/logout\">注销</a>");
                } else {
                    out.println("<a href=\"/login\">登录</a>");
                }
            %>
            </a>
            <img src="/images/user_logo.png" />

        </div>
    </div>
