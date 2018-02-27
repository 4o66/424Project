/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Sean Cox
 */
public class Course implements Serializable{
    
    private int id;
    private String name;
    private String description;
    private float hours;

    public Course() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.hours = 0;
    }

    public Course(int id, String name, String description, float hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }
        
}
