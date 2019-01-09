drop database if exists gamecenter;
create database if not exists gamecenter;

use gamecenter;

SET @@global.time_zone = '-03:00';

create table empresa(
	IDempresa int not null auto_increment primary key,
    empresa varchar(80) not null
);

create table genero(
	IDgenero int not null auto_increment primary key,
    genero varchar(64) not null
);

create table plataforma(
	IDplataforma int not null auto_increment primary key,
    plataforma varchar(64) not null
);

create table jogo (
	IDjogo int not null auto_increment primary key,
    jogo varchar(80),
    lancamento date not null,
    nota_usuarios int, -- entre 0 - 10
    nota_midia int, -- entre 0 - 10
    classificacao int not null
);

create table usuario (
	IDusuario int not null auto_increment primary key,
    login varchar(64) not null, -- nao pode ser igual outro login
    pass varchar(24) not null, -- minimo 8 caracter
    nick varchar(64) not null, -- nao pode ser igual outro nick
    email varchar(120) not null,
    nascimento date not null
);

create table gamecenter (
	IDgamecenter int not null auto_increment primary key,
    IDempresa int not null,
    IDgenero int not null,
    IDplataforma int not null,
    IDjogo int not null,
    IDusuario int not null,
    foreign key (IDusuario) references usuario(IDusuario),
    foreign key (IDempresa) references empresa(IDempresa),
    foreign key (IDgenero) references genero(IDgenero),
    foreign key (IDplataforma) references plataforma(IDplataforma),
    foreign key (IDjogo) references jogo(IDjogo)
);

select * from empresa;