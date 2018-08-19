<%-- 
    Document   : Employee
    Author     : Blair
--%>

<%@page import="model.Emp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="myStyle.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style>
            body{
                background: url('empbackg.jpg');
                background-repeat: no-repeat;
                background-size: cover;
            }
            h1{
                color: wheat;
            }
        </style>
    </head>
    <body>
        <h1>Welcome</h1>
        
        <jsp:useBean scope="request" id="Emp" type="Emp">
            <h2><jsp:getProperty name="Emp" property="usrname"/></h2>
        </jsp:useBean>

        <div>
            <a href="login.html" class="btn btn-primary logoutbtn"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
        </div>
        
        <div>
            <input type="button" class="btn btn-info" value="Edit Information"/>
        </div>
        
        <div>
            <%
                
            %>
        </div>
    </body>
</html>
