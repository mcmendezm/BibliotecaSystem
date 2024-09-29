package models;

public class Usuario extends Persona {
    private int prestamos;
    private String email;
    private String contraseña;

    // Constructor actualizado
    public Usuario(int id, String nombre, String apellido, int prestamos, String email, String contraseña) {
        super(id, nombre, apellido, "Usuario");
        this.prestamos = prestamos;
        this.email = email;
        this.contraseña = contraseña;
    }

    public int getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(int prestamos) {
        this.prestamos = prestamos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID: " + getId() +
                ", Nombre: " + getNombre() +
                ", Apellido: " + getApellido() +
                ", Préstamos: " + prestamos +
                ", Email: " + email +
                '}';
    }
}
