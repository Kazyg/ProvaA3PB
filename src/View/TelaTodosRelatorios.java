package View;

import DAO.HistoricoDAO;
import Model.HistoricoPersonalizado;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaTodosRelatorios extends javax.swing.JFrame {

    private final HistoricoDAO objetohistorico;

    public TelaTodosRelatorios() {
        initComponents();
        this.objetohistorico = new HistoricoDAO();
        carregaRelatorio(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaTodosOsRelatorios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaRelatorioTotal = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAmigoQueMaisFezEmprestimos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TelaTodosOsRelatorios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Todos os relatorios ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)));

        TabelaRelatorioTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Ferramenta", "Situação", "Data de empréstimo", "Data de Entrega"
            }
        ));
        TabelaRelatorioTotal.setRowHeight(35);
        TabelaRelatorioTotal.setShowGrid(true);
        jScrollPane1.setViewportView(TabelaRelatorioTotal);

        jLabel1.setText("O amigo que fez mais empréstimos foi:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmigoQueMaisFezEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAmigoQueMaisFezEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout TelaTodosOsRelatoriosLayout = new javax.swing.GroupLayout(TelaTodosOsRelatorios);
        TelaTodosOsRelatorios.setLayout(TelaTodosOsRelatoriosLayout);
        TelaTodosOsRelatoriosLayout.setHorizontalGroup(
            TelaTodosOsRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addGroup(TelaTodosOsRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        TelaTodosOsRelatoriosLayout.setVerticalGroup(
            TelaTodosOsRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaTodosOsRelatoriosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaTodosOsRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TelaTodosOsRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTodosRelatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaRelatorioTotal;
    private javax.swing.JPanel TelaTodosOsRelatorios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAmigoQueMaisFezEmprestimos;
    // End of variables declaration//GEN-END:variables
    public void carregaRelatorio(int idAmigo) {
        String amigoQueMaisEmpresta = "";
        int contagemMaisAlta = 0;
        limparTabela();
        DefaultTableModel modelo = new DefaultTableModel();
        this.TabelaRelatorioTotal.setModel(modelo);
        TabelaRelatorioTotal = this.TabelaRelatorioTotal;
        modelo.addColumn("Nome Amigo");
        modelo.addColumn("Ferramenta");
        modelo.addColumn("Marca Ferramenta");
        modelo.addColumn("Situação");
        modelo.addColumn("Data do Emprestimo");
        modelo.addColumn("Data de Entrega Prevista");

        CentralizarRenderer centralizarRenderer = new CentralizarRenderer();
        TabelaRelatorioTotal.getColumnModel().getColumn(0).setCellRenderer(centralizarRenderer);
        TabelaRelatorioTotal.getColumnModel().getColumn(1).setCellRenderer(centralizarRenderer);
        TabelaRelatorioTotal.getColumnModel().getColumn(2).setCellRenderer(centralizarRenderer);
        TabelaRelatorioTotal.getColumnModel().getColumn(3).setCellRenderer(centralizarRenderer);
        TabelaRelatorioTotal.getColumnModel().getColumn(4).setCellRenderer(centralizarRenderer);
        TabelaRelatorioTotal.getColumnModel().getColumn(5).setCellRenderer(centralizarRenderer);

        ArrayList<HistoricoPersonalizado> minhalista = new ArrayList<>();
        minhalista.clear();
        try {
            minhalista = objetohistorico.getMinhaListaPersonalizada(idAmigo);
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorioFerramentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        LocalDate dataAtual = LocalDate.now();
        Date dataAtualDate = Date.from(dataAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Map<String, Integer> contagemAmigos = new HashMap<>();
        for (HistoricoPersonalizado h : minhalista) {
            if (h.getDataEntregaEfetiva() == null) {
                if (dataAtualDate.after(h.getDataEntregaPrevista())) {
                    String status = "<span style='color: red;'>ATRASADO</span>";
                    modelo.addRow(new Object[]{
                        h.getNomeAmigo(),
                        h.getNomeFerramenta(),
                        h.getMarcaFerramenta(),
                        "<html>" + status + "</html>",
                        h.getDataEmprestimo(),
                        h.getDataEntregaPrevista()
                    });
                } else {
                    String status = "<span style='color: green;'>DENTRO DO PRAZO</span>";
                    modelo.addRow(new Object[]{
                        h.getNomeAmigo(),
                        h.getNomeFerramenta(),
                        h.getMarcaFerramenta(),
                        "<html>" + status + "</html>",
                        h.getDataEmprestimo(),
                        h.getDataEntregaPrevista()
                    });

                }
            } else {
                if (dataAtualDate.after(h.getDataEntregaPrevista())) {
                    String status = "<span style='color: red;'>FINALIZADO<br>-ATRASADO-</span>";
                    modelo.addRow(new Object[]{
                        h.getNomeAmigo(),
                        h.getNomeFerramenta(),
                        h.getMarcaFerramenta(),
                        "<html>" + status + "</html>",
                        h.getDataEmprestimo(),
                        h.getDataEntregaPrevista()
                    });
                } else {
                    String status = "<span style='color: green;'>FINALIZADO<br>------OK------</span>";
                    modelo.addRow(new Object[]{
                        h.getNomeAmigo(),
                        h.getNomeFerramenta(),
                        h.getMarcaFerramenta(),
                        "<html>" + status + "</html>",
                        h.getDataEmprestimo(),
                        h.getDataEntregaPrevista()
                    });

                }
            }
            if (contagemAmigos.containsKey(h.getNomeAmigo())) {

                int contagem = contagemAmigos.get(h.getNomeAmigo());
                contagemAmigos.put(h.getNomeAmigo(), contagem + 1);
            } else {

                contagemAmigos.put(h.getNomeAmigo(), 1);
            }

        }
        for (Map.Entry<String, Integer> entry : contagemAmigos.entrySet()) {
            String amigo = entry.getKey();
            int contagem = entry.getValue();

            if (contagem > contagemMaisAlta) {
                amigoQueMaisEmpresta = amigo;
                contagemMaisAlta = contagem;
            }
        }
        txtAmigoQueMaisFezEmprestimos.setText(amigoQueMaisEmpresta);
        txtAmigoQueMaisFezEmprestimos.setEditable(false);

    }

    public class CentralizarRenderer extends DefaultTableCellRenderer {

        public CentralizarRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }

    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) TabelaRelatorioTotal.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
