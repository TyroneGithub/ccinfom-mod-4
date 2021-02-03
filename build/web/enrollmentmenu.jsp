<%-- 
    Document   : enrollmentmenu
    Created on : 02 1, 21, 8:40:21 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session" />
        <jsp:useBean id="studentBean" class="enrollment.students" scope="session" />

        <%
            // reset when user changes
            studentBean.studentid = 0;
            enrollBean.clearEnrollment();
            
        %>
        
        <div style="margin-left: 16px">
            <h3>Enrollment Menu</h3>
            <form name="enroll" action="enroll.jsp" method="POST">
                Student ID:  <input type="text" name="studentid" id="studentid"/>
                <br/>
                Term: <input type="text" name="term" id="term"/>
                <br/>
                School Year: <input type="text" name="startyear" id="startyear"/>
                -<input type="text" name="endyear" id="endyear"/>
                <br/>
                <input type="submit" value="Proceed to Enrollment" name="enroll"/>
            </form>
        </div>
        <br/>
        <a href="index.jsp">Return to Main Menu</a>

                
    </body>
</html>