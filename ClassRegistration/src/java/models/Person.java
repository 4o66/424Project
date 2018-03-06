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
import java.util.List;

/**
 *
 * @author Sean Cox
 */
public class Person implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String role;
    private List<Course> courses;

    public Person() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.courses = null;
        this.role = null;

    }

    public Person(int id, String firstName, String lastName, String role, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.courses = courses;
    }

    public Person(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/classregistration";
            /* String dbURL = "jdbc:mysql://localhost:3306/murach"; */
            String username = "root";
            String password = "sesame";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select p.id, p.firstname, p.lastname, r.role from person p join role r on p.id = r.id Where p.id = " + id);

            if (rs.next()) {

                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.id = (id);
                this.role = rs.getString("role");

            }
            statement.close();

            statement = connection.createStatement();
            rs = statement.executeQuery("Select c.id, c.name, c.description, c.hours from course c join personcourse p on c.id = p.courseid Where p.personid = " + id);
            
            this.courses = new ArrayList<Course>();
            
            if (rs.next()) {

                this.courses.add(new Course(
                    rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getFloat("hours")
                ));
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
