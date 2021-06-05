<jsp:useBean id="dao" class="com.web.cadastrodepessoas.dao.PessoaDAO"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="WEB-APP/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-APP/datatables/css/datatables.min.css" rel="stylesheet" type="text/css"/>
        <title>POO2 ICA 3-4 - Listagem de cadastros</title>        
    </head>
    <body>   
        <c:import url="modal.jsp"/>        
        <c:import url="menu.jsp"/>
        <div class="container container-fluid">
            <div class="page-header">
                <h3>Listagem de cadastros</h3>       
            </div>
            <c:import url="alert_msg.jsp"/>
            <div class="row">       
                <div class="col-md-12"> 
                    <a class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target=".cadastro-modal">
                        <span class="glyphicon glyphicon-plus"></span> Novo Cadastro
                    </a>                    
                </div>
            </div>
            <br>
            <div class="row"> 
                <div class="col-md-12">
                    <table class="table table-condensed table-responsive table-bordered table-hover table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOME</th>
                                <th>CPF</th>
                                <th>RG</th>
                                <th>AÇÃO</th>
                            </tr>
                        </thead>
                        <tbody>                            
                            <c:forEach var="pessoa" items="${dao.all}">
                                <tr>     
                                    <td>${pessoa.id_pessoa}</td>
                                    <td>${pessoa.nome}</td>
                                    <td>${pessoa.cpf}</td>
                                    <td>${pessoa.rg}</td>
                                    <td>
                                        <form action="pessoa" method="post">
                                            <input type="hidden" name="id" value="${pessoa.id_pessoa}">
                                            <div class="btn-group btn-group-xs">
                                                <button type="submit" class="btn btn-default" name="action" value="redirecionaInfo" data-toggle="tooltip" data-placement="top" title="Visualizar">
                                                    <span class="glyphicon glyphicon-zoom-in"></span>
                                                </button>

                                                <button type="submit" class="btn btn-default" name="action" value="redirecionaEditar" data-toggle="tooltip" data-placement="top" title="Editar">
                                                    <span class="glyphicon glyphicon-pencil"></span>
                                                </button>

                                                <button type="submit" class="btn btn-default" name="action" value="remover" data-toggle="tooltip" data-placement="top" title="Remover">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </button>
                                            </div>
                                        </form>
                                    </td>                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>
            </div>
        </div>
        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
        <script src="WEB-APP/datatables/js/datatables.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/util.js" type="text/javascript"></script>
    </body>    
</html>