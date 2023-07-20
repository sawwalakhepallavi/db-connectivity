package com.bootcoding.student.dao;

import com.bootcoding.student.model.Patient;
import com.bootcoding.student.service.PatientService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
}
