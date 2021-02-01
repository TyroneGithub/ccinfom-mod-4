package enrollment;
import java.sql.*;
import java.util.*;

public class coursedegree {
    
    public String courseid;
    public String degree;
    public String tempCourse;
    public String tempDegree;

    
    public coursedegree () {
        this.courseid = "";
        this.degree = "";
        this.tempDegree ="";
        this.tempCourse = "";
    };
    public int modRecord()  {
        try {
            
            Connection conn;     
 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE coursedegree SET courseid = ?, degree = ? WHERE degree = ? AND courseid = ?");

            pstmt.setString (1, tempCourse);
            pstmt.setString (2, degree);
            pstmt.setString (3, courseid);

            

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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM coursedegree WHERE courseid=? AND degree =?");
            
            pstmt.setString (1, courseid);
            pstmt.setString (2, degree);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO coursedegree (courseid, degree) VALUES (?, ?)");
            
            pstmt.setString(1, courseid);
            pstmt.setString(2, degree);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, degree FROM coursedegree WHERE courseid = ? AND degree = ?");
            pstmt.setString(1, courseid);
            pstmt.setString(2, degree);
            
            ResultSet rs = pstmt.executeQuery();
//            courseList.clear();
            while(rs.next()){
                coursedegree cds = new coursedegree();
                cds.courseid = rs.getString("courseid");
                cds.degree = rs.getString ("degree");
//                courseList.add(cds);
            }
            

//            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
          
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    
    public static void main(String args[]) {
       coursedegree cd = new coursedegree();
       
       //ADD TEST
//       cd.courseid = "CCPROG3";
//       cd.degree = "BSCS";
//       cd.addRecord();
       
       //MOD TEST
//       cd.courseid = "CCINFOM";
//       cd.degree = "BSCS";
//       cd.tempCourse = "DDSINFOM";
//       cd.modRecord();
//       System.out.println(cd.courseid);       
//       System.out.println(cd.degree);
//       System.out.println(cd.tempCourse);

       //DELETE TEST
//       cd.courseid = "CCPROG3";
//       cd.degree = "BSCS";
//       cd.delRecord();
       
       //VIEW TEST
//        cd.degree = "BSIS";
//        cd.viewRecord();
//        
//        System.out.println("SHOWING RECORD OF DEGREE: " + cd.degree);
//        System.out.println("------------------------------------------------------");
//        System.out.println("COURSEID \t DEGREE \n");

 
    }
}
