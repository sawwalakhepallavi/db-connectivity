package com.bootcoding.student.model;

import java.util.ArrayList;

public class Rating {
    private int ratingId;

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

//    public int getID(ArrayList<Student> id) {
//        return ID;
//    }

    private int totalAssignment;
    private int solved;
    private int unsolved;
    private double score;

    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTotalAssignment() {
        return totalAssignment;
    }

    public void setTotalAssignment(int totalAssignment) {
        this.totalAssignment = totalAssignment;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public int getUnsolved() {
        return unsolved;
    }

    public void setUnsolved(int unsolved) {
        this.unsolved = unsolved;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
