/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import proyectotranversalulp.Entidades.Alumno;

/**
 *
 * @author abate
 */
public class AlumnoData {
    private Connection con=null;

    public AlumnoData() {
        con=Conectar.getConectar();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql="insert into alumno (nombre,apellido,dni,fechaNacimiento,estado) "
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getDni());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agrego el alumno");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos " + ex.getMessage());
        }
    }
    
    public Alumno buscarAlumno(int id){
        Alumno alumno = null;
        String sql = "select * from alumno where idAlumno= ? and estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                alumno=new Alumno();
                alumno.setIdAlumno(id);
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno por id " + ex.getMessage());
        }
                
        return alumno;
        
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        Alumno alumno = null;
        String sql ="SELECT * FROM alumno WHERE dni=? AND estado = 1";
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return alumno;
        
    }
    
    public List<Alumno> listarAlumnos(){
        
        return null;
        
    }
    
    public void modificarAlumno(Alumno alumno){
        
    }
    
    public void eliminarAlumno(int id){
        
    }
}
