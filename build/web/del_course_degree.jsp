<%-- 
    Document   : del_course_degree
    Created on : 02 1, 21, 11:03:52 PM
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
            courseBean.courseid = request.getParameter("courseid");
            courseBean.degree = request.getParameter("degree");

            int result = courseBean.delRecord();
            if (result == 0){
        %>
                <p>Record was not successfully deleted</p>
        <%  } else{ %>
                <p>Record was successfully deleted</p>
        <%    }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>
