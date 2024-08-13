
package com.mycompany.projetolpooe1_elielsilveira.model;

/**
 *
 * @author telmo
 */
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
        // Getters e Setters

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @ManyToMany
    @JoinTable(name = "tb_pedido_produto",
               joinColumns = @JoinColumn(name = "pedido_id"),
               inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

}