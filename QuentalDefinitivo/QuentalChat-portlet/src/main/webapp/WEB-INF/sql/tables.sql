create table Asignacion (
	asignacionId LONG not null primary key,
	userId LONG,
	conversacionId LONG
);

create table Conversacion (
	conversacionId LONG not null primary key,
	nickName VARCHAR(75) null,
	createDate DATE null,
	finDate DATE null,
	categoria VARCHAR(75) null,
	descripcion VARCHAR(75) null,
	etiquetas VARCHAR(75) null,
	asignado BOOLEAN,
	cerrada BOOLEAN
);

create table Mensaje (
	mensajeId LONG not null primary key,
	autor VARCHAR(75) null,
	createDate DATE null,
	contenido VARCHAR(75) null,
	conversacionId LONG
);