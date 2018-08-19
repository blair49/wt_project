/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Blair
 */
public class Emp {
    public String usrname;
    private String passwd,fname,lname,contact,email,city,designation,zip_code;
    public static int count;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getDesignation() {
        return designation;
    }

    public String getZip_code() {
        return zip_code;
    }
    
    public String getPasswd() {
        return passwd;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
    
    
}
