<%-- 
    Document   : view_course
    Created on : 01 31, 21, 6:46:07 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application | View/ Modify Course</title>
    </head>
    <body>
        <jsp:useBean id="courseBean" class="enrollment.courses" scope="page" />
        <%
            courseBean.courseid = request.getParameter("courseid");
            int result = courseBean.viewRecord();
           if (result==0) {
        %>       
            <p>Record was not successfully retrieved</p>
        <% } else {
        %>       
            <h4>Course Data: </h4>
            <h5>Course id: <%= courseBean.courseid %></h5>
            <h5>Course Name: <%= courseBean.coursename %></h5>
            <h5>Department: <%= courseBean.department %></h5>
            <% }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>