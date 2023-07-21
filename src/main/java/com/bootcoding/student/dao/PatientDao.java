package com.bootcoding.student.dao;

import com.bootcoding.student.model.Patient;
import com.bootcoding.student.service.PatientService;

import java.sql.*;
import java.util.List;

public class PatientDao {
    public void insertPatient(List<Patient> patientsList) throws SQLException {
        DaoService daoService=new DaoService();
        Connection con=daoService.getConnection();
        PreparedStatement pmt= con.prepareStatement("insert into hospitaldb values(?,?,?,?,?,?)");
        for(int i=0;i<patientsList.size();i++){
//            Patient value= patientsList.get(i);
            pmt.setInt(1,patientsList.get(i).getId());
            pmt.setString(2,patientsList.get(i).getName());
            pmt.setString(3,patientsList.get(i).getDisease());
            pmt.setInt(4,patientsList.get(i).getMobile_number());
            pmt.setString(5,patientsList.get(i).getCity());
            pmt.setString(6,patientsList.get(i).getEmail_id());
            int j=pmt.executeUpdate();
        }
        pmt.close();
        con.close();
    }

    public void fetchPatient() throws SQLException {
        DaoService daoService=new DaoService();
        Connection con= daoService.getConnection();
        Statement statement = con.createStatement();
        ResultSet rs= statement.executeQuery("select * from hospitaldb where city='nagpur' and disease='diabetic'");
        while(rs.next()){
            System.out.println("ID :- "+rs.getInt("id"));
            System.out.println("Patient Name :-" + rs.getString("name"));
            System.out.println("Diseases :-"+ rs.getString("disease"));
            System.out.println("Mobile number :-" + rs.getInt(4));
            System.out.println("city :-"+ rs.getString(5));
            System.out.println("Email:- "+ rs.getString(6));
        }
        rs.close();

    }
}
