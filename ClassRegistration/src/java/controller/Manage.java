/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
@WebServlet(name = "Manage", urlPatterns = {"/manage"})
public class Manage extends HttpServlet {

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

        Person person = new Person(Integer.parseInt(request.getUserPrincipal().getName()));
        request.setAttribute("person", person);

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "addcourse":

                    String id = "",
                     name = "",
                     description = "";
                    int hours;

                    try {
                        id = request.getParameter("courseid");
                        name = request.getParameter("coursename");
                        description = request.getParameter("coursedescription");
                        hours = Integer.parseInt(request.getParameter("coursehours"));
                    } catch (NumberFormatException e) {
                        request.setAttribute("message", "Course hours must be a number.");
                        request.setAttribute("courseid", id);
                        request.setAttribute("coursename", name);
                        request.setAttribute("coursedescription", description);
                        String url = "/admin.jsp";
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        return;
                    }

                    Course course = new Course(id, name, description, hours);
                    course.addCourse();

                    break;
                case "deletecourse":
                    if (!new Course().delCourse(request.getParameter("course"))) {
                        request.setAttribute("message", "Unable to delete course " + request.getParameter("course"));
                    }
                    break;
                case "logoff":
                    //logout
                    request.getSession().invalidate();
                    String url = "/ClassRegistration";
                    response.sendRedirect(url);
                    return;
                default:
                    break;
            }
        }

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
            PreparedStatement statement;

            statement = connection.prepareStatement("select * "
                    + "from course c "
                    + "where c.id not in ( "
                    + "	select distinct courseid "
                    + "	from personcourse);");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

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
        String url = "/admin.jsp";
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
