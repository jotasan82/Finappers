# Consultar BD
show databases;

# Crear base de datos
create DATABASE finappers;

# Conectar a base de datos
USE finappers;

# Crear tabla
CREATE TABLE mascotas(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(80) NOT NULL,
    tipo_mascota VARCHAR(30) NOT NULL, 
    raza VARCHAR(15) NOT NULL,
    edad INT NOT NULL,
    observacion TEXT NOT NULL
);

# Mostrar tablas
SHOW TABLES;
DESCRIBE mascotas;