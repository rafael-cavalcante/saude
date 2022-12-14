/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.saude.tela.medico;

import br.com.saude.model.Medico;
import br.com.saude.tela.consulta.AtualizarConsulta;
import br.com.saude.tela.consulta.ConfirmarConsulta;
import br.com.saude.tela.consulta.FilaConsulta;
import br.com.saude.tela.prontuario.VisualizarProntuario;
import br.com.saude.tela.telefone.CadastrarTelefone;

/**
 *
 * @author tecin
 */
public class MainMedico extends javax.swing.JFrame {

    private final CadastrarTelefone cadastrarTelefone;
    private final FilaConsulta filaConsulta;
    private final ConfirmarConsulta confirmarConsulta;
    private final VisualizarProntuario visualizarProntuario;
    private final AtualizarConsulta atualizarConsulta;
    private Medico medico;

    /**
     * Creates new form MainMedico
     */
    public MainMedico() {
        initComponents();
        initConfiguracoes();
        this.cadastrarTelefone = new CadastrarTelefone();
        this.filaConsulta = new FilaConsulta();
        this.confirmarConsulta = new ConfirmarConsulta();
        this.visualizarProntuario = new VisualizarProntuario();
        this.atualizarConsulta = new AtualizarConsulta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        bt_cadastrarTelefone = new javax.swing.JButton();
        bt_filaConsulta = new javax.swing.JButton();
        bt_confirmarConsulta = new javax.swing.JButton();
        bt_visualizarProntuario = new javax.swing.JButton();
        bt_atualizarConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("??REA DO MEDICO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        bt_cadastrarTelefone.setText("CADASTRAR TELEFONE");
        bt_cadastrarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarTelefoneActionPerformed(evt);
            }
        });

        bt_filaConsulta.setText("FILA CONSULTA");
        bt_filaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_filaConsultaActionPerformed(evt);
            }
        });

        bt_confirmarConsulta.setText("CONFIRMAR CONSULTA");
        bt_confirmarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarConsultaActionPerformed(evt);
            }
        });

        bt_visualizarProntuario.setText("VISUALIZAR PRONTUARIO");
        bt_visualizarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_visualizarProntuarioActionPerformed(evt);
            }
        });

        bt_atualizarConsulta.setText("ATUALIZAR CONSULTA");
        bt_atualizarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_cadastrarTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(bt_visualizarProntuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_confirmarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(bt_filaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(bt_atualizarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cadastrarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_filaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_confirmarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(bt_visualizarProntuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_atualizarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastrarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarTelefoneActionPerformed
        if (!this.cadastrarTelefone.isVisible()) {
            this.cadastrarTelefone.inicializar(this.medico);
            this.cadastrarTelefone.setVisible(true);
        }
    }//GEN-LAST:event_bt_cadastrarTelefoneActionPerformed

    private void bt_filaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_filaConsultaActionPerformed
        if (!this.filaConsulta.isVisible()) {
            this.filaConsulta.inicializar(this.medico);
            this.filaConsulta.setVisible(true);
        }
    }//GEN-LAST:event_bt_filaConsultaActionPerformed

    private void bt_confirmarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarConsultaActionPerformed
        if (!this.confirmarConsulta.isVisible()) {
            this.confirmarConsulta.inicializar(this.medico);
            this.confirmarConsulta.setVisible(true);
        }
    }//GEN-LAST:event_bt_confirmarConsultaActionPerformed

    private void bt_visualizarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_visualizarProntuarioActionPerformed
        if (!this.visualizarProntuario.isVisible()) {
            this.visualizarProntuario.inicializar(this.medico);
            this.visualizarProntuario.setVisible(true);
        }
    }//GEN-LAST:event_bt_visualizarProntuarioActionPerformed

    private void bt_atualizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarConsultaActionPerformed
        if (!this.atualizarConsulta.isVisible()) {
            this.atualizarConsulta.inicializar();
            this.atualizarConsulta.setVisible(true);
        }
    }//GEN-LAST:event_bt_atualizarConsultaActionPerformed

    public void inicializar(Medico medico) {
        this.medico = medico;
    }

    private void initConfiguracoes() {
        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMedico().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizarConsulta;
    private javax.swing.JButton bt_cadastrarTelefone;
    private javax.swing.JButton bt_confirmarConsulta;
    private javax.swing.JButton bt_filaConsulta;
    private javax.swing.JButton bt_visualizarProntuario;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
