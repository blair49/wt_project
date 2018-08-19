<%-- 
    Document   : RemoveEmp
    Author     : Blair
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Employee</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("EmpId"));
            PreparedStatement ps;
            Connection con;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HRMS","blair","12345");
            
            ps = con.prepareStatement("Select * from EMPLOYEE where EMPID=? ");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                ps=con.prepareStatement("Delete from EMPLOYEE where EMPID=?");
                ps.setInt(1, rs.getInt(1));
                ps.executeUpdate();
                ps=con.prepareStatement("Delete from SKILLS where SKILLID=?");
                ps.setInt(1, rs.getInt(11));
                ps.executeUpdate();
        %>
        <h2>Removed Successfully</h2>
        <a href="SelectEmp.jsp"> << Back </a>
        <%
            }
            else{
        %>
        <h2>Unable to remove</h2>
        <a href="SelectEmp.jsp"> << Back </a>
        <% } %>
    </body>
</html>
