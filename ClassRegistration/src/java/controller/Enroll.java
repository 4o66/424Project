/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Course;
import models.Person;

/**
 *
 * @author Sean Cox
 */
@WebServlet(name = "Enroll", urlPatterns = {"/enroll"})
public class Enroll extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String action = request.getParameter("action");
            if (action == null) {action = "none";}
        
            if (action.equals("drop")) {
                
            } else if (action.equals("add")){
                
            } else if (action.equals("logoff")){ //logout
                request.getSession().invalidate();
                
                String url = "/ClassRegistration";
                response.sendRedirect(url);
                return;
            }
                   
        Person person = new Person(Integer.parseInt(request.getUserPrincipal().getName()));

        request.setAttribute("person", person);

        ArrayList<Course> courses = new ArrayList<>();
        
            try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/classregistration";
            /* String dbURL = "jdbc:mysql://localhost:3306/murach"; */
            String username = "root";
            String password = "sesame";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            
            
            String query = null;
            PreparedStatement statement = null;
            
            if (person.getRole().equals("S")) { //Only get classes with professors that they are not enrolled in
                statement = connection.prepareStatement("select distinct c.id, c.name, c.description, c.hours " +
                    "from course c " +
                    "left join personcourse pc on c.id = pc.courseid " +
                    "join person p on pc.personid = p.id " +
                    "join role r on p.id = r.id and r.role like 'P' " +
                    "where c.id not in (" +
                    "	select distinct courseid from personcourse where personid = ?" +
                    ");");
                statement.setInt(1, person.getId());
            } else {  //Get all classes with no professor
                statement = connection.prepareStatement("select c.id, c.name, c.description, c.hours " +
                    "from course c " +
                    "where c.id not in ( " +
                    "	select c.id " +
                    "	from course c " +
                    "	left join personcourse pc on c.id = pc.courseid " +
                    "	join person p on pc.personid = p.id " +
                    "   join role r on p.id = r.id and r.role like 'P' " +
                    ");");
            }
                      
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                courses.add(new Course(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getFloat("hours")));

            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            
        }
            
        request.setAttribute("courses", courses);
        String url = "/register.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        

        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
