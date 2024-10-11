CREATE TABLE  remedios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    quantidade INT,
    validade VARCHAR(100) ,
    laboratorio VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2),
    PRIMARY KEY(id)

);