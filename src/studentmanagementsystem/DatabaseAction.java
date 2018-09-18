/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nafiul
 */
public class DatabaseAction {
    
    Connection getConnection() throws SQLException{
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","");
        return conn;
    }
    
    ObservableList<Student> getAllStudents() throws SQLException{
        
        ObservableList<Student> stdList=FXCollections.observableArrayList();
        
        Connection conn = getConnection();
        Statement statement=conn.createStatement();
        String query="select * from student";
        
        ResultSet rs=statement.executeQuery(query);
        
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String address=rs.getString("address");
            String email=rs.getString("email");
            
            Student student=new Student(id,name,email,address);
            stdList.add(student);
        }
        return stdList;
        
    }
    
    String insertStudent(Student student) throws SQLException{
        Connection conn=getConnection();
        Statement statement=conn.createStatement();
        
        String query="insert into student "
                + "values('"+student.getName()+"',"+student.getId()+",'"+student.getAddress()+"','"+student.getEmail()+"')";
        
        if(statement.executeUpdate(query)>0){
            return "student added successfully";
        }else{
            return "failed";
        }     
        
    }
    
   void deleteStudents(ObservableList<Student> selectedStudents) throws SQLException{
       Connection conn=getConnection();
       Statement statement=conn.createStatement();
       
       for(Student student:selectedStudents){
           String query="delete from student where id = "+student.getId();
           statement.executeUpdate(query);
       }
       
       
   }
        
    
    
}
