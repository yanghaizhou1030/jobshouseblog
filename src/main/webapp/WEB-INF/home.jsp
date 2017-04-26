<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="top.jsp" %>

<!--LOGIN----------------------------------------------------------------------->
<div class="main_content">
<div class="main_content_left">
<%@ page import="java.util.List" %>
<%@ page import="com.jobshouse.blog.model.User" %>
欢迎来到 JOBSHOUSE 博客!<br />
<%
    /*String username = (String)request.getAttribute("username");
    out.println("This msg is from java println! <br />");
    out.println("Get attribute from request:" + username);

    List<User> userList = (List<User>)request.getAttribute("userList");
    out.println("<br /> <br />");
    for (User user : userList) {
        out.println("username: " + user.getUserName());
        out.println(" password: " + user.getPassWord() + "<br />");
    }*/
    if (session.getAttribute("message") != null) {
        out.println((String)session.getAttribute("message"));
        session.setAttribute("message", null);
    }
%>
</div>
<div class="main_content_right">
    <div class="main_content_right_menu">
        <div class="main_content_right_menu_item"><a href="#">>>最近发表</a></div>
        <div class="main_content_right_menu_item"><a href="#">>>阅读最多</a></div>
        <%
            if (user != null) {
                out.println("<div class=\"main_content_right_menu_item\">");
                out.println("<a href=\"/posts/create\">>>新写一篇</a>");
                out.println("</div>");
                out.println("<div class=\"main_content_right_menu_item\">");
                out.println("<a href=\"/posts/show\">>>我的文章</a>");
                out.println("</div>");
            }
        %>
    </div>
</div>
   <div class="main_content_left">
   <%@ page import="com.jobshouse.blog.model.Post" %>
   <table>
   <thead>
        <tr>
            <th>标题</th>
            <th>作者</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>阅读次数</th>
            <th>喜欢次数</th>
        </tr>
   </thead>
   </tbody>
   <%
        List<Post> posts = (List<Post>)request.getAttribute("posts");
        if (posts != null) {
            for(Post post: posts) {
                out.println("<tr>");
                out.println("<td>" + post.getTitle() + "</td>");
                out.println("<td>" + post.getCreator() + "</td>");
                out.println("<td>" + post.getCreateTime() + "</td>");
                out.println("<td>" + post.getModifyTime() + "</td>");
                out.println("<td>" + post.getReadTimes() + "</td>");
                out.println("<td>" + post.getLikeTimes() + "</td>");
                out.println("</tr>");
            }
        }
   %>
   </tbody>
   </table>
   </div>
</div>

<%@ include file="bottom.jsp" %>