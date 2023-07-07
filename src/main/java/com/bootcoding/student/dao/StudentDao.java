package com.bootcoding.student.dao;

import com.bootcoding.student.model.Student;
import com.bootcoding.student.service.StudentService;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    public Connection con;
    public void getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public void insertStudent() throws SQLException {
//        Student s=new Student();
//        s.setID(203);
//        s.setName("raj");
//        s.setContact(5865);
//        s.setEmail("guvsjb");
//        s.setCourse("java");
//        s.setCity("pune");
//        String query="insert into student values(?,?,?,?,?,?)";
//        PreparedStatement ps= null;
//        try {
//            ps = con.prepareStatement(query);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ps.setInt(1,s.getID(201));
//        ps.setString(2,s.getName());
//        ps.setInt(3,s.getContact());
//        ps.setString(4,s.getEmail());
//        ps.setString(5,s.getCourse());
//        ps.setString(6,s.getCity());
//        int p=ps.executeUpdate();
//        System.out.println(p);
//        ps.close();
//    }
//    public void readData(Student s) throws SQLException {
//        Statement st=con.createStatement();
////        st.executeQuery("select name from student where id='"+s.getID(201))+"'");
//    }

    public void setStudent(){
        try {
            StudentService studentService=new StudentService();
            ArrayList<Student> students= (ArrayList<Student>) studentService.insertStudent(10);
            PreparedStatement psmt=con.prepareStatement("insert into student values (?,?,?,?,?,?)");
            for(Student row: students){
                psmt.setInt(1,row.getID());
                psmt.setString(2,row.getName());
                psmt.setInt(3,row.getContact());
                psmt.setString(4,row.getEmail());
                psmt.setString(5,row.getCourse());
                psmt.setString(6,row.getCity());
                psmt.executeUpdate();
            }
            System.out.println("rows are affected");
            psmt.close();
            con.close();
            }
        catch (SQLException ex) {
            throw new RuntimeException("Driver not found "+ex);
        }


    }
}
