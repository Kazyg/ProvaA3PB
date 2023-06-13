package View;

import DAO.AmigoDAO;
import DAO.EmprestimoDAO;
import DAO.FerramentaDAO;
import DAO.HistoricoDAO;
import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TelaRegistrarEmprestimo extends javax.swing.JFrame {

    private final AmigoDAO objetoamigo;
    private final FerramentaDAO objetoferramenta;
    private final EmprestimoDAO objetoemprestimo;
    private final HistoricoDAO objetohistorico;
    private String marcaFerramenta;

    public TelaRegistrarEmprestimo() {
        initComponents();
        this.objetoamigo = new AmigoDAO();
        this.objetoferramenta = new FerramentaDAO();
        this.objetoemprestimo = new EmprestimoDAO();
        this.objetohistorico = new HistoricoDAO();
        limparCampos();
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarResultadoPesquisa();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizarResultadoPesquisa();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizarResultadoPesquisa();
            }

            private void atualizarResultadoPesquisa() {
                String nomeAmigo = txtNomeAmigoEmprestimo.getText();
                String emailAmigo = txtEmailAmigoEmprestimo.getText();
                String searchTerm = txtfildEmprestimoFerramenta.getText();

                List<Amigo> amigosEncontrados = filtrarAmigos(nomeAmigo, emailAmigo);
                exibirResultadosAmigos(amigosEncontrados);

                List<Ferramenta> ferramentasEncontradas = filtrarFerramenta(searchTerm);
                exibirResultadosFerramentas(ferramentasEncontradas);
            }
        };
        txtNomeAmigoEmprestimo.getDocument().addDocumentListener(documentListener);
        txtEmailAmigoEmprestimo.getDocument().addDocumentListener(documentListener);
        txtfildEmprestimoFerramenta.getDocument().addDocumentListener(documentListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TelaRegistroDeEmprestimo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DataDeDevolução = new javax.swing.JLabel();
        txtfildEmprestimoFerramenta = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        btnRegisterVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNomeAmigoEmprestimo = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEmailAmigoEmprestimo = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TelaRegistroDeEmprestimo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros de Empréstimos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TelaRegistroDeEmprestimo.setToolTipText("");

        jLabel1.setText("Insira os dados para empréstimo");

        jLabel2.setText("Nome do amigo:");

        jLabel3.setText("Ferramenta:");

        DataDeDevolução.setText("Data de devolução:");

        txtfildEmprestimoFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfildEmprestimoFerramentaActionPerformed(evt);
            }
        });

        btnRegistro.setText("Registrar");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnRegisterVoltar.setText("Voltar");
        btnRegisterVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterVoltarActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de Empréstimo:");

        txtNomeAmigoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAmigoEmprestimoActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Email do amigo:");

        txtEmailAmigoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailAmigoEmprestimoActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout TelaRegistroDeEmprestimoLayout = new javax.swing.GroupLayout(TelaRegistroDeEmprestimo);
        TelaRegistroDeEmprestimo.setLayout(TelaRegistroDeEmprestimoLayout);
        TelaRegistroDeEmprestimoLayout.setHorizontalGroup(
            TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2)
                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnRegistro)
                                .addComponent(DataDeDevolução))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeAmigoEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(txtEmailAmigoEmprestimo))
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                        .addComponent(txtfildEmprestimoFerramenta, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(btnRegisterVoltar)))
                                .addGap(18, 18, 18)
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        TelaRegistroDeEmprestimoLayout.setVerticalGroup(
            TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeAmigoEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailAmigoEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfildEmprestimoFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DataDeDevolução)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegisterVoltar)
                            .addComponent(btnRegistro)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TelaRegistroDeEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TelaRegistroDeEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeAmigoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAmigoEmprestimoActionPerformed

    }//GEN-LAST:event_txtNomeAmigoEmprestimoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Object selectedValue = jComboBox1.getSelectedItem();
        if (selectedValue != null) {
            String selectedString = selectedValue.toString();
            String[] parts = selectedString.split("-");
            if (parts.length == 2) {
                String nome = parts[0].trim();
                String email = parts[1].trim();
                txtNomeAmigoEmprestimo.setText(nome);
                txtEmailAmigoEmprestimo.setText(email);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtEmailAmigoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailAmigoEmprestimoActionPerformed

    }//GEN-LAST:event_txtEmailAmigoEmprestimoActionPerformed

    private void btnRegisterVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnRegisterVoltarActionPerformed

    private void txtfildEmprestimoFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfildEmprestimoFerramentaActionPerformed

    }//GEN-LAST:event_txtfildEmprestimoFerramentaActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Object selectedValue = jComboBox2.getSelectedItem();
        if (selectedValue != null) {
            String selectedString = selectedValue.toString();
            String[] parts = selectedString.split("-");
            if (parts.length == 2) {
                String nome = parts[0].trim();
                marcaFerramenta = parts[1].trim();
                txtfildEmprestimoFerramenta.setText(nome);
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        try {
            String nomeAmigo = txtNomeAmigoEmprestimo.getText(),
                    emailAmigo = txtEmailAmigoEmprestimo.getText(),
                    nomeFerramenta = txtfildEmprestimoFerramenta.getText(),
                    dataEmprestimo = jFormattedTextField1.getText(),
                    dataDevolucao = jFormattedTextField2.getText();
            Date dataEmprestimoConvertida = null,
                    dataDevolucaoConvertida = null;
            Integer idAmigo,
                    idFerramenta;
            int idEmprestimo = 0,
                    idEmprestimoCadastrado,
                    idHistorico = 0;
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            if (!dataEmprestimo.trim().isEmpty() || !dataDevolucao.trim().isEmpty()) {
                LocalDate dataEmprestimoParaConverter = LocalDate.parse(dataEmprestimo, formatoEntrada);
                LocalDate dataDevolucaoParaConverter = LocalDate.parse(dataDevolucao, formatoEntrada);
                if (isValidDate(dataEmprestimoParaConverter) && isValidDate(dataDevolucaoParaConverter)) {
                    dataEmprestimoConvertida = java.sql.Date.valueOf(dataEmprestimoParaConverter);
                    dataDevolucaoConvertida = java.sql.Date.valueOf(dataDevolucaoParaConverter);
                }
            } else {
                throw new MensagensException("Insira uma data valida");
            }
            idEmprestimoCadastrado = this.objetoemprestimo.InsertEmprestimoBD(idEmprestimo, dataEmprestimoConvertida, dataDevolucaoConvertida);

            idAmigo = encontrarAmigo(nomeAmigo, emailAmigo).getId();
            if (marcaFerramenta == null) {
                throw new MensagensException("Selecione uma ferramenta na lista");
            }
            idFerramenta = encontrarFerramenta(nomeFerramenta, marcaFerramenta).getId();

            Amigo amigoHistorico = this.objetoamigo.carregaAmigo(idAmigo);
            Ferramenta ferramentaHistorico = this.objetoferramenta.carregaFerramenta(idFerramenta);
            Emprestimo emprestimoHistorico = this.objetoemprestimo.carregaEmprestimo(idEmprestimoCadastrado);

            this.objetohistorico.InsertHistoricoBD(idHistorico, amigoHistorico, ferramentaHistorico, emprestimoHistorico, null);
            JOptionPane.showMessageDialog(rootPane, "Emprestimo feito com sucesso");
            limparCampos();

        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }


    }//GEN-LAST:event_btnRegistroActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistrarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataDeDevolução;
    private javax.swing.JPanel TelaRegistroDeEmprestimo;
    private javax.swing.JButton btnRegisterVoltar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEmailAmigoEmprestimo;
    private javax.swing.JTextField txtNomeAmigoEmprestimo;
    private javax.swing.JTextField txtfildEmprestimoFerramenta;
    // End of variables declaration//GEN-END:variables

    private List<Amigo> filtrarAmigos(String nomeAmigo, String emailAmigo) {
        List<Amigo> amigosConvertidos = new ArrayList<>();

        List<Amigo> amigosEncontrados = null;
        try {
            amigosEncontrados = objetoamigo.getMinhaLista();
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Amigo amigo : amigosEncontrados) {
            if (!nomeAmigo.isEmpty() && emailAmigo.isEmpty()) {
                if (amigo.getNome().toLowerCase().contains(nomeAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
            if (!emailAmigo.isEmpty() && nomeAmigo.isEmpty()) {
                if (amigo.getEmail().toLowerCase().contains(emailAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
            if (!emailAmigo.isEmpty() && !nomeAmigo.isEmpty()) {
                if (amigo.getNome().toLowerCase().contains(nomeAmigo.toLowerCase()) && amigo.getEmail().toLowerCase().contains(emailAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
            if(emailAmigo.isEmpty() && nomeAmigo.isEmpty()){
                if (amigo.getNome().toLowerCase().contains(nomeAmigo.toLowerCase()) || amigo.getEmail().toLowerCase().contains(emailAmigo.toLowerCase())){
                    amigosConvertidos.add(amigo);
                }
            }
        }
        return amigosConvertidos;
    }

    private void exibirResultadosAmigos(List<Amigo> amigosEncontrados) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Amigo amigo : amigosEncontrados) {
            String amigoTexto = amigo.getNome() + " - " + amigo.getEmail();
            comboBoxModel.addElement(amigoTexto);
        }

        jComboBox1.setModel(comboBoxModel);
    }

    private List<Ferramenta> filtrarFerramenta(String searchTerm) {
        List<Ferramenta> ferramentaConvertidas = new ArrayList<>();

        List<Ferramenta> ferramentaEncontrados = null;
        try {
            ferramentaEncontrados = objetoferramenta.getMinhaLista();
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Ferramenta ferramenta : ferramentaEncontrados) {
            if (ferramenta.getNome().toLowerCase().contains(searchTerm.toLowerCase()) || ferramenta.getMarca().toLowerCase().contains(searchTerm.toLowerCase())) {
                ferramentaConvertidas.add(ferramenta);
            }
        }
        return ferramentaConvertidas;
    }

    private void exibirResultadosFerramentas(List<Ferramenta> ferramentaEncontrada) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Ferramenta ferramenta : ferramentaEncontrada) {
            String ferramentaTexto = ferramenta.getNome() + " - " + ferramenta.getMarca();
            comboBoxModel.addElement(ferramentaTexto);
        }

        jComboBox2.setModel(comboBoxModel);
    }

    private static boolean isValidDate(LocalDate date) {
        LocalDate dataAtual = LocalDate.now();

        if (date.isBefore(dataAtual)) {
            return false;
        }

        int dia = date.getDayOfMonth();
        int mes = date.getMonthValue();
        int ano = date.getYear();

        if (mes > 12 || dia > 31) {
            return false;
        }

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
                return false;
            }
        } else if (mes == 2) {
            if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                if (dia > 29) {
                    return false;
                }
            } else {
                if (dia > 28) {
                    return false;
                }
            }
        }

        return true;
    }

    private Amigo encontrarAmigo(String nomeAmigo, String emailAmigo) throws MensagensException {
        Amigo amigoConvertido = new Amigo();

        List<Amigo> amigosEncontrados = null;
        try {
            amigosEncontrados = objetoamigo.getMinhaLista();
        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }

        for (Amigo amigo : amigosEncontrados) {
            if (amigo.getNome().toLowerCase().equals(nomeAmigo.toLowerCase()) && amigo.getEmail().toLowerCase().equals(emailAmigo.toLowerCase())) {
                amigoConvertido = amigo;
            }
        }
        if (amigoConvertido.getNome() == null || amigoConvertido.getNome().isEmpty()) {
            limparCampos();
            throw new MensagensException("Selecione um amigo existente");
        }

        return amigoConvertido;
    }

    private Ferramenta encontrarFerramenta(String nomeFerramenta, String marcaFerramenta) throws MensagensException {
        Ferramenta ferramentaConvertida = new Ferramenta();

        List<Ferramenta> ferramentaEncontrada = null;
        try {
            ferramentaEncontrada = objetoferramenta.getMinhaLista();
        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }

        for (Ferramenta ferramenta : ferramentaEncontrada) {
            if (ferramenta.getNome().toLowerCase().equals(nomeFerramenta.toLowerCase()) && ferramenta.getMarca().toLowerCase().equals(marcaFerramenta.toLowerCase())) {
                ferramentaConvertida = ferramenta;
            }
        }
        if (ferramentaConvertida.getNome() == null || ferramentaConvertida.getNome().isEmpty()) {
            limparCampos();
            throw new MensagensException("Selecione uma ferramenta existente");
        }
        return ferramentaConvertida;
    }

    private void limparCampos() {
        this.txtNomeAmigoEmprestimo.setText("");
        this.txtEmailAmigoEmprestimo.setText("");
        this.txtfildEmprestimoFerramenta.setText("");
        this.jFormattedTextField1.setText("");
        this.jFormattedTextField2.setText("");
        List<Ferramenta> ferramentaEncontrada = filtrarFerramenta("");
        exibirResultadosFerramentas(ferramentaEncontrada);
        List<Amigo> amigosEncontrados = filtrarAmigos("", "");
        exibirResultadosAmigos(amigosEncontrados);
    }

}
