/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;

/**
 *
 * @author Russ
 */
public class ProfessorCourse implements Serializable {
    
    private Integer professorID;
    private String courseID;

    public ProfessorCourse(Integer professorID, String courseID) {
        this.professorID = null;
        this.courseID = "";
    }

    public Integer getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Integer professorID) {
        this.professorID = professorID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    
}
