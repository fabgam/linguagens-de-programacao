<%@page import="factory.Database"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <%
            Database.create();
            Database.populate();
            String redirectURL = "exibir.jsp";
            response.sendRedirect(redirectURL);
        %>
    </body>
</html>