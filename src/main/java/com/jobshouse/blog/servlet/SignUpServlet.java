package com.jobshouse.blog.servlet;

import com.jobshouse.blog.model.User;
import com.jobshouse.blog.service.UserService;
import com.jobshouse.blog.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yang on 17-4-4.
 */
public class SignUpServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String username = "";
        String password = "";
        String password_rpt = "";
        username = req.getParameter("username").trim();
        password = req.getParameter("password").trim();
        password_rpt = req.getParameter("password_rpt").trim();
        UserService userService = new UserService(MyBatisUtil.getSqlSessionFactory());
        User user = userService.getByUserName(username);
        if (user != null) {
            req.setAttribute("error", "用户名已被使用!");
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        } else if (password.equals("")) {
            req.setAttribute("error", "密码不能为空！");
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        } else if(!password.equals(password_rpt)) {
            req.setAttribute("error", "两次输入的密码不一致!");
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        } else {
            user = new User();
            user.setUserName(username).setPassWord(password).setUserRole("default");
            userService.addUser(user);
            user = userService.getByUserName(username);
            if (user == null) {
                req.setAttribute("error", "注册失败!");
                req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("message", "恭喜您注册成功!");
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/home");
            }
        }
    }
}
