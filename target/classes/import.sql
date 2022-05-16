

INSERT INTO categorias (nombre, imagen) value ('Bebes y Niños', null);
INSERT INTO categorias (nombre, imagen) value ('Farmacia', null);
INSERT INTO categorias (nombre, imagen) value ('Cosmeticos', null);
INSERT INTO categorias (nombre, imagen) value ('Cuidado Personal', null);

--INSERT INTO subcategorias (nombre, categoria_id) values ('subcategoria 1',1);
--INSERT INTO subcategorias (nombre, categoria_id) values ('subcategoria 2',1);
--INSERT INTO subcategorias (nombre, categoria_id) values ('subcategoria 3',1);
--INSERT INTO subcategorias (nombre, categoria_id) values ('subcategoria 4',2);
--INSERT INTO subcategorias (nombre, categoria_id) values ('subcategoria 5',2);

INSERT INTO usuarios (username,documento, movil, password, enabled, nombre, apellido, email) values ('andres','77378856','987654321','$2a$10$1mFjFA.p/UaKPqsDMDt5JeVgblDm8YBZUbRVzmz90g.N5PvVAeKxa' ,1 , 'Andres', 'Guzman', 'andres@gmail.com');
INSERT INTO usuarios (username,documento, movil, password, enabled, nombre, apellido, email) values ('admin','77368856','951478632','$2a$10$h49C0/eJQlOt9/nsyvtKyuRmxWVP6ItTWJ857qPCQkbKiyRRcOvtu' ,1 , 'Alexis', 'Pajuelo', 'administrador@gmail.com');


INSERT INTO roles (nombre) values ('ROLE_USER');
INSERT INTO roles (nombre) values ('ROLE_ADMIN');

INSERT INTO users_authorities (usuario_id, role_id) values (1, 1);
INSERT INTO users_authorities (usuario_id, role_id) values (2, 2);
INSERT INTO users_authorities (usuario_id, role_id) values (2, 1);


INSERT INTO productos (categoria_id, nombre, imagen , descripcion , precio, stock) VALUES ( 3, 'Vick Vaporub Unguento', 'd42da59a-3d63-4dc5-b38c-c25c53164a01_vickvaporub.jpg', 'Vick Vaporub Unguento', 7.9, '1');
INSERT INTO productos (categoria_id, nombre, imagen , descripcion , precio, stock) VALUES ( 4, 'Panadol Antigripal NF Tableta', 'c7cf0d6a-10b5-4e2f-b888-8932e9445616_panadol.jpg', 'Panadol Antigripal NF Tableta', 9.9, '5');
INSERT INTO productos (categoria_id, nombre, imagen , descripcion , precio, stock) VALUES ( 2,  'Aspirina ultra 500 gramos', 'aspirina.jpg', 'Aspirina ultra 500 gramos', 4.5, '5');
INSERT INTO productos (categoria_id, nombre, imagen , descripcion , precio, stock) VALUES ( 1, 'Bisolvon Jarabe adultos', null, 'Bisolvon Jarabe adultos', 18.9, '1');
INSERT INTO productos (categoria_id, nombre, imagen , descripcion , precio, stock) VALUES (1, 'Nastisol Compositum Forte', 'nastisol.jpg', 'Nastisol Compositum Forte', 12.16, '2');
INSERT INTO productos ( categoria_id, nombre, imagen , descripcion , precio, stock) VALUES ( 1, 'Multibioticos con sabor a mentol', null, 'Multibioticos con sabor a mentol', 2.3, '2');
--INSERT INTO productos (usuario_id, categoria_id, nombre, imagen , descripcion , precio, stock) VALUES (2, 4, 'C1ASACA CON POLAR INTERIOR NEGRA', null, 'ALL-BASICS - TALLA 14', '39', '100');
--INSERT INTO productos (usuario_id, categoria_id, nombre, imagen , descripcion , precio, stock) VALUES (2, 4, 'ZAPATILLA NIX PSD NEGRO NEGRO T 42', null, 'VENUS - TALLA 42" ABT310A', '69', '100');
--INSERT INTO productos (usuario_id, categoria_id, nombre, imagen , descripcion , precio, stock) VALUES (2, 4, 'ENTERIZO POLAR', null, 'ALL-BASICS - 6 MESES', '19', '100');



