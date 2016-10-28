package modelo;

import dao.PessoaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTextField;
import visao.ProgramaDialogs;

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
    private static final PessoaDAO DAO = new PessoaDAO();

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

    public void addPessoa(JXTable jxTableListaCadastros, int searchFieldID) {
        Pessoa p = DAO.get(searchFieldID);
        limparListaDePessoas(jxTableListaCadastros);
        DefaultTableModel model = (DefaultTableModel) jxTableListaCadastros.getModel();
        model.addRow(new Object[0]);
        jxTableListaCadastros.getModel().setValueAt(p.getId_pessoa(), 0, 0);
        jxTableListaCadastros.getModel().setValueAt(p.getNome(), 0, 1);
        jxTableListaCadastros.getModel().setValueAt(p.getCpf(), 0, 2);
        jxTableListaCadastros.getModel().setValueAt(p.getRg(), 0, 3);
        jxTableListaCadastros.getModel().setValueAt(p.getTelResidencial(), 0, 4);
        jxTableListaCadastros.getModel().setValueAt(p.getTelCelular(), 0, 5);
        jxTableListaCadastros.getModel().setValueAt(p.getEmail(), 0, 6);
        jxTableListaCadastros.getModel().setValueAt(p.getWhatsApp(), 0, 7);
    }

    public void removePessoa(int indiceLinha) {

    }

    public void addListaDePessoas(JXTable jxTableListaCadastros) {
        List<Pessoa> p = DAO.getAll();
        DefaultTableModel model = (DefaultTableModel) jxTableListaCadastros.getModel();
        for (int i = 0; i < p.size(); i++) {
            model.addRow(new Object[0]);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getId_pessoa(), i, 0);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getNome(), i, 1);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getCpf(), i, 2);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getRg(), i, 3);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getTelResidencial(), i, 4);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getTelCelular(), i, 5);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getEmail(), i, 6);
            jxTableListaCadastros.getModel().setValueAt(p.get(i).getWhatsApp(), i, 7);
        }
    }

    public void limparListaDePessoas(JXTable jxTableListaCadastros) {
        DefaultTableModel model = (DefaultTableModel) jxTableListaCadastros.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void limparCamposDeCadastro(JXTable jxTableListaCadastros, JXTextField jxTextFieldNome,
            JXTextField jxTextFieldCPF, JXTextField jxTextFieldRG, JXTextField jxTextFieldTelResidencial,
            JXTextField jxTextFieldTelCelular, JXTextField jxTextFieldEmail, JXTextField jxTextFieldWhatsApp) {
        jxTextFieldNome.setText("");
        jxTextFieldCPF.setText("");
        jxTextFieldRG.setText("");
        jxTextFieldTelResidencial.setText("");
        jxTextFieldTelCelular.setText("");
        jxTextFieldEmail.setText("");
        jxTextFieldWhatsApp.setText("");
    }

    public boolean validaCampos(JXTextField jxTextFieldNome, JXTextField jxTextFieldCPF, JXTextField jxTextFieldRG,
            JXTextField jxTextFieldTelResidencial, JXTextField jxTextFieldTelCelular,
            JXTextField jxTextFieldEmail, JXTextField jxTextFieldWhatsApp) {
        if ("".equals(jxTextFieldNome.getText().trim())) {
            return false;
        } else if ("".equals(jxTextFieldCPF.getText().trim())) {
            return false;
        } else if ("".equals(jxTextFieldRG.getText().trim())) {
            return false;
        } else if ("".equals(jxTextFieldTelResidencial.getText().trim())) {
            return false;
        } else if ("".equals(jxTextFieldTelCelular.getText().trim())) {
            return false;
        } else if ("".equals(jxTextFieldEmail.getText().trim())) {
            return false;
        } else if ("".equals(jxTextFieldWhatsApp.getText().trim())) {
            return false;
        }
        return true;
    }

    public void criaDialogs(int op) {
        ProgramaDialogs pg = new ProgramaDialogs(op);
        Thread t = new Thread(pg);
        t.start();
    }
}
