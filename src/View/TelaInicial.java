/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form menua3
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        menuItemAmigos = new javax.swing.JMenuItem();
        menuItemCadastro = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        menuItemAtivos = new javax.swing.JMenuItem();
        menuItemFerramentas = new javax.swing.JMenuItem();
        menuItemTodosRelatorios = new javax.swing.JMenuItem();
        menuRegistro = new javax.swing.JMenu();
        menuItemEmprestimo = new javax.swing.JMenuItem();
        menuAgenda = new javax.swing.JMenu();
        menuItemAgenda = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jToolBar1.setRollover(true);

        jMenu2.setText("jMenu2");

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        MenuCadastro.setText("Cadastros");

        menuItemAmigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/group_add.png"))); // NOI18N
        menuItemAmigos.setText("Amigos");
        menuItemAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAmigosActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuItemAmigos);

        menuItemCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/add.png"))); // NOI18N
        menuItemCadastro.setText("Ferramentas");
        menuItemCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastroActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuItemCadastro);

        jMenuBar1.add(MenuCadastro);

        MenuRelatorio.setText("Relatórios");

        menuItemAtivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/application_view_detail.png"))); // NOI18N
        menuItemAtivos.setText("Ativos");
        menuItemAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAtivosActionPerformed(evt);
            }
        });
        MenuRelatorio.add(menuItemAtivos);

        menuItemFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/application_view_columns.png"))); // NOI18N
        menuItemFerramentas.setText("Ferramentas");
        menuItemFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFerramentasActionPerformed(evt);
            }
        });
        MenuRelatorio.add(menuItemFerramentas);

        menuItemTodosRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/application_view_list.png"))); // NOI18N
        menuItemTodosRelatorios.setText("Todas os relatórios");
        menuItemTodosRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTodosRelatoriosActionPerformed(evt);
            }
        });
        MenuRelatorio.add(menuItemTodosRelatorios);

        jMenuBar1.add(MenuRelatorio);

        menuRegistro.setText("Registros");

        menuItemEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/application_add.png"))); // NOI18N
        menuItemEmprestimo.setText("Registro de Emprestimos");
        menuItemEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEmprestimoActionPerformed(evt);
            }
        });
        menuRegistro.add(menuItemEmprestimo);

        jMenuBar1.add(menuRegistro);

        menuAgenda.setText("Agenda");

        menuItemAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/date_add.png"))); // NOI18N
        menuItemAgenda.setText("Agenda");
        menuItemAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgendaActionPerformed(evt);
            }
        });
        menuAgenda.add(menuItemAgenda);

        jMenuBar1.add(menuAgenda);

        menuItemSair.setText("Sair");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ICONS/icons 1/door_in.png"))); // NOI18N
        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuItemSair.add(jMenuItem3);

        jMenuBar1.add(menuItemSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastroActionPerformed
        new TelaCadastroFerramenta().setVisible(true);
    }//GEN-LAST:event_menuItemCadastroActionPerformed

    private void menuItemAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAtivosActionPerformed
        new TelaRelatorioAtivos().setVisible(true);
    }//GEN-LAST:event_menuItemAtivosActionPerformed

    private void menuItemFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFerramentasActionPerformed
        new TelaRelatorioFerramentas().setVisible(true);
    }//GEN-LAST:event_menuItemFerramentasActionPerformed

    private void menuItemEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEmprestimoActionPerformed
        try {
            new TelaRegistrarEmprestimo().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MensagensException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemEmprestimoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItemAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAmigosActionPerformed
        new TelaCadastroAmigo().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemAmigosActionPerformed

    private void menuItemTodosRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTodosRelatoriosActionPerformed
        new TelaTodosRelatorios().setVisible(true);
    }//GEN-LAST:event_menuItemTodosRelatoriosActionPerformed

    private void menuItemAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgendaActionPerformed
        new TelaAgenda().setVisible(true);
    }//GEN-LAST:event_menuItemAgendaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenuItem menuItemAgenda;
    private javax.swing.JMenuItem menuItemAmigos;
    private javax.swing.JMenuItem menuItemAtivos;
    private javax.swing.JMenuItem menuItemCadastro;
    private javax.swing.JMenuItem menuItemEmprestimo;
    private javax.swing.JMenuItem menuItemFerramentas;
    private javax.swing.JMenu menuItemSair;
    private javax.swing.JMenuItem menuItemTodosRelatorios;
    private javax.swing.JMenu menuRegistro;
    // End of variables declaration//GEN-END:variables
}
