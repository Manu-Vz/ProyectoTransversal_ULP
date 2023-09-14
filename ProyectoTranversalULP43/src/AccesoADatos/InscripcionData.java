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
           //ps.setInt(1, insc.getAlumno().getIdAlumno());
           //ps.setArray(2, insc.getMateria().getIdMateria());
           ps.setInt(1, );
           ps.setDouble(3, insc.getNota());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           if(rs.next()){
               
               insc.setIdInscripcion(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "inscripcion registrada");
           }
           ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
   }
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
}