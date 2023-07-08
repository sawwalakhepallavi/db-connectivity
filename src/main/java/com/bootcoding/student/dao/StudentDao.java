package com.bootcoding.student.dao;

import com.bootcoding.student.model.Student;
import com.bootcoding.student.service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {


        public void insertStudents (List <Student> students) {
            try {
                DaoService daoService = new DaoService();
                Connection con = daoService.getConnection();
                for (Student student : students) {
                    insertStudent(con, student);
                }
                System.out.println("rows are affected");
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Driver not found " + ex);
            }


        }

    public void insertStudent(Connection con, Student row) throws SQLException {
        PreparedStatement psmt = con.prepareStatement("insert into student values (?,?,?,?,?,?)");
        psmt.setInt(1, row.getID());
        psmt.setString(2, row.getName());
        psmt.setInt(3, row.getContact());
        psmt.setString(4, row.getEmail());
        psmt.setString(5, row.getCourse());
        psmt.setString(6, row.getCity());
        int i = psmt.executeUpdate();

        psmt.close();
    }

    // save(student)
}