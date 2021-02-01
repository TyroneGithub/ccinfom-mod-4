<%-- 
    Document   : mod_course_degree
    Created on : 02 1, 21, 11:13:51 PM
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
        <jsp:useBean id="courseBean" class="enrollment.coursedegree" scope="page" />
        <%
            courseBean.tempCourse = request.getParameter("tempCourse");
            courseBean.tempDegree = request.getParameter("tempDegree");
            courseBean.courseid = request.getParameter("courseid");            
            courseBean.degree = request.getParameter("degree");

            int result = courseBean.modRecord();
            if (result == 0){
        %>
                <p>Record was not successfully modified</p>
        <% } else{ 
        %>
                <p>Record was successfully modified</p>
        <% }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>
