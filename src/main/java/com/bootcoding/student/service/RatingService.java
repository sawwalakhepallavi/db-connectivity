package com.bootcoding.student.service;

import com.bootcoding.student.model.Rating;
import com.bootcoding.student.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RatingService {
    public ArrayList<Rating> getStudentRating(List<Student> students){
        ArrayList<Rating> ratings=new ArrayList<>();
        for(int i=0;i<students.size();i++){
            Rating rating=new Rating();
            rating.setRatingId(idGenerator());
            rating.setID(i+1);
            rating.setStudentId(students.get(i).getID());
            rating.setTotalAssignment(totalAssignment());
            rating.setSolved(solved(rating.getTotalAssignment()));
            rating.setUnsolved(unsolved(rating.getTotalAssignment(),rating.getSolved()));
            ratings.add(rating);
        }
        return ratings;
    }

    int id=1;
     private int idGenerator(){
        id=id+1;
        return id;
     }
    static int i=0;
    public static int totalAssignment() {
        int min = 1;
        int max = 1000;
        i=min + new Random().nextInt(max-min);
        return i;
     }
     public static int solved(int i){
         int min=1;
         int max=i;
         return min + new Random().nextInt(max-min);
     }
     public int unsolved(int totalAssignment,int solved){
        int min=solved;
        int max=totalAssignment;
        return (max-min);

     }

    public int saveRating(int id) {
       return id;
    }

}
