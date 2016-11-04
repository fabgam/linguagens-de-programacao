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
        <link href="WEB-APP/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>       
        <title>POO2 ICA 3-4 - Home</title>
    </head>
    <body>        

        <!-- Modal Cadastro -->
        <div class="modal fade" id="new-pessoa-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Novo cadastro</h4>
                    </div>

                    <form action="PessoaController" method="post">  
                        <div class="modal-body">                                                  
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="nome">Nome *</label>
                                    <input type="text" class="form-control " id="nome" name="nome">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="cpf">CPF *</label>
                                    <input type="text" class="form-control" id="cpf" name="cpf">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="rg">RG *</label>
                                    <input type="text" class="form-control" id="rg" name="rg">
                                    <sub>* Campos de preenchimento obrigatório</sub>                                    
                                </div>
                            </div>                        
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <input type="submit" class="btn btn-primary" name="enviar" value="Salvar">  
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal View -->
        <div class="modal fade" id="view-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Visualizar cadastro</h4>
                    </div>

                    <div class="modal-body">
                        <form>                            
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="nome">Nome</label>
                                    <input type="text" class="form-control" id="nome" value="<c:out value="${nome.variavel}" placeholder="Nome" readonly="readonly"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="cpf">CPF</label>
                                    <input type="text" class="form-control" id="cpf" value="<c:out value="${nome.variavel}" placeholder="CPF" readonly="readonly"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="rg">RG</label>
                                    <input type="text" class="form-control" id="rg" value="<c:out value="${nome.variavel}" placeholder="RG" readonly="readonly"/>
                                </div>
                            </div>                          
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Edit -->
        <div class="modal fade" id="edit-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Editar cadastro</h4>
                    </div>
                    <div class="modal-body">
                        <form>                            
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="nome">Nome *</label>
                                    <input type="text" class="form-control " id="nome">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="cpf">CPF *</label>
                                    <input type="text" class="form-control" id="cpf">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="rg">RG *</label>
                                    <input type="text" class="form-control" id="rg">
                                    <sub>* Campos de preenchimento obrigatório</sub>
                                </div>
                            </div>                          
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary">Salvar</button>                        
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Delete -->
        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Excluir cadastro</h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir este cadastro?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                        <button type="button" class="btn btn-danger">Sim</button>                        
                    </div>
                </div>
            </div>
        </div>

        <!-- Menu Top -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">                    
                    <a class="navbar-brand" href="index.jsp">POO2 ICA 3-4</a>
                </div>                
            </div>
        </nav>

        <div id="main" class="container-fluid" style="margin-top: 50px">  

            <div id="top" class="row">
                <div class="col-md-3">
                    <h2>CRUD de pessoas</h2>
                </div>

                <div class="col-md-6">
                    <div class="input-group h2">
                        <input name="data[search]" class="form-control" id="search" type="text" placeholder="Buscar por ID">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>
                </div>

                <div class="col-md-3"> 
                    <button type="button" class="btn btn-primary pull-right h2" data-toggle="modal" data-target="#new-pessoa-modal"  >Novo cadastro</button>                    
                </div>
            </div>  

            <div id="list" class="row">    <br>            
                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th id="id">ID</th>
                                <th id="nome">Nome</th>
                                <th id="cpf">CPF</th>
                                <th id="rg">RG</th>
                                <th id="acoes" class="actions">Ações</th>
                            </tr>
                        </thead>
                        <%
                            PessoaDAO dao = new PessoaDAO();
                            List<Pessoa> pessoas = dao.getAll();
                        %>
                        <tbody>
                            <%
                                for (int i = 0; i < pessoas.size(); i++) {
                            %>
                            <tr>                                
                                <td><%=pessoas.get(i).getId_pessoa()%></td>
                                <td><%=pessoas.get(i).getNome()%></td>
                                <td><%=pessoas.get(i).getCpf()%></td>
                                <td><%=pessoas.get(i).getRg()%></td>
                                <td class="actions">
                                    <button id="view" type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#view-modal">Visualizar</button>
                                    <button id="edit" type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#edit-modal">Editar</button>
                                    <button id="delete" type="button" class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#delete-modal">Excluir</button>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div> <!-- /#list -->

            <div id="bottom" class="row">
                <div class="col-md-12">
                    <ul class="pagination">
                        <li class="disabled"><a>&lt; Anterior</a></li>
                        <li class="disabled"><a>1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
                    </ul><!-- /.pagination -->
                </div>
            </div> <!-- /#bottom -->
        </div>  <!-- /#main -->          

        <script src="WEB-APP/bootstrap/js/jquery.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    </body>    
</html>