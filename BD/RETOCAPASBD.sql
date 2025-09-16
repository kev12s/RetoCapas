CREATE DATABASE RETOCAPAS;

USE RETOCAPAS;

CREATE TABLE USUARIO
(NOMBRE_USUARIO VARCHAR (30) NOT NULL PRIMARY KEY,
CONTRASEÑA VARCHAR(50),
EDAD INT,
DNI CHAR(9) UNIQUE,
EMAIL VARCHAR (50)
);

INSERT INTO USUARIO (NOMBRE_USUARIO, CONTRASEÑA, EDAD, DNI, EMAIL) VALUES
('juanperez', 'miClaveSegura123', 28, '12345678A', 'juan.perez@email.com'),
('mariagarcia', 'Maria2024!', 32, '87654321B', 'maria.garcia@empresa.com'),
('carloslopez', 'Carlos*789', 24, '11223344C', 'carlos.l@universidad.edu'),
('anarodriguez', 'AnaPass!2024', 45, '55667788D', 'ana.rodriguez@correo.com'),
('pedromartinez', 'P3dr0_Mart1nez', 19, '99887766E', 'pedro.m@estudiante.edu'),
('laurafernandez', 'LauritaF2024!', 37, '44332211F', 'laura.fernandez@trabajo.com'),
('miguelangel', 'Miguel123$', 29, '66778899G', 'miguel.angel@personal.com'),
('sofiatorres', 'SofiaT0rr3s!', 22, '22334455H', 'sofia.t@universidad.edu'),
('davidgomez', 'DavidG0mez*', 41, '77889900I', 'david.gomez@empresa.com'),
('elenasanchez', 'ElenaS2024!', 26, '33445566J', 'elena.sanchez@correo.com');