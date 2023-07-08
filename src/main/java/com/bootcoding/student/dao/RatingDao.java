package com.bootcoding.student.dao;

import com.bootcoding.student.model.Rating;
import com.bootcoding.student.model.Student;
import com.bootcoding.student.service.RatingService;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDao {
    public void insertRating(List<Student> students){

        RatingService rs= new RatingService();
        ArrayList<Rating> rat=rs.getStudentRating(students);
        try {
            int i=0;
            DaoService daoService = new DaoService();
            Connection con = daoService.getConnection();
            PreparedStatement st=con.prepareStatement("insert into rating values(?,?,?,?,?)");

            for(Rating row:rat){
                st.setInt(1,row.getID());
                st.setInt(2,row.getStudentId());
                st.setInt(3,row.getTotalAssignment());
                st.setInt(4,row.getSolved());
                st.setInt(5,row.getUnsolved());
                st.executeUpdate();
            }

            st.close();
            con.close();
            System.out.println("rows are inserted");
        } catch (SQLException e) {
            throw new RuntimeException("error"+e);
        }

    }
}
