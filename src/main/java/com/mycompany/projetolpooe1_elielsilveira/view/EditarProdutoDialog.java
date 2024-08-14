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

public class EditarProdutoDialog extends JDialog {

    private JTextField nomeField;
    private JTextField precoField;
    private JButton salvarButton;
    private JButton cancelarButton;
    private int produtoId; // ID do produto a ser editado

    public EditarProdutoDialog(JDialog parent, int produtoId) {
        super(parent, "Editar Produto", true);
        this.produtoId = produtoId;
        initComponents();
        loadProduto();
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

    private void loadProduto() {
        try {
            PersistenciaJPA persistencia = new PersistenciaJPA();
            Produto produto = persistencia.entity.find(Produto.class, produtoId);
            if (produto != null) {
                nomeField.setText(produto.getNome());
                precoField.setText(String.valueOf(produto.getPreco()));
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void salvarProduto() {
        String nome = nomeField.getText();
        String precoStr = precoField.getText();

        try {
            PersistenciaJPA persistencia = new PersistenciaJPA();
            Produto produto = persistencia.entity.find(Produto.class, produtoId);
            if (produto != null) {
                produto.setNome(nome);
                produto.setPreco(Double.parseDouble(precoStr));

                persistencia.entity.getTransaction().begin();
                persistencia.entity.merge(produto);
                persistencia.entity.getTransaction().commit();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

