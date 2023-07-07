package com.bootcoding.student.application;

import com.bootcoding.student.dao.StudentDao;
import com.bootcoding.student.model.Student;

import java.sql.SQLException;

public class StudentApplication {
    public static void main(String[] args){
        StudentDao studentDao=new StudentDao();
        studentDao.getConnection();
        studentDao.setStudent();


    }
}
