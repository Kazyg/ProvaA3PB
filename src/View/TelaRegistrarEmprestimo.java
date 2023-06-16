package View;

import DAO.AmigoDAO;
import DAO.EmprestimoDAO;
import DAO.FerramentaDAO;
import DAO.HistoricoDAO;
import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;
import Model.Historico;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static Utils.Utils.filtrarAmigos;
import static Utils.Utils.filtrarFerramenta;
import static Utils.Utils.isValidDate;

public class TelaRegistrarEmprestimo extends javax.swing.JFrame {

    private final AmigoDAO objetoamigo;
    private final FerramentaDAO objetoferramenta;
    private final EmprestimoDAO objetoemprestimo;
    private final HistoricoDAO objetohistorico;
    private String marcaFerramenta;
    private ArrayList<Ferramenta> listaFerramenta;
    private ArrayList<String> listaFerramentasJList;
    private DefaultListModel<String> model;

    public TelaRegistrarEmprestimo() throws SQLException, MensagensException {
        initComponents();
        this.objetoamigo = new AmigoDAO();
        this.objetoferramenta = new FerramentaDAO();
        this.objetoemprestimo = new EmprestimoDAO();
        this.objetohistorico = new HistoricoDAO();
        this.listaFerramenta = new ArrayList<>();
        this.listaFerramentasJList = new ArrayList<>();
        this.model = new DefaultListModel<>();
        limparCampos();
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
                String nomeAmigo = txtNomeAmigoEmprestimo.getText();
                String emailAmigo = txtEmailAmigoEmprestimo.getText();
                String searchTerm = txtfildEmprestimoFerramenta.getText();

                List<Amigo> amigosEncontrados;
                try {
                    amigosEncontrados = filtrarAmigos(nomeAmigo, emailAmigo);
                    exibirResultadosAmigos(amigosEncontrados);
                } catch (MensagensException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }

                List<Ferramenta> ferramentasEncontradas;
                try {
                    ferramentasEncontradas = filtrarFerramenta(searchTerm, "");
                    exibirResultadosFerramentas(ferramentasEncontradas);
                } catch (MensagensException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }

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
        dataEmprestimoEfetuado = new javax.swing.JFormattedTextField();
        dataDevolucaoPrevista = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
            dataEmprestimoEfetuado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataEmprestimoEfetuado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEmprestimoEfetuadoActionPerformed(evt);
            }
        });

        try {
            dataDevolucaoPrevista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jScrollPane1.setViewportView(jList1);

        jLabel6.setText("Lista de Ferramentas para serem emprestadas");

        jButton1.setText("Limpar Lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnRegistro)
                                        .addComponent(DataDeDevolução))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeAmigoEmprestimo)
                                    .addComponent(txtEmailAmigoEmprestimo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dataDevolucaoPrevista)
                                    .addComponent(dataEmprestimoEfetuado)
                                    .addComponent(txtfildEmprestimoFerramenta)
                                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                                        .addComponent(btnRegisterVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56))))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(87, 87, 87))
        );
        TelaRegistroDeEmprestimoLayout.setVerticalGroup(
            TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeAmigoEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailAmigoEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtfildEmprestimoFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dataEmprestimoEfetuado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DataDeDevolução)
                                    .addComponent(dataDevolucaoPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(TelaRegistroDeEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRegisterVoltar)
                                    .addComponent(btnRegistro)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TelaRegistroDeEmprestimoLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
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
            model.clear();
            listaFerramentasJList.add(selectedString);
            for (String item : listaFerramentasJList) {
                model.addElement(item);
            }
            jList1.setModel(model);
        }
        txtfildEmprestimoFerramenta.setText("");
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        try {
            String nomeAmigo = txtNomeAmigoEmprestimo.getText(),
                    emailAmigo = txtEmailAmigoEmprestimo.getText(),
                    nomeFerramenta,
                    dataEmprestimo = dataEmprestimoEfetuado.getText(),
                    dataDevolucao = dataDevolucaoPrevista.getText();
            Date dataEmprestimoConvertida = null,
                    dataDevolucaoConvertida = null;
            Integer idAmigo,
                    idFerramenta;
            int idEmprestimo = 0,
                    idHistorico = 0,
                    resposta = -2;

            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for (String item : listaFerramentasJList) {
                String[] parts = item.split("-");
                if (parts.length == 2) {
                    nomeFerramenta = parts[0].trim();
                    marcaFerramenta = parts[1].trim();
                    List<Ferramenta> ferramentaEncontrada = filtrarFerramenta(nomeFerramenta, marcaFerramenta);
                    if (ferramentaEncontrada.get(0).getNome() == null || ferramentaEncontrada.get(0).getNome().isEmpty()) {
                        limparCampos();
                        throw new MensagensException("Selecione uma ferramenta existente");
                    }
                    idFerramenta = ferramentaEncontrada.get(0).getId();
                    Ferramenta ferramentaDaLista = this.objetoferramenta.carregaFerramenta(idFerramenta);
                    boolean ferramentaExistente = false;
                    for (Ferramenta ferramenta : listaFerramenta) {
                        if (ferramenta.getId() == ferramentaDaLista.getId()) {
                            ferramentaExistente = true;
                            break; // Se a ferramenta já existe, interrompe o loop
                        }
                    }

                    if (!ferramentaExistente) {
                        listaFerramenta.add(ferramentaDaLista);
                    }

                }
            }

            if (!dataEmprestimo.trim().isEmpty() || !dataDevolucao.trim().isEmpty()) {
                LocalDate dataEmprestimoParaConverter = LocalDate.parse(dataEmprestimo, formatoEntrada);
                LocalDate dataDevolucaoParaConverter = LocalDate.parse(dataDevolucao, formatoEntrada);
                if (dataDevolucaoParaConverter.isBefore(dataEmprestimoParaConverter)) {
                    throw new MensagensException("Insira uma data valida");
                }
                if (isValidDate(dataEmprestimoParaConverter) && isValidDate(dataDevolucaoParaConverter)) {
                    dataEmprestimoConvertida = java.sql.Date.valueOf(dataEmprestimoParaConverter);
                    dataDevolucaoConvertida = java.sql.Date.valueOf(dataDevolucaoParaConverter);
                } else {
                    throw new MensagensException("Insira uma data valida");
                }
            } else {
                throw new MensagensException("Insira uma data valida");
            }

            List<Amigo> amigoEncontrado = filtrarAmigos(nomeAmigo, emailAmigo);
            if (amigoEncontrado == null) {
                limparCampos();
                throw new MensagensException("Selecione um amigo existente");
            }
            idAmigo = amigoEncontrado.get(0).getId();
            if (marcaFerramenta == null) {
                throw new MensagensException("Selecione uma ferramenta na lista");
            }
            List<Historico> historico = objetohistorico.getMinhaLista();
            for (Historico h : historico) {
                for (Ferramenta ferramentaHistorico : listaFerramenta) {
                    if (h.getFerramenta().getId() == ferramentaHistorico.getId() && h.getDataEfetivaDevolucao() == null) {
                        limparCampos();
                        throw new MensagensException("Não é possível emprestar uma ferramenta que está emprestada.");
                    }
                }
            }
            for (Historico h : historico) {
                if (h.getAmigo().getId() == amigoEncontrado.get(0).getId() && h.getDataEfetivaDevolucao() == null) {
                    resposta = JOptionPane.showConfirmDialog(rootPane, "O amigo selecionado ja tem um emprestimo ativo, deseja continuar?");
                    break;
                }
                if (h.getAmigo().getId() == amigoEncontrado.get(0).getId() && h.getDataEfetivaDevolucao() != null) {
                    Emprestimo idEmprestimoValida = objetoemprestimo.carregaEmprestimo(h.getEmprestimo().getId());
                    if (h.getDataEfetivaDevolucao().after(idEmprestimoValida.getDataPrevistaDevolucao())) {
                        resposta = JOptionPane.showConfirmDialog(rootPane, "O amigo selecionado ja entregou ferramentas com atraso, deseja continuar?");
                        break;
                    }
                }
            }
            switch (resposta) {
                case 0:
                    realizarEmprestimo(idEmprestimo, dataEmprestimoConvertida, dataDevolucaoConvertida, idAmigo, listaFerramenta, idHistorico);
                    break;
                case 1:
                    limparCampos();
                    break;
                case 2:
                    limparCampos();
                    break;
                case -1:
                    break;
                default:
                    realizarEmprestimo(idEmprestimo, dataEmprestimoConvertida, dataDevolucaoConvertida, idAmigo, listaFerramenta, idHistorico);
            }

        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }


    }//GEN-LAST:event_btnRegistroActionPerformed

    private void dataEmprestimoEfetuadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataEmprestimoEfetuadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataEmprestimoEfetuadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limparJlist();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                try {
                    new TelaRegistrarEmprestimo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MensagensException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataDeDevolução;
    private javax.swing.JPanel TelaRegistroDeEmprestimo;
    private javax.swing.JButton btnRegisterVoltar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JFormattedTextField dataDevolucaoPrevista;
    private javax.swing.JFormattedTextField dataEmprestimoEfetuado;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEmailAmigoEmprestimo;
    private javax.swing.JTextField txtNomeAmigoEmprestimo;
    private javax.swing.JTextField txtfildEmprestimoFerramenta;
    // End of variables declaration//GEN-END:variables

    private void exibirResultadosAmigos(List<Amigo> amigosEncontrados) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Amigo amigo : amigosEncontrados) {
            String amigoTexto = amigo.getNome() + " - " + amigo.getEmail();
            comboBoxModel.addElement(amigoTexto);
        }

        jComboBox1.setModel(comboBoxModel);
    }

    private void exibirResultadosFerramentas(List<Ferramenta> ferramentaEncontrada) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Ferramenta ferramenta : ferramentaEncontrada) {
            String ferramentaTexto = ferramenta.getNome() + " - " + ferramenta.getMarca();
            comboBoxModel.addElement(ferramentaTexto);
        }

        jComboBox2.setModel(comboBoxModel);
    }

    private void realizarEmprestimo(int idEmprestimo, Date dataEmprestimo, Date dataDevolucao, int idAmigo, List<Ferramenta> listaFerramenta, int idHistorico) {
        int idEmprestimoCadastrado;
        try {
            idEmprestimoCadastrado = this.objetoemprestimo.InsertEmprestimoBD(idEmprestimo, dataEmprestimo, dataDevolucao);
            Amigo amigoHistorico = this.objetoamigo.carregaAmigo(idAmigo);
            Emprestimo emprestimoHistorico = this.objetoemprestimo.carregaEmprestimo(idEmprestimoCadastrado);

            for (Ferramenta ferramentaHistorico : listaFerramenta) {
                this.objetohistorico.InsertHistoricoBD(idHistorico, amigoHistorico, ferramentaHistorico, emprestimoHistorico, null);
            }
            JOptionPane.showMessageDialog(rootPane, "Emprestimo feito com sucesso");
            limparCampos();
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparCampos() throws SQLException, MensagensException {
        this.txtNomeAmigoEmprestimo.setText("");
        this.txtEmailAmigoEmprestimo.setText("");
        this.txtfildEmprestimoFerramenta.setText("");
        this.dataEmprestimoEfetuado.setText("");
        this.dataDevolucaoPrevista.setText("");
        limparJlist();
        List<Ferramenta> ferramentaEncontrada = null;
        try {
            ferramentaEncontrada = filtrarFerramenta("", "");
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        exibirResultadosFerramentas(ferramentaEncontrada);
        List<Amigo> amigosEncontrados = null;
        try {
            amigosEncontrados = filtrarAmigos("", "");
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        exibirResultadosAmigos(amigosEncontrados);
    }

    private void limparJlist() {
        this.listaFerramentasJList.clear();
        this.listaFerramenta.clear();
        model.clear();
        this.jList1.setModel(model);
    }

}
