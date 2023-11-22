ALTER TABLE car ADD COLUMN nameinterest VARCHAR(100);

ALTER TABLE car ADD COLUMN numberinterest VARCHAR(12);

UPDATE car SET interest = 0 WHERE interest = 1;

DROP TABLE car;

SELECT * FROM car;
DESCRIBE car;

SHOW TABLES;

DESCRIBE report;

SELECT * FROM report;

SELECT * FROM user;

DELETE FROM report;

DESCRIBE report;

DROP TABLE report;

DESCRIBE user;


INSERT INTO user (login, password, name, active, birthdate, registerdate) VALUES ("jotap", "joao", "João", 0, "2003-07-25", "2023-11-12");

DELETE FROM report;

