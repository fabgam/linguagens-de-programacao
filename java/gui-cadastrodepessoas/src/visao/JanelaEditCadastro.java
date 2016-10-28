package visao;

import dao.PessoaDAO;
import modelo.Pessoa;
import modelo.PessoaTableModel;
import org.jdesktop.swingx.JXTextField;

public class JanelaEditCadastro extends javax.swing.JFrame {

    private final PessoaTableModel model = new PessoaTableModel();
    private final PessoaDAO dao = new PessoaDAO();

    public JanelaEditCadastro() {        
        initComponents();
    }
    
    public JanelaEditCadastro(Pessoa p) {
        jxTextFieldCOD.setText(Integer.toString(p.getId_pessoa()));
        jxTextFieldNome.setText(p.getNome());
        jxTextFieldCPF.setText(p.getCpf());
        jxTextFieldRG.setText(p.getRg());
        jxTextFieldTelResidencial.setText(p.getTelResidencial());
        jxTextFieldTelCelular.setText(p.getTelCelular());
        jxTextFieldEmail.setText(p.getEmail());
        jxTextFieldWhatsApp.setText(p.getWhatsApp());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jXButtonSave = new org.jdesktop.swingx.JXButton();
        jXButtonDelete = new org.jdesktop.swingx.JXButton();
        jXButtonUndo = new org.jdesktop.swingx.JXButton();
        jXButtonFirst = new org.jdesktop.swingx.JXButton();
        jXButtonPrevious = new org.jdesktop.swingx.JXButton();
        jXButtonNext = new org.jdesktop.swingx.JXButton();
        jXButtonLast = new org.jdesktop.swingx.JXButton();
        jXButtonFechar = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edição de cadastro");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jxLabelCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxLabelRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jxLabelWhatsApp.setText("WhatsApp:");

        jxLabelEmail.setText("E-mail:");

        jxLabelTelResidencial.setText("Tel. Residencial:");

        jxLabelTelCelular.setText("Tel. Celular:");

        jXButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/accept.png"))); // NOI18N
        jXButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonSaveActionPerformed(evt);
            }
        });

        jXButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jXButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonDeleteActionPerformed(evt);
            }
        });

        jXButtonUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow_undo.png"))); // NOI18N
        jXButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonUndoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jXPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
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
                .addGap(18, 18, 18)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonUndo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jxTextFieldTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jxLabelTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jxTextFieldTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jxLabelTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXButtonUndo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jxTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jxLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jxTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jxLabelWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXButtonFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resultset_first.png"))); // NOI18N
        jXButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonFirstActionPerformed(evt);
            }
        });

        jXButtonPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resultset_previous.png"))); // NOI18N
        jXButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonPreviousActionPerformed(evt);
            }
        });

        jXButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resultset_next.png"))); // NOI18N
        jXButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonNextActionPerformed(evt);
            }
        });

        jXButtonLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resultset_last.png"))); // NOI18N
        jXButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonLastActionPerformed(evt);
            }
        });

        jXButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        jXButtonFechar.setText("Fechar");
        jXButtonFechar.setMaximumSize(new java.awt.Dimension(110, 25));
        jXButtonFechar.setMinimumSize(new java.awt.Dimension(110, 25));
        jXButtonFechar.setPreferredSize(new java.awt.Dimension(110, 25));
        jXButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXButtonFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXButtonLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void limparCamposDeCadastro(JXTextField jxTextFieldNome, JXTextField jxTextFieldCPF,
            JXTextField jxTextFieldRG, JXTextField jxTextFieldTelResidencial, JXTextField jxTextFieldTelCelular,
            JXTextField jxTextFieldEmail, JXTextField jxTextFieldWhatsApp) {
        jxTextFieldNome.setText("");
        jxTextFieldCPF.setText("");
        jxTextFieldRG.setText("");
        jxTextFieldTelResidencial.setText("");
        jxTextFieldTelCelular.setText("");
        jxTextFieldEmail.setText("");
        jxTextFieldWhatsApp.setText("");
    }

    private void jXButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonUndoActionPerformed
        if (evt.getSource().equals(jXButtonUndo)) {
            limparCamposDeCadastro(jxTextFieldNome, jxTextFieldCPF, jxTextFieldRG, jxTextFieldTelResidencial, jxTextFieldTelCelular, jxTextFieldEmail, jxTextFieldWhatsApp);
            Pessoa p = dao.get(Integer.parseInt(jxTextFieldCOD.getText()));
            jxTextFieldNome.setText(p.getNome());
            jxTextFieldCPF.setText(p.getCpf());
            jxTextFieldRG.setText(p.getRg());
            jxTextFieldTelResidencial.setText(p.getTelResidencial());
            jxTextFieldTelCelular.setText(p.getTelCelular());
            jxTextFieldEmail.setText(p.getEmail());
            jxTextFieldWhatsApp.setText(p.getWhatsApp());
        }
    }//GEN-LAST:event_jXButtonUndoActionPerformed

    private void jXButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonDeleteActionPerformed
        if (evt.getSource().equals(jXButtonDelete)) {
            dao.delete(Integer.parseInt(jxTextFieldCOD.getText()));
            model.criaDialogs(2);
        }
    }//GEN-LAST:event_jXButtonDeleteActionPerformed

    private void jXButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonSaveActionPerformed
        if (evt.getSource().equals(jXButtonSave)) {
            dao.update(new Pessoa(Integer.parseInt(jxTextFieldCOD.getText()), jxTextFieldNome.getText(),
                    jxTextFieldCPF.getText(), jxTextFieldRG.getText(), jxTextFieldTelResidencial.getText(),
                    jxTextFieldTelCelular.getText(), jxTextFieldEmail.getText(), jxTextFieldWhatsApp.getText()));
            model.criaDialogs(3);
        }
    }//GEN-LAST:event_jXButtonSaveActionPerformed

    private void jXButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonFirstActionPerformed
        if (evt.getSource().equals(jXButtonFirst)) {

        }
    }//GEN-LAST:event_jXButtonFirstActionPerformed

    private void jXButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonPreviousActionPerformed
        if (evt.getSource().equals(jXButtonPrevious)) {

        }
    }//GEN-LAST:event_jXButtonPreviousActionPerformed

    private void jXButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonNextActionPerformed
        if (evt.getSource().equals(jXButtonNext)) {

        }
    }//GEN-LAST:event_jXButtonNextActionPerformed

    private void jXButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonLastActionPerformed
        if (evt.getSource().equals(jXButtonLast)) {
            Pessoa p = dao.get(dao.maiorIDInserida());
            if (p.getId_pessoa() > 0) {
                jxTextFieldCOD.setText(Integer.toString(p.getId_pessoa()));
                jxTextFieldNome.setText(p.getNome());
                jxTextFieldCPF.setText(p.getCpf());
                jxTextFieldRG.setText(p.getRg());
                jxTextFieldTelResidencial.setText(p.getTelResidencial());
                jxTextFieldTelCelular.setText(p.getTelCelular());
                jxTextFieldEmail.setText(p.getEmail());
                jxTextFieldWhatsApp.setText(p.getWhatsApp());
            }
        }
    }//GEN-LAST:event_jXButtonLastActionPerformed

    private void jXButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonFecharActionPerformed
        if (evt.getSource().equals(jXButtonFechar)) {
            dispose();
        }
    }//GEN-LAST:event_jXButtonFecharActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaEditCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaEditCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaEditCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaEditCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new JanelaEditCadastro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton jXButtonDelete;
    private org.jdesktop.swingx.JXButton jXButtonFechar;
    private org.jdesktop.swingx.JXButton jXButtonFirst;
    private org.jdesktop.swingx.JXButton jXButtonLast;
    private org.jdesktop.swingx.JXButton jXButtonNext;
    private org.jdesktop.swingx.JXButton jXButtonPrevious;
    private org.jdesktop.swingx.JXButton jXButtonSave;
    private org.jdesktop.swingx.JXButton jXButtonUndo;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXLabel jxLabelCOD;
    private org.jdesktop.swingx.JXLabel jxLabelCPF;
    private org.jdesktop.swingx.JXLabel jxLabelEmail;
    private org.jdesktop.swingx.JXLabel jxLabelNome;
    private org.jdesktop.swingx.JXLabel jxLabelRG;
    private org.jdesktop.swingx.JXLabel jxLabelTelCelular;
    private org.jdesktop.swingx.JXLabel jxLabelTelResidencial;
    private org.jdesktop.swingx.JXLabel jxLabelWhatsApp;
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
