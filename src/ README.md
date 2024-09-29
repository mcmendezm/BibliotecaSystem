# BibliotecaSystem

## Descripción

**BibliotecaSystem** es un sistema de gestión de una biblioteca que permite gestionar libros y usuarios. Con este proyecto, puedes agregar, actualizar, eliminar y listar libros y usuarios registrados en la base de datos. Este proyecto está desarrollado en Java utilizando JDBC para conectarse a una base de datos MySQL.

## Características

- Gestión de libros: agregar, actualizar, eliminar y listar libros.
- Gestión de usuarios: agregar, actualizar, eliminar y listar usuarios.
- Manejo de préstamos (pendiente de implementación o ajuste).
- Conexión con MySQL mediante JDBC.

## Tecnologías utilizadas

- **Java**: Lenguaje principal.
- **MySQL**: Base de datos relacional para almacenar la información de libros y usuarios.
- **JDBC**: Para la conexión y manejo de la base de datos.
- **IntelliJ IDEA**: IDE usado para el desarrollo.

## Estructura del Proyecto

El proyecto se organiza en paquetes:

Paso 2: Configuración de la base de datos
Asegúrate de tener MySQL instalado y en ejecución.
Crea una base de datos llamada biblioteca o el nombre que prefieras.
Ejecuta el archivo SQL proporcionado (schema.sql) para crear las tablas necesarias en la base de datos:


## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java JDK** (versión 8 o superior)
- **MySQL Server**
- **MySQL Connector/J** (para la conexión entre Java y MySQL)
- **IntelliJ IDEA** (opcional)

## Instalación y ejecución

### Paso 1: Clonar el repositorio

```bash
git clone https://github.com/tu_usuario/BibliotecaSystem.git
cd BibliotecaSystem
```
### Paso 2: Configuración de la base de datos
- **Asegúrate de tener MySQL instalado y en ejecución.**
- **Crea una base de datos llamada biblioteca o el nombre que prefieras.**
- **Ejecuta el archivo SQL proporcionado (schema.sql) para crear las tablas necesarias en la base de datos:**

```bash
CREATE DATABASE IF NOT EXISTS biblioteca;

USE biblioteca;

CREATE TABLE IF NOT EXISTS Personas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  tipo ENUM('admin', 'usuario')
);

CREATE TABLE IF NOT EXISTS Libros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(100),
  autor VARCHAR(100),
  isbn VARCHAR(20),
  disponible BOOLEAN
);

CREATE TABLE IF NOT EXISTS Prestamos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  libro_id INT,
  usuario_id INT,
  fecha_prestamo DATE,
  fecha_devolucion DATE,
  FOREIGN KEY (libro_id) REFERENCES Libros(id),
  FOREIGN KEY (usuario_id) REFERENCES Personas(id)
);
```
### Paso 3: Configuración del entorno
1. Abre el proyecto en IntelliJ IDEA.
2. Añade el conector de MySQL (mysql-connector-java) a tu proyecto (puedes descargarlo y agregarlo manualmente o gestionarlo mediante Maven/Gradle).
3. Configura el SDK de Java en tu IDE.
### Paso 4: Ejecutar el proyecto
1. Compila y ejecuta el archivo Main.java desde tu entorno de desarrollo.
2. El programa debería conectarse a la base de datos MySQL y permitir la gestión de libros y usuarios.
### Paso 5: Opcional - Comandos Git
Si ya iniciaste el repositorio local, realiza los siguientes comandos para asegurarte de subir correctamente el proyecto a GitHub:
```bash
git add .
git commit -m "Initial commit"
git push origin main
```
## Esquema de Base de Datos
Adjunta el archivo schema.sql para la creación de las tablas de la base de datos.

