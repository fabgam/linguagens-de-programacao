<%@page import="factory.Database"%>
<%@page import="servlets.PessoaController"%>
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
        <link href="WEB-APP/bootstrap/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>POO2 ICA 3-4 - Home</title>        
    </head>

    <body>   

        <%@include file="modal.jsp"%>

        <!-- Menu Top -->
        <nav class="navbar navbar-default">
            <div class="container container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="index.jsp">
                                <span class="glyphicon glyphicon-home"></span> HOME
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>                                                                     
                    </ul>                    
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>        

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

                <!-- Lista -->
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
                                    <td class="actions">

                                        <form action="PessoaController" method="post">
                                            <input type="hidden" name="id" value="<%=pessoas.get(i).getId_pessoa()%>">

                                            <button type="submit" class="btn btn-info btn-xs" name="action" value="redirecionaExibir" >
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
                </div> <!-- #Lista -->
            </fieldset>
        </div>

        <script src="WEB-APP/jquery/js/jquery.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
        <script src="WEB-APP/jquery/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/list.js" type="text/javascript"></script>        

    </body>    
</html>