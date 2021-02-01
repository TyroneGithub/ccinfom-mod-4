<%-- 
    Document   : generatedrop
    Created on : 01 27, 21, 12:13:15 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
              width:100%;
            }
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
            th, td {
              padding: 15px;
              text-align: left;
            }
            tr:nth-child(even) {
              background-color: #eee;
            }
            tr:nth-child(odd) {
             background-color: #fff;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session" />
            
        <%
            if (dropBean.Student.studentid == 0){
                dropBean.Student.studentid = Integer.parseInt(request.getParameter("studentid"));
                dropBean.term =  Integer.parseInt(request.getParameter("term"));
                dropBean.schoolyear = Integer.parseInt(request.getParameter("startyear") + request.getParameter("endyear"));
            }
           
            
            
            int result = dropBean.loadCourses();
            if (result==0) {%>       
                <p>Record was not successfully retrieved.</p>
          <%} 
            else if (result == 2) {%>       
                <p>You are not currently enrolled in any course.</p>
          <%} 
            else {%>   
            <h3 style="text-align: center">Enrolled Courses</h3>
            <table style="width:100%">
                <tr>
                    <th>COURSE ID</th>
                    <th>TERM</th>
                    <th>SCHOOLYEAR</th>
                </tr>
               
            <% 
                for (int i = 0; i < dropBean.EnrollmentList.size(); i++){ 
            %>
                <tr>
                    <td>
                        <%= dropBean.EnrollmentList.get(i).courseid %>
                    </td>
                    <td>
                        <%= dropBean.EnrollmentList.get(i).term %>                        
                    </td>
                    <td>
                        <%= dropBean.EnrollmentList.get(i).schoolyear %>                        
                    </td>
                </tr>
              <%}
                %>
                </table>
                
                <form name="adddrop" action="addtodrop.jsp" method="POST">
                <input type="hidden" value= "<%= dropBean.Student.studentid %>" name="studentid" />
                <input type="hidden" value= "<%= dropBean.term %>" name="term" />
                <input type="hidden" value= "<%= dropBean.schoolyear %>" name="schoolyear" />

                <br/> 
                Add to Drop <input type="text" name="courseid" id="courseid"/>
                <br/>
                <input type="submit" value="Submit Course" name="addtodrop"/>
                
                </form>
                <ul style="list-style-type: none">
                <li><a href="submitdrop.jsp">Submit Dropped Courses</a></li> 
                <li><a href="drop.jsp">Return to Drop</a></li> 
                
            <% }
        %>
            
           
            
                <li><a href="index.jsp">Return to Main Menu</a><li>
            </ul>
        
    </body>
</html>

