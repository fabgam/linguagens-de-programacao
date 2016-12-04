<%
    String status = "";
    status = (String) request.getAttribute("status");
    if (request.getAttribute("status") != null) {
        if (request.getAttribute("status").equals("inseridoComSucesso")) {
%>
<div class="row">
    <div class="col-md-10">
        <div class="alert alert-success alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <span class="glyphicon glyphicon-ok-sign"></span>
            Cadastro efetuado com <strong>sucesso!</strong>
        </div>
    </div>
</div>
<%
} else if (request.getAttribute("status").equals("atualizadoComSucesso")) {
%>
<div class="row">
    <div class="col-md-10">
        <div class="alert alert-success alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <span class="glyphicon glyphicon-ok-sign"></span>
            Cadastro atualizado com <strong>sucesso!</strong>
        </div>
    </div>
</div>
<%
} else if (request.getAttribute("status").equals("deletadoComSucesso")) {
%>
<div class="row">
    <div class="col-md-10">
        <div class="alert alert-success alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <span class="glyphicon glyphicon-ok-sign"></span>
            Cadastro removido com <strong>sucesso!</strong>
        </div>
    </div>
</div>
<%
} else if (request.getAttribute("status").equals("erroCadastroCampoVazio")) {
%>
<div class="row">
    <div class="col-md-10">
        <div class="alert alert-danger alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <span class="glyphicon glyphicon-exclamation-sign"></span>
            Cadastro não efetuado, <strong>preencha todos os campos!</strong>
        </div>
    </div>
</div>
<%
} else if (request.getAttribute("status").equals("erroAtualizacaoCampoVazio")) {
%>
<div class="row">
    <div class="col-md-10">
        <div class="alert alert-danger alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <span class="glyphicon glyphicon-exclamation-sign"></span>
            Atualização cadastral não efetuada, <strong>preencha todos os campos!</strong>
        </div>
    </div>
</div>
<%
} else if (request.getAttribute("status").equals("erroDadosInvalidos")) {
%>
<div class="row">
    <div class="col-md-10">
        <div class="alert alert-danger alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <span class="glyphicon glyphicon-exclamation-sign"></span>
            Cadastro não efetuado, <strong>preencha todos os campos!</strong>
        </div>
    </div>
</div>
<%
        }
    }
%>