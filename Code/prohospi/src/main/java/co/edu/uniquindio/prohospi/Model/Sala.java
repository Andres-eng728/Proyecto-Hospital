package co.edu.uniquindio.prohospi.Model;

public class Sala {
    private String codigo;
    private String descripcion;

    public Sala(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}