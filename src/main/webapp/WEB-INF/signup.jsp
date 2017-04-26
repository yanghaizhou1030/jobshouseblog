<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="top.jsp" %>

<!--SINGUP--------------------------------------------------------------------->
<div class="main_content">
    <%
        String error = "";
        if (request.getAttribute("error") != null) {
            error = (String)request.getAttribute("error");
            out.println(error);
        } else {
            out.println("请输入用户名并确认密码后点击注册:");
        }
    %>
    <br />
    <form name='f' action="/signup" method="post">
        <div class="controls">
            <label>用户名</label>
            <div >
                <input type='text' name='username' placeholder="输入您的用户名" />
            </div>
        </div>
        <div class="controls">
            <label>密码</label>
            <div >
                <input type="password" name="password" placeholder="输入您的密码" />
            </div>
        </div>
        <div class="controls">
            <label>确认密码</label>
            <div >
                <input type="password" name="password_rpt" placeholder="输入您的密码" />
            </div>
        </div>
        <div class="controls">
            <div>
                <button type="submit">注册</button>
            </div>
        </div>
        已有账号? <a href="/login" />>点我登录!</a>
    </form>
</div>

<%@ include file="bottom.jsp" %>
