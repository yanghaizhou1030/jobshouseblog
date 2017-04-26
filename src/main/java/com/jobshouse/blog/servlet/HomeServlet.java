package com.jobshouse.blog.servlet;

import com.jobshouse.blog.model.Post;
import com.jobshouse.blog.model.User;
import com.jobshouse.blog.service.PostService;
import com.jobshouse.blog.service.UserService;
import com.jobshouse.blog.util.MyBatisUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Created by yang on 17-3-31.
 */
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String username = "NickYang";
        req.setAttribute("username", username);
        UserService userService = new UserService(MyBatisUtil.getSqlSessionFactory());
        req.setAttribute("userList", userService.getAllUsers());
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);*/

        //req.setCharacterEncoding("UTF-8");
        //resp.setContentType("text/html; charset=UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            PostService service = new PostService(MyBatisUtil.getSqlSessionFactory());
            List<Post> postList = service.getAllPosts();
            req.setAttribute("posts", postList);
            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
        }
    }
}
