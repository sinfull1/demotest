DROP TABLE IF EXISTS resource;

CREATE TABLE resource
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL

);

INSERT INTO resource (name)
VALUES ('Aliko'),
       ('Bill'),
       ('Folrunsho');