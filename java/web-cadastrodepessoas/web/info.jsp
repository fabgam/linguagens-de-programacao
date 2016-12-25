<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="WEB-APP/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-APP/datatables/css/datatables.min.css" rel="stylesheet" type="text/css"/>
        <title>POO2 ICA 3-4 - Informação do cadastro</title>
    </head>
    <body>   
        <c:import url="menu.jsp"/>
        <div class="container container-fluid">
            <div class="page-header">
                <h3>Exibição de dados cadastrais</h3>
            </div>
            <form action="infocadastro" method="post">
                <div class="row">
                    <div class="form-group form-group-sm col-md-12">
                        <label for="id">ID</label>
                        <input type="text" class="form-control" value="${requestScope.id}" id="id" name="id" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group form-group-sm col-md-12">
                        <label for="nome">Nome *</label>
                        <input type="text" class="form-control " value="${requestScope.nome}" id="nome" name="nome" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group form-group-sm col-md-12">
                        <label for="cpf">CPF *</label>
                        <input type="text" class="form-control" value="${requestScope.cpf}" id="cpf" name="cpf" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group form-group-sm col-md-12">
                        <label for="rg">RG *</label>
                        <input type="text" class="form-control" value="${requestScope.rg}" id="rg" name="rg" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default btn-block" name="action" value="redirecionaExibir">Voltar</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
        <script src="WEB-APP/datatables/js/datatables.min.js" type="text/javascript"></script>
    </body>    
</html>