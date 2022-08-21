create table if not exists server(
    id bigserial primary key,
    ip_address varchar unique not null,
    name varchar,
    memory varchar,
    type varchar,
    status varchar
);

insert into server (id, ip_address, name, memory, type, status) values (1, '240.250.68.8', 'Fay and Sons', '32 GB ','Staré Město server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (2, '66.29.20.233', 'Welch, Kertzmann and Schumm', '32 GB ', 'Wenchang server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (3, '105.3.206.132', 'Heaney Group', '32 GB ', 'Shiḩan as Suflá server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (4, '237.210.148.207', 'Wisozk, Jacobs and Stiedemann', '32 GB ', 'Donghe server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (5, '244.31.190.132', 'Funk Group', '32 GB ', 'Hisings Kärra server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (6, '35.192.3.162', 'Turner, Greenholt and Rolfson', '32 GB ', 'Muncar server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (7, '48.62.22.34', 'Medhurst-Cremin', '32 GB ', 'Užice server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (8, '234.221.162.90', 'Keeling, Considine and Yost', '32 GB ', 'Yunping server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (9, '5.205.65.152', 'Ratke-Nader', '32 GB ', 'Kota Kinabalu server', 'SERVER_DOWN');
insert into server (id, ip_address, name, memory, type, status) values (10, '193.84.99.177', 'Schroeder-Stanton', '32 GB ', 'Alkmaar server', 'SERVER_DOWN');

select SETVAL('server_id_seq', (select max(id) from server))