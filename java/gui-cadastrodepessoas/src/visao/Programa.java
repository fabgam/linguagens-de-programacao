package visao;

import dao.PessoaDAO;
import factory.Database;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import modelo.Pessoa;
import modelo.PessoaTableModel;

public class Programa extends javax.swing.JFrame {

    private final PessoaTableModel model = new PessoaTableModel();
    private final PessoaDAO dao = new PessoaDAO();

    public Programa() throws SQLException {
        initComponents();
        Database.create();
        jxTextFieldCOD.setText(Integer.toString(dao.maiorIDInserida()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jxPanelListaCadastros = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jxTableListaCadastros = new org.jdesktop.swingx.JXTable();
        jxSearchFieldBuscaID = new org.jdesktop.swingx.JXSearchField();
        jXButtonAtualizarLista = new org.jdesktop.swingx.JXButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jxTextFieldRG = new org.jdesktop.swingx.JXTextField();
        jxLabelRG = new org.jdesktop.swingx.JXLabel();
        jxLabelCPF = new org.jdesktop.swingx.JXLabel();
        jxLabelNome = new org.jdesktop.swingx.JXLabel();
        jxTextFieldCOD = new org.jdesktop.swingx.JXTextField();
        jxLabelCOD = new org.jdesktop.swingx.JXLabel();
        jxTextFieldCPF = new org.jdesktop.swingx.JXTextField();
        jxTextFieldNome = new org.jdesktop.swingx.JXTextField();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jxTextFieldEmail = new org.jdesktop.swingx.JXTextField();
        jxLabelWhatsApp = new org.jdesktop.swingx.JXLabel();
        jxTextFieldTelCelular = new org.jdesktop.swingx.JXTextField();
        jxLabelEmail = new org.jdesktop.swingx.JXLabel();
        jxTextFieldTelResidencial = new org.jdesktop.swingx.JXTextField();
        jxTextFieldWhatsApp = new org.jdesktop.swingx.JXTextField();
        jxLabelTelResidencial = new org.jdesktop.swingx.JXLabel();
        jxLabelTelCelular = new org.jdesktop.swingx.JXLabel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jxButtonRemover = new org.jdesktop.swingx.JXButton();
        jxButtonEditar = new org.jdesktop.swingx.JXButton();
        jxButtonSair = new org.jdesktop.swingx.JXButton();
        jXPanel5 = new org.jdesktop.swingx.JXPanel();
        jxButtonCadastrar = new org.jdesktop.swingx.JXButton();
        jxButtonLimpar = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de pessoas");

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
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jxSearchFieldBuscaID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jxSearchFieldBuscaIDKeyPressed(evt);
            }
        });

        jXButtonAtualizarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow_refresh.png"))); // NOI18N
        jXButtonAtualizarLista.setText("Atualizar");
        jXButtonAtualizarLista.setMaximumSize(new java.awt.Dimension(110, 25));
        jXButtonAtualizarLista.setMinimumSize(new java.awt.Dimension(110, 25));
        jXButtonAtualizarLista.setPreferredSize(new java.awt.Dimension(110, 25));
        jXButtonAtualizarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonAtualizarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jxPanelListaCadastrosLayout = new javax.swing.GroupLayout(jxPanelListaCadastros);
        jxPanelListaCadastros.setLayout(jxPanelListaCadastrosLayout);
        jxPanelListaCadastrosLayout.setHorizontalGroup(
            jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jxPanelListaCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jxPanelListaCadastrosLayout.createSequentialGroup()
                        .addComponent(jxSearchFieldBuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXButtonAtualizarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jxPanelListaCadastrosLayout.setVerticalGroup(
            jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jxPanelListaCadastrosLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jxPanelListaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxSearchFieldBuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonAtualizarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação | Contato"));

        jxLabelRG.setText("RG:");

        jxLabelCPF.setText("CPF:");

        jxLabelNome.setText("Nome:");

        jxTextFieldCOD.setEditable(false);

        jxLabelCOD.setText("Código:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jxLabelCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxLabelRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxLabelRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jxLabelWhatsApp.setText("WhatsApp:");

        jxLabelEmail.setText("E-mail:");

        jxLabelTelResidencial.setText("Tel. Residencial:");

        jxLabelTelCelular.setText("Tel. Celular:");

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jXPanel2Layout.createSequentialGroup()
                            .addComponent(jxLabelTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jxTextFieldTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jxLabelWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jxLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jxTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jxTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jxLabelTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jxTextFieldTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxTextFieldTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxLabelTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxLabelWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jxButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jxButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        javax.swing.GroupLayout jXPanel5Layout = new javax.swing.GroupLayout(jXPanel5);
        jXPanel5.setLayout(jXPanel5Layout);
        jXPanel5Layout.setHorizontalGroup(
            jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jxButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel5Layout.setVerticalGroup(
            jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jxPanelListaCadastros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jXPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxPanelListaCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jxButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonSairActionPerformed
        if (evt.getSource().equals(jxButtonSair)) {
            System.exit(0);
        }
    }//GEN-LAST:event_jxButtonSairActionPerformed

    private void jxButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonRemoverActionPerformed
        if (evt.getSource().equals(jxButtonRemover)) {
            dao.delete((int) jxTableListaCadastros.getValueAt(jxTableListaCadastros.getSelectedRow(), 0));
            model.limparListaDePessoas(jxTableListaCadastros);
            model.addListaDePessoas(jxTableListaCadastros);
            jxSearchFieldBuscaID.setText("");
            model.criaDialogs(2);
        }
    }//GEN-LAST:event_jxButtonRemoverActionPerformed

    private void jxButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonEditarActionPerformed
        if (evt.getSource().equals(jxButtonEditar)) {
            JanelaEditCadastro janelaEditCadastro = new JanelaEditCadastro();
            janelaEditCadastro.setVisible(true);
        }
    }//GEN-LAST:event_jxButtonEditarActionPerformed

    private void jxSearchFieldBuscaIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jxSearchFieldBuscaIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(jxSearchFieldBuscaID.getText().trim())) {
                model.criaDialogs(4);
            } else if (dao.persist(Integer.parseInt(jxSearchFieldBuscaID.getText().trim())) == false) {
                model.criaDialogs(6);
            } else {
                int searchFieldID = Integer.parseInt(jxSearchFieldBuscaID.getText().trim());
                model.addPessoa(jxTableListaCadastros, searchFieldID);
                jxSearchFieldBuscaID.setText("");
            }
        }
    }//GEN-LAST:event_jxSearchFieldBuscaIDKeyPressed

    private void jxButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonCadastrarActionPerformed
        if (evt.getSource().equals(jxButtonCadastrar)) {
            if (model.validaCampos(jxTextFieldNome, jxTextFieldCPF, jxTextFieldRG,
                    jxTextFieldTelResidencial, jxTextFieldTelCelular,
                    jxTextFieldEmail, jxTextFieldWhatsApp)) {

                dao.insert(new Pessoa(Integer.parseInt(
                        jxTextFieldCOD.getText()), jxTextFieldNome.getText(),
                        jxTextFieldCPF.getText(), jxTextFieldRG.getText(),
                        jxTextFieldTelResidencial.getText(), jxTextFieldTelCelular.getText(),
                        jxTextFieldEmail.getText(), jxTextFieldWhatsApp.getText()));

                model.limparCamposDeCadastro(
                        jxTableListaCadastros, jxTextFieldNome, jxTextFieldCPF,
                        jxTextFieldRG, jxTextFieldTelResidencial, jxTextFieldTelCelular,
                        jxTextFieldEmail, jxTextFieldWhatsApp);

                jxTextFieldCOD.setText(Integer.toString(dao.maiorIDInserida()));
                model.addListaDePessoas(jxTableListaCadastros);
                jxTableListaCadastros.addRowSelectionInterval(0, 0);
                model.criaDialogs(1);
            } else {
                model.criaDialogs(5);
            }
        }
    }//GEN-LAST:event_jxButtonCadastrarActionPerformed

    private void jxButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxButtonLimparActionPerformed
        if (evt.getSource().equals(jxButtonLimpar)) {
            model.limparCamposDeCadastro(jxTableListaCadastros, jxTextFieldNome, jxTextFieldCPF,
                    jxTextFieldRG, jxTextFieldTelResidencial, jxTextFieldTelCelular, jxTextFieldEmail, jxTextFieldWhatsApp);
        }
    }//GEN-LAST:event_jxButtonLimparActionPerformed

    private void jXButtonAtualizarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonAtualizarListaActionPerformed
        if (evt.getSource().equals(jXButtonAtualizarLista)) {
            jxSearchFieldBuscaID.setText("");
            model.limparListaDePessoas(jxTableListaCadastros);
            model.addListaDePessoas(jxTableListaCadastros);
        }
    }//GEN-LAST:event_jXButtonAtualizarListaActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXButton jXButtonAtualizarLista;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXPanel jXPanel5;
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
