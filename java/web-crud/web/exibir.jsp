<%@page import="java.util.List"%>
<%@page import="modelo.Pessoa"%>
<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>         
        <%@include file="head.jsp"%>
        <title>POO2 ICA 3-4 - Listagem de cadastros</title>        
    </head>
    <body>   
        <%@include file="modal.jsp"%>
        <%@include file="menu.jsp" %>    

        <div class="container container-fluid" style="margin-top: 5px">
            <fieldset>
                <legend>Listagem de cadastros</legend>
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
                        <table id="list" class="table table-condensed table-responsive table-bordered" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>RG</th>
                                    <th id="acoes" class="actions">Ações</th>
                                </tr>
                            </thead>
                            <%
                                PessoaDAO dao = new PessoaDAO();
                                List<Pessoa> pessoas = dao.getAll();
                            %>
                            <tbody>
                                <%
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

                                            <button type="submit" class="btn btn-info btn-xs" name="action" value="redirecionaInfo" >
                                                <span class="glyphicon glyphicon-eye-open"></span> Info
                                            </button>

                                            <button type="submit" class="btn btn-warning btn-xs" name="action" value="redirecionaEditar" >
                                                <span class="glyphicon glyphicon-edit"></span> Editar
                                            </button>

                                            <button type="submit" class="btn btn-danger btn-xs" name="action" value="remover" >
                                                <span class="glyphicon glyphicon-remove"></span> Remover
                                            </button>
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

        <%@include file="scripts.jsp"%>

    </body>    
</html>