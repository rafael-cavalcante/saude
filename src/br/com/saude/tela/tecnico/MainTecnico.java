/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.saude.tela.tecnico;

import br.com.saude.model.Tecnico;
import br.com.saude.tela.consulta.AtualizarConsulta;
import br.com.saude.tela.consulta.SolicitarConsultaEmergencia;
import br.com.saude.tela.consulta.VisualizarConsulta;
import br.com.saude.tela.medico.CadastrarMedico;
import br.com.saude.tela.telefone.CadastrarTelefone;

/**
 *
 * @author tecin
 */
public class MainTecnico extends javax.swing.JFrame {

    private final CadastrarMedico cadastrarMedico;
    private final SolicitarConsultaEmergencia solicitarConsultaEmergencia;
    private final AtualizarConsulta atualizarConsulta;
    private final CadastrarTelefone cadastrarTelefone;
    private final VisualizarConsulta visualizarConsulta;
    private Tecnico tecnico;

    /**
     * Creates new form MainTecnico
     */
    public MainTecnico() {
        initComponents();
        initConfiguracoes();
        this.cadastrarMedico = new CadastrarMedico();
        this.solicitarConsultaEmergencia = new SolicitarConsultaEmergencia();
        this.atualizarConsulta = new AtualizarConsulta();
        this.cadastrarTelefone = new CadastrarTelefone();
        this.visualizarConsulta = new VisualizarConsulta();
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
        bt_cadastrarMedico = new javax.swing.JButton();
        bt_solicitarConsultaEmergencia = new javax.swing.JButton();
        bt_atualizarConsulta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        bt_cadastrarTelefone = new javax.swing.JButton();
        bt_visualizarConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bt_cadastrarMedico.setText("CADASTRAR MEDICO");
        bt_cadastrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarMedicoActionPerformed(evt);
            }
        });

        bt_solicitarConsultaEmergencia.setText("SOLICITAR CONSULTA EMERGENCIA");
        bt_solicitarConsultaEmergencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_solicitarConsultaEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_solicitarConsultaEmergenciaActionPerformed(evt);
            }
        });

        bt_atualizarConsulta.setText("ATUALIZAR CONSULTA");
        bt_atualizarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarConsultaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ÁREA DO TECNICO");

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

        bt_visualizarConsulta.setText("VISUALIZAR CONSULTA");
        bt_visualizarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_visualizarConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_cadastrarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cadastrarTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_visualizarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bt_solicitarConsultaEmergencia, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(bt_atualizarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cadastrarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_solicitarConsultaEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cadastrarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_atualizarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_visualizarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_atualizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarConsultaActionPerformed
        if (!this.atualizarConsulta.isVisible()) {
            this.atualizarConsulta.inicializar();
            this.atualizarConsulta.setVisible(true);
        }
    }//GEN-LAST:event_bt_atualizarConsultaActionPerformed

    private void bt_cadastrarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarMedicoActionPerformed
        if (!this.cadastrarMedico.isVisible()) {
            this.cadastrarMedico.inicializar(this.tecnico);
            this.cadastrarMedico.setVisible(true);
        }
    }//GEN-LAST:event_bt_cadastrarMedicoActionPerformed

    private void bt_solicitarConsultaEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_solicitarConsultaEmergenciaActionPerformed
        if (!this.solicitarConsultaEmergencia.isVisible()) {
            this.solicitarConsultaEmergencia.inicializar();
            this.solicitarConsultaEmergencia.setVisible(true);
        }
    }//GEN-LAST:event_bt_solicitarConsultaEmergenciaActionPerformed

    private void bt_cadastrarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarTelefoneActionPerformed
        if (!this.cadastrarTelefone.isVisible()) {
            this.cadastrarTelefone.inicializar(this.tecnico);
            this.cadastrarTelefone.setVisible(true);
        }
    }//GEN-LAST:event_bt_cadastrarTelefoneActionPerformed

    private void bt_visualizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_visualizarConsultaActionPerformed
        if(!this.visualizarConsulta.isVisible()){
            this.visualizarConsulta.inicializar();
            this.visualizarConsulta.setVisible(true);
        }
    }//GEN-LAST:event_bt_visualizarConsultaActionPerformed

    public void inicializar(Tecnico tecnico) {
        this.tecnico = tecnico;
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
            java.util.logging.Logger.getLogger(MainTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainTecnico().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizarConsulta;
    private javax.swing.JButton bt_cadastrarMedico;
    private javax.swing.JButton bt_cadastrarTelefone;
    private javax.swing.JButton bt_solicitarConsultaEmergencia;
    private javax.swing.JButton bt_visualizarConsulta;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
