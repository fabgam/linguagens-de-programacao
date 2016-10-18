package modelo;

import dao.PessoaDAO;

public class ProgramaModelo {

    private final PessoaDAO dao = new PessoaDAO();

    public boolean isDigit(String str) {
        return str.matches("[0-9]*");
    }
    
    public int strToInt(String str){
        int op = -1;
        try {
                op = Integer.parseInt(str);
            } catch (NumberFormatException exception) {

            }
        return op;
    }

    public boolean isCadastroValido(String nome, String cpf, String rg) {
        return !(nome.trim().isEmpty() || cpf.trim().isEmpty() || rg.trim().isEmpty());
    }

    public boolean isDatabasePopulate() {
        return dao.maiorIDInserida() != 0;
    }
}
