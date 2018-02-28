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
public class Course  implements Serializable{
    
    private String hours;
    private String description;
    private String name;

       
public Course(){
    courseID = "";
    hours = "";
    description = "";
    name = "";
}

 public Course(String hours, String description, String name, String courseID) {
        this.hours = hours;
        this.description = description;
        this.name = name;
        this.courseID = courseID;
    }

    private String courseID;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
}
