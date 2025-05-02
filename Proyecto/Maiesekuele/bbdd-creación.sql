drop database if exists bdTiendaEbays;
create database bdTiendaEbays;
use bdTiendaEbays;

drop table if exists usuarios;
create table usuarios(
codigo_usuario int primary key auto_increment,
nombre varchar(50) not null,
nombre_usuario varchar (50) not null,
apellido1 varchar(50) not null,
apellido2 varchar(50),
email varchar(50) not null,
contrasenya varchar(20) not null,
esAdmin boolean not null,
constraint chk_email check (email like '_%@_%._%')
);

drop table if exists articulos;
create table articulos(
id_articulo int primary key auto_increment,
nombre varchar(150) not null,
descripcion varchar(200) not null,
existencias int not null,
precio decimal(7,2) not null,
fecha_publicacion date not null,
codigo_usuario int not null,
constraint fk_user_pone_art foreign key (codigo_usuario) references usuarios(codigo_usuario),
constraint chk_existencias check (existencias >= 0),
constraint chk_precio check (precio >= 0)
);

drop table if exists compras;
create table compras(
id_compra int primary key auto_increment,
cod_user int not null,
id_art int not null,
cantidad int not null,
fecha_compra date not null,
constraint fk_user_compra foreign key (cod_user) references usuarios(codigo_usuario),
constraint fk_art_compra foreign key (id_art) references articulos(id_articulo)
);

drop table if exists etiquetas;
create table etiquetas(
nombre varchar(30) primary key
);


create table articulo_etiqueta (
    id_articulo int,
    nombre_etiqueta varchar(30),
    primary key (id_articulo, nombre_etiqueta),
    foreign key (id_articulo) references articulos(id_articulo),
    foreign key (nombre_etiqueta) references etiquetas(nombre)
);

/*
select * from etiquetas;
select * from articulos;
select * from articulo_etiqueta;
select * from usuarios;
*/