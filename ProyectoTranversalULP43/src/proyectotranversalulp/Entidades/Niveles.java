package proyectotranversalulp.Entidades;
/**
 *
 * @author Manuel Vasquez
 * 
 **/
public class Niveles {
    private int idNivel;
    private String nombre;
    private String descripcion;
    private boolean estado;
    
    public Niveles(){}
    
    public Niveles(int idNivel, String nombre, String descripcion, boolean estado){
        this.idNivel = idNivel;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdNivel() {
        return idNivel;
    }
    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
