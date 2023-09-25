/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import org.mariadb.jdbc.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectotranversalulp.Entidades.Usuario;
/**
 *
 * @author kalema
 */
public class AcV {
    
    private Connection miCon=null;
    public static Usuario us=new Usuario();
    
    public AcV(){
        miCon=Conectar.getConectar();
    }

    public boolean validarAcceso(String user,char [] clave){
        String sql="select * from usuario";
        String pass=Encry.encriptar(clave);
        System.out.println("muestro la clave "+ pass);
        boolean valido=false;
        try {
            Statement ps=miCon.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            while(rs.next()){
                if(user.equals(rs.getString("userAc")) && pass.equals(rs.getString("clave"))){
                    us.setIdNivel(rs.getInt("idNivel"));
                    us.setUser(rs.getString("userAc"));
                    us.setNombre(rs.getString("nombre"));
                    valido=true;
                    break;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos "+e.getMessage());
        }
        
        return valido;
    }

    
}
