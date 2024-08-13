
package com.mycompany.projetolpooe1_elielsilveira.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersistenciaJDBC implements InterfacePersistencia {
    
    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "postgre";
    public static final String URL = "jdbc:postgresql://localhost:5432/ProjetoLPOOE1_elielsilveira";
    private Connection con = null;

    public PersistenciaJDBC() throws Exception {
        Class.forName(DRIVER); // Carregamento do driver PostgreSQL
        System.out.println("Tentando estabelecer conexao JDBC com : " + URL + " ...");
        this.con = DriverManager.getConnection(URL, USER, SENHA);
    }

    public Boolean conexaoAberta() {
        try {
            if (con != null)
                return !con.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void fecharConexao() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Fechou conexao JDBC");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para remover um Produto pelo ID
    public void removerProduto(int produtoId) throws SQLException {
        String sql = "DELETE FROM tb_produto WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Número de produtos removidos: " + rowsAffected);
        }
    }

    // Método para remover um Cliente pelo ID
    public void removerCliente(int clienteId) throws SQLException {
        String sql = "DELETE FROM tb_cliente WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Número de clientes removidos: " + rowsAffected);
        }
    }

    // Método para remover um Pedido pelo ID
    public void removerPedido(int pedidoId) throws SQLException {
        String sql = "DELETE FROM tb_pedido WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Número de pedidos removidos: " + rowsAffected);
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

