CREATE DATABASE testJPA;

USE testJPA;

CREATE TABLE region(
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE city(
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    region_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(region_id) REFERENCES region(id)
);

CREATE TABLE client(
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    city_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(city_id) REFERENCES city(id)
);

INSERT INTO region VALUES
(NULL, '1º Región'),(NULL, '2º Región'),(NULL, '3º Región'),
(NULL, '4º Región'),(NULL, '5º Región'),(NULL, '6º Región');

INSERT INTO city VALUES
(NULL, 'Ciudad 1',1),(NULL, 'Ciudad 2',1),
(NULL, 'Ciudad 3',2),(NULL, 'Ciudad 4',2),
(NULL, 'Ciudad 5',3),(NULL, 'Ciudad 6',3),
(NULL, 'Ciudad 7',4),(NULL, 'Ciudad 8',4),
(NULL, 'Ciudad 9',5),(NULL, 'Ciudad 10',5),
(NULL, 'Ciudad 11',6),(NULL, 'Ciudad 12',6);

INSERT INTO client VALUES
(NULL, 'Cliente 1',1), (NULL, 'Cliente 2',1),
(NULL, 'Cliente 3',2), (NULL, 'Cliente 4',2),
(NULL, 'Cliente 5',3), (NULL, 'Cliente 6',3),
(NULL, 'Cliente 7',4), (NULL, 'Cliente 8',4),
(NULL, 'Cliente 9',5), (NULL, 'Cliente 10',5),
(NULL, 'Cliente 11',6), (NULL, 'Cliente 12',6),
(NULL, 'Cliente 13',7), (NULL, 'Cliente 14',7),
(NULL, 'Cliente 15',8), (NULL, 'Cliente 16',8),
(NULL, 'Cliente 17',9), (NULL, 'Cliente 18',9),
(NULL, 'Cliente 19',10), (NULL, 'Cliente 20',10),
(NULL, 'Cliente 21',11), (NULL, 'Cliente 22',11),
(NULL, 'Cliente 23',12), (NULL, 'Cliente 24',12);

SELECT * FROM region;
SELECT * FROM city;
SELECT * FROM client;

-- DROP TABLE region;
-- DROP TABLE city;
-- DROP TABLE client;