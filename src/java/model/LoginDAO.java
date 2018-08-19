/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Blair
 */
public class LoginDAO {
    PreparedStatement ps;
    Connection con;
    
    //Get connection to database
    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/HRMS","blair","12345");
    }
    
    //Check Login for employee
    public boolean checkLoginEmp(Emp emp) throws SQLException, ClassNotFoundException {
        
        con = getConnection();
        
        String queryString = "SELECT Usrname, Password FROM EMPLOYEE where Usrname=? and Password=?";
        ps = con.prepareStatement(queryString);
        ps.setString(1,emp.getUsrname());
        ps.setString(2,emp.getPasswd());
        
        return checkLogin(ps);
    }
    
    //Check login for HR
    public boolean checkLoginHR(Hr hr) throws ClassNotFoundException, SQLException{
        con = getConnection();
        
        String queryString = "SELECT Usrname, Password FROM HR where Usrname=? and Password=?";
        ps = con.prepareStatement(queryString);
        ps.setString(1,hr.getUsrname());
        ps.setString(2,hr.getPasswd());
        
        return checkLogin(ps);
        
    }
    
    private boolean checkLogin(PreparedStatement ps) throws SQLException{
        ResultSet results = ps.executeQuery();

        if (results.next()) {
            results.close();
            con.close();
            return true;
        }
        else{
            results.close();
            con.close();
            return false;
        }
    }
}
