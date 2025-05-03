drop database if exists bdTiendaEbays;
create database bdTiendaEbays;
use bdTiendaEbays;

drop table if exists usuarios;
create table usuarios(
codigo_usuario int primary key auto_increment,
nombre varchar(50) not null,
nombre_usuario varchar (50) unique not null,
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
nombre varchar(150) unique not null,
descripcion varchar(200) not null,
existencias int not null,
precio decimal(7,2) not null,
fecha_publicacion datetime not null,
codigo_usuario int not null,
constraint fk_user_pone_art foreign key (codigo_usuario) references usuarios(codigo_usuario) on delete cascade,
constraint chk_existencias check (existencias >= 0),
constraint chk_precio check (precio >= 0)
);

drop table if exists compras;
create table compras(
id_compra int primary key auto_increment,
nom_user varchar(50) not null,
nom_art varchar(150) not null,
cantidad int not null,
fecha_compra datetime not null,
constraint fk_user_compra foreign key (nom_user) references usuarios(nombre_usuario),
constraint fk_art_compra foreign key (nom_art) references articulos(nombre) on delete cascade on update cascade
);

drop table if exists etiquetas;
create table etiquetas(
nombre varchar(30) primary key
);

create table articulo_etiqueta (
    id_articulo int,
    nombre_etiqueta varchar(30),
    primary key (id_articulo, nombre_etiqueta),
    foreign key (id_articulo) references articulos(id_articulo) on update cascade on delete cascade,
    foreign key (nombre_etiqueta) references etiquetas(nombre)
);

-- Usuario administrador
insert into usuarios (nombre, nombre_usuario, apellido1, apellido2, email, contrasenya, esAdmin)
values ('Admin', 'admin', 'Master', 'Root', 'admin@tienda.com', 'admin', true);

-- Usuarios normales
insert into usuarios (nombre, nombre_usuario, apellido1, apellido2, email, contrasenya, esAdmin) values
('Carlos', 'user1', 'Perez', 'Lopez', 'user1@mail.com', '1234', false),
('Laura', 'user2', 'Gomez', 'Martinez', 'user2@mail.com', '1234', false),
('Ana', 'user3', 'Fernandez', 'Ruiz', 'user3@mail.com', '1234', false),
('Luis', 'user4', 'Sanchez', 'Garcia', 'user4@mail.com', '1234', false),
('Marta', 'user5', 'Diaz', 'Torres', 'user5@mail.com', '1234', false),
('David', 'user6', 'Romero', 'Morales', 'user6@mail.com', '1234', false),
('Elena', 'user7', 'Alvarez', 'Ramos', 'user7@mail.com', '1234', false),
('Pablo', 'user8', 'Ortega', 'Castro', 'user8@mail.com', '1234', false),
('Sara', 'user9', 'Navarro', 'Ortega', 'user9@mail.com', '1234', false);

insert into articulos (nombre, descripcion, existencias, precio, fecha_publicacion, codigo_usuario) values
('Teclado Mecánico', 'Teclado RGB mecánico con switches azules', 15, 49.99, '2025-04-01 10:00:00', 1),
('Ratón Gamer', 'Ratón ergonómico para videojuegos', 20, 29.99, '2025-04-02 12:00:00', 2),
('Monitor 24"', 'Monitor Full HD de 24 pulgadas', 18, 129.99, '2025-04-03 09:00:00', 3),
('Auriculares Bluetooth', 'Auriculares inalámbricos con micrófono', 25, 39.99, '2025-04-04 11:00:00', 4),
('Disco SSD 1TB', 'Disco sólido con alta velocidad de lectura/escritura', 12, 99.99, '2025-04-05 13:00:00', 5),
('Cortacésped eléctrico', 'Cortacésped para jardín con motor de 1200W', 6, 149.99, '2025-04-21 10:00:00', 1),     -- Jardín
('Manguera extensible', 'Manguera de jardín de 15 metros', 10, 29.99, '2025-04-21 11:00:00', 2),                    -- Jardín
('Chaqueta impermeable', 'Chaqueta ligera para lluvia', 12, 59.99, '2025-04-21 12:00:00', 3),                      -- Moda
('Zapatillas deportivas', 'Calzado deportivo para correr', 15, 89.99, '2025-04-21 13:00:00', 4),                   -- Moda / Deportes
('Casco moto', 'Casco integral con visera solar', 8, 109.99, '2025-04-21 14:00:00', 5),                            -- Motor
('Aceite sintético 5W40', 'Lubricante de motor sintético', 20, 34.99, '2025-04-21 15:00:00', 6),                   -- Motor
('Torno industrial', 'Herramienta para talleres mecánicos', 2, 899.99, '2025-04-21 16:00:00', 7),                  -- Equipamiento industrial
('Kit herramientas', 'Juego de 120 herramientas de mano', 9, 79.99, '2025-04-21 17:00:00', 8),
-- Otros 15 artículos con distintas existencias
('Alfombrilla XL', 'Alfombrilla para ratón de tamaño extendido', 8, 14.99, '2025-04-06 15:00:00', 6),
('Webcam HD', 'Cámara para videollamadas en alta definición', 5, 24.99, '2025-04-07 16:30:00', 7),
('Micrófono USB', 'Micrófono profesional para streaming', 3, 54.99, '2025-04-08 10:45:00', 8),
('Silla Gaming', 'Silla ergonómica para largas sesiones', 7, 189.99, '2025-04-09 17:15:00', 9),
('Portátil i5', 'Ordenador portátil con procesador i5', 4, 649.99, '2025-04-10 08:00:00', 2),
('Powerbank 20000mAh', 'Batería portátil de alta capacidad', 9, 24.99, '2025-04-11 14:20:00', 3),
('Tablet 10"', 'Tablet Android con 64GB', 6, 159.99, '2025-04-12 19:00:00', 4),
('Smartwatch', 'Reloj inteligente con monitor de salud', 5, 69.99, '2025-04-13 11:10:00', 5),
('Cargador Inalámbrico', 'Cargador rápido por inducción', 3, 19.99, '2025-04-14 12:30:00', 6),
('Hub USB-C', 'Adaptador múltiple para puertos USB-C', 4, 34.99, '2025-04-15 16:50:00', 7),
('Altavoz Bluetooth', 'Altavoz portátil resistente al agua', 6, 44.99, '2025-04-16 13:40:00', 8),
('Cámara Deportiva', 'Cámara para grabar en exteriores', 2, 89.99, '2025-04-17 09:25:00', 9),
('Lámpara LED Escritorio', 'Lámpara regulable con carga USB', 5, 22.99, '2025-04-18 18:10:00', 1),
('Cable HDMI 2m', 'Cable HDMI alta velocidad', 10, 9.99, '2025-04-19 10:00:00', 2);

