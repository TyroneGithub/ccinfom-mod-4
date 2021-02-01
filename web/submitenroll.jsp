<%-- 
    Document   : submitenroll
    Created on : 02 1, 21, 1:15:13 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
         <jsp:useBean id="enrollBean" class="enrollment.enroll" scope = "session"/>

          <%if (enrollBean.EnrollmentList.size() != 0){%>
             <%= "Successfully added the courses." %>
            <h3 style="text-align: center">List of New Courses Enrolled</h3>
            <table style="width:100%">
                <tr>
                    <th>COURSE ID</th>
                    <th>TERM</th>
                    <th>SCHOOLYEAR</th>
                </tr>
               
            <% 
                for (int i = 0; i < enrollBean.EnrollmentList.size(); i++){ 
            %>
                <tr>
                    <td>
                        <%= enrollBean.EnrollmentList.get(i).courseid %>
                    </td>
                    <td>
                        <%= enrollBean.EnrollmentList.get(i).term %>                        
                    </td>
                    <td>
                        <%= enrollBean.EnrollmentList.get(i).schoolyear %>                        
                    </td>
                </tr>
                <%}
                %>
                </table>
              <%
                enrollBean.confirmEnrollment();
                %>
                
            <% } else{%>
                    <br/>
                    <p>You currently have no courses in your drop cart.</p>
                    <br/>
                    
                <%}
                enrollBean.clearEnrollment();
                %>
        <br/>
        <a href="index.jsp">Return to Main Menu</a><br/>
        </body>
</html> 