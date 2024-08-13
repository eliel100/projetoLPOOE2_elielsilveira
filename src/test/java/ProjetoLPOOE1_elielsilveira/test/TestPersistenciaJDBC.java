
package ProjetoLPOOE1_elielsilveira.test;


import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJDBC;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author telmo
 */
public class TestPersistenciaJDBC {
    
    
    //@Test
    public void testPersistenciaProcedimento() throws Exception {
        
       
    }
    
    @Test
    public void testPersistenciaConexao() throws Exception {
        
        //criar um objeto do tipo PersistenciaJDBC.
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if(jdbc.conexaoAberta()){
            System.out.println("conectou no BD via jdbc ...");
            jdbc.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");
                        
        }
        
    }
   
}
