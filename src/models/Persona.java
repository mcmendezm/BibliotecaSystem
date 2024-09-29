package models;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String tipo;

    public Persona(int id, String nombre, String apellido, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID: " + id +
                ", Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Tipo: " + tipo +
                '}';
    }
}
