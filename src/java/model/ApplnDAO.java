/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Blair
 */
public class ApplnDAO {
    
    PreparedStatement ps;
    Connection con;
    static ResultSet rs;
    
   public ApplnDAO() throws ClassNotFoundException, SQLException{
        con=getConnection();
    }
    //Get connection to database
    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/HRMS","blair","12345");
    }
    
    public boolean addSkills(String [] skills) throws SQLException{
        int i;
        String queryString = "Insert into SKILLS (SKILL1, SKILL2, SKILL3, SKILL4, SKILL5) values(?, ?, ?, ?, ?)";
        ps = con.prepareStatement(queryString, new String[] {"SKILLID"});
        for(i=1; i<=skills.length;i++){
            ps.setString(i, skills[i-1]);
        }
        
        while(i<=5){
            ps.setString(i, NULL.toString());
            i++;
        }
       int rowsUpdated = ps.executeUpdate();
       
       rs = ps.getGeneratedKeys();
       return rowsUpdated!=0;
    }
    public boolean addAppln(JobAppln jobappln) throws ClassNotFoundException, SQLException{
        JobAppln.count++;
        
        java.sql.Date SqlDOB = new java.sql.Date(jobappln.getDOB().getTime());
        
        String queryString = "Insert into JOBAPPLN (FNAME, LNAME, CONTACT, EMAIL, CITY, ZIP_CODE, DOB, GENDER, SKILLS) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps= con.prepareStatement(queryString);
        //ps.setInt(1,JobAppln.count);
        ps.setString(1, jobappln.getFname());
        ps.setString(2, jobappln.getLname());
        ps.setString(3, jobappln.getContact());
        ps.setString(4, jobappln.getEmail());
        ps.setString(5, jobappln.getCity());
        ps.setString(6, jobappln.getZip_code());
        ps.setDate(7, SqlDOB);
        ps.setString(8, jobappln.getGender());
        if(rs.next())
            ps.setInt(9,rs.getInt(1));
        
        
        int rowsUpdated = ps.executeUpdate();
        return rowsUpdated!=0;
    }
}
