package enrollment;
import java.sql.*;
import java.util.*;

public class coursedegree {
    
    public String courseid;
    public String degree;
    
    public ArrayList <coursedegree> courseList = new ArrayList<>();
    
    public coursedegree () {
        this.courseid = "";
        this.degree = "";
    };
    public int modRecord()  {
        try {
            
            Connection conn;     
 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE coursedegree SET courseid = ? WHERE  degree = ?");

            pstmt.setString (1, courseid);

            pstmt.setString (2, "BSIS");
            

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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, degree FROM coursedegree WHERE degree = ?");
            
            pstmt.setString(1, degree);
            
            ResultSet rs = pstmt.executeQuery();
            courseList.clear();
            while(rs.next()){
                coursedegree cds = new coursedegree();
                cds.courseid = rs.getString("courseid");
                cds.degree = rs.getString ("degree");
                courseList.add(cds);
            }
            

            pstmt.executeUpdate();
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
//       cd.courseid = "CCPROG3";
//       cd.degree = "BSIS";
//       cd.modRecord();
       
       //DELETE TEST
//       cd.courseid = "CCPROG3";
//       cd.degree = "BSCS";
//       cd.delRecord();
       
       //VIEW TEST
        cd.degree = "BSIS";
        cd.viewRecord();
        
        System.out.println("SHOWING RECORD OF DEGREE: " + cd.degree);
        System.out.println("------------------------------------------------------");
        System.out.println("COURSEID \t DEGREE \n");

        for(int i = 0; i < cd.courseList.size(); i++){
            coursedegree cdtemp = new coursedegree();
            cdtemp = cd.courseList.get(i);
            System.out.printf("%s \t %s\n",cdtemp.courseid, cdtemp.degree);
        
        }
 
    }
}
