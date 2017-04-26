<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="top.jsp" %>

<!--LOGIN----------------------------------------------------------------------->
<div class="main_content">
    <%
        String error = "";
        if (request.getAttribute("error") != null) {
            error = (String)request.getAttribute("error");
            out.println(error);
        } else {
            out.println("请输入用户名和密码登录:");
        }
    %>
    <br />
    <form name='f' action="/login" method="post">
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
            <div>
                <button type="submit">登录</button>
            </div>
        </div>
        还没有账号? <a href="/signup" />>点我注册!</a>
    </form>
</div>

<%@ include file="bottom.jsp" %>
