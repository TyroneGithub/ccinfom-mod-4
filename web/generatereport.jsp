<%-- 
    Document   : generatereport
    Created on : 01 26, 21, 11:04:34 AM
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
        <jsp:useBean id="reportBean" class="enrollment.report" scope="page" />

        <%
            reportBean.term = Integer.parseInt(request.getParameter("term"));
            reportBean.schoolyear = Integer.parseInt(request.getParameter("startyear") + request.getParameter("endyear"));
            int result = reportBean.generatereport();
           if (result==0) {
        %>       
            <p>Record was not successfully retrieved</p>
        <% } else {
        %>       
            <table style="width:100%">
                <tr>
                    <th>COURSE ID</th>
                    <th>COUNT</th>
                </tr>
               
            <% 
                for (int i = 0; i < reportBean.Count.size(); i++){ 
%>
                <tr>
                    <td>
                        <%= reportBean.Count.get(i).courseid %>
                    </td>
                    <td>
                        <%= reportBean.Count.get(i).count %>                        
                    </td>
                </tr>
        

            <% }
        }
        %>
            </table>
        <a href="report.jsp">Return to Report Menu</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
        </body>
</html>