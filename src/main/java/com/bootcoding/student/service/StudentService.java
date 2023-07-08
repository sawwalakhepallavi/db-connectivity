package com.bootcoding.student.service;

import com.bootcoding.student.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {
    public List<Student> setStudent(int size){
        ArrayList<Student> stud=new ArrayList<>();
        for(int i=0;i<size;i++){
            Student student=new Student();
            student.setID(grtId());
            student.setName(RandomName());
            student.setContact(randomContact());
            student.setEmail(RandomMail());
            student.setCourse(RandomCourse());
            student.setCity(RandomCity());
            stud.add(student);
        }
        return stud;
    }
    public String RandomName(){
        String[] names={"rohan","yash","mitali","yogita"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public String RandomCity(){
        String[] names={"nagpur","pune","mumbai","banglur"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public String RandomMail(){
        String[] names={"rohan@gmail.com","yash@gmail.com","mitali@gmail.com","yogita@gmail.com"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public String RandomCourse(){
        String[] names={"java","python","php",".net"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    int min = 1;
    public int grtId() {
        min=min+1;
        return min;

    }
    public int randomContact() {
        int min = 455;
        int max = 9999;
        return min + new Random().nextInt(max-min);

    }


}
