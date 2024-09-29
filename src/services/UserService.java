package services;

import java.sql.*;

public class UserService {
    private Connection connection;

    public UserService(Connection connection) {
        this.connection = connection;
    }

    // Método para registrar un usuario
    public void registrarUsuario(String nombre, String apellido, String contraseña) {
        // SQL para insertar en Persona y obtener el ID generado
        String sqlPersona = "INSERT INTO Persona (nombre, apellido, tipo) VALUES (?, ?, 'Usuario')";
        try {
            // Insertar en la tabla Persona
            PreparedStatement stmtPersona = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            stmtPersona.setString(1, nombre);
            stmtPersona.setString(2, apellido);
            stmtPersona.executeUpdate();

            // Obtener el ID generado para insertar en Usuario
            ResultSet generatedKeys = stmtPersona.getGeneratedKeys();
            if (generatedKeys.next()) {
                int personaId = generatedKeys.getInt(1);

                // Insertar en la tabla Usuario con el ID de Persona
                String sqlUsuario = "INSERT INTO Usuario (id) VALUES (?)";
                PreparedStatement stmtUsuario = connection.prepareStatement(sqlUsuario);
                stmtUsuario.setInt(1, personaId);
                stmtUsuario.executeUpdate();
                stmtUsuario.close();
            }
            stmtPersona.close();

            System.out.println("Usuario registrado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para mostrar todos los usuarios
    public void mostrarUsuarios() {
        // SQL para hacer JOIN entre Persona y Usuario para mostrar los usuarios registrados
        String sql = "SELECT Persona.id, Persona.nombre, Persona.apellido FROM Persona " +
                "JOIN Usuario ON Persona.id = Usuario.id WHERE Persona.tipo = 'Usuario'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            // Mostrar resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                System.out.println("ID: " + id + ", Nombre: " + nombre + " " + apellido);
            }

            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(int id, String nombre, String apellido) {
        // SQL para actualizar la tabla Persona
        String sqlPersona = "UPDATE Persona SET nombre = ?, apellido = ? WHERE id = ? AND tipo = 'Usuario'";
        try {
            PreparedStatement stmtPersona = connection.prepareStatement(sqlPersona);
            stmtPersona.setString(1, nombre);
            stmtPersona.setString(2, apellido);
            stmtPersona.setInt(3, id);
            stmtPersona.executeUpdate();
            stmtPersona.close();

            System.out.println("Usuario actualizado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(int id) {
        // SQL para eliminar en Usuario y luego en Persona
        String sqlUsuario = "DELETE FROM Usuario WHERE id = ?";
        String sqlPersona = "DELETE FROM Persona WHERE id = ? AND tipo = 'Usuario'";
        try {
            // Eliminar en la tabla Usuario
            PreparedStatement stmtUsuario = connection.prepareStatement(sqlUsuario);
            stmtUsuario.setInt(1, id);
            stmtUsuario.executeUpdate();
            stmtUsuario.close();

            // Eliminar en la tabla Persona
            PreparedStatement stmtPersona = connection.prepareStatement(sqlPersona);
            stmtPersona.setInt(1, id);
            stmtPersona.executeUpdate();
            stmtPersona.close();

            System.out.println("Usuario eliminado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
