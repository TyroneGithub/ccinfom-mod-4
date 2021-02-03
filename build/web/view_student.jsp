<%-- 
    Document   : view_student
    Created on : 01 25, 21, 11:11:36 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application | View/ Modify Student</title>
    </head>
    <body>
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="page" />
        <%
            studentsBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            int result = studentsBean.viewRecord();
           if (result==0) {
        %>       
            <p>Record was not successfully retrieved</p>
        <% } else {
        %>       
            <h4>Student Record: </h4>
            <h5>Student id:<%= studentsBean.studentid %></h5>
            <h5>Name: <%= studentsBean.completename %></h5>            
            <h5>Course: <%= studentsBean.degreeid %></h5>

            <% }
        %>
        <a href="studentmaintenance.jsp">Return to Student Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>