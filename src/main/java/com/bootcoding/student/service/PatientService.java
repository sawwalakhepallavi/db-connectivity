package com.bootcoding.student.service;

import com.bootcoding.student.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientService {
    public List<Patient> setPatient(int size){
        ArrayList<Patient> patients=new ArrayList<>();
        for(int i=0;i<size;i++){
            patients.add(buildPatient());
        }
        return patients;
    }

    public Patient buildPatient(){
        Patient patient=new Patient();
        patient.setId(idGet());
        patient.setName(randomName());
        patient.setDisease(randomDisease());
        patient.setMobile_number(randomNumber());
        patient.setCity(randomCity());
        patient.setEmail_id(randomMail());
//        patient.setAdmission_date(4-6-2023);
        return patient;
    }
    int min=0;
    public int idGet(){
        min=min +1;
        return min;
    }

    public String randomName(){
        String[]  names={"Pallavi","radhika","roshan","akshali","suhag","sakshit","Aman"};
        Random random=new Random();
        int name= random.nextInt(names.length);
        return names[name];
    }
    public String randomDisease(){
        String[] diseases={"cancer","tb","stork","join-disk","pneumonia","surer","piles","diabetic"};
        return diseases[new Random().nextInt(diseases.length)];
    }

    public int randomNumber(){
        int min=1;
        int max=1000000;
        return min+ new Random().nextInt(max-min);
    }

    public String randomMail(){
        String[] names={"pallavi@gmail.com","radhika@gmail.com","akshali@gmail.com","roshan@gmail.com"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }

    public String randomCity(){
        String[] names={"nagpur","pune","mumbai","banglur"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }


}
