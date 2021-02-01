package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    public students                 Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<courses>  CourseList      = new ArrayList<> ();
    public int term;
    public int schoolyear;
    
    public enroll() {
        term = 0;
        schoolyear = 0;
        Student.studentid = 0;
        Student.completename = "";
        Student.degreeid = "";
        CourseList.clear();
        EnrollmentList.clear();
    
        /*try{
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, term, schoolyear FROM enrollment");
                                    
            ResultSet rs = pstmt.executeQuery();
            EnrollmentList.clear();
            while(rs.next()){
                enrollment e = new enrollment();
                e.courseid = rs.getString("courseid");
                e.term = rs.getInt("term");
                e.schoolyear = rs.getInt("schoolyear");          
                EnrollmentList.add(e);
          
            }
              
            rs.close();
            pstmt.close();
            conn.close();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }  
        */
          
    };// perform all the necessary data loading from DB
    public int clearEnrollment ()   {
        EnrollmentList.clear();
        return 0;   
    }   // clears enrollment data of the student 
    public int loadCourses ()       {   
        try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement(  "SELECT c.courseid, c.coursename, c.department "
                                                            + "FROM courses c JOIN coursedegree cd ON c.courseid=cd.courseid "
                                                            + "WHERE cd.degree=? AND c.courseid NOT IN (SELECT e.courseid "
                                                                                                + "FROM enrollment e "
                                                                                                + "WHERE studentid=?)");
            
            pstmt.setString(1, Student.degreeid);
            pstmt.setInt(2, Student.studentid);
                        
            ResultSet rs = pstmt.executeQuery();

            CourseList.clear();
            while(rs.next()){
                courses c = new courses();
                c.courseid = rs.getString("courseid");
                c.coursename = rs.getString("coursename");
                c.department = rs.getString("department");
                
                // If not in memory
                if(!CourseList.contains(c))
                    CourseList.add(c);    
            }
              
            rs.close();
            pstmt.close();
            conn.close();
          
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    }   // load valid courses into the course list
    public int confirmEnrollment()  {   
            
        for(int i = 0; i < EnrollmentList.size(); i++){
            /*
            enrollment e = new enrollment();
            e.studentid = EnrollmentList.get(i).studentid;
            e.courseid = EnrollmentList.get(i).courseid;
            e.term = EnrollmentList.get(i).term;
            e.schoolyear = EnrollmentList.get(i).schoolyear;
            */   
            EnrollmentList.get(i).addRecord();
         
        }
        return 1;
        
    
    }   // saves enrollment data into the Database
   
//    public static void main(String[] args){
//       
//       enroll e = new enroll(); 
//       e.Student.studentid = 1010002;
//       e.Student.degreeid = "BSCS";
//
//       e.term = 1;
//       e.schoolyear = 20192020;
//       
//       e.loadCourses();
//        System.out.println((e.CourseList).toString());
//}
//    
}
