package visao;

import javax.swing.JOptionPane;

public class ProgramaDialogs extends Thread {

    private final int op;

    public ProgramaDialogs(int op) {
        this.op = op;
    }

    public int getOp() {
        return this.op;
    }

    @Override
    public void run() {
        switch (getOp()) {
            case 1:
                cadastroEfetuadoComSucesso();
                break;
            case 2:
                cadastroRemovidoComSucesso();
                break;
            case 3:
                cadastroAtualizadoComSucesso();
                break;
            case 4:
                searchFieldIDVazio();
                break;
            case 5:
                textFieldsVazios();
                break;
            case 6:
                searchFieldIDInexistente();
                break;
            default:
                throw new RuntimeException("Dialog index out of bounds");
        }
    }

    public void cadastroEfetuadoComSucesso() {
        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
    }

    public void cadastroRemovidoComSucesso() {
        JOptionPane.showMessageDialog(null, "Cadastro removido com sucesso.");
    }

    public void cadastroAtualizadoComSucesso() {
        JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.");
    }

    public void textFieldsVazios() {
        JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
    }

    public void searchFieldIDVazio() {
        JOptionPane.showMessageDialog(null, "Digite um número inteiro.");
    }

    private void searchFieldIDInexistente() {
        JOptionPane.showMessageDialog(null, "Cadastro inexistente.");
    }
}
