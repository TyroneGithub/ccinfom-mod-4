<%-- 
    Document   : submitdrop
    Created on : 01 27, 21, 12:08:26 PM
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
         <jsp:useBean id="dropBean" class="enrollment.drop" scope = "session"/>

          <%if (dropBean.DropList.size() != 0){%>
             <%= "Successfully dropped your chosen courses." %>
            <h3 style="text-align: center">List of Dropped Courses</h3>
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
                <%}
                %>
                </table>
              <%
                dropBean.submitDrop();
                %>
                
            <% } else{%>
                    <br/>
                    <p>You currently have no courses in your drop cart.</p>
                    <br/>
                    
                <%}
                dropBean.resetDrop();
                    %>
            </table>
        <br/>
        <a href="drop.jsp">Return to Drop Menu</a><br/>
        </body>
</html> 
