<%-- 
    Document   : addtodrop
    Created on : 01 27, 21, 12:08:45 PM
    Author     : ccslearner
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application | Drop Cart</title>
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
         <jsp:useBean id="dropBean" class="enrollment.drop" scope = "session"/>         
         <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope = "page"/>

         <%   dropBean.courseid = request.getParameter("courseid");
         
            enrollmentBean.courseid = request.getParameter("courseid");              
            enrollmentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            enrollmentBean.term = Integer.parseInt(request.getParameter("term"));
            enrollmentBean.schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
            dropBean.DropList.add(enrollmentBean);
            
            int result = enrollmentBean.viewRecord();
            
            
            if (result == 1){%>
                <p>Successfully added course to drop cart!</p>
          <%} else{%>
                <p>Could not add course to drop cart.</p>
          <%}%>
            <%--<%= dropBean.courseid %>--%>
            <%--<%= dropBean.Student.studentid %>--%>
            <%--<%= dropBean.term %>--%>
            <%--<%= dropBean.schoolyear %>--%>
            <%--<%= "dropbean droplist size " + dropBean.DropList.size() %>--%>
          
          <%if (dropBean.DropList.size() != 0){%>
            <h3 style="text-align: center">Drop Course List</h3>
            <table style="width:100%">
                 <tr>
                    <th>COURSE ID</th>
                    <th>TERM</th>
                    <th>SCHOOLYEAR</th>
                </tr>
            
                <% 
                    for (int i = 0; i < dropBean.DropList.size(); i++){ 
                %>
                    <tr>
                        <td>
                            <%= dropBean.DropList.get(i).courseid %>
                        </td>
                        <td>
                            <%= dropBean.DropList.get(i).term %>                        
                        </td>
                        <td>
                            <%= dropBean.DropList.get(i).schoolyear %>                        
                        </td>
                    </tr>
                <%
                    }
                %>
                
                
            <% } else{%>
                    <br/>
                    <p>You currently have no courses in your drop cart.</p>
                    <br/>
                <%}
                    %>
            </table>
        <br/>
        <a href="dropmenu.jsp">Return to Drop Menu</a><br/>
        </body>
</html> 