package enrollment;
import java.sql.*;

public class courses {
    
    public String courseid;
    public String coursename;
    public String department;
    
    
    
    public courses () {
        this.courseid = "";
        this.coursename = "";
        this.department = "";
    };
    
    
    
    public int modRecord()  {
        try {
            
            Connection conn;     
 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE courses          " +
                                                            "SET    coursename   = ?, department = ?" + 
                                                            "WHERE  courseid = ? ");
            // 5. Supply the statement with values
            pstmt.setString (1, coursename );
            pstmt.setString (2, department);
            pstmt.setString (3, courseid);
            // 6. Execute the SQL Statement
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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM courses WHERE courseid =?");
            
            pstmt.setString(1, courseid);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO courses (courseid, coursename, department) VALUES (?, ?, ?)");
            
            pstmt.setString(1, courseid);
            pstmt.setString(2, coursename);
            pstmt.setString(3, department);           
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, coursename, department FROM courses WHERE courseid=?");
            
            pstmt.setString(1, courseid);
                        
            ResultSet rs = pstmt.executeQuery();
 
            while(rs.next()){
                courseid = rs.getString("courseid");
                coursename  = rs.getString("coursename");
                department = rs.getString ("department");
                
            }
            
            
            
            pstmt.close();
            conn.close();
            if (coursename.equals("")){
                return 0;
            }
            
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    };
    
    
    public static void main(String args[]) {
        courses cs = new courses();
        
//        cs.courseid = "CCAPDEV";
//        cs.coursename = "Web Application Development";
//        cs.department = "Information Technology";
//        
//        //cs.addRecord();
//        //cs.delRecord();
//        //cs.modRecord();
//        
//        cs.courseid = "CCPROG1";
//        cs.viewRecord();
//        System.out.println (cs.coursename);
//        System.out.println (cs.department);
    }
}
