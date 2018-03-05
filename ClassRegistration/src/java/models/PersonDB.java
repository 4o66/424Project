/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*; 

/**
 *
 * @author Russ
 */
public class PersonDB {
    
public static Person dbGetPerson(Integer aID){
/*dbConnect(); */

//initialize new person
Person aPerson = null;

try
{
    String dbURL = "jdbc:mysql://localhost:3306/classregistration"; 
   /* String dbURL = "jdbc:mysql://localhost:3306/murach"; */
    String username = "root";
    String password = "sesame";
    Connection connection = DriverManager.getConnection(
        dbURL, username, password);
    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery("Select * from person Where id = '" + aID + "'");
    
     if (rs.next()) {
     
     aPerson = new Person();
     aPerson.setFirstName(rs.getString("firstName"));
     aPerson.setLastName(rs.getString("lastName"));
     aPerson.setDigest(rs.getString("digest"));
     aPerson.setId(rs.getInt("ID"));
     aPerson.setRole(rs.getString("role"));
     
     }
    statement.close();
          connection.close();  
    
}
catch(SQLException e)
{
    for (Throwable t : e)
        t.printStackTrace();
}

return aPerson;
}
  
    
private static void dbConnect(){    
    try
{
 
    String dbURL = "jdbc:mysql://localhost:3306/murach"; 
    String username = "root";
    String password = "sesame";
    Connection connection = DriverManager.getConnection(
        dbURL, username, password);
}
catch(SQLException e)
{
    for (Throwable t : e)
        t.printStackTrace();
}
}
    
    
    
}
