--liquibase formatted sql

--changeset lilfrost:1
create table if not exists server(
                                     id bigserial primary key,
                                     ip_address varchar unique not null,
                                     name varchar(32),
                                     memory varchar(32),
                                     type varchar,
                                     status varchar(32)
);
-- rollback drop table server

--changeset lilfrost:2
create table if not exists users(
                                    id bigserial primary key,
                                    username varchar(32),
                                    password varchar (128),
                                    role varchar(32)
);
-- rollback drop table users
