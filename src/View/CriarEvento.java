package View;

import Model.Amigo;
import static Utils.GoogleCalendarIntegration.criarEvento;
import static Utils.Utils.filtrarAmigos;
import static Utils.Utils.isValidDate;
import com.google.api.client.util.DateTime;
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


public class CriarEvento extends javax.swing.JFrame {
    
    private List<String> listaEmailsJList;
    private DefaultListModel<String> model;
    
    public CriarEvento() throws SQLException {
        initComponents();
        this.listaEmailsJList = new ArrayList<>();
        this.model = new DefaultListModel<>();
        try {
            limparCampos();
        } catch (MensagensException ex) {
            Logger.getLogger(CriarEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                String nomeAmigo = txtNomeAmigoEvento.getText();
                String emailAmigo = txtEmailAmigoEvento.getText();
                

                List<Amigo> amigosEncontrados;
                try {
                    amigosEncontrados = filtrarAmigos(nomeAmigo, emailAmigo);
                    exibirResultadosAmigos(amigosEncontrados);
                } catch (MensagensException ex) {
                    Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }

               

            }
        };
        txtNomeAmigoEvento.getDocument().addDocumentListener(documentListener);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCriarEvento = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAmigosConvidar = new javax.swing.JList<>();
        comboBoxAmigos = new javax.swing.JComboBox<>();
        txtNomeAmigoEvento = new javax.swing.JTextField();
        txtTituloEvento = new javax.swing.JTextField();
        txtDataEvento = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLimparLista = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEmailAmigoEvento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCriarEvento.setText("Criar Evento");
        btnCriarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarEventoActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaAmigosConvidar);

        comboBoxAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAmigosActionPerformed(evt);
            }
        });

        txtTituloEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloEventoActionPerformed(evt);
            }
        });

        try {
            txtDataEvento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Amigo:");

        jLabel2.setText("Titulo do Evento:");

        jLabel3.setText("Data do Evento:");

        jLabel4.setText("Lista de amigos para convidar");

        btnLimparLista.setText("Limpar Lista");
        btnLimparLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparListaActionPerformed(evt);
            }
        });

        jLabel5.setText("EVENTOS");

        jLabel6.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnCriarEvento))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel1)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmailAmigoEvento)
                            .addComponent(txtNomeAmigoEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtDataEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtTituloEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(comboBoxAmigos, 0, 171, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimparLista)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(232, 232, 232))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeAmigoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailAmigoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTituloEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimparLista)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarEvento)
                    .addComponent(btnVoltar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloEventoActionPerformed
        
    }//GEN-LAST:event_txtTituloEventoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void comboBoxAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAmigosActionPerformed
        Object selectedValue = comboBoxAmigos.getSelectedItem();
        if (selectedValue != null) {
            String selectedString = selectedValue.toString();
            String[] parts = selectedString.split("-");
            String email = parts[1].trim();
            model.clear();
            listaEmailsJList.add(email);
            for (String item : listaEmailsJList) {
                model.addElement(item);
            }
            listaAmigosConvidar.setModel(model);
        }
        txtEmailAmigoEvento.setText("");
        txtNomeAmigoEvento.setText("");
    }//GEN-LAST:event_comboBoxAmigosActionPerformed

    private void btnLimparListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparListaActionPerformed
        limparJlist();
    }//GEN-LAST:event_btnLimparListaActionPerformed

    private void btnCriarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarEventoActionPerformed
        
        String dataEvento = txtDataEvento.getText();
        Date dataEventoConvertida = null;
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try {
        if (!dataEvento.trim().isEmpty()) {
                LocalDate dataEventoParaConverter = LocalDate.parse(dataEvento, formatoEntrada);
                if (isValidDate(dataEventoParaConverter)) {
                    dataEventoConvertida = java.sql.Date.valueOf(dataEventoParaConverter);
                } else {
                    throw new MensagensException("Insira uma data valida");
                }
            } else {
                throw new MensagensException("Insira uma data valida");
            }
        DateTime dataEventoCriar = new DateTime(dataEventoConvertida);
        criarEvento(listaEmailsJList, dataEventoCriar, txtTituloEvento.getText());
        JOptionPane.showMessageDialog(rootPane, "Evento criado com sucesso");
        limparCampos();
        } catch (MensagensException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(CriarEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCriarEventoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarEvento;
    private javax.swing.JButton btnLimparLista;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboBoxAmigos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaAmigosConvidar;
    private javax.swing.JFormattedTextField txtDataEvento;
    private javax.swing.JTextField txtEmailAmigoEvento;
    private javax.swing.JTextField txtNomeAmigoEvento;
    private javax.swing.JTextField txtTituloEvento;
    // End of variables declaration//GEN-END:variables
    private void exibirResultadosAmigos(List<Amigo> amigosEncontrados) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Amigo amigo : amigosEncontrados) {
            String amigoTexto = amigo.getNome() + " - " + amigo.getEmail();
            comboBoxModel.addElement(amigoTexto);
        }

        comboBoxAmigos.setModel(comboBoxModel);
    }
    
    private void limparJlist() {
        this.listaEmailsJList.clear();
        model.clear();
        this.listaAmigosConvidar.setModel(model);
    }
    
    private void limparCampos() throws SQLException, MensagensException {
        this.txtNomeAmigoEvento.setText("");
        this.txtEmailAmigoEvento.setText("");
        this.txtTituloEvento.setText("");
        this.txtDataEvento.setText("");
        limparJlist();
        List<Amigo> amigosEncontrados = null;
        try {
            amigosEncontrados = filtrarAmigos("", "");
        } catch (MensagensException ex) {
            Logger.getLogger(TelaRegistrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        exibirResultadosAmigos(amigosEncontrados);
    }
}
