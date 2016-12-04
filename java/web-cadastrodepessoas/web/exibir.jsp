<%@page import="java.util.List"%>
<%@page import="modelo.Pessoa"%>
<%@page import="dao.PessoaDAO"%>
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
        <%@include file="modal.jsp"%>        
        <%@include file="menu.jsp" %>
        <div class="container container-fluid" style="margin-top: 5px">
            <fieldset>
                <legend>Listagem de cadastros</legend>       
                <%@include file="alert_msg.jsp"%>
                <div class="row">                
                    <div class="col-md-10"> 
                        <a class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#cadastro-modal">
                            <span class="glyphicon glyphicon-plus"></span> Novo Cadastro
                        </a>                    
                    </div>
                </div>
                <br>
                <div class="row"> 
                    <div class="table-responsive col-md-10">
                        <table class="table table-condensed table-responsive table-bordered" cellspacing="0" cellpadding="0">
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
                                <%                                    PessoaDAO dao = new PessoaDAO();
                                    List<Pessoa> pessoas = dao.getAll();

                                    if (!pessoas.isEmpty()) {
                                        for (int i = 0; i < pessoas.size(); i++) {
                                %>
                                <tr>     
                                    <td><%=pessoas.get(i).getId_pessoa()%></td>
                                    <td><%=pessoas.get(i).getNome()%></td>
                                    <td><%=pessoas.get(i).getCpf()%></td>
                                    <td><%=pessoas.get(i).getRg()%></td>
                                    <td>
                                        <form action="PessoaController" method="post">
                                            <input type="hidden" name="id" value="<%=pessoas.get(i).getId_pessoa()%>">
                                            <div class="btn-group btn-group-xs">
                                                <button type="submit" class="btn btn-default" name="action" value="redirecionaInfo" >
                                                    <span class="glyphicon glyphicon-zoom-in"></span>
                                                </button>

                                                <button type="submit" class="btn btn-default" name="action" value="redirecionaEditar" >
                                                    <span class="glyphicon glyphicon-pencil"></span>
                                                </button>

                                                <button type="submit" class="btn btn-default" name="action" value="remover" >
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </button>
                                            </div>
                                        </form>
                                    </td>                                    
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table> 
                    </div>
                </div>
            </fieldset>
        </div>
        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
        <script src="WEB-APP/datatables/js/datatables.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/util.js" type="text/javascript"></script>
    </body>    
</html>