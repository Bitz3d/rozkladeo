# rozkladeo
make config.properties file in `src/main/resources` folder

add login in password

database.login = [login]
database.password = [password]
-------------------------------------------------------------------------------
init database

CREATE DATABASE rokzladeo;

INSERT INTO bus_stop (id, name)
VALUES (1,'Wrzeszcz PKP');
INSERT INTO bus_stop (id, name)
VALUES (2,'Galeria Bałtycka');
INSERT INTO bus_stop (id, name)
VALUES (3,'Benzynowa');
INSERT INTO bus_stop (id, name)
VALUES (4,'Brzeźno');
INSERT INTO bus_stop (id, name)
VALUES (5,'Charpentiera');
INSERT INTO bus_stop (id, name)
VALUES (6,'Cystersów');
INSERT INTO bus_stop (id, name)
VALUES (7,'Derdowskiego');
INSERT INTO bus_stop (id, name)
VALUES (8,'Elmet');
INSERT INTO bus_stop (id, name)
VALUES (9,'Głucha');
INSERT INTO bus_stop (id, name)
VALUES (10,'Hucisko');


-- Wrzeszcz PKP

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (1, 'Galeria Bałtycka', 10,(SELECT id from bus_stop WHERE name ='Wrzeszcz PKP'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (2, 'Benzynowa', 2, (SELECT id from bus_stop WHERE name ='Wrzeszcz PKP'));

-- Galeria Bałtycka

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (3, 'Hucisko', 4, (SELECT id from bus_stop WHERE name ='Galeria Bałtycka'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (4, 'Wrzeszcz PKP', 10, (SELECT id from bus_stop WHERE name ='Galeria Bałtycka'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (5, 'Charpentiera', 5, (SELECT id from bus_stop WHERE name ='Galeria Bałtycka'));

-- Hucisko

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (6, 'Galeria Bałtycka', 4, (SELECT id from bus_stop WHERE name ='Hucisko'));

-- Charpentiera

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (7, 'Galeria Bałtycka', 5, (SELECT id from bus_stop WHERE name ='Charpentiera'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (8, 'Elmet', 11, (SELECT id from bus_stop WHERE name ='Charpentiera'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (9, 'Cystersów', 7, (SELECT id from bus_stop WHERE name ='Charpentiera'));

-- Cystersów
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (10, 'Charpentiera', 7, (SELECT id from bus_stop WHERE name ='Cystersów'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (11, 'Głucha', 15, (SELECT id from bus_stop WHERE name ='Cystersów'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (12, 'Derdowskiego', 8, (SELECT id from bus_stop WHERE name ='Cystersów'));


-- Głucha

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (13, 'Derdowskiego', 2, (SELECT id from bus_stop WHERE name ='Głucha'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (14, 'Cystersów', 15, (SELECT id from bus_stop WHERE name ='Głucha'));


-- Derdowskiego

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (15, 'Głucha', 2, (SELECT id from bus_stop WHERE name ='Derdowskiego'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (16, 'Cystersów', 8, (SELECT id from bus_stop WHERE name ='Derdowskiego'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (17, 'Brzeźno', 50, (SELECT id from bus_stop WHERE name ='Derdowskiego'));

-- Benzynowa

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (18, 'Wrzeszcz PKP', 2, (SELECT id from bus_stop WHERE name ='Benzynowa'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (19, 'Brzeźno', 15, (SELECT id from bus_stop WHERE name ='Benzynowa'));

-- Elmet

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (20, 'Charpentiera', 11, (SELECT id from bus_stop WHERE name ='Elmet'));


-- Brzeźno

INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (21, 'Benzynowa', 15, (SELECT id from bus_stop WHERE name ='Brzeźno'));
INSERT INTO connected_bus_stop (id, bus_stop_name, distance_in_minutes, bus_stop_id)
VALUES (22, 'Derdowskiego', 50, (SELECT id from bus_stop WHERE name ='Brzeźno'));


http://localhost:8080/api/busStops - GET - return all available bus stops

http://localhost:8080/api/route - GET {"date":"2020-05-12", - return path quickest between 2 bus stops
                                       "source":"Elmet",
                                       "destination": "Benzynowa"
                                       }

