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
            <h4>Showing Record of Course:<%= courseBean.courseid %></h4>
            <div style="margin-left: 16px">
                <h3>Modify Course</h3>
                <form name="modcourse" action="mod_course.jsp" method="POST">
                      <input type="hidden" id="courseid" name="courseid" value="<%= courseBean.courseid %>"> 
                    Course Name: <input type="text" value="<%= courseBean.coursename %>" name="coursename" id="coursename"/>
                    <br/>
                    Department: <input type="text" value="<%= courseBean.department %>" name="department" id="department"/>
                    <br/>                
                    <input type="submit" value="Modify Course" name="modcourse"/>
                </form>
            </div>
            <% }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>