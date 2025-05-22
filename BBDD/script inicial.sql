DROP DATABASE IF EXISTS ProyectoFinal;
CREATE DATABASE ProyectoFinal;
USE ProyectoFinal;

CREATE TABLE Continentes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20), -- not null
    superficie INT,
    clima VARCHAR(50),
    num_paises INT -- not null
);

CREATE TABLE Pais (
	id_continente VARCHAR(20), -- 
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),--
    poblacion  INT,
    idioma_oficial VARCHAR(50),
    FOREIGN KEY (continente) REFERENCES Continentes (nombre)
);

CREATE TABLE Curiosidades (
	id_pais INT,--
    id INT AUTO_INCREMENT PRIMARY KEY,
    gastronomia VARCHAR(50),--
    curi_historica VARCHAR(255),--
    dia_nac VARCHAR(50),
    FOREIGN KEY (nombre_pais) REFERENCES Pais (nombre)
);



