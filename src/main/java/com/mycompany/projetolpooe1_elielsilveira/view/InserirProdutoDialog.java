/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolpooe1_elielsilveira.view;

import com.mycompany.projetolpooe1_elielsilveira.model.Produto;
import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserirProdutoDialog extends JDialog {

    private JTextField nomeField;
    private JTextField precoField;
    private JButton salvarButton;
    private JButton cancelarButton;

    public InserirProdutoDialog(JDialog parent) {
        super(parent, "Inserir Novo Produto", true);
        initComponents();
    }

    private void initComponents() {
        nomeField = new JTextField(20);
        precoField = new JTextField(20);
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        JLabel nomeLabel = new JLabel("Nome:");
        JLabel precoLabel = new JLabel("Preço:");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(precoLabel);
        panel.add(precoField);
        panel.add(salvarButton);
        panel.add(cancelarButton);

        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null); // Centraliza o diálogo na tela
    }

    private void salvarProduto() {
        String nome = nomeField.getText();
        String precoText = precoField.getText();
        double preco = 0.0;

        // Valida o preço
        try {
            preco = Double.parseDouble(precoText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            PersistenciaJPA persistencia = new PersistenciaJPA();
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setPreco(preco);

            persistencia.entity.getTransaction().begin();
            persistencia.entity.persist(produto);
            persistencia.entity.getTransaction().commit();
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
