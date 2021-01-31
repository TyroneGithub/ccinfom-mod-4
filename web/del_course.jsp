<%-- 
    Document   : del_course
    Created on : 01 31, 21, 6:44:35 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="courseBean" class="enrollment.courses" scope="page" />
        <%
            courseBean.courseid = request.getParameter("courseid");
            int result = courseBean.delRecord();
           if (result==0) {
        %>       
            <p>Record was not successfully deleted</p>
        <% } else {
        %>       
            <p>Record was successfully deleted</p>    
        <% }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>