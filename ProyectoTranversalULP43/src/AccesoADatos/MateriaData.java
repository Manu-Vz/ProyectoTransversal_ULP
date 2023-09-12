package AccesoADatos;

import org.mariadb.jdbc.Connection;

/**
 *
 * @author manuv
 */
public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conectar.getConectar();
    }
    
    //Metodos
    
}
