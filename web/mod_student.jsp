<%-- 
    Document   : mod_student
    Created on : 01 25, 21, 11:21:36 PM
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
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="page" />
        <%
            studentsBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            studentsBean.completename = request.getParameter("completename");
            studentsBean.degreeid = request.getParameter("degreeid");            
            int result = studentsBean.modRecord();
           if (result==0) {
        %>       
            <p>Record was not successfully modified</p>
        <% } else {
        %>       
            <p>Record was successfully modified</p>    
        <% }
        %>
        <a href="studentmaintenance.jsp">Return to Student Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>
