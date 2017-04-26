package com.jobshouse.blog.servlet;

import com.jobshouse.blog.model.Post;
import com.jobshouse.blog.model.User;
import com.jobshouse.blog.service.PostService;
import com.jobshouse.blog.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by yang on 17-4-4.
 */
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/home");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/posts/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/WEB-INF/login.jsp");
            return;
        }
        //String post_text = (String)req.getAttribute("post_editor");
        String post_text = (String)req.getParameter("post_editor");
        if (post_text == null || post_text.equals("")) {
            req.setAttribute("error", "文章内容不能为空！");
            req.getRequestDispatcher("/WEB-INF/posts/create.jsp").forward(req, resp);
            return;
        }
        Post post = PostService.createPost("test", post_text, user);
        PostService service = new PostService(MyBatisUtil.getSqlSessionFactory());
        service.addPost(post);
        req.setAttribute("post", post);
        req.getRequestDispatcher("/WEB-INF/posts/show_one.jsp").forward(req, resp);
    }
}
