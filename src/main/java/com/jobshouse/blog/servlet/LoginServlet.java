package com.jobshouse.blog.servlet;

import com.jobshouse.blog.model.User;
import com.jobshouse.blog.service.UserService;
import com.jobshouse.blog.util.MyBatisUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by yang on 17-4-3.
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getServletPath().equals("/logout")) {
            session.setAttribute("user", null);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        } else if (session.getAttribute("user") != null) {
            resp.sendRedirect("/home");
        } else {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
        String username = "";
        String password = "";
        username = req.getParameter("username");
        password = req.getParameter("password");
        UserService userService = new UserService(MyBatisUtil.getSqlSessionFactory());
        User user = userService.getByUserName(username);
        if (user == null) {
            req.setAttribute("error", "用户名不存在!");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        } else if (user.getPassWord().equals(password)) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            req.setAttribute("error", "密码错误!");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
