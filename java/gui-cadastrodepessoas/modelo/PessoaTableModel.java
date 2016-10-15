package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PessoaTableModel extends AbstractTableModel {

    private final List<Pessoa> linhas;
    private final String[] colunas = new String[]{"ID", "Nome", "CPF", "RG", "Tel. Residencial", "Tel. Celular", "E-mail", "WhatsApp"};
    private static final int ID_PESSOA = 0;
    private static final int NOME = 1;
    private static final int CPF = 2;
    private static final int RG = 3;
    private static final int TELRESIDENCIAL = 4;
    private static final int TELCELULAR = 5;
    private static final int EMAIL = 6;
    private static final int WHATSAPP = 7;

    public PessoaTableModel() {
        this.linhas = new ArrayList<Pessoa>();
    }

    public PessoaTableModel(List<Pessoa> listaDePessoas) {
        this.linhas = new ArrayList<Pessoa>(listaDePessoas);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Pessoa pessoa = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID_PESSOA:
                return pessoa.getId_pessoa();
            case NOME:
                return pessoa.getNome();
            case CPF:
                return pessoa.getCpf();
            case RG:
                return pessoa.getRg();
            case TELRESIDENCIAL:
                return pessoa.getTelResidencial();
            case TELCELULAR:
                return pessoa.getTelCelular();
            case EMAIL:
                return pessoa.getEmail();
            case WHATSAPP:
                return pessoa.getWhatsApp();
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds");
        }
    }

    public Pessoa getPessoa(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addPessoa(Pessoa pessoa) {
        linhas.add(pessoa);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removePessoa(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDePessoas(List<Pessoa> pessoas) {
        int indice = getRowCount();
        linhas.addAll(pessoas);
        fireTableRowsInserted(indice, indice + pessoas.size());
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
