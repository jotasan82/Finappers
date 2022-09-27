# Consultar BD
show databases;

# Crear base de datos
create DATABASE finappers;

# Conectar a base de datos
USE finappers;

# Crear tabla
CREATE TABLE usuario(
	correo VARCHAR(45) NOT NULL PRIMARY KEY,
    contrasena VARCHAR(10) NOT NULL,
    nombreUsuario VARCHAR(60) NOT NULL,
    apellidoUsuario VARCHAR(60) NOT NULL
);

CREATE TABLE categoria(
	idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreCategoria VARCHAR(45) NOT NULL
);

CREATE TABLE producto(
	idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreProducto VARCHAR(45) NOT NULL,
    descripcionProducto VARCHAR(45),
    usuario_correo VARCHAR(45) FOREING KEY
);

# Mostrar tablas
SHOW TABLES;
DESCRIBE mascotas;