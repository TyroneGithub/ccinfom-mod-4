/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ccslearner
 */

public class report {
    public ArrayList<courses> CourseList = new ArrayList<>();
    public ArrayList<count> Count = new ArrayList<>();
    public int schoolyear;
    public int term;
        
    public class count{
        public String courseid;
        public int count;
        
        
        public count(){
            courseid = "";
            count = 0;
        }        
    }


    public report(){
        term = 0;
        schoolyear = 0;
        // load courses
        CourseList.clear();
        try{
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid, coursename, department FROM courses");                        
            ResultSet rs = pstmt.executeQuery();
 
            while(rs.next()){
                courses c = new courses();
                c.courseid = rs.getString("courseid");
                c.coursename  = rs.getString("coursename");
                c.department = rs.getString ("department");
                CourseList.add(c);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }  
    }; 
    
    public int resetreport(){
        schoolyear = 0;
        term = 0;
        Count.clear();        
        return 1;
    };
    
    public int generatereport(){        
        
        try{
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT c.courseid, COUNT(e.courseid) AS numberofstudents " +
                                                            "FROM enrolldb.courses c LEFT JOIN enrolldb.enrollment e ON c.courseid = e.courseid " +
                                                            "AND e.term = ? AND e.schoolyear = ? " +
                                                            "GROUP BY c.courseid");

            pstmt.setInt(1, term);
            pstmt.setInt(2, schoolyear);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                count co = new count();
                co.courseid = rs.getString("courseid");
                co.count  = rs.getInt("numberofstudents");
                Count.add(co);
            }
            
            rs.close();
            pstmt.close();
            conn.close();

            return 1;
        }catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
        
    };
        
    
    
    public static void main(String args[]) {
        /*
        report r = new report();
        
        r.term = 2;
        r.schoolyear = 20192020;
        r.generatereport();
            
        for(int i = 0; i < r.Count.size(); i++)
            System.out.printf("%s \t %s\n", r.Count.get(i).courseid, r.Count.get(i).count);
        */
        
    }

}


