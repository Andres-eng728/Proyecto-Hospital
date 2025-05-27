package co.edu.uniquindio.prohospi.Model;

public abstract class Persona {
    protected String nombre;
    protected String identificacion;
    protected String correo;

    public Persona(String nombre, String identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
    }
    /**
     * metodo que retorna nombre
     * @return
     */
    public String getNombre() { return nombre; }
     /**
     * metodo que retorna identificacion
     * @return
     */
    public String getIdentificacion() { return identificacion; }
        /**
     * metodo que retorna correo
     * @return
     */
    public String getCorreo() { return correo; }
    /**
     * metodo que asigna el correo
     * @param correo
     */
    public void setCorreo(String correo) { this.correo = correo; }
    /**
     * metodo que asigna el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * metodo para asignar identificacion
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}