insert into compras (nom_user, nom_art, cantidad, fecha_compra) values
('user1', 'Teclado Mecánico', 1, '2025-04-10 10:00:00'),
('user2', 'Ratón Gamer', 2, '2025-04-11 11:30:00'),
('user3', 'Monitor 24"', 1, '2025-04-12 14:15:00'),
('user4', 'Auriculares Bluetooth', 1, '2025-04-13 09:45:00'),
('user5', 'Disco SSD 1TB', 1, '2025-04-14 12:00:00'),
('user6', 'Webcam HD', 1, '2025-04-15 08:30:00'),
('user7', 'Micrófono USB', 1, '2025-04-16 15:20:00'),
('user8', 'Portátil i5', 1, '2025-04-17 16:00:00'),
('user9', 'Smartwatch', 2, '2025-04-18 13:40:00'),
('user1', 'Hub USB-C', 1, '2025-04-19 17:00:00'),
('user2', 'Altavoz Bluetooth', 1, '2025-04-20 10:10:00');

insert into etiquetas (nombre) values
('Electrónica'),
('Jardín'),
('Moda'),
('Motor'),
('Deportes'),
('Juguetes y ocio'),
('Equipamiento industrial'),
('Ofertas');


-- Electrónica
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Teclado Mecánico'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Ratón Gamer'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Monitor 24"'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Auriculares Bluetooth'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Disco SSD 1TB'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Webcam HD'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Micrófono USB'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Portátil i5'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Tablet 10"'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Smartwatch'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Altavoz Bluetooth'), 'Electrónica'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Lámpara LED Escritorio'), 'Electrónica');

-- Moda
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Chaqueta impermeable'), 'Moda'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Zapatillas deportivas'), 'Moda'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Smartwatch'), 'Moda');

-- Deportes
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Zapatillas deportivas'), 'Deportes'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Cámara Deportiva'), 'Deportes');

-- Ofertas
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Teclado Mecánico'), 'Ofertas'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Alfombrilla XL'), 'Ofertas'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Cable HDMI 2m'), 'Ofertas');

-- Juguetes y ocio
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Altavoz Bluetooth'), 'Juguetes y ocio'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Cámara Deportiva'), 'Juguetes y ocio');

-- Motor
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Casco moto'), 'Motor'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Aceite sintético 5W40'), 'Motor');

-- Equipamiento industrial
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Torno industrial'), 'Equipamiento industrial'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Kit herramientas'), 'Equipamiento industrial'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Silla Gaming'), 'Equipamiento industrial');

-- Jardín
INSERT INTO articulo_etiqueta (id_articulo, nombre_etiqueta) VALUES
((SELECT id_articulo FROM articulos WHERE nombre = 'Cortacésped eléctrico'), 'Jardín'),
((SELECT id_articulo FROM articulos WHERE nombre = 'Manguera extensible'), 'Jardín');



/*
select * from etiquetas;
select * from articulos;
select * from articulo_etiqueta;
select * from usuarios;
select * from compras;
*/