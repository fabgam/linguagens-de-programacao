package Cronometro;

import javax.swing.SwingUtilities;

public class JanelaCronometro extends javax.swing.JFrame {

    public JanelaCronometro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXFrame1 = new org.jdesktop.swingx.JXFrame();
        jxlMSG = new org.jdesktop.swingx.JXLabel();
        jxtfCron = new org.jdesktop.swingx.JXTextField();
        jxlTempo = new org.jdesktop.swingx.JXLabel();
        jxbIniciar = new org.jdesktop.swingx.JXButton();
        jxbZerar = new org.jdesktop.swingx.JXButton();

        javax.swing.GroupLayout jXFrame1Layout = new javax.swing.GroupLayout(jXFrame1.getContentPane());
        jXFrame1.getContentPane().setLayout(jXFrame1Layout);
        jXFrame1Layout.setHorizontalGroup(
            jXFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jXFrame1Layout.setVerticalGroup(
            jXFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronômetro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
        });

        jxlMSG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jxlMSG.setText("Digite o tempo para parada");
        jxlMSG.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N

        jxtfCron.setBackground(new java.awt.Color(12, 12, 13));
        jxtfCron.setForeground(new java.awt.Color(17, 240, 22));
        jxtfCron.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jxtfCron.setText("00:00:00");
        jxtfCron.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N

        jxlTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jxlTempo.setText("00:00:00");
        jxlTempo.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        jxlTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jxbIniciar.setText("Iniciar");
        jxbIniciar.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jxbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxbIniciarActionPerformed(evt);
            }
        });

        jxbZerar.setText("Zerar");
        jxbZerar.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jxbZerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxbZerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxbZerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxbIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxlTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxtfCron, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jxlMSG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jxlMSG, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxtfCron, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxlTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jxbIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxbZerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jxbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxbIniciarActionPerformed
        jxlTempo.setText(jxtfCron.getText());
        jxtfCron.setText("00:00:00");
        new Cronometro(jxtfCron, jxlTempo).start();
    }//GEN-LAST:event_jxbIniciarActionPerformed

    private void jxbZerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxbZerarActionPerformed
        if ((!evt.getSource().equals(jxbZerar) || !"00:00:00".equals(jxlTempo.getText())) || !"00:00:00".equals(jxtfCron.getText())) {
            jxtfCron.setText("00:00:00");
            jxlTempo.setText("00:00:00");
        }
    }//GEN-LAST:event_jxbZerarActionPerformed

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        SwingUtilities.invokeLater(() -> {
            jxtfCron.repaint();
        });
    }//GEN-LAST:event_formWindowDeiconified

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new JanelaCronometro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXFrame jXFrame1;
    private org.jdesktop.swingx.JXButton jxbIniciar;
    private org.jdesktop.swingx.JXButton jxbZerar;
    private org.jdesktop.swingx.JXLabel jxlMSG;
    private org.jdesktop.swingx.JXLabel jxlTempo;
    private org.jdesktop.swingx.JXTextField jxtfCron;
    // End of variables declaration//GEN-END:variables
}
