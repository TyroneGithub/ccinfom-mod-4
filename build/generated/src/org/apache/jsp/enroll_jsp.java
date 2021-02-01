package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class enroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Web Application | Enrollment</title>\n");
      out.write("        <style>\n");
      out.write("                        table {\n");
      out.write("              width:100%;\n");
      out.write("            }\n");
      out.write("            table, th, td {\n");
      out.write("              border: 1px solid black;\n");
      out.write("              border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("            th, td {\n");
      out.write("              padding: 15px;\n");
      out.write("              text-align: left;\n");
      out.write("            }\n");
      out.write("            tr:nth-child(even) {\n");
      out.write("              background-color: #eee;\n");
      out.write("            }\n");
      out.write("            tr:nth-child(odd) {\n");
      out.write("             background-color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      enrollment.enroll enrollBean = null;
      synchronized (session) {
        enrollBean = (enrollment.enroll) _jspx_page_context.getAttribute("enrollBean", PageContext.SESSION_SCOPE);
        if (enrollBean == null){
          enrollBean = new enrollment.enroll();
          _jspx_page_context.setAttribute("enrollBean", enrollBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      enrollment.students studentBean = null;
      synchronized (session) {
        studentBean = (enrollment.students) _jspx_page_context.getAttribute("studentBean", PageContext.SESSION_SCOPE);
        if (studentBean == null){
          studentBean = new enrollment.students();
          _jspx_page_context.setAttribute("studentBean", studentBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            \n");
      out.write("        ");

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
           
            
            
            if (result==0) {
      out.write("       \n");
      out.write("                <p>Record was not successfully retrieved.</p>\n");
      out.write("          ");
} 
            else if (result == 2) {
      out.write("       \n");
      out.write("                <p>No Courses available to enroll</p>\n");
      out.write("          ");
}
            else {
      out.write("   \n");
      out.write("            <h3 style=\"text-align: center\">Enrolled Courses</h3>\n");
      out.write("            <table style=\"width:100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>COURSE ID</th>\n");
      out.write("                    <th>COURSE NAME</th>\n");
      out.write("                    <th>DEPARTMENT</th>\n");
      out.write("                </tr>\n");
      out.write("               \n");
      out.write("            ");
 
                for (int i = 0; i < enrollBean.CourseList.size(); i++){ 
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( enrollBean.CourseList.get(i).courseid );
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( enrollBean.CourseList.get(i).coursename );
      out.write("                        \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( enrollBean.CourseList.get(i).department );
      out.write("                        \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("              ");
}
                
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <form name=\"addtoenroll\" action=\"addtoenroll.jsp\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" value= \"");
      out.print( enrollBean.Student.studentid );
      out.write("\" name=\"studentid\" />\n");
      out.write("                <input type=\"hidden\" value= \"");
      out.print( enrollBean.term );
      out.write("\" name=\"term\" />\n");
      out.write("                <input type=\"hidden\" value= \"");
      out.print( enrollBean.schoolyear );
      out.write("\" name=\"schoolyear\" />\n");
      out.write("                <br/> \n");
      out.write("                Add to Enrollment Cart <input type=\"text\" name=\"courseid\" id=\"courseid\"/>\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"submit\" value=\"Add Course to Enrollment\" name=\"addtoenroll\"/>\n");
      out.write("                \n");
      out.write("                </form>\n");
      out.write("                <ul style=\"list-style-type: none\">\n");
      out.write("                <li><a href=\"submitenroll.jsp\">Confirm/ Submit Enrollment</a></li> \n");
      out.write("                <li><a href=\"enrollmentmenu.jsp\">Return to Enrollment Menu</a></li> \n");
      out.write("                \n");
      out.write("            ");
 }
        
      out.write("           \n");
      out.write("            \n");
      out.write("                <li><a href=\"index.jsp\">Return to Main Menu</a><li>\n");
      out.write("            </ul>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
