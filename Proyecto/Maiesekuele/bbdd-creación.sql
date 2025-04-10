drop database if exists bdTiendaEbays;
create database bdTiendaEbays;
use bdTiendaEbays;

drop table if exists usuarios;
create table usuarios(
codigo_usuario int primary key auto_increment,
nombre varchar(50) not null,
apellido1 varchar(50) not null,
apellido2 varchar(50),
email varchar(50) not null,
contrasenya varchar(20) not null,
constraint chk_email check (email like '_%@_%._%')
);

drop table if exists articulos;
create table articulos(
id_articulo int primary key auto_increment,
nombre varchar(150) not null,
descripcion varchar(200) not null,
precio decimal(7,2) not null
);

drop table if exists ventas;
create table ventas (
id_venta int primary key auto_increment,
cod_user int,
id_art int,
fecha_venta date not null,
constraint fk_user_vende foreign key (cod_user) references usuarios(codigo_usuario),
constraint fk_art_vende foreign key (id_art) references articulos(id_articulo)
);

drop table if exists compras;
create table compras(
id_compra int primary key auto_increment,
cod_user int not null,
id_art int not null,
fecha_compra date not null,
constraint fk_user_compra foreign key (cod_user) references usuarios(codigo_usuario),
constraint fk_art_compra foreign key (id_art) references articulos(id_articulo)
);

drop table if exists etiquetas;
create table etiquetas(
nombre varchar(20) primary key
);

alter table articulos add column etiqueta varchar (20);
alter table articulos add constraint fk_etiqueta foreign key (etiqueta) references etiquetas(nombre);