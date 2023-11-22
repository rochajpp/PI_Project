CREATE TABLE car(
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    value FLOAT NOT NULL,
    description VARCHAR(1000) NOT NULL,
    image VARCHAR(1000) NOT NULL,
    interest BOOLEAN NOT NULL,
    manufactureyear INT NOT NULL,
    modelyear INT NOT NULL,
    registerdate DATE NOT NULL
);

CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(10) NOT NULL, 
    password VARCHAR(20) NOT NULL,
    name VARCHAR(100) NOT NULL,
    active BOOLEAN NOT NULL,
    birthdate DATE NOT NULL,
    registerdate DATE NOT NULL
);


CREATE TABLE report(
    id INT PRIMARY KEY AUTO_INCREMENT,
    idcar INT NOT NULL,
    nameclient VARCHAR(100) NOT NULL,
    phoneclient VARCHAR(20) NOT NULL,
    registerdate DATE NOT NULL
);