<%@page import="modelo.Pessoa"%>
<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head> 
        <%@include file="head.jsp"%>
        <title>POO2 ICA 3-4 - Informação do cadastro</title>
    </head>
    <body>   
        <%@include file="menu.jsp" %>  

        <div class="container container-fluid" style="margin-top: 5px">
            <fieldset>
                <legend>Exibição de dados cadastrais</legend>   
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
                    <button type="submit" class="btn btn-default btn-sm" name="action" value="redirecionaExibir">Voltar</button>
                </form>
            </fieldset>
        </div>

        <%@include file="scripts.jsp"%>

    </body>    
</html>