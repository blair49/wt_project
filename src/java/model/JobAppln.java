/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Blair
 */
public class JobAppln {
    private int ApplnId;
    private String fname,lname,contact,email,city,zip_code,skillId,Gender;
    public static int count;
    Date DOB;

    public Date getDOB() {
        return DOB;
    }
    
    
    public int getApplnId() {
        return ApplnId;
    }

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

    public String getZip_code() {
        return zip_code;
    }

   

    public String getSkillId() {
        return skillId;
    }

    public String getGender() {
        return Gender;
    }

    public void setApplnId(int ApplnId) {
        this.ApplnId = ApplnId;
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

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    
    
}
