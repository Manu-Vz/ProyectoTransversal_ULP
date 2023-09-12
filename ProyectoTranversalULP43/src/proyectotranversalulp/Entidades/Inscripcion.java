/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotranversalulp.Entidades;

/**
 *
 * @author Tomas
 */
public class Inscripcion {
    private int idInscripto;
    private int alumno;
    private int materia;
    private int nota;
    private boolean estado;

    public Inscripcion() {
    }

    public Inscripcion(int alumno, int materia, int nota, boolean estado) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.estado = estado;
    }

    public Inscripcion(int idInscripto, int alumno, int materia, int nota, boolean estado) {
        this.idInscripto = idInscripto;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.estado = estado;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + ", estado=" + estado + '}';
    }
    
    
}
