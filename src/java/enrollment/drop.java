/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class drop {
  
    public students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<enrollment>    DropList        = new ArrayList<> ();
    public int schoolyear;
    public int term;
    public String courseid;

    public drop() {

        schoolyear = 0;
        term = 0;
        EnrollmentList.clear();
        DropList.clear();
    }; // perform all the necessary data loading from DB
    
//    public void setcourseid (String courseid){
//        this.courseid=courseid;
//    }
    
    public int loadCourses ()    {
        try{
            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT studentid, courseid, term, schoolyear FROM enrollment WHERE studentid = ? AND term = ? AND schoolyear = ?");                        
            pstmt.setInt(1, Student.studentid);
            pstmt.setInt(2, term);
            pstmt.setInt(3, schoolyear);
            ResultSet rs = pstmt.executeQuery();
            EnrollmentList.clear();
            while(rs.next()){
                enrollment e = new enrollment();
                e.studentid  = rs.getInt("studentid");
                e.courseid = rs.getString("courseid");
                e.term = rs.getInt ("term");
                e.schoolyear = rs.getInt ("schoolyear");
                EnrollmentList.add(e);
            }
            
            if (EnrollmentList.isEmpty()){
                rs.close();
                pstmt.close();
                conn.close();
                return 2; 
            }
            else {
                rs.close();
                pstmt.close();
                conn.close();
                return 1; 
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    }   // loads enrollment data of the student 
    
    public int resetDrop () {
        DropList.clear();
        return 1;
    }  //clears DropList array after removing from enrollment list
    
    public int submitDrop (){
        for (int i = 0; i<DropList.size(); i++){
             DropList.get(i).delRecord();
        }
        return 1;

    }
    
//    public int submitCourse() {
//        DropList.add(0);
//        return 1;

//        try{
//            Connection conn;     
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
//            System.out.println("Connection Successful");
//            
//            PreparedStatement pstmt = conn.prepareStatement("SELECT courseid,studentid,  term, schoolyear FROM enrollment WHERE  courseid = ? AND studentid = ? AND term = ? AND schoolyear =?");                        
//            
//            pstmt.setString(1, courseid);
//            pstmt.setInt(2, Student.studentid);
//            pstmt.setInt(3, term);
//            pstmt.setInt(4, schoolyear);
//            
//            ResultSet rs = pstmt.executeQuery();
//
//            while(rs.next()){
//                enrollment e = new enrollment();
//                
//                e.courseid = rs.getString("courseid");
//                e.studentid = rs.getInt ("studentid");
//                e.term = rs.getInt("term");
//                e.schoolyear = rs.getInt("schoolyear");
//                
//                DropList.add(e);
//            }
//            
//            
//            rs.close();
//            pstmt.close();
//            conn.close();
//            return 1;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());  
//            return 0;
//        }  
//    }  //adds course to drop cart
    
    public static void main (String args[]){
        drop drp = new drop();

    }
}
