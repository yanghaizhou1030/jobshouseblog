<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../top.jsp" %>

<!--POST_SHOW_ONLY_ONE----------------------------------------------------------------->
<div class="main_content">
    <div class="main_content_left">
        <!--SHOW THE CONTENT OF A POST------------------------------------------------->
        <div>
        <%@ page import="com.jobshouse.blog.model.Post" %>
        <%
            Post post = (Post)request.getAttribute("post");
            if (post == null) {
                out.println("木有内容。。。");
            } else {
                out.println("作者: " + post.getCreator() + "<br />");
                out.println("内容: <br />" + post.getContent());
            }
        %>
        </div>
        <div>
            <br />
            <a href="/home"> 返回主页 </a>
        </div>
    </div>
</div>
<%@ include file="../bottom.jsp" %>
