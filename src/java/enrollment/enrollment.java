package enrollment;
import java.sql.*;
import java.util.*;

public class enrollment {
    
    
        public int      studentid;
        public String   courseid;
        public int      term;
        public int      schoolyear;
        
        // Used for Mod
        public int      newstudentid;
        public String   newcourseid;
        public int      newterm;
        public int      newschoolyear;

        //public enrollment eTemp = new enrollment(); 
        public ArrayList<enrollment> studentEnrollList = new ArrayList<>();
        
    public enrollment () {
        studentid = 0;
        courseid = "";
        term = 0;
        schoolyear = 0;
        studentEnrollList.clear();       
    };
    
    
    public int modRecord()  {         
        try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE  enrollment set studentid=?, courseid=?, term=?, schoolyear=? WHERE studentid=? AND courseid=? AND term=? AND schoolyear=?");
            
            pstmt.setInt(1, newstudentid);
            pstmt.setString(2, newcourseid);
            pstmt.setInt(3, newterm);
            pstmt.setInt(4, newschoolyear);
            pstmt.setInt(5, studentid);
            pstmt.setString(6, courseid);
            pstmt.setInt(7, term);
            pstmt.setInt(8, schoolyear);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
          
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }    
 };
    public int delRecord()  { 
        try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM enrollment WHERE studentid =? AND courseid=? AND term=? AND schoolyear=?");
            
            pstmt.setInt(1, studentid);
            pstmt.setString(2, courseid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
          
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }    
        
    };
    public int addRecord()  { 
        try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO enrollment(studentid, courseid, term, schoolyear) VALUES (?, ?, ?, ?)");
            
            pstmt.setInt(1, studentid);
            pstmt.setString(2, courseid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);
            
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
          
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }    
    
    };
    
    public int viewRecord() { 
        try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, term, "
                    + "schoolyear, studentid FROM enrollment "
                    + "WHERE courseid = ? AND studentid = ? "
                    + "AND term = ? AND schoolyear =?");
            
            pstmt.setString(1, courseid);
            pstmt.setInt(2, studentid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);

                        
            ResultSet rs = pstmt.executeQuery();
//            studentEnrollList.clear();
            while(rs.next()){
                
                enrollment e = new enrollment();
                e.courseid = rs.getString("courseid");
                e.term = rs.getInt("term");
                e.schoolyear = rs.getInt("schoolyear");
                e.studentid = rs.getInt("studentid");

                
//                studentEnrollList.add(e);
                
            }
            
            
            rs.close();
            pstmt.close();
            conn.close();
          
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    
    
    
    };
    
    public static void main(String args[]) {
       enrollment v_enrollment = new enrollment();
       
       // TEST ADD       
      /*
       v_enrollment.studentid = 10100020;
       v_enrollment.courseid = "CCINFOM";
       v_enrollment.term = 3;
       v_enrollment.schoolyear = 20212022;
       v_enrollment.addRecord();
       */
       // TEST MOD
//       v_enrollment.studentid = 10100001;
//       v_enrollment.courseid = "CCINFOM";
//       v_enrollment.term = 2;
//       v_enrollment.schoolyear = 20192020;
//       // change to
//       v_enrollment.newstudentid = 10100012;
//       v_enrollment.newcourseid = "CCINFOM";
//       v_enrollment.newterm = 3;
//       v_enrollment.newschoolyear = 20202021;
//
//       v_enrollment.modRecord();
//       
       // TEST DEL
       /* 
        v_enrollment.studentid = 10100020;
        v_enrollment.courseid = "CCPROG3";
        v_enrollment.term = 1;
        v_enrollment.schoolyear = 20202021;
        v_enrollment.delRecord();
        */       
       
    }
}
