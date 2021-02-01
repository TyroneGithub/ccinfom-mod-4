<%-- 
    Document   : addtoenroll
    Created on : 02 1, 21, 10:39:35 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application | Enrollment Cart</title>
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
         <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope = "page"/>
         <jsp:useBean id="courseBean" class="enrollment.courses" scope = "page"/>

         <%   
         
            enrollmentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            enrollmentBean.courseid = request.getParameter("courseid");              
            enrollmentBean.term = Integer.parseInt(request.getParameter("term"));
            enrollmentBean.schoolyear = Integer.parseInt(request.getParameter("schoolyear"));

            courseBean.courseid = enrollmentBean.courseid;            
            int exists = courseBean.viewRecord();

            // To avoid adding duplicates
            if(exists == 1 && !enrollBean.EnrollmentList.contains(enrollmentBean)){
                enrollBean.EnrollmentList.add(enrollmentBean);
                enrollBean.CourseList.remove(courseBean);
                
            }
            int result;
            if(exists == 1)    
                result = enrollmentBean.viewRecord();
            else
                result = 2;
            
            if (result == 1){%>
                <p>Successfully added course to enrollmentcart!</p>
          <%} 
            else if(result == 2){
          %>
                <p>Invalid course. Cart remained unchange</p>
          <%      
            }else{%>
                <p>Could not add course to enrollment cart.</p>
          <%}%>
          <%if (enrollBean.EnrollmentList.size() != 0){%>
            <h3 style="text-align: center">Enrollment Cart List</h3>
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
                <%
                    }
                %>
                
                
            <% } else{%>
                    <br/>
                    <p>You currently have no courses in your enrollment cart.</p>
                    <br/>
                <%}
                    %>
            </table>
        <br/>
        <a href="enroll.jsp">Return to Enroll</a><br/>
        </body>
</html> 