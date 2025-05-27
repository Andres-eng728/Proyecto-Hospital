package co.edu.uniquindio.prohospi.Model;

public class Horario {
    private String dia;
    private String hora;

    public Horario(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }
    /**
     * Metodo que retorna el dia 
     * @return
     */
    public String getDia() {
        return dia;
    }
    /**
     * Metodo que retorna la hora
     * @return
     */
    public String getHora() {
        return hora;
    }
    /**
     * Metodo para asignar dia 
     * @param dia
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
    /**
     * Metodo para asignar hora
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
}
