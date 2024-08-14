package com.mycompany.projetolpooe1_elielsilveira.view;

import com.mycompany.projetolpooe1_elielsilveira.model.Cliente;
import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarClienteDialog extends JDialog {

    private JTextField nomeField;
    private JTextField emailField;
    private JButton salvarButton;
    private JButton cancelarButton;
    private Cliente cliente;

    public EditarClienteDialog(JDialog parent, Cliente cliente) {
        super(parent, "Editar Cliente", true);
        this.cliente = cliente;
        initComponents();
    }

    private void initComponents() {
        nomeField = new JTextField(cliente.getNome(), 20);
        emailField = new JTextField(cliente.getEmail(), 20);
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
            cliente.setNome(nome);
            cliente.setEmail(email);

            persistencia.entity.getTransaction().begin();
            persistencia.entity.merge(cliente); // Usa merge para atualizar o cliente existente
            persistencia.entity.getTransaction().commit();
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

