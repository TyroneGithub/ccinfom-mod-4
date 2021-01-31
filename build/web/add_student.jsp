
<%-- 
    Document   : add_student
    Created on : 01 25, 21, 10:32:20 PM
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
            studentsBean.completename = request.getParameter("completename");
            studentsBean.degreeid = request.getParameter("degreeid");            
            int result = studentsBean.addRecord();
           if (result==0) {
        %>       
            <p>New Record was not successfully added</p>
        <% } else {
        %>       
            <p>New Record was successfully added</p>    
        <% }
        %>
        <a href="studentmaintenance.jsp">Return to Student Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>
