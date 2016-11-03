<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="WEB-APP/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-APP/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>       
        <title>Titulo</title>
    </head>
    <body>  

        <div id="main" class="container-fluid">

            <div id="top" class="row">
                <div class="col-md-3">
                    <h2>Pessoas</h2>
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
                <div class="col-md-3"> <!-- /MODAL PARA ADICIONAR NOVA PESSOA -->
                    <a href="add.html" class="btn btn-primary pull-right h2">Adicionar Pessoa</a>
                </div>
            </div> 

            <div id="list" class="row">
                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>RG</th>
                                <th class="actions">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1001</td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing</td>
                                <td>Jes</td>
                                <td>01/01/2015</td>
                                <td class="actions">
                                    <a class="btn btn-success btn-xs" href="view.html">Visualizar</a>
                                    <a class="btn btn-warning btn-xs" href="edit.html">Editar</a>
                                    <a class="btn btn-danger btn-xs"  href="#" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                                </td>
                            </tr>
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
        <script src="WEB-APP/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="WEB-APP/bootstrap/js/jquery.min.js" type="text/javascript"></script>
    </body>    
</html>