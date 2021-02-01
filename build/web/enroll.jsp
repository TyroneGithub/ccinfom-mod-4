<%-- 
    Document   : enroll
    Created on : 02 1, 21, 8:43:15 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web Application | Enrollment</title>
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
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session" />
        <jsp:useBean id="studentBean" class="enrollment.students" scope="session" />
            
        <%
            int result = 0;
            if (studentBean.studentid == 0){
                studentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
                
                // loads student's degree (used in loadcourses)
                studentBean.viewRecord();
                            
                enrollBean.Student.studentid = studentBean.studentid;
                enrollBean.Student.degreeid = studentBean.degreeid;
                
                enrollBean.term =  Integer.parseInt(request.getParameter("term"));
                enrollBean.schoolyear = Integer.parseInt(request.getParameter("startyear") + request.getParameter("endyear"));
                result = enrollBean.loadCourses();
            }else{
                
                if(enrollBean.CourseList.size() > 0)
                    result = 1;
                else
                    result = 2;
            }
           
            
            
            if (result==0) {%>       
                <p>Record was not successfully retrieved.</p>
          <%} 
            else if (result == 2) {%>       
                <p>No Courses available to enroll</p>
          <%}
            else {%>   
            <h3 style="text-align: center">Enrolled Courses</h3>
            <table style="width:100%">
                <tr>
                    <th>COURSE ID</th>
                    <th>COURSE NAME</th>
                    <th>DEPARTMENT</th>
                </tr>
               
            <% 
                for (int i = 0; i < enrollBean.CourseList.size(); i++){ 
            %>
                <tr>
                    <td>
                        <%= enrollBean.CourseList.get(i).courseid %>
                    </td>
                    <td>
                        <%= enrollBean.CourseList.get(i).coursename %>                        
                    </td>
                    <td>
                        <%= enrollBean.CourseList.get(i).department %>                        
                    </td>
                </tr>
              <%}
                %>
                </table>
                <form name="addtoenroll" action="addtoenroll.jsp" method="POST">
                <input type="hidden" value= "<%= enrollBean.Student.studentid %>" name="studentid" />
                <input type="hidden" value= "<%= enrollBean.term %>" name="term" />
                <input type="hidden" value= "<%= enrollBean.schoolyear %>" name="schoolyear" />
                <br/> 
                Add to Enrollment Cart <input type="text" name="courseid" id="courseid"/>
                <br/>
                <input type="submit" value="Add Course to Enrollment" name="addtoenroll"/>
                
                </form>
                <ul style="list-style-type: none">
                <li><a href="submitenroll.jsp">Confirm/ Submit Enrollment</a></li> 
                <li><a href="enrollmentmenu.jsp">Return to Enrollment Menu</a></li> 
                
            <% }
        %>           
            
                <li><a href="index.jsp">Return to Main Menu</a><li>
            </ul>
        
    </body>
</html>
