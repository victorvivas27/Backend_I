CREATE TABLE MEDICAMENTOS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CODIGO INT NOT NULL,
    NOMBRE VARCHAR(255) NOT NULL,
    LABORATORIO VARCHAR(255) NOT NULL,
    CANTIDAD INT NOT NULL,
    PRECIO NUMERIC(10, 2) NOT NULL
);