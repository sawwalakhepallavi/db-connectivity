package com.bootcoding.student.application;

import com.bootcoding.student.dao.DaoService;
import com.bootcoding.student.dao.PatientDao;
import com.bootcoding.student.model.Patient;
import com.bootcoding.student.service.PatientService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientApplication {
    public static void main(String[] args) throws SQLException {
        PatientDao patientDao=new PatientDao();
        PatientService patientService=new PatientService();
        List<Patient> patientsList=patientService.setPatient(100);
        patientDao.insertPatient(patientsList);
    }
}
