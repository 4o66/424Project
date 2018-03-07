/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sean Cox
 */
public class Course implements Serializable{
    
    private String id;
    private String name;
    private String description;
    private float hours;

    public Course() {
        this.id = null;
        this.name = null;
        this.description = null;
        this.hours = 0;
    }

    public Course(String id, String name, String description, float hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hours = hours;
    }
    
    public Course(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/classregistration";
            /* String dbURL = "jdbc:mysql://localhost:3306/murach"; */
            String username = "root";
            String password = "sesame";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM course WHERE id LIKE '" + id + "';");

            if (rs.next()) {

                this.name = rs.getString("name");
                this.description = rs.getString("description");
                this.id = (id);
                this.hours = rs.getFloat("hours");

            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
