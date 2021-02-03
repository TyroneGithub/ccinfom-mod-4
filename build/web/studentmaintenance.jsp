<%-- 
    Document   : studentmaintenance
    Created on : 01 25, 21, 9:20:39 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application | Student Maintenance</title>
    </head>
    <body>
        <h1>Student Maintenance</h1>
        <div style="margin-left: 16px">
            <h3>Add Student</h3>
            <form name="addstudent" action="add_student.jsp" method="POST">
                Complete Name: <input type="text" name="completename" id="completename"/>
                <br/>
                Degree ID: <input type="text" name="degreeid" id="degreeid"/>
                <br/>
                <input type="submit" value="Add Student" name="addstudent"/>
            </form>
        </div>
        <div style="margin-left: 16px">
            <h3>Delete Student</h3>
            <form name="delstudent" action="del_student.jsp" method="POST">
                Student ID: <input type="text" name="studentid" id="studentid"/>
                <input type="submit" value="Delete Student" name="delstudent"/>
            </form>
        </div>        
        <div style="margin-left: 16px">
            <h3>Modify Student</h3>
            <form name="modstudent" action="view_mod_student.jsp" method="POST">
                Student ID: <input type="text" name="studentid" id="studentid"/>
                <input type="submit" value="Modify Student" name="modstudent"/>
            </form>
        </div>   
        <div style="margin-left: 16px">
            <h3>View Student</h3>
            <form name="viewstudent" action="view_student.jsp" method="POST">
                Student ID: <input type="text" name="studentid" id="studentid"/>
                <input type="submit" value="View Student" name="viewstudent"/>
            </form>
        </div>   
        
        <br/>
        <a href="index.jsp">Return to Main Menu</a>
    </body>
</html>
