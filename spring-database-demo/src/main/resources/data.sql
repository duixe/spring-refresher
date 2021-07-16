CREATE TABLE person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255) not null,
    birth_date timestamp,
    primary key(id)
);

INSERT INTO PERSON(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'sunday', 'accra', sysdate());
INSERT INTO PERSON(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10002, 'duixe', 'kumasi', sysdate());
INSERT INTO PERSON(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10003, 'emma', 'koforidua', sysdate());
INSERT INTO PERSON(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10004, 'eachap', 'Takoradi', sysdate());
