package visao;

import dao.PessoaDAO;
import factory.Database;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Pessoa;
import modelo.PessoaTableModel;
import org.jdesktop.swingx.JXTextField;

public class Programa extends javax.swing.JFrame {

    public Programa() throws SQLException {
        initComponents();
        Database.create();
        jxTextFieldCOD.setText(Integer.toString(PessoaDAO.maiorIDInserida()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelIdentificacao = new javax.swing.JPanel();
        jxLabelNome = new org.jdesktop.swingx.JXLabel();
        jxLabelRG = new org.jdesktop.swingx.JXLabel();
        jxTextFieldCOD = new org.jdesktop.swingx.JXTextField();
        jxLabelCPF = new org.jdesktop.swingx.JXLabel();
        jxLabelCOD = new org.jdesktop.swingx.JXLabel();
        jxTextFieldCPF = new org.jdesktop.swingx.JXTextField();
        jxTextFieldRG = new org.jdesktop.swingx.JXTextField();
        jxTextFieldNome = new org.jdesktop.swingx.JXTextField();
        jPanelContato = new javax.swing.JPanel();
        jxTextFieldEmail = new org.jdesktop.swingx.JXTextField();
        jxLabelEmail = new org.jdesktop.swingx.JXLabel();
        jxTextFieldTelCelular = new org.jdesktop.swingx.JXTextField();
        jxTextFieldTelResidencial = new org.jdesktop.swingx.JXTextField();
        jxLabelTelResidencial = new org.jdesktop.swingx.JXLabel();
        jxLabelTelCelular = new org.jdesktop.swingx.JXLabel();
        jxLabelWhatsApp = new org.jdesktop.swingx.JXLabel();
        jxTextFieldWhatsApp = new org.jdesktop.swingx.JXTextField();
        jxButtonCadastrar = new org.jdesktop.swingx.JXButton();
        jxButtonLimpar = new org.jdesktop.swingx.JXButton();
        jxButtonEditar = new org.jdesktop.swingx.JXButton();
        jxButtonRemover = new org.jdesktop.swingx.JXButton();
        jxButtonSair = new org.jdesktop.swingx.JXButton();
        jxPanelListaCadastros = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jxTableListaCadastros = new org.jdesktop.swingx.JXTable();
        jxSearchFieldBuscaID = new org.jdesktop.swingx.JXSearchField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de pessoas");

        jPanelIdentificacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));

        jxLabelNome.setText("Nome:");

        jxLabelRG.setText("RG:");

        jxTextFieldCOD.setEditable(false);

        jxLabelCPF.setText("CPF:");

        jxLabelCOD.setText("Código:");

        javax.swing.GroupLayout jPanelIdentificacaoLayout = new javax.swing.GroupLayout(jPanelIdentificacao);
        jPanelIdentificacao.setLayout(jPanelIdentificacaoLayout);
        jPanelIdentificacaoLayout.setHorizontalGroup(
            jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdentificacaoLayout.createSequentialGroup()
                .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIdentificacaoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jxLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jxLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jxLabelRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jxTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jxTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jxTextFieldRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIdentificacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jxLabelCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jxTextFieldCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelIdentificacaoLayout.setVerticalGroup(
            jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdentificacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelContato.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jxLabelEmail.setText("E-mail:");

        jxLabelTelResidencial.setText("Tel. Residencial:");

        jxLabelTelCelular.setText("Tel. Celular:");

        jxLabelWhatsApp.setText("WhatsApp:");

        javax.swing.GroupLayout jPanelContatoLayout = new javax.swing.GroupLayout(jPanelContato);
        jPanelContato.setLayout(jPanelContatoLayout);
        jPanelContatoLayout.setHorizontalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContatoLayout.createSequentialGroup()
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelContatoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jxLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jxLabelTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jxLabelWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jxLabelTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jxTextFieldTelResidencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxTextFieldTelCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxTextFieldWhatsApp, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelContatoLayout.setVerticalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jxButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_add.png"))); // NOI18N
        jxButtonCadastrar.setText("Cadastrar");
        jxButtonCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jxButtonCadastrar.setMaximumSize(new java.awt.Dimension(110, 25));
        jxButtonCadastrar.setMinimumSize(new java.awt.Dimension(110, 25));
        jxButtonCadastrar.setPreferredSize(new java.awt.Dimension(110, 25));
        jxButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxButtonCadastrarActionPerformed(evt);
            }
        });

        jxButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bin.png"))); // NOI18N
        jxButtonLimpar.setText("Limpar");
        jxButtonLimpar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jxButtonLimpar.setMaximumSize(new java.awt.Dimension(110, 25));
        jxButtonLimpar.setMinimumSize(new java.awt.Dimension(110, 25));
        jxButtonLimpar.setPreferredSize(new java.awt.Dimension(110, 25));
        jxButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxButtonLimparActionPerformed(evt);
            }
        });

        jxButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_edit.png"))); // NOI18N
        jxButtonEditar.setText("Editar");
        jxButtonEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jxButtonEditar.setMaximumSize(new java.awt.Dimension(110, 25));
        jxButtonEditar.setMinimumSize(new java.awt.Dimension(110, 25));
        jxButtonEditar.setPreferredSize(new java.awt.Dimension(110, 25));
        jxButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxButtonEditarActionPerformed(evt);
            }
        });

        jxButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_delete.png"))); // NOI18N
        jxButtonRemover.setText("Remover");
        jxButtonRemover.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jxButtonRemover.setMaximumSize(new java.awt.Dimension(110, 25));
        jxButtonRemover.setMinimumSize(new java.awt.Dimension(110, 25));
        jxButtonRemover.setPreferredSize(new java.awt.Dimension(110, 25));
        jxButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxButtonRemoverActionPerformed(evt);
            }
        });

        jxButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        jxButtonSair.setText("Sair");
        jxButtonSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jxButtonSair.setMaximumSize(new java.awt.Dimension(110, 25));
        jxButtonSair.setMinimumSize(new java.awt.Dimension(110, 25));
        jxButtonSair.setPreferredSize(new java.awt.Dimension(110, 25));
        jxButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxButtonSairActionPerformed(evt);
            }
        });

        jxPanelListaCadastros.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de cadastros"));

        jxTableListaCadastros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jxTableListaCadastros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "RG", "Tel. Residencial", "Tel. Celular", "E-mail", "WhatsApp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jxTableListaCadastros.setToolTipText("");
        jScrollPane2.setViewportView(jxTableListaCadastros);
        jxTableListaCadastros.getAccessibleContext().setAccessibleDescription("ID");

        jxSearchFieldBuscaID.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jxSearchFieldBuscaID.setToolTipText("Buscar por ID");
        jxSearchFieldBuscaID.setMaximumSize(new java.awt.Dimension(110, 25));
        jxSearchFieldBuscaID.setMinimumSize(new java.awt.Dimension(110, 25));
        jxSearchFieldBuscaID.setName(""); // NOI18N
        jxSearchFieldBuscaID.setPreferredSize(new java.awt.Dimension(110, 25));
        jxSearchFieldBuscaID.setPrompt("Busca por ID");
        jxSearchFieldBuscaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxSearchFieldBuscaIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jxPanelListaCadastrosLayout = new javax.swing.GroupLayout(jxPanelListaCadastros);
        jxPanelListaCadastros.setLayout(jxPanelListaCadastrosLayout);
        jxPanelListaCadastrosLayout.setHorizontalGroup(
            jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jxPanelListaCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jxPanelListaCadastrosLayout.createSequentialGroup()
                        .addComponent(jxSearchFieldBuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jxPanelListaCadastrosLayout.setVerticalGroup(
            jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jxPanelListaCadastrosLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jxSearchFieldBuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxPanelListaCadastros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jxButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jxButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jxButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jxButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jxButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxPanelListaCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void montajxTableListaCadastros() {
        PessoaDAO dao = new PessoaDAO();
        List<Pessoa> p = dao.getAll();
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

    private void limpajxTableListaCadastros() {
        DefaultTableModel model = (DefaultTableModel) jxTableListaCadastros.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void limparCamposDeCadastro() {
        jxTextFieldNome.setText("");
        jxTextFieldCPF.setText("");
        jxTextFieldRG.setText("");
        jxTextFieldTelResidencial.setText("");
        jxTextFieldTelCelular.setText("");
        jxTextFieldEmail.setText("");
        jxTextFieldWhatsApp.setText("");
    }

    private void jxButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonLimparActionPerformed
        if (evt.getSource().equals(jxButtonLimpar)) {
            limparCamposDeCadastro();
        }
    }//GEN-LAST:event_jxButtonLimparActionPerformed

    private void jxButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonSairActionPerformed
        if (evt.getSource().equals(jxButtonSair)) {
            System.exit(0);
        }
    }//GEN-LAST:event_jxButtonSairActionPerformed

    private void jxButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonCadastrarActionPerformed
        if (evt.getSource().equals(jxButtonCadastrar) && !validaCampos(jxTextFieldNome)
                && !validaCampos(jxTextFieldCPF) && !validaCampos(jxTextFieldRG)
                && !validaCampos(jxTextFieldTelResidencial) && !validaCampos(jxTextFieldTelCelular)
                && !validaCampos(jxTextFieldEmail) && !validaCampos(jxTextFieldWhatsApp)) {

            PessoaDAO.insert(new Pessoa(Integer.parseInt(jxTextFieldCOD.getText()), jxTextFieldNome.getText(), jxTextFieldCPF.getText(),
                    jxTextFieldRG.getText(), jxTextFieldTelResidencial.getText(),
                    jxTextFieldTelCelular.getText(), jxTextFieldEmail.getText(),
                    jxTextFieldWhatsApp.getText()));

            limparCamposDeCadastro();
            jxTextFieldCOD.setText(Integer.toString(PessoaDAO.maiorIDInserida()));
            montajxTableListaCadastros();
        }
    }//GEN-LAST:event_jxButtonCadastrarActionPerformed

    private boolean validaCampos(JXTextField jxtf) {
        return jxtf.getText().equals("") || jxtf.getText().equals(" ");
    }

    private void jxSearchFieldBuscaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxSearchFieldBuscaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jxSearchFieldBuscaIDActionPerformed

    private void jxButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonRemoverActionPerformed
        if (evt.getSource().equals(jxButtonRemover)) {
            PessoaDAO dao = new PessoaDAO();
            dao.delete((int) jxTableListaCadastros.getValueAt(jxTableListaCadastros.getSelectedRow(), 0));
            limpajxTableListaCadastros();
            montajxTableListaCadastros();
        }
    }//GEN-LAST:event_jxButtonRemoverActionPerformed

    private void jxButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonEditarActionPerformed
        if (evt.getSource().equals(jxButtonEditar)) {

        }
    }//GEN-LAST:event_jxButtonEditarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Programa().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private PessoaTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelContato;
    private javax.swing.JPanel jPanelIdentificacao;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXButton jxButtonCadastrar;
    private org.jdesktop.swingx.JXButton jxButtonEditar;
    private org.jdesktop.swingx.JXButton jxButtonLimpar;
    private org.jdesktop.swingx.JXButton jxButtonRemover;
    private org.jdesktop.swingx.JXButton jxButtonSair;
    private org.jdesktop.swingx.JXLabel jxLabelCOD;
    private org.jdesktop.swingx.JXLabel jxLabelCPF;
    private org.jdesktop.swingx.JXLabel jxLabelEmail;
    private org.jdesktop.swingx.JXLabel jxLabelNome;
    private org.jdesktop.swingx.JXLabel jxLabelRG;
    private org.jdesktop.swingx.JXLabel jxLabelTelCelular;
    private org.jdesktop.swingx.JXLabel jxLabelTelResidencial;
    private org.jdesktop.swingx.JXLabel jxLabelWhatsApp;
    private org.jdesktop.swingx.JXPanel jxPanelListaCadastros;
    private org.jdesktop.swingx.JXSearchField jxSearchFieldBuscaID;
    private org.jdesktop.swingx.JXTable jxTableListaCadastros;
    private org.jdesktop.swingx.JXTextField jxTextFieldCOD;
    private org.jdesktop.swingx.JXTextField jxTextFieldCPF;
    private org.jdesktop.swingx.JXTextField jxTextFieldEmail;
    private org.jdesktop.swingx.JXTextField jxTextFieldNome;
    private org.jdesktop.swingx.JXTextField jxTextFieldRG;
    private org.jdesktop.swingx.JXTextField jxTextFieldTelCelular;
    private org.jdesktop.swingx.JXTextField jxTextFieldTelResidencial;
    private org.jdesktop.swingx.JXTextField jxTextFieldWhatsApp;
    // End of variables declaration//GEN-END:variables
}
