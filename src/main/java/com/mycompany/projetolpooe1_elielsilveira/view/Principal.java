/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe1_elielsilveira.view;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author spiec
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
            setSize(800, 600); // Largura de 800 pixels e altura de 600 pixels
            
                setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabel_boasvindas = new javax.swing.JLabel();
        gerenciador_pedido = new javax.swing.JButton();
        gerenciador_cliente = new javax.swing.JButton();
        gereciador_produto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jlabel_boasvindas.setText("Bem vindo ao sistema de gerenciamento da Lanchonete!!!");
        jlabel_boasvindas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jlabel_boasvindas);

        gerenciador_pedido.setText("Gerenciar_pedidos");
        gerenciador_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciador_pedidoActionPerformed(evt);
            }
        });
        getContentPane().add(gerenciador_pedido);

        gerenciador_cliente.setText("gerenciar_cliente");
        gerenciador_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciador_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(gerenciador_cliente);

        gereciador_produto.setText("gerenciar_produtos");
        gereciador_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gereciador_produtoActionPerformed(evt);
            }
        });
        getContentPane().add(gereciador_produto);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void gerenciador_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciador_pedidoActionPerformed
       g_pedidos dialogPedidos = new g_pedidos(this, true); // Instancia o JDialog g_clientes
       
         // Obter o tamanho da tela
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // Definir o tamanho do JDialog para preencher a tela
    dialogPedidos.setSize(screenSize.width, screenSize.height);
    
    // Definir a localização para centralizar
    dialogPedidos.setLocationRelativeTo(null); // Centraliza na tela
       
       dialogPedidos.setVisible(true);
    }//GEN-LAST:event_gerenciador_pedidoActionPerformed

    private void gereciador_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gereciador_produtoActionPerformed
        g_produtos dialogProdutos = new g_produtos(this, true); // Instancia o JDialog g_produtos
          // Obter o tamanho da tela
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // Definir o tamanho do JDialog para preencher a tela
    dialogProdutos.setSize(screenSize.width, screenSize.height);
    
    // Definir a localização para centralizar
    dialogProdutos.setLocationRelativeTo(null); // Centraliza na tela
        
        dialogProdutos.setVisible(true); // Exibe o JDialog
    }//GEN-LAST:event_gereciador_produtoActionPerformed

    private void gerenciador_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciador_clienteActionPerformed
          g_clientes dialogClientes = new g_clientes(this, true); // Instancia o JDialog g_clientes
          // Obter o tamanho da tela
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // Definir o tamanho do JDialog para preencher a tela
    dialogClientes.setSize(screenSize.width, screenSize.height);
    
    // Definir a localização para centralizar
    dialogClientes.setLocationRelativeTo(null); // Centraliza na tela
        dialogClientes.setVisible(true); // Exibe o JDialog
    }//GEN-LAST:event_gerenciador_clienteActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gereciador_produto;
    private javax.swing.JButton gerenciador_cliente;
    private javax.swing.JButton gerenciador_pedido;
    private javax.swing.JLabel jlabel_boasvindas;
    // End of variables declaration//GEN-END:variables
}
