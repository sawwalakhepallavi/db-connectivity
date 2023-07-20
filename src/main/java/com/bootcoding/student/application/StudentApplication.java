package com.bootcoding.student.application;

import com.bootcoding.student.dao.PatientDao;
import com.bootcoding.student.dao.RatingDao;
import com.bootcoding.student.dao.StudentDao;
import com.bootcoding.student.model.Student;
import com.bootcoding.student.service.RatingService;
import com.bootcoding.student.service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentApplication {
    public static void main(String[] args){
        StudentDao studentDao=new StudentDao();
        StudentService studentService=new StudentService();
        List<Student> students = studentService.setStudent(500);
        studentDao.insertStudents(students);

        RatingDao ratingDao=new RatingDao();
        RatingService rs = new RatingService();

        ratingDao.insertRating(students);

        for(Student st : students){
            int id = st.getID();
            rs.saveRating(id);
        }



    }
}
