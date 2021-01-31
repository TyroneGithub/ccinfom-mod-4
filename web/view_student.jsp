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
            <h4>Showing Record of :<%= studentsBean.studentid %></h4>
            <div style="margin-left: 16px">
                <h3>Modify Student</h3>
                <form name="modstudent" action="mod_student.jsp" method="POST">
                      <input type="hidden" id="studentid" name="studentid" value="<%= studentsBean.studentid %>"> 
                    Complete Name: <input type="text" value="<%= studentsBean.completename %>" name="completename" id="completename"/>
                    <br/>
                    Degree ID: <input type="text" value="<%= studentsBean.degreeid %>" name="degreeid" id="degreeid"/>
                    <br/>                
                    <input type="submit" value="Modify Student" name="modstudent"/>
                </form>
            </div>
            <% }
        %>
        <a href="studentmaintenance.jsp">Return to Student Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>