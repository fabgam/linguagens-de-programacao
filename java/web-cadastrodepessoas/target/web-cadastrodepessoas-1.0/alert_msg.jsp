<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${requestScope.status == 'inseridoComSucesso'}">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-success alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-ok-sign"></span>
                    Cadastro efetuado com <strong>sucesso!</strong>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${requestScope.status == 'atualizadoComSucesso'}">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-success alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-ok-sign"></span>
                    Cadastro atualizado com <strong>sucesso!</strong>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${requestScope.status == 'deletadoComSucesso'}">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-success alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-ok-sign"></span>
                    Cadastro removido com <strong>sucesso!</strong>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${requestScope.status == 'erroCadastroCampoVazio'}">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    Cadastro não efetuado, <strong>preencha todos os campos!</strong>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${requestScope.status == 'erroAtualizacaoCampoVazio'}">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    Atualização cadastral não efetuada, <strong>preencha todos os campos!</strong>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${requestScope.status == 'erroDadosInvalidos'}">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    Cadastro não efetuado, <strong>preencha todos os campos!</strong>
                </div>
            </div>
        </div>
    </c:when>
</c:choose>