<%-- 
    Document   : report.jsp
    Created on : 01 26, 21, 10:54:43 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1></h1>
        <div style="margin-left: 16px">
            <h3>Generate Report</h3>
            <form name="generatereport" action="generatereport.jsp" method="POST">
                Term:  
                <select name="term" id="term">
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                </select>
                <br/>
                School Year: <input type="text" name="startyear" id="startyear"/>
                - <input type="text" name="endyear" id="endyear"/>
                <br/>
                <input type="submit" value="Generate Report" name="generatereport"/>
            </form>
        </div>
        <br/>
        <a href="index.jsp">Return to Main Menu</a>
                
    </body>
</html>