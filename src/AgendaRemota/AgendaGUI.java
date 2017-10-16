package AgendaRemota;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigo
 */
public class AgendaGUI extends javax.swing.JFrame {

    private CompromissoGUI dialogCompromisso;
    private DefaultTableModel modelAgenda;

    public AgendaGUI() {
        initComponents();
        dialogCompromisso = new CompromissoGUI(this, true);
        modelAgenda = (DefaultTableModel) tableAgenda.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCompromissos = new javax.swing.JPanel();
        buttonAdicionar = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        buttonListar = new javax.swing.JButton();
        buttonRemover = new javax.swing.JButton();
        panelSistema = new javax.swing.JPanel();
        buttonLogin = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        textFieldUsuario = new javax.swing.JTextField();
        panelAgenda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAgenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Remota");

        panelCompromissos.setBorder(javax.swing.BorderFactory.createTitledBorder(" Compromissos "));
        panelCompromissos.setName("panelCompromissos"); // NOI18N

        buttonAdicionar.setText("Adicionar");
        buttonAdicionar.setName("buttonAdicionar"); // NOI18N
        buttonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        buttonAlterar.setText("Alterar");
        buttonAlterar.setName("buttonAlterar"); // NOI18N
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        buttonListar.setText("Listar");
        buttonListar.setName("buttonListar"); // NOI18N
        buttonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarActionPerformed(evt);
            }
        });

        buttonRemover.setText("Remover");
        buttonRemover.setName("buttonRemover"); // NOI18N
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCompromissosLayout = new javax.swing.GroupLayout(panelCompromissos);
        panelCompromissos.setLayout(panelCompromissosLayout);
        panelCompromissosLayout.setHorizontalGroup(
            panelCompromissosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompromissosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompromissosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonAdicionar)
                    .addComponent(buttonAlterar)
                    .addComponent(buttonRemover)
                    .addComponent(buttonListar))
                .addContainerGap())
        );

        panelCompromissosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAdicionar, buttonAlterar, buttonListar, buttonRemover});

        panelCompromissosLayout.setVerticalGroup(
            panelCompromissosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompromissosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonListar)
                .addContainerGap())
        );

        panelSistema.setBorder(javax.swing.BorderFactory.createTitledBorder(" Sistema "));
        panelSistema.setName("panelSistema"); // NOI18N

        buttonLogin.setText("Login");
        buttonLogin.setName("buttonLogin"); // NOI18N
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonLogout.setText("Logout");
        buttonLogout.setName("buttonLogout"); // NOI18N
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSistemaLayout = new javax.swing.GroupLayout(panelSistema);
        panelSistema.setLayout(panelSistemaLayout);
        panelSistemaLayout.setHorizontalGroup(
            panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSistemaLayout.setVerticalGroup(
            panelSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelUsuario.setText("Usuário: ");
        labelUsuario.setName("labelUsuario"); // NOI18N

        textFieldUsuario.setEditable(false);
        textFieldUsuario.setText("Turma de SD");
        textFieldUsuario.setName("textFieldUsuario"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuario)
                .addGap(4, 4, 4)
                .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelAgenda.setBorder(javax.swing.BorderFactory.createTitledBorder(" Agenda "));
        panelAgenda.setName("panelAgenda"); // NOI18N

        tableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"17/05/2010", "20:50:00", "Prova SD", "Prova de sistemas distribuídos sobre comunicação entre processos", "SIM"}
            },
            new String [] {
                "Data", "Hora", "Assunto", "Descrição", "Notificação"
            }
        ));
        tableAgenda.setName("tableAgenda"); // NOI18N
        jScrollPane1.setViewportView(tableAgenda);
        if (tableAgenda.getColumnModel().getColumnCount() > 0) {
            tableAgenda.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableAgenda.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableAgenda.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableAgenda.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        javax.swing.GroupLayout panelAgendaLayout = new javax.swing.GroupLayout(panelAgenda);
        panelAgenda.setLayout(panelAgendaLayout);
        panelAgendaLayout.setHorizontalGroup(
            panelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAgendaLayout.setVerticalGroup(
            panelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgendaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCompromissos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelCompromissos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelAgenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed
        // TODO add your handling code here:
        dialogCompromisso.setVisible(true);

        // se a ação executa da dialog CompromissoGUI foi "Adicionar"
        if (dialogCompromisso.getActionExecuted() == CompromissoGUI.ActionType.ADD) {
            String[] dados = dialogCompromisso.obtemDados();
            modelAgenda.addRow(dados);
            
            // [TODO] Adicionar remotamente 
        } //if
    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        // Pega os valores de uma linha selecionada
        int linha = tableAgenda.getSelectedRow();
        if (linha >= 0) {
            String data = (String) modelAgenda.getValueAt(linha, 0);
            String hora = (String) modelAgenda.getValueAt(linha, 1);
            String assunto = (String) modelAgenda.getValueAt(linha, 2);
            String descricao = (String) modelAgenda.getValueAt(linha, 3);
            String notificacao = (String) modelAgenda.getValueAt(linha, 4);
            
            // [TODO] Atualizar remotamente
        }
        
        
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
        // Remove a linha selecionada
        int linha = tableAgenda.getSelectedRow();
        if (linha >= 0) {
            // pega os campos chaves
            String data = (String) modelAgenda.getValueAt(linha, 0);
            String hora = (String) modelAgenda.getValueAt(linha, 1);

            // remove da GUI
            modelAgenda.removeRow(linha);
      
            // [TODO] Remover remotamente
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarActionPerformed
        // Lista os compromissos de uma data
        String data = JOptionPane.showInputDialog("Listar compromissos em: ", "digite a data");
        
        // [TODO] Buscar os compromissos remotamente
    }//GEN-LAST:event_buttonListarActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // [TODO] Obter a referência remota
        // [TODO] Recuperar todos os compromissos já cadastrados
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // [TODO] Bloquear a referência remota e limpar a JTable
    }//GEN-LAST:event_buttonLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonListar;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelAgenda;
    private javax.swing.JPanel panelCompromissos;
    private javax.swing.JPanel panelSistema;
    private javax.swing.JTable tableAgenda;
    private javax.swing.JTextField textFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
