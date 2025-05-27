package co.edu.uniquindio.prohospi.Model;

public  class Sala {
    private final javafx.beans.property.SimpleStringProperty id;
    private final javafx.beans.property.SimpleStringProperty tipo;
    private final javafx.beans.property.SimpleIntegerProperty capacidad;

    public Sala(String id, String tipo, int capacidad) {
        this.id = new javafx.beans.property.SimpleStringProperty(id);
        this.tipo = new javafx.beans.property.SimpleStringProperty(tipo);
        this.capacidad = new javafx.beans.property.SimpleIntegerProperty(capacidad);
    }

    public javafx.beans.property.StringProperty idProperty() {
        return id;
    }

    public javafx.beans.property.StringProperty tipoProperty() {
        return tipo;
    }

    public javafx.beans.property.IntegerProperty capacidadProperty() {
        return capacidad;
    }
}

