DROP TABLE Administrador CASCADE CONSTRAINTS
;
DROP TABLE Calificacion CASCADE CONSTRAINTS
;
DROP TABLE Categoria CASCADE CONSTRAINTS
;
DROP TABLE Condicion CASCADE CONSTRAINTS
;
DROP TABLE Contrasena CASCADE CONSTRAINTS
;
DROP TABLE Mensaje CASCADE CONSTRAINTS
;
DROP TABLE Objeto CASCADE CONSTRAINTS
;
DROP TABLE Publicacion CASCADE CONSTRAINTS
;
DROP TABLE Usuario CASCADE CONSTRAINTS
;
DROP TABLE UsuarioOPUD CASCADE CONSTRAINTS
;

CREATE TABLE Administrador
(
	nickname   VARCHAR2(10) NOT NULL,
	idUsuario  VARCHAR2(15) NOT NULL
)
;


CREATE TABLE Calificacion
(
	idCalificador  VARCHAR2(15) NOT NULL,
	idCalificado   VARCHAR2(15) NOT NULL,
	nota           NUMBER(2) NOT NULL
)
;


CREATE TABLE Categoria
(
	idCategoria  VARCHAR2(3) NOT NULL,
	nombre       VARCHAR2(50) NOT NULL,
	descripcion  VARCHAR2(50) NOT NULL
)
;


CREATE TABLE Condicion
(
	idCondicion  VARCHAR2(3) NOT NULL,
	nombre       VARCHAR(20) NOT NULL
)
;


CREATE TABLE Contrasena
(
	idUsuario   VARCHAR2(15) NOT NULL,
	contrasena  VARCHAR2(30) NOT NULL
)
;


CREATE TABLE Mensaje
(
	idMensaje  VARCHAR2(15) NOT NULL,
	idOrigen   VARCHAR2(15) NOT NULL,
	idDestino  VARCHAR2(15) NOT NULL,
	asunto     VARCHAR2(50) NOT NULL,
	mensaje    VARCHAR2(200) NOT NULL,
	fecha      DATE NOT NULL,
	leido      NUMBER(1) NOT NULL
)
;


CREATE TABLE Objeto
(
	idObjeto     VARCHAR2(25) NOT NULL,
	nombre       VARCHAR(20) NOT NULL,
	idCategoria  VARCHAR2(3) NOT NULL,
	descripcion  VARCHAR2(200),
	idCondicion  VARCHAR(3) NOT NULL
)
;


CREATE TABLE Publicacion
(
	idPublicacion     VARCHAR2(25) NOT NULL,
	idUsuario         VARCHAR2(15) NOT NULL,
	idObjeto          VARCHAR2(25) NOT NULL,
	titulo            VARCHAR2(50) NOT NULL,
	fechaPublicacion  DATE NOT NULL,
	fechaCondicion    DATE NOT NULL,
	tipoPublicacion   NUMBER(2) NOT NULL,
	activo            NUMBER(1) NOT NULL
)
;


CREATE TABLE Usuario
(
	idUsuario      VARCHAR2(15) NOT NULL,
	nombre         VARCHAR2(30) NOT NULL,
	apellido       VARCHAR2(30) NOT NULL,
	docIdentidad   VARCHAR2(50) NOT NULL,
	tipoDocumento  VARCHAR2(5) NOT NULL,
	correo         VARCHAR2(50) NOT NULL
)
;


CREATE TABLE UsuarioOPUD
(
	rolUniversidad  VARCHAR(30) NOT NULL,
	codigo          VARCHAR2(15) NOT NULL,
	idUsuario       VARCHAR2(15) NOT NULL
)
;



ALTER TABLE Administrador ADD CONSTRAINT PK_Administrador 
	PRIMARY KEY (idUsuario)
;

ALTER TABLE Categoria ADD CONSTRAINT PK_Categoria 
	PRIMARY KEY (idCategoria)
;

ALTER TABLE Condicion ADD CONSTRAINT PK_Condicion 
	PRIMARY KEY (idCondicion)
;

ALTER TABLE Mensaje ADD CONSTRAINT PK_Mensaje 
	PRIMARY KEY (idMensaje)
;

ALTER TABLE Objeto ADD CONSTRAINT PK_Objeto 
	PRIMARY KEY (idObjeto)
;

ALTER TABLE Publicacion ADD CONSTRAINT PK_Publicacion 
	PRIMARY KEY (idPublicacion)
;

ALTER TABLE Usuario ADD CONSTRAINT PK_Usuario 
	PRIMARY KEY (idUsuario)
;

ALTER TABLE UsuarioOPUD ADD CONSTRAINT PK_UsuarioOPUD 
	PRIMARY KEY (idUsuario)
;



ALTER TABLE Administrador ADD CONSTRAINT FK_Administrador_Usuario 
	FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
;

ALTER TABLE Calificacion ADD CONSTRAINT FK_Calificacion_UsuarioOPUDA 
	FOREIGN KEY (idCalificador) REFERENCES UsuarioOPUD (idUsuario)
;

ALTER TABLE Calificacion ADD CONSTRAINT FK_Calificacion_UsuarioOPUDB 
	FOREIGN KEY (idCalificado) REFERENCES UsuarioOPUD (idUsuario)
;

ALTER TABLE Contrasena ADD CONSTRAINT FK_Contrasena_Usuario 
	FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
;

ALTER TABLE Mensaje ADD CONSTRAINT FK_Mensaje_Usuario 
	FOREIGN KEY (idDestino) REFERENCES Usuario (idUsuario)
;

ALTER TABLE Mensaje ADD CONSTRAINT FK_Mensaje_Usuario_Origen 
	FOREIGN KEY (idOrigen) REFERENCES Usuario (idUsuario)
;

ALTER TABLE Objeto ADD CONSTRAINT FK_Objeto_Categoria 
	FOREIGN KEY (idCategoria) REFERENCES Categoria (idCategoria)
;

ALTER TABLE Objeto ADD CONSTRAINT FK_Objeto_Condicion 
	FOREIGN KEY (idCondicion) REFERENCES Condicion (idCondicion)
;

ALTER TABLE Publicacion ADD CONSTRAINT FK_Publicacion_Objeto 
	FOREIGN KEY (idObjeto) REFERENCES Objeto (idObjeto)
;

ALTER TABLE Publicacion ADD CONSTRAINT FK_Publicacion_UsuarioOPUD 
	FOREIGN KEY (idUsuario) REFERENCES UsuarioOPUD (idUsuario)
;

ALTER TABLE UsuarioOPUD ADD CONSTRAINT FK_UsuarioOPUD_Usuario 
	FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
;
