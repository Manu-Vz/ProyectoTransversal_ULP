package AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public Materia buscarMateria(int id){
        Materia materia = null;
        String sql = "select * from materia where idMateria = ? and estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(true);            
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materia por id " + ex.getMessage());
        }
                
        return materia;
    }
    
    public void modificarMateria (Materia materia){
        String sql = "UPDATE materia SET nombre = ?, anio = ?, estado = ? WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Se modifico Correctamente");
            }
                      
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar materia" + ex.getMessage());
        } 
    }
    
    public void eliminarMateria (int id){
        String sql = "Update materia Set estado = 0 Where idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, id);
            
            int fila = ps.executeUpdate();
            
            if (fila == 1){
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar materia");
        }
    }
    
    public List<Materia> listarMatera (){
        List<Materia> materias = new ArrayList<>();
        
        String sql = "Select * from materia Where estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Base de Datos");
        }
        
        return materias;
    }
}
