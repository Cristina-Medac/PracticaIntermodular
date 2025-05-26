DROP DATABASE IF EXISTS ProyectoFinal;
CREATE DATABASE ProyectoFinal;
USE ProyectoFinal;

CREATE TABLE Continentes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL, 
    superficie INT, -- en millones
    clima VARCHAR(50),
    num_paises INT NOT NULL,
    contador INT 
);

CREATE TABLE Paises (
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_continente INT NOT NULL, 
    nombre VARCHAR(50) NOT NULL UNIQUE,
    poblacion INT,
    idioma_oficial VARCHAR(50),
    FOREIGN KEY (id_continente) REFERENCES Continentes (id)
);

CREATE TABLE Curiosidades (
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_pais INT NOT NULL,
    gastronomia VARCHAR(50) NOT NULL,
    peculiaridad VARCHAR(255) NOT NULL,
    festividad VARCHAR(255) UNIQUE,
    FOREIGN KEY (id_pais) REFERENCES Paises (id)
);

-- TRIGGER
DELIMITER //
CREATE TRIGGER actualizarContador
AFTER INSERT ON Paises
FOR EACH ROW
	BEGIN
		UPDATE Continentes
		SET contador = contador+1
		WHERE id = NEW.id_continente;
	END
    //
  DELIMITER ;

INSERT INTO Continentes 
(nombre, superficie, clima, num_paises, contador)
VALUES
	('Africa',30,'Tropical', 54, 0),
    ('Europa',10,'Templado',44, 0),
    ('Asia',44,'Variado', 49, 0),
    ('America',42,'Templado', 35, 0),
    ('Oceania',8,'Templado', 14, 0);
    

INSERT INTO Paises
(id_continente, nombre, poblacion, idioma_oficial)
VALUES 
	(1, 'Nigeria', 227, 'ingles'),
    (1, 'Argelia', 45, 'bereber'),
    (1, 'Egipto', 111, 'arabe'),
    
    (2, 'Espania', 47, 'espaniol'),
    (2, 'Italia', 60, 'italiano'),
    (2, 'Francia', 68, 'frances'),
    
    (3, 'China', 1426, 'chino'),
    (3, 'Japon', 125, 'japones'),
    (3, 'Corea del Sur', 52, 'coreano'),
    
    (4, 'Argentina', 46, 'espaniol'),
    (4, 'Canada', 38, 'ingles, frances'),
    (4, 'Brasil', 213, 'portugues'),
    
    (5, 'Australia', 26, 'ingles'),
    (5, 'Nueva Zelanda', 5, 'ingles, maori'),
    (5, 'Papua Nueva Guinea', 10, 'ingles, tok pisin, hiri motu');
    

INSERT INTO Curiosidades 
(id_pais, gastronomia, peculiaridad, festividad)
VALUES
	(1,'Jollof rice','Mas de 500 lenguas y grupos etnicos', '1 de octubre - Dia de la independencia'),
    (2,'Cuscus','Gran parte del pais es el desierto de Sahara', '5 julio - Dia de la independencia'),
    (3,'Koshari','Hogar de las piramides de Giza', 'ramadan'),
    (4,'Gazpacho','Es el mayor productor de aceite de oliva del mundo, produciendo mas de la mitad de la produccion global', 'Semana Santa'),
    (5,'Pizza','Cuna del imperio romano y del renacimiento', '2 junio - Festa della Repubblica Italiana'),
    (6,'Croissant','La torre Eiffel es uno de los monumentos mas visitados del mundo, y crece en verano', '14 de julio - Dia de la Bastilla'),
    (7,'Pato laqueado','China es el mayor productor mundial del te, teniendo una ceremonia del te muy refinada.', 'Anio nuevo chino'),
    (8,'Sushi','Mezcla única de tradicion milenaria y tecnologia avanzada', '1 enero - Anio nuevo japones'),
    (9,'Kimchi','Uno de los paises mas digitalizados y con mayor velocidad de internet del mundo', 'Chuseok Fiesta de la cosecha'),
    (10,'Asado','Hogar del tango', '9 julio - Dia de la independencia'),
    (11,'Poutine','Existe una Ley de disculpas, que refleja una cultura de pedir perdon', '1 julio - Dia de Canada'),
    (12,'Feijoada','Contiene el Amazonas, la mayor selva del mundo', 'Carnaval'),
    (13,'Vegemite','Tiene especies unicas como canguros y koalas', '26 enero - Dia de Australia'),
    (14,'Hangi','Lugar de grabacion de El senior de los anillos', '6 febrero - Waitangi Day'),
    (15,'Mumu','Entre el 5% y 7% de las especies conocidas en el mundo viven en este pequenio pais', 'Hiri Moale Festival');
    
    
    select * from Continentes;
    select * from Paises;
    select * from Curiosidades;
    
    


