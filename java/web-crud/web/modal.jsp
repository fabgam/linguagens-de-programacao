<!-- Modal Cadastro -->
<div class="modal fade" id="cadastro-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalLabel">Novo cadastro</h4>
            </div>

            <form action="PessoaController" method="post">  
                <div class="modal-body">                                                  
                    <div class="row">
                        <div class="form-group form-group-sm col-md-12">
                            <label for="nome">Nome *</label>
                            <input type="text" class="form-control " id="nome" name="nome">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group form-group-sm col-md-12">
                            <label for="cpf">CPF *</label>
                            <input type="text" class="form-control" id="cpf" name="cpf">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group form-group-sm col-md-12">
                            <label for="rg">RG *</label>
                            <input type="text" class="form-control" id="rg" name="rg">
                            <sub>* Campos de preenchimento obrigatório</sub>                                    
                        </div>
                    </div>                        
                </div>

                <div class="modal-footer">
                    <input type="hidden" name="action" value="novo">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancelar</button>
                    <input type="submit" class="btn btn-primary btn-sm" value="Salvar">  
                </div>
            </form>
        </div>
    </div>
</div>