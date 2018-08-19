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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Blair
 */
public class AddEmpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PreparedStatement ps;
            Connection con;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HRMS","blair","12345");
            ps = con.prepareStatement("Insert into EMPLOYEE (FNAME, LNAME, CONTACT, EMAIL, CITY, USRNAME, PASSWORD, DESIGNATION, ZIP_CODE, SKILLS) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, request.getParameter("fname"));
            ps.setString(2, request.getParameter("lname"));
            ps.setString(3, request.getParameter("phoneno"));
            ps.setString(4, request.getParameter("email"));
            ps.setString(5, request.getParameter("city"));
            ps.setString(6, request.getParameter("fname"));
            ps.setString(7, "12345");
            ps.setString(8, request.getParameter("designation"));
            ps.setString(9, request.getParameter("zipcode"));
            ps.setString(10, request.getParameter("skillid"));
        int rowsUpdated = ps.executeUpdate();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Employee</title>");            
            out.println("</head>");
            out.println("<body>");
            if(rowsUpdated!=0){
                ps = con.prepareStatement("Delete from JOBAPPLN where SKILLS=? ");
                ps.setInt(1, Integer.parseInt(request.getParameter("skillid")));
                ps.executeUpdate();
                out.println("<h1>Employee added Successfully</h1>");
                out.println("<b>Username:</b>"+ request.getParameter("fname"));
                out.println("<b>Password:</b> 12345");
                out.println("<a href='SelectAppln.jsp'>Continue</a>");
            }
            else{
                out.println("<h1>Failed to add employee</h1>");
                out.println("<a href='SelectAppln.jsp'>Continue</a>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddEmpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddEmpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
