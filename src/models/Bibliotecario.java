package models;

public class Bibliotecario extends Persona {
    public Bibliotecario(int id, String nombre, String apellido) {
        super(id, nombre, apellido, "Bibliotecario");
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "ID: " + getId() +
                ", Nombre: " + getNombre() +
                ", Apellido: " + getApellido() +
                '}';
    }
}
