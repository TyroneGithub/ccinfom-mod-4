package enrollment;
import java.sql.*;

public class students {
    
    public int studentid;
    public String completename;
    public String degreeid;
    
    public students () {
        studentid = 0;
        completename = "";
        degreeid = "";
    };
    
    public int modRecord()  { 
            try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE  students set completename=?, degreeid=? WHERE studentid=?");
            
            pstmt.setString(1, completename);
            pstmt.setString(2, degreeid);
            pstmt.setInt(3, studentid);
                        
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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE studentid =?");
            
            pstmt.setInt(1, studentid);
            
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



            PreparedStatement pstmt0 = conn.prepareStatement("SELECT MAX(studentid) as newstudentnumber FROM students");


            ResultSet rs0 = pstmt0.executeQuery();

           while (rs0.next()) {
                studentid  = rs0.getInt("newstudentnumber");
           }
           studentid++;


            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students(studentid, completename, degreeid) VALUES (?, ?, ?)");
            
            pstmt.setInt(1, studentid);
            pstmt.setString(2, completename);
            pstmt.setString(3, degreeid);
                        
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT completename, degreeid FROM students WHERE studentid=?");
            
            pstmt.setInt(1, studentid);
                        
            ResultSet rs = pstmt.executeQuery();
            
           while (rs.next()) {
                completename  = rs.getString("completename");
                degreeid        = rs.getString("degreeid");
           }
            rs.close();             
            pstmt.close();
            conn.close();
          
            if(completename.equals(""))
                return 0;
            
            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
     
        
        
    };
    
    public static void main(String args[]) {
        
        students s  = new students();
        // TEST ADD
        /*
        s.completename = "Gavin Raine R. Dizon";
        s.degreeid = "BSCS-ST";
        s.addRecord();
        */

        // TEST MOD
        /*
        s.studentid = 11927534;
        s.completename = "Rachelle Ty";
        s.degreeid = "CLA";
        s.modRecord();
        */
        
        // TEST VIEW
       /*
        s.studentid = 11927534;
        s.viewRecord();
        System.out.printf("%s \t %s\n", s.completename, s.degreeid);
       */
        
        // TEST DEL
        /*
        s.studentid = 11927534;
        s.delRecord();
        */
        
    }
}
