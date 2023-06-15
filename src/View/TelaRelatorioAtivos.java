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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaRelatorioAtivos extends javax.swing.JFrame {

    private final HistoricoDAO objetohistorico;

    public TelaRelatorioAtivos() {
        initComponents();
        this.objetohistorico = new HistoricoDAO();
        carregaRelatorio(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TelaEmprestimosAtivos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRelatorioAtivos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TelaEmprestimosAtivos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empréstimos ativos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TableRelatorioAtivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome Amigo", "Nome Ferramenta", "Marca Ferramenta", "Situação", "Data de Empréstimo", "Data de Entrega Prevista"
            }
        ));
        TableRelatorioAtivos.setName("Relatório de empréstimos ativos"); // NOI18N
        TableRelatorioAtivos.setRowHeight(30);
        TableRelatorioAtivos.setShowGrid(true);
        jScrollPane1.setViewportView(TableRelatorioAtivos);
        TableRelatorioAtivos.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout TelaEmprestimosAtivosLayout = new javax.swing.GroupLayout(TelaEmprestimosAtivos);
        TelaEmprestimosAtivos.setLayout(TelaEmprestimosAtivosLayout);
        TelaEmprestimosAtivosLayout.setHorizontalGroup(
            TelaEmprestimosAtivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaEmprestimosAtivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addContainerGap())
        );
        TelaEmprestimosAtivosLayout.setVerticalGroup(
            TelaEmprestimosAtivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaEmprestimosAtivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaEmprestimosAtivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaEmprestimosAtivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioAtivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableRelatorioAtivos;
    private javax.swing.JPanel TelaEmprestimosAtivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public void carregaRelatorio(int idAmigo) {
        limparTabela();
        DefaultTableModel modelo = new DefaultTableModel();
        this.TableRelatorioAtivos.setModel(modelo);
        TableRelatorioAtivos = this.TableRelatorioAtivos;
        modelo.addColumn("Nome Amigo");
        modelo.addColumn("Ferramenta");
        modelo.addColumn("Marca Ferramenta");
        modelo.addColumn("Situação");
        modelo.addColumn("Data do Emprestimo");
        modelo.addColumn("Data de Entrega Prevista");

        CentralizarRenderer centralizarRenderer = new CentralizarRenderer();
        TableRelatorioAtivos.getColumnModel().getColumn(0).setCellRenderer(centralizarRenderer);
        TableRelatorioAtivos.getColumnModel().getColumn(1).setCellRenderer(centralizarRenderer);
        TableRelatorioAtivos.getColumnModel().getColumn(2).setCellRenderer(centralizarRenderer);
        TableRelatorioAtivos.getColumnModel().getColumn(3).setCellRenderer(centralizarRenderer);
        TableRelatorioAtivos.getColumnModel().getColumn(4).setCellRenderer(centralizarRenderer);
        TableRelatorioAtivos.getColumnModel().getColumn(5).setCellRenderer(centralizarRenderer);

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
        for (HistoricoPersonalizado h : minhalista) {
            if (h.getDataEntregaEfetiva() == null) {
                if (dataAtualDate.after(h.getDataEntregaPrevista())) {
                    TableRelatorioAtivos.getColumnModel().getColumn(3).setCellRenderer(new CustomCellRenderer());
                    modelo.addRow(new Object[]{
                        h.getNomeAmigo(),
                        h.getNomeFerramenta(),
                        h.getMarcaFerramenta(),
                        "ATRASADO",
                        h.getDataEmprestimo(),
                        h.getDataEntregaPrevista()
                    });
                } else {
                    TableRelatorioAtivos.getColumnModel().getColumn(3).setCellRenderer(new CustomCellRenderer());
                    modelo.addRow(new Object[]{
                        h.getNomeAmigo(),
                        h.getNomeFerramenta(),
                        h.getMarcaFerramenta(),
                        "DENTRO DO PRAZO",
                        h.getDataEmprestimo(),
                        h.getDataEntregaPrevista()
                    });

                }
            }
        }
    }

    public class CentralizarRenderer extends DefaultTableCellRenderer {

        public CentralizarRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }

    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) TableRelatorioAtivos.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public class CustomCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Verifica se o valor da célula é "ATRASADO" e configura a cor do texto como vermelho
            if ("ATRASADO".equals(value)) {
                component.setForeground(Color.RED);
            } else if ("DENTRO DO PRAZO".equals(value)) {
                component.setForeground(Color.GREEN);
            }else {
                // Caso contrário, retorna à cor padrão da célula
                component.setForeground(table.getForeground());
            }

            return component;
        }
    }
}
