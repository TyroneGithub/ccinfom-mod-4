package enrollment;
import java.sql.*;

public class degree {
    
    public String degreeid;
    public String degreename;
    
    public degree () {
        degreeid = "";
        degreename = "";
    };
    public int modRecord()  { 
        try{
            Connection conn;     

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");

            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE  degree set degreename=? WHERE degreeid=?");
            
            pstmt.setString(1, degreename);
            pstmt.setString(2, degreeid);
                        
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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM degree WHERE degreeid =?");
            
            pstmt.setString(1, degreeid);
            
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO degree(degreeid, degreename) VALUES (?, ?)");
            
            pstmt.setString(1, degreeid);
            pstmt.setString(2, degreename);
                        
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT degreename FROM degree WHERE degreeid=?");
            
            pstmt.setString(1, degreeid);
                        
            ResultSet rs = pstmt.executeQuery();
            
           while (rs.next()) {
                degreename        = rs.getString("degreename");
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
        //degree d = new degree();
     
        
        // TEST ADD
        /*
        d.degreeid = "BSCE";
        d.degreename = "Bachelor of Science in Computer Engineering";
        d.addRecord();
        */
        
        // TEST MOD
        /*
        d.degreeid = "BSCE";
        d.degreename = "Bachelor of Science in Chemical Engineering";
        d.modRecord();
        */
        
        // TEST VIEW
        /*
        d.degreeid = "BSCE";
        d.viewRecord();
        System.out.printf("%s \t %s\n", d.degreeid, d.degreename);
        */
        
        // TEST DEL
        /*
        d.degreeid = "BSCE";        
        d.delRecord();
        */
        
        
    }
}
