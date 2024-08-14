package com.mycompany.projetolpooe1_elielsilveira.view;

package com.mycompany.projetolpooe1_elielsilveira.view;

import com.mycompany.projetolpooe1_elielsilveira.model.Cliente;
import com.mycompany.projetolpooe1_elielsilveira.model.Pedido;
import com.mycompany.projetolpooe1_elielsilveira.model.Produto;
import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InserirPedidoDialog extends JDialog {

    private JComboBox<Cliente> clienteComboBox;
    private JComboBox<Produto> produtoComboBox;
    private JTextField dataField;
    private JButton salvarButton;
    private JButton cancelarButton;

    public InserirPedidoDialog(JDialog parent) {
        super(parent, "Inserir Novo Pedido", true);
        initComponents();
    }

    private void initComponents() {
        clienteComboBox = new JComboBox<>();
        produtoComboBox = new JComboBox<>();
        dataField = new JTextField(20);
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        JLabel clienteLabel = new JLabel("Cliente:");
        JLabel produtoLabel = new JLabel("Produto:");
        JLabel dataLabel = new JLabel("Data:");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPedido();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Configura o painel e o layout
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clienteLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteComboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(produtoLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(produtoComboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvarButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteLabel)
                    .addComponent(clienteComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(produtoLabel)
                    .addComponent(produtoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(dataField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null); // Centraliza o diálogo na tela

        carregarClientes();
        carregarProdutos();
    }

    private void carregarClientes() {
        try {
            PersistenciaJPA persistencia = new PersistenciaJPA();
            List<Cliente> clientes = persistencia.entity.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            clienteComboBox.setModel(new DefaultComboBoxModel<>(clientes.toArray(new Cliente[0])));
            System.out.println("Clientes carregados: " + clientes.size());
        } catch (Exception e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void carregarProdutos() {
        try {
            PersistenciaJPA persistencia = new PersistenciaJPA();
            List<Produto> produtos = persistencia.entity.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
            produtoComboBox.setModel(new DefaultComboBoxModel<>(produtos.toArray(new Produto[0])));
            System.out.println("Produtos carregados: " + produtos.size());
        } catch (Exception e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void salvarPedido() {
        Cliente cliente = (Cliente) clienteComboBox.getSelectedItem();
        Produto produto = (Produto) produtoComboBox.getSelectedItem();
        String dataString = dataField.getText();

        System.out.println("Cliente selecionado: " + cliente);
        System.out.println("Produto selecionado: " + produto);
        System.out.println("Data informada: " + dataString);

        if (cliente == null || produto == null || dataString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            System.out.println("Um ou mais campos estão vazios.");
            return;
        }

        try {
            // Converte a string para Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Ajuste o formato conforme necessário
            Date dataPedido = dateFormat.parse(dataString);
            System.out.println("Data do pedido convertida: " + dataPedido);

            PersistenciaJPA persistencia = new PersistenciaJPA();
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setDataPedido(dataPedido); // Define a data do pedido

            // Adiciona o produto ao pedido, se houver uma relação de muitos para muitos
            pedido.getPedidoProdutos().add(produto);

            persistencia.entity.getTransaction().begin();
            persistencia.entity.persist(pedido);
            persistencia.entity.getTransaction().commit();
            System.out.println("Pedido salvo com sucesso.");
            dispose();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro ao converter a data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao salvar o pedido: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
