package co.edu.uniquindio.prohospi.Model;

public class Sala {
    private String codigo;
    private String descripcion;

    public Sala(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    /**
     * metodo que retorna codigo
     * @return
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * metodo que retorna descripcion
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }
}
