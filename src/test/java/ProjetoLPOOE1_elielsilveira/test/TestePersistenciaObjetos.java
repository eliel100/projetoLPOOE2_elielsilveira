/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ProjetoLPOOE1_elielsilveira.test;

import com.mycompany.projetolpooe1_elielsilveira.model.Cliente;
import com.mycompany.projetolpooe1_elielsilveira.model.Pedido;
import com.mycompany.projetolpooe1_elielsilveira.model.Produto;
import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author spiec
 */
public class TestePersistenciaObjetos {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistenciaObjetos() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void test() throws Exception {
        // Criação das Entidades
        Cliente c = new Cliente();
        c.setNome("Eliel");
        c.setEmail("sspsmcdnc@gmail.com");
        System.out.println("Cliente " + c.getNome() + "adicionado com sucesso!!!");

        Produto pr = new Produto();
        pr.setNome("xis");
        pr.setPreco(9.6);
        
        Produto pr2 = new Produto();
        pr2.setNome("dog");
        pr2.setPreco(8.4);
        
        Pedido pd = new Pedido();
        pd.setCliente(c);
        pd.setDataPedido(new Date());

        // Adicionar Produtos ao Pedido
        List<Produto> produtos = new ArrayList<>();
        produtos.add(pr);
        produtos.add(pr2);
        pd.setProdutos(produtos);
        
        
        // Persistência das Entidades 
        jpa.persist(c);     
        jpa.persist(pr);   
        jpa.persist(pr2);     
        jpa.persist(pd);
    }
}