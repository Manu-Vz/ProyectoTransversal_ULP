/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import proyectotranversalulp.Entidades.Alumno;
import proyectotranversalulp.Entidades.Inscripcion;
import proyectotranversalulp.Entidades.Materia;

/**
 *
 * @author pcdlc
 */
public class InscripcionData {
    private Connection con=null;
    
    private MateriaData matData = new MateriaData();
    private AlumnoData aluData = new AlumnoData();
   
    
    public InscripcionData(){
        con=Conectar.getConectar();
        
        
    }
    
     public void guardarInscripcion(Inscripcion insc){
       String sql="INSERT INTO inscripcion(idAlumno,idMateria, nota) VALUES(?,?,?)";
   
       try {
           
           PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, insc.getAlumno().getIdAlumno());
           ps.setInt(2, insc.getMateria().getIdMateria());
           ps.setDouble(3, insc.getNota());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           if(rs.next()){
               
              insc.setIdInscripto(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "inscripcion registrada");
           }
           ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
   }
   }   
     
     public List<Inscripcion> optenerInscripcionPorAlumno(int id){
         ArrayList<Inscripcion> cursada = new ArrayList<>();
         
         String sql = "SELECT * FROM inscripcion WHERE alumno = ? ";
         
         Inscripcion insc = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                insc = new Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripto"));
                Alumno alu =  aluData.buscarAlumno(rs.getInt("alumno"));
                Materia mat = matData.buscarMateria(rs.getInt("materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursada.add(insc); 
                
            }
            ps.close();
        } 
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
         return cursada;
     } 
     
    public List<Materia> OptenerMateriasCursadas(int id){
        
        List<Materia> mat = new ArrayList<Materia>();
      
        
        try {
            
            String sql = "SELECT inscripcion.materia, nombre, anio FROM inscripcion,"
                + "materia WHERE inscripcion.materia = materia.idMateria\n "
                + "AND inscripcion.alumno = ? ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Materia materia;
                
            while (rs.next()){ 
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                mat.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones " + ex.getMessage());
        }
        return mat;
} 
    public List<Materia> OptenerMateriasNoCursadas(int id){
        
        ArrayList<Materia> materias = new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE  estado = 1 AND idMateria NOT IN (SELECT materia FROM inscripcion"
                + "WHERE alumno = ?)";
        
        try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Materia materia;
                
            while (rs.next()){ 
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones " + ex.getMessage());
        }
      
        return materias;
        
    }
    
    public void borrarInscripcionMateriaAlumno (int idAlumno, int idMateria){
        
        try {
            String sql = "DELETE FROM inscripcion WHERE alumno = ?  AND materia = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if( filas > 0){
                JOptionPane.showMessageDialog(null, "Se borro la Inscripcion ");
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla " + ex.getMessage());
             
        }
        
      
        
    }
    
    
    
    
    
    
}