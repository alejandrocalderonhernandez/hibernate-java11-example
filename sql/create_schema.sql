DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE(
    ID SERIAL PRIMARY KEY,
    EMAIL VARCHAR(25) unique,
    FIRST_NAME VARCHAR(20),
    LAST_NAME VARCHAR(20)
);

DROP TABLE IF EXISTS car_brand;
DROP TABLE IF EXISTS car_model;

create type category as enum (
    'luxury',
    'sports',
    'accessible',
    'all terrain',
    'transport');

create table car_brand(
    id bigserial primary key,
    "name" varchar(15) not null,
    country varchar(15),
    category category not null,
    foundation_date date
);

create table car_model(
    seriel_number uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    id_brand bigint,
    "name" varchar(15) not null,
    hp integer,
    pice double precision,
    constraint fk_brand foreign key(id_brand) references car_brand(id)
);