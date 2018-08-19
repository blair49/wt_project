<%-- 
    Document   : ShowJobAppln
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
        <title>Job Applications</title>
        <style>
            body{
                background: url('viewappln.jpg');
                background-repeat: no-repeat;
                background-size: cover;
            }
            td{
                background: url('tablebackg.gif');
            }
        </style>
    </head>
    <body>
        <a href="hr.html"> << Back </a>
        <%
            PreparedStatement ps;
            Connection con;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HRMS","blair","12345");
            ps = con.prepareStatement("Select * from JOBAPPLN");
            ResultSet rs = ps.executeQuery();
        %>
        <table cellpadding="15" border="1">
            <tr>
                <th>Appln_ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Phone no.</th>
                <th>Email id</th>
                <th>City</th>
                <th>Gender</th>
                <th colspan="5">Skills</th>
            </tr>
            <%
                while (rs.next()) {
                    ps = con.prepareStatement("Select * from SKILLS where SKILLID =?");
                    ps.setInt(1, rs.getInt(10));
                    ResultSet res = ps.executeQuery();
            %>
            <tr>
                <td><%=rs.getInt(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td>
                    <form method ="post" action="EmailClient.jsp">
                        <input value="<%=rs.getString(5)%>" name="to_email" readonly/><input type="submit" value="Send Email"/>
                    </form>
                </td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(9)%></td>
                
                <% if(res.next()){
                    int i=2;
                    while(i<=6 && !res.getString(i).equalsIgnoreCase("NULL")){
                %>
                <td><%=res.getString(i)%></td>
                <% 
                        i++;
                    }
                   }
                %>
            
            </tr>
            <% } %>
        </table>
    </body>
</html>
