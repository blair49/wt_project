/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ApplnDAO;
import model.JobAppln;

/**
 *
 * @author Blair
 */
public class AddJobAppln extends HttpServlet {
    
    PreparedStatement ps;
    Connection con;
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
            throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            JobAppln jobappln = new JobAppln();
            jobappln.setFname(request.getParameter("fname"));
            jobappln.setLname(request.getParameter("lname"));
            jobappln.setEmail(request.getParameter("email"));
            jobappln.setContact(request.getParameter("phoneno"));
            jobappln.setCity(request.getParameter("city"));
            jobappln.setZip_code(request.getParameter("zipcode"));
            
            java.util.Date DOB = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dob")); 
            jobappln.setDOB(DOB);
            
            jobappln.setGender(request.getParameter("gender"));
            
            String [] skills =request.getParameterValues("skills");
            
            ApplnDAO applndao = new ApplnDAO();
            if(applndao.addSkills(skills)){
                if(applndao.addAppln(jobappln)){    
                    out.print("Successfully added");
                    out.print("<a href='index.html'>Home</a>");
                }
                else{
                    out.print("Failed to add");
                    out.print("<a href='apply.html'>Try again</a>");
                }
            }
            else{
                out.print("Failed to add");
                out.print("<a href='apply.html'>Try Again</a>");
            }
            
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
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(AddJobAppln.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(AddJobAppln.class.getName()).log(Level.SEVERE, null, ex);
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
