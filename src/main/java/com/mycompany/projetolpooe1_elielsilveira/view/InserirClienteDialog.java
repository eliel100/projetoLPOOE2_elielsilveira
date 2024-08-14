/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolpooe1_elielsilveira.view;

import com.mycompany.projetolpooe1_elielsilveira.model.Cliente;
import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserirClienteDialog extends JDialog {

    private JTextField nomeField;
    private JTextField emailField;
    private JButton salvarButton;
    private JButton cancelarButton;

    public InserirClienteDialog(JDialog parent) {
        super(parent, "Inserir Novo Cliente", true);
        initComponents();
    }

    private void initComponents() {
        nomeField = new JTextField(20);
        emailField = new JTextField(20);
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        JLabel nomeLabel = new JLabel("Nome:");
        JLabel emailLabel = new JLabel("Email:");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCliente();
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
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(salvarButton);
        panel.add(cancelarButton);

        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null); // Centraliza o diálogo na tela
    }

    private void salvarCliente() {
        String nome = nomeField.getText();
        String email = emailField.getText();

        try {
            PersistenciaJPA persistencia = new PersistenciaJPA();
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setEmail(email);

            persistencia.entity.getTransaction().begin();
            persistencia.entity.persist(cliente);
            persistencia.entity.getTransaction().commit();
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
