<%-- 
    Document   : logout
    Created on : Jun 8, 2022, 11:50:20 AM
    Author     : Akshay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
        request.logout();
        
      // request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        response.sendRedirect("Login.xhtml");
        %>
    </body>
</html>
