package View;

import DAO.HistoricoDAO;
import Model.Amigo;
import Model.Ferramenta;
import Model.Historico;
import Model.HistoricoPersonalizado;
import static Utils.Utils.filtrarAmigos;
import static Utils.Utils.filtrarFerramenta;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaDevolucao extends javax.swing.JFrame {

    private final List<Integer> selectedRows;
    private final HistoricoDAO objetohistorico;

    public TelaDevolucao() {
        initComponents();
        this.selectedRows = new ArrayList<>();
        this.objetohistorico = new HistoricoDAO();
        this.criarEvento();
        limparCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNomeAmigoDevolucao = new javax.swing.JTextField();
        txtEmailAmigoDevolucao = new javax.swing.JTextField();
        btnVoltarDevolucao = new javax.swing.JButton();
        btnEfeturarDevolucao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeEmprestimos = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Devolução");

        txtEmailAmigoDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailAmigoDevolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeAmigoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(txtEmailAmigoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeAmigoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailAmigoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVoltarDevolucao.setText("Voltar");
        btnVoltarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarDevolucaoActionPerformed(evt);
            }
        });

        btnEfeturarDevolucao.setText("Efeturar Devolução");
        btnEfeturarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfeturarDevolucaoActionPerformed(evt);
            }
        });

        tabelaDeEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Selecionar", "Codigo Historico", "Nome Amigo", "Nome Ferramenta", "Marca Ferramenta", "Codigo Emprestimo", "Data de Entraga"
            }
        ));
        jScrollPane1.setViewportView(tabelaDeEmprestimos);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnEfeturarDevolucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltarDevolucao)
                        .addGap(155, 155, 155))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarDevolucao)
                    .addComponent(btnEfeturarDevolucao))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailAmigoDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailAmigoDevolucaoActionPerformed

    }//GEN-LAST:event_txtEmailAmigoDevolucaoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        limparTabela();
        Object selectedValue = jComboBox1.getSelectedItem();
        int idAmigo;
        if (selectedValue != null) {
            String selectedString = selectedValue.toString();
            String[] parts = selectedString.split("-");
            if (parts.length == 2) {
                try {
                    String nome = parts[0].trim();
                    String email = parts[1].trim();
                    txtNomeAmigoDevolucao.setText(nome);
                    txtEmailAmigoDevolucao.setText(email);
                    List<Amigo> amigoEncontrado = filtrarAmigos(nome, email);
                    idAmigo = amigoEncontrado.get(0).getId();
                    amigoEncontrado.clear();
                    this.carregaRelatorio(idAmigo);
                } catch (MensagensException ex) {
                    Logger.getLogger(TelaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.criarEvento();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnVoltarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarDevolucaoActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarDevolucaoActionPerformed

    private void btnEfeturarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfeturarDevolucaoActionPerformed
        try {

            if (selectedRows.isEmpty()) {
                throw new MensagensException("Selecione a ferramenta que deseja devolver");
            }
            try {
                List<Historico> historico = objetohistorico.getMinhaLista();

                for (int i = 0; i < selectedRows.size(); i++) {
                    try {
                        for (Historico h : historico) {
                            if (h.getId() == parseInt(this.tabelaDeEmprestimos.getValueAt(selectedRows.get(i), 1).toString())) {
                                LocalDate dataAtual = LocalDate.now();
                                Date dataAtualDate = Date.from(dataAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
                                objetohistorico.AlterarHistoricoBD(h.getId(), h.getAmigo(), h.getFerramenta(), h.getEmprestimo(), dataAtualDate);
                            }
                        }
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
            limparTabela();
            criarEvento();
        }
    }//GEN-LAST:event_btnEfeturarDevolucaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEfeturarDevolucao;
    private javax.swing.JButton btnVoltarDevolucao;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDeEmprestimos;
    private javax.swing.JTextField txtEmailAmigoDevolucao;
    private javax.swing.JTextField txtNomeAmigoDevolucao;
    // End of variables declaration//GEN-END:variables
    public void carregaRelatorio(int idAmigo) {
        limparTabela();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        this.tabelaDeEmprestimos.setModel(modelo);
        tabelaDeEmprestimos = this.tabelaDeEmprestimos;
        modelo.addColumn("Selecionado");
        modelo.addColumn("Codigo Historico");
        modelo.addColumn("Nome Amigo");
        modelo.addColumn("Ferramenta");
        modelo.addColumn("Marca Ferramenta");
        modelo.addColumn("Codigo Emprestimo");
        modelo.addColumn("Data de Entrega");

        CentralizarRenderer centralizarRenderer = new CentralizarRenderer();
        tabelaDeEmprestimos.getColumnModel().getColumn(1).setCellRenderer(centralizarRenderer);
        tabelaDeEmprestimos.getColumnModel().getColumn(2).setCellRenderer(centralizarRenderer);
        tabelaDeEmprestimos.getColumnModel().getColumn(3).setCellRenderer(centralizarRenderer);
        tabelaDeEmprestimos.getColumnModel().getColumn(4).setCellRenderer(centralizarRenderer);
        tabelaDeEmprestimos.getColumnModel().getColumn(5).setCellRenderer(centralizarRenderer);
        tabelaDeEmprestimos.getColumnModel().getColumn(6).setCellRenderer(centralizarRenderer);

        ArrayList<HistoricoPersonalizado> minhalista = new ArrayList<>();
        minhalista.clear();
        try {
            minhalista = objetohistorico.getMinhaListaPersonalizada(idAmigo);
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (HistoricoPersonalizado h : minhalista) {
            if (h.getDataEntregaEfetiva() == null) {
                modelo.addRow(new Object[]{
                    false,
                    h.getIdHistorico(),
                    h.getNomeAmigo(),
                    h.getNomeFerramenta(),
                    h.getMarcaFerramenta(),
                    h.getIdEmprestimo(),
                    h.getDataEntregaPrevista()
                });
            }
        }
    }

    public class CentralizarRenderer extends DefaultTableCellRenderer {

        public CentralizarRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }

    private void criarEvento() {
        tabelaDeEmprestimos.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
                    selecionarLinhasMarcadas();
                }
            }
        });
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    atualizarResultadoPesquisa();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    atualizarResultadoPesquisa();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    atualizarResultadoPesquisa();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void atualizarResultadoPesquisa() throws SQLException {
                String nomeAmigo = txtNomeAmigoDevolucao.getText();
                String emailAmigo = txtEmailAmigoDevolucao.getText();

                List<Amigo> amigosEncontrados;
                try {
                    amigosEncontrados = filtrarAmigos(nomeAmigo, emailAmigo);
                    exibirResultadosAmigos(amigosEncontrados);
                } catch (MensagensException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        txtNomeAmigoDevolucao.getDocument().addDocumentListener(documentListener);
        txtEmailAmigoDevolucao.getDocument().addDocumentListener(documentListener);

    }

    private void exibirResultadosAmigos(List<Amigo> amigosEncontrados) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Amigo amigo : amigosEncontrados) {
            String amigoTexto = amigo.getNome() + " - " + amigo.getEmail();
            comboBoxModel.addElement(amigoTexto);
        }

        jComboBox1.setModel(comboBoxModel);
    }

    private void selecionarLinhasMarcadas() {
        selectedRows.clear();
        DefaultTableModel modelo = (DefaultTableModel) tabelaDeEmprestimos.getModel();
        int rowCount = modelo.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            boolean isSelected = (boolean) modelo.getValueAt(row, 0);
            if (isSelected) {
                selectedRows.add(row);
            }
        }
    }

    private void limparCampos() {
        txtEmailAmigoDevolucao.setText("");
        txtNomeAmigoDevolucao.setText("");
        List<Amigo> amigosEncontrados = null;
        try {
            amigosEncontrados = filtrarAmigos("", "");
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        exibirResultadosAmigos(amigosEncontrados);
        limparTabela();
    }

    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaDeEmprestimos.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
