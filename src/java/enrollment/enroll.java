package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
 
    public enroll() {
        EnrollmentList.clear();
         try{
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
            
            PreparedStatement pstmt = conn.prepareStatement(  "SELECT courseid, degree "
                                                            + "FROM coursedegree"
                                                            + "WHERE degree=? AND courseid NOT IN (SELECT courseid"
                                                                                                + "FROM enrollment"
                                                                                                + "WHERE studentid=?)");
            
            pstmt.setString(1, Student.degreeid);
            pstmt.setInt(2, Student.studentid);
                        
            ResultSet rs = pstmt.executeQuery();
            CourseList.clear();
            while(rs.next()){
                coursedegree cd = new coursedegree();
                cd.courseid = rs.getString("courseid");
                cd.degree = rs.getString("degree");
                
                // If not in memory
                if(!CourseList.contains(cd))
                    CourseList.add(cd);    
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
    
}
