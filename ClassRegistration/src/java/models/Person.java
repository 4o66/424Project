/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sean Cox
 */
public class Person implements Serializable{
    
    private int id;
    private String firstName;
    private String lastName;
    private List<Course> courses;

    public Person() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.courses = null;
    }

    public Person(int id, String firstName, String lastName, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public Person validateLogin(int id, String password) {
        
        //TODO implement logon password/hash check
        
        return null;
    }
    
    public String enroll(Course course, Boolean action) {
        
        //TODO implement
        
        return null;
    }
    
    
}
