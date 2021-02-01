<%-- 
    Document   : view_course_degree
    Created on : 02 1, 21, 11:14:49 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application | View/ Modify Course</title>
    </head>
    <body>
        <jsp:useBean id="courseBean" class="enrollment.coursedegree" scope="page" />
        <%
            courseBean.courseid = request.getParameter("courseid");            
            courseBean.degree = request.getParameter("degree");

            int result = courseBean.viewRecord();
            if (result == 0){
        %>

            <p>Record was not successfully retrieved.</p>
        <%
            } else {
        %>
                <h4>Showing record for:<%= courseBean.courseid %></h4>
                <div style="margin-left:16px">
                    <h3>Modify Course Degree</h3>
                    <form name="modcoursedegree" action="mod_course_degree.jsp" method="POST">
                        <input type="hidden" value="<%= courseBean.courseid %>" name="courseid">
                        <input type="hidden" value="<%= courseBean.degree %>" name="degree">
                        <input type="text" value="<%= courseBean.courseid %>" name="tempCourse"/>
                        <br/>
                        <input type="text" value="<%= courseBean.degree %>" name="tempDegree"/>
                        <br/>
                        <input type="submit" value="Modify Course"/>

                    </form>
                    
                </div>
        <%
        }
        %>
        <a href="coursemaintenance.jsp">Return to Course Maintenance</a><br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>
