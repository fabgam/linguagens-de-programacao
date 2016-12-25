<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="db" class="factory.Database"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Index</title>
    </head>
    <body>
        ${db.create()}
        ${db.populate()}
        <c:redirect url="exibir.jsp"/>        
    </body>
</html>