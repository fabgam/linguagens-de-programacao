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
        <title>POO2 ICA 3-4 - Exibição de cadastros</title>
    </head>
    <body>   

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
                <legend>Exibição de dados cadastrais</legend>   

                <div class="row">                
                    <div class="col-md-4"> 

                        <form action="PessoaController" method="post">
                            <div class="col-md-12">
                                <div class="input-group input-group-sm h2">
                                    <input type="hidden" name="action" value="pesquisarExibir">
                                    <input class="form-control" id="search" name="data[search]" type="text" placeholder="Pesquisar">
                                    <span class="input-group input-group-btn">
                                        <button class="btn btn-primary" type="submit">
                                            <span class="glyphicon glyphicon-search"></span>
                                        </button>
                                    </span>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>

                <form action="PessoaController" method="post">                    

                    <%
                        PessoaDAO dao = new PessoaDAO();
                        Pessoa p = dao.get(Integer.parseInt(request.getParameter("id")));
                    %>

                    <div class="row">
                        <div class="form-group form-group-sm col-md-4">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" value="<%=p.getId_pessoa()%>" id="id" name="id" readonly="readonly">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group form-group-sm col-md-4">
                            <label for="nome">Nome *</label>
                            <input type="text" class="form-control " value="<%=p.getNome()%>" id="nome" name="nome" readonly="readonly">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group form-group-sm col-md-4">
                            <label for="cpf">CPF *</label>
                            <input type="text" class="form-control" value="<%=p.getCpf()%>" id="cpf" name="cpf" readonly="readonly">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group form-group-sm col-md-4">
                            <label for="rg">RG *</label>
                            <input type="text" class="form-control" value="<%=p.getRg()%>" id="rg" name="rg" readonly="readonly">
                            <sub>* Campos de preenchimento obrigatório</sub>                                    
                        </div>
                    </div>                      

                    <a href="index.jsp" class="btn btn-default btn-sm">Voltar</a>                    
                </form>
            </fieldset>
        </div>

        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
        <script src="WEB-APP/datatables/js/datatables.min.js" type="text/javascript"></script>
        <script src="WEB-APP/datatables/js/ptable.js" type="text/javascript"></script>

    </body>    
</html>