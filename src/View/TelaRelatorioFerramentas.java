package View;

import DAO.FerramentaDAO;
import DAO.HistoricoDAO;
import Model.Ferramenta;
import Model.Historico;
import static Utils.Utils.filtrarFerramenta;
import static java.lang.Double.parseDouble;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class TelaRelatorioFerramentas extends javax.swing.JFrame {

    private final FerramentaDAO objferramenta;
    private JTable tableRelatorioFerramentas;
    private final List<Integer> selectedRows;
    private final HistoricoDAO objetohistorico;

    public TelaRelatorioFerramentas() {
        initComponents();
        this.selectedRows = new ArrayList<>();
        this.objferramenta = new FerramentaDAO();
        this.objetohistorico = new HistoricoDAO();
        this.carregaRelatorio();
        this.criarEvento();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaRelatoroDeFerramentas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRelatorioFerramentas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCampoCustoTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtCampoNomeFerramento = new javax.swing.JTextField();
        txtCampoMarcaFerramento = new javax.swing.JTextField();
        txtCampoCustoFerramento = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TelaRelatoroDeFerramentas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório de Ferramentas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TableRelatorioFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ferramenta", "Descrição", "Custo Unitario"
            }
        ));
        TableRelatorioFerramentas.setName("Relatório de empréstimos ativos"); // NOI18N
        TableRelatorioFerramentas.setRowHeight(35);
        TableRelatorioFerramentas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TableRelatorioFerramentasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TableRelatorioFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRelatorioFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableRelatorioFerramentas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Gasto total com aquisição de ferramentas:");

        txtCampoCustoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoCustoTotalActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Novo nome:");

        jLabel3.setText("Nova marca:");

        jLabel4.setText("Novo custo:");

        javax.swing.GroupLayout TelaRelatoroDeFerramentasLayout = new javax.swing.GroupLayout(TelaRelatoroDeFerramentas);
        TelaRelatoroDeFerramentas.setLayout(TelaRelatoroDeFerramentasLayout);
        TelaRelatoroDeFerramentasLayout.setHorizontalGroup(
            TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampoCustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                        .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCampoCustoFerramento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCampoMarcaFerramento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCampoNomeFerramento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TelaRelatoroDeFerramentasLayout.setVerticalGroup(
            TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(TelaRelatoroDeFerramentasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCampoNomeFerramento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCampoMarcaFerramento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCampoCustoFerramento)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(TelaRelatoroDeFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(txtCampoCustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaRelatoroDeFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaRelatoroDeFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public class CentralizarRenderer extends DefaultTableCellRenderer {

        public CentralizarRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }

    public void carregaRelatorio() {
        double custoTotalFerramental = 0;
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        this.TableRelatorioFerramentas.setModel(modelo);
        tableRelatorioFerramentas = this.TableRelatorioFerramentas;
        modelo.addColumn("Selecionado");
        modelo.addColumn("Nome");
        modelo.addColumn("Marca");
        modelo.addColumn("Custo");

        CentralizarRenderer centralizarRenderer = new CentralizarRenderer();
        TableRelatorioFerramentas.getColumnModel().getColumn(1).setCellRenderer(centralizarRenderer);
        TableRelatorioFerramentas.getColumnModel().getColumn(2).setCellRenderer(centralizarRenderer);
        TableRelatorioFerramentas.getColumnModel().getColumn(3).setCellRenderer(centralizarRenderer);

        ArrayList<Ferramenta> minhalista = new ArrayList<>();
        try {
            minhalista = objferramenta.getMinhaLista();
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Ferramenta f : minhalista) {
            modelo.addRow(new Object[]{
                false,
                f.getNome(),
                f.getMarca(),
                f.getCusto()
            });
            custoTotalFerramental += f.getCusto();
            String custoTotalString = Double.toString(custoTotalFerramental);
            txtCampoCustoTotal.setText("R$:" + custoTotalString);
            txtCampoCustoTotal.setEditable(false);
        }
    }

    private void selecionarLinhasMarcadas() {
        selectedRows.clear();
        DefaultTableModel modelo = (DefaultTableModel) tableRelatorioFerramentas.getModel();
        int rowCount = modelo.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            boolean isSelected = (boolean) modelo.getValueAt(row, 0);
            if (isSelected) {
                selectedRows.add(row);
            }
        }
    }

    private void criarEvento() {
        tableRelatorioFerramentas.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
                    selecionarLinhasMarcadas();
                }
            }
        });
    }
    private void TableRelatorioFerramentasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TableRelatorioFerramentasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TableRelatorioFerramentasAncestorAdded

    private void txtCampoCustoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampoCustoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampoCustoTotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableRelatorioFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRelatorioFerramentasMouseClicked

    }//GEN-LAST:event_TableRelatorioFerramentasMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int idFerramenta = 0;
        try {

            if (selectedRows.isEmpty()) {
                throw new MensagensException("Selecione a ferramenta que deseja excluir");
            }
            try {
                List<Historico> historico = objetohistorico.getMinhaLista();

                for (int i = 0; i < selectedRows.size(); i++) {
                    try {
                        List<Ferramenta> ferramentaEncontrada = filtrarFerramenta(this.TableRelatorioFerramentas.getValueAt(selectedRows.get(i), 1).toString(), this.TableRelatorioFerramentas.getValueAt(selectedRows.get(i), 2).toString());
                        idFerramenta = ferramentaEncontrada.get(0).getId();

                        for (Historico h : historico) {
                            if (h.getFerramenta().getId() == ferramentaEncontrada.get(0).getId() && h.getDataEfetivaDevolucao() == null) {
                                throw new MensagensException("Não é possível excluir uma ferramenta que está emprestada.");
                            }
                        }

                        this.objferramenta.DeleteFerramentaBD(idFerramenta);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                selectedRows.clear();
            } catch (SQLException ex) {
                Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } finally {
            carregaRelatorio();
            criarEvento();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int idFerramenta = 0;
        String nomeFerramenta = txtCampoNomeFerramento.getText(),
                marcaFerramenta = txtCampoMarcaFerramento.getText();
        double custoFerramenta;

        try {

            if (selectedRows.isEmpty()) {
                throw new MensagensException("Selecione a ferramenta que deseja alterar");
            }
            if (selectedRows.size() > 1) {
                throw new MensagensException("Selecione apenas uma ferramenta para alterar");
            } else {
                try {
                    if (nomeFerramenta.isEmpty()) {
                        nomeFerramenta = this.TableRelatorioFerramentas.getValueAt(selectedRows.get(0), 1).toString();
                    }
                    if (marcaFerramenta.isEmpty()) {
                        marcaFerramenta = this.TableRelatorioFerramentas.getValueAt(selectedRows.get(0), 2).toString();
                    }
                    if (txtCampoCustoFerramento.getText().isEmpty()) {
                        custoFerramenta = parseDouble(this.TableRelatorioFerramentas.getValueAt(selectedRows.get(0), 3).toString());
                    } else {
                        custoFerramenta = parseDouble(txtCampoCustoFerramento.getText());
                    }
                    List<Ferramenta> ferramentaEncontrada = filtrarFerramenta(this.TableRelatorioFerramentas.getValueAt(selectedRows.get(0), 1).toString(), this.TableRelatorioFerramentas.getValueAt(selectedRows.get(0), 2).toString());
                    idFerramenta = ferramentaEncontrada.get(0).getId();
                    this.objferramenta.AlterarFerramentaBD(idFerramenta, nomeFerramenta, marcaFerramenta, custoFerramenta);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
                }

                selectedRows.clear();
            }
        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } finally {
            carregaRelatorio();
            criarEvento();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableRelatorioFerramentas;
    private javax.swing.JPanel TelaRelatoroDeFerramentas;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCampoCustoFerramento;
    private javax.swing.JTextField txtCampoCustoTotal;
    private javax.swing.JTextField txtCampoMarcaFerramento;
    private javax.swing.JTextField txtCampoNomeFerramento;
    // End of variables declaration//GEN-END:variables

}
