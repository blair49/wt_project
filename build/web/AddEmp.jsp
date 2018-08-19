<%-- 
    Document   : AddEmp
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
        <title>Add Employee</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="myStyle.css">
        <script src="formvalidation.js"></script>
    </head>
    <body>
        <a href="SelectAppln.jsp"> << Back </a>
        <%
            int id =Integer.parseInt(request.getParameter("ApplnId"));
            PreparedStatement ps;
            Connection con;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HRMS","blair","12345");
            ps = con.prepareStatement("Select * from JOBAPPLN where APPLNID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
        %>
        <form class="form-horizontal" method="post" action="AddEmpServlet.do">
            <fieldset>
                <!-- Form Name -->
                <legend style="text-align:center;">Job Application</legend>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="fname">First Name</label>  
                    <div class="col-md-3">
                        <input name="fname" class="form-control input-md" id="name" readonly type="text" value="<%=rs.getString(2)%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="lname">Last Name</label>  
                    <div class="col-md-3">
                        <input name="lname" class="form-control input-md" id="name" readonly type="text" value="<%=rs.getString(3)%>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email Id</label>  
                    <div class="col-md-4">
                        <input name="email" class="form-control input-md" id="email" readonly type="text" value="<%=rs.getString(5)%>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="phoneno">Phone no.</label>  
                    <div class="col-md-4">
                        <input name="phoneno" class="form-control input-md" id="phoneno" readonly type="text" value="<%=rs.getString(4)%>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="city">City</label>
                    <div class="col-md-4">
                        <input type="text" name="city" class="form-control input-md" readonly value="<%=rs.getString(6)%>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="zipcode">Zip Code</label>  
                    <div class="col-md-4">
                        <input name="zipcode" class="form-control input-md" id="zipcode" readonly type="text" value="<%=rs.getString(7)%>"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label" for="designation">Designation</label>  
                    <div class="col-md-4">
                        <input name="designation" class="form-control input-md" id="designation" type="text" placeholder="Enter designation if applicable"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label" for="skillid">SkillID</label>  
                    <div class="col-md-4">
                        <input name="skillid" class="form-control input-md" id="skillid" type="text" readonly value="<%=rs.getInt(10)%>"/>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-8">
                        <input type="submit" name="submit" value="Submit" class="btn btn-primary" id="submit">
                    </div>
                </div>
            </fieldset>
            </form>
        <% }%>
        
        <script src="formvalidation.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
