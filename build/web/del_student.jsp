<%-- 
    Document   : del_student
    Created on : 01 25, 21, 11:03:24 PM
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
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="page" />
        <%
            studentsBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            int result = studentsBean.delRecord();
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