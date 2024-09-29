import services.LibraryService;
import services.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Establecer conexión a la base de datos
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "nodo");
            System.out.println("Conexión establecida.");

            // Crear instancias de servicios
            LibraryService libraryService = new LibraryService(connection);
            UserService userService = new UserService(connection);

            // Pruebas con libros
            // Agregar libros
            libraryService.agregarLibro("Crimen y Castigo", "Fiódor Dostoyevski", "978-3-16-148410-7", true);
            libraryService.agregarLibro("El Gran Gatsby", "F. Scott Fitzgerald", "978-3-16-148410-8", true);

            // Mostrar todos los libros
            System.out.println("\nLista de libros:");
            libraryService.mostrarLibros();

            // Actualizar un libro
            libraryService.actualizarLibro(1, "Cien Años de Soledad (Edición Especial volumen 5)", "Gabriel García Márquez", "978-3-16-148410-0", true);

            // Mostrar lista de libros actualizado
            System.out.println("\nLista de libros después de la actualización:");
            libraryService.mostrarLibros();

            // Eliminar un libro con ID
            libraryService.eliminarLibro(19);

            // Mostrar lista de libros después de la eliminación
            System.out.println("\nLista de libros después de la eliminación:");
            libraryService.mostrarLibros();

            // Pruebas con usuarios
            // Registrar usuarios (ajusta la llamada eliminando el email)
            userService.registrarUsuario("Julian", "Caicedo", "password789");
            userService.registrarUsuario("Tiberio", "Ospina", "password012");

            // Mostrar todos los usuarios
            System.out.println("\nLista de usuarios:");
            userService.mostrarUsuarios();

            // Actualizar un usuario (suponiendo que el ID del usuario a actualizar es 1)
            userService.actualizarUsuario(1, "Juan", "Pérez Actualizado 2");

            // Mostrar lista de usuarios después de la actualización
            System.out.println("\nLista de usuarios después de la actualización:");
            userService.mostrarUsuarios();

            // Eliminar un usuario con ID
             userService.eliminarUsuario(5);

            // Mostrar lista de usuarios después de la eliminación
            System.out.println("\nLista de usuarios después de la eliminación:");
            userService.mostrarUsuarios();

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}