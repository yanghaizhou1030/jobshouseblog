<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../top.jsp" %>

<!--POST_CREATE------------------------------------------------------------------------>
<div class="main_content">
    <div class="main_content_left">
        <!--CHECK IF HAS MESSAGE TO SHOW----------------------------------------------->
        <%
            String error = (String)request.getAttribute("error");
            if (error != null) {
                out.println(error +"<br />");
            }
        %>
        <!--TEXT EDITOR---------------------------------------------------------------->
        <form action="/posts/create" method="post">
            <textarea class="editor_text" name="post_editor" rows="10" cols="80">
            请在此输入文章内容
            </textarea><br />
            <button type="submit">发布</button>
        </form>
    </div>
</div>
<%@ include file="../bottom.jsp" %>
