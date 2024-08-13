
package ProjetoLPOOE1_elielsilveira.test;


import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author eliel
 */
public class TestPersistenciaJPA {
    
    @Test
    public void testConexaoJPA(){
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            System.out.println("conectou no BD via jpa ...");
            jpa.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");
                        
        }
    }
    
   
     
    }

