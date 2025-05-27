package co.edu.uniquindio.prohospi.Model;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    protected String nombre;
    protected String identificacion;
    protected String correo;
    private static final long serialVersionUID = 1L;

    public Persona(String nombre, String identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
    }
    public Persona() {
        // Constructor vacío requerido para deserialización
    }

    public String getNombre(){
        return nombre;
    }
    public String getIdentificacion() { return identificacion; }
    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}

