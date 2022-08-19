create table if not exists server(
    id bigserial primary key,
    ip_address varchar unique not null,
    name varchar,
    memory varchar,
    type varchar,
    status varchar,
);

