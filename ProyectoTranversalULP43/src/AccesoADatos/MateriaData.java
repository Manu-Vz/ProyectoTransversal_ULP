package AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import proyectotranversalulp.Entidades.Materia;

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
    
    public void guardarMateria(Materia materia){
        String sql = "insert into materia (nombre, anio, estado) "
                + "values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia Guardada Correctamente");
                
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos " + ex.getMessage());
        }
        
        
    }
}
