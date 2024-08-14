    
package com.mycompany.projetolpooe1_elielsilveira.model.dao;


import com.mycompany.projetolpooe1_elielsilveira.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author eliel
 */
public class PersistenciaJPA implements InterfacePersistencia{

    public EntityManagerFactory factory;
    public EntityManager entity;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_ProjetoLPOOE2_elielsilveira");
        entity = factory.createEntityManager();
    }
    
    
    
    
    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    
    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }
    
    
      public List<Cliente> listarTodosClientes() {
        TypedQuery<Cliente> query = entity.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }
   
    
}
