<%-- 
    Document   : mod_course
    Created on : 01 31, 21, 6:51:20 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            courseBean.coursename = request.getParameter("coursename");
            courseBean.department = request.getParameter("department");            
            int result = courseBean.modRecord();
           if (result==0) {
        %>       
            <p>Record was not successfully modified</p>
        <% } else {
        %>       
            <p>Record was successfully modified</p>    
        <% }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>