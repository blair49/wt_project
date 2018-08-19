<%-- 
    Document   : EmailClient
    Author     : Blair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Email</title>
    </head>
    <body>
        <h2>Send Email to applicant</h2>
        <form method="post" action="MailDispatcher">
            <table>
                <tr>
                    <td align="right"><b>To:</b></td>
                    <td><input value="<%=request.getParameter("to_email")%>" name="to_email" readonly/></td>
                </tr>
                <tr>
                    <td align="right"><b>Subject:</b></td>
                    <td><input type="text" placeholder="Enter subject here" size="75" name="subject"/></td>
                </tr>
                <tr>
                    <td align="right"><b>Message:</b></td>
                    <td><textarea type="text" cols="75" rows="6" name="message" placeholder="Type your message here"></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Send"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
