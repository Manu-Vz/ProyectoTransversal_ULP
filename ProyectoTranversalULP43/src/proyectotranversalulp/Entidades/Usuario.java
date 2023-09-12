/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotranversalulp.Entidades;

/**
 *
 * @author kalema
 */
public class Usuario {
    private int idUsuario;
    private int idNivel;
    private String user;
    private String clave;
    private String nombre;

    public Usuario() {
    }

    public Usuario(int idNivel, String user, String clave, String nombre) {
        this.idNivel = idNivel;
        this.user = user;
        this.clave = clave;
        this.nombre = nombre;
    }

    public Usuario(int idUsuario, int idNivel, String user, String clave, String nombre) {
        this.idUsuario = idUsuario;
        this.idNivel = idNivel;
        this.user = user;
        this.clave = clave;
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", idNivel=" + idNivel + ", user=" + user + ", clave=" + clave + ", nombre=" + nombre + '}';
    }
    
    
}
