-- Modelo Físico do Projeto Saude+

-- create database saude;

-- create schema postinho;

create table postinho.pessoa(
	-- 001.001.001-01
	cpf varchar(14),
	senha varchar(20) not null,
	nome varchar(60),
	bairro varchar(20),
	rua varchar(60),
	numero int,
	primary key(cpf)
);

create table postinho.telefone(
	-- (84) 90101-0101
	numero varchar(15),
	cpf_pessoa varchar(14),
	primary key(numero, cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf)
);

create table postinho.paciente(
	cpf_pessoa varchar(14),
	-- 001.001.001
	rg varchar(11),
	data_nascimento date,
	primary key(cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf)
);

create table postinho.administrador(
	cpf_pessoa varchar(14),
	primary key(cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf)
);

create table postinho.tecnico(
	cpf_pessoa varchar(14),
	cpf_administrador varchar(14),
	primary key(cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf),
	foreign key(cpf_administrador) references postinho.administrador(cpf_pessoa)
);

create table postinho.medico(
	-- CRM/RN 010101
	crm varchar(13),
	cpf_pessoa varchar(14),
	cpf_tecnico varchar(14),
	especializacao varchar(40),
	primary key(crm),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf),
	foreign key(cpf_tecnico) references postinho.tecnico(cpf_pessoa)
);

create table postinho.laudo(
	codigo int,
	data_criacao date,
	descricao text,
	primary key(codigo)
);

create table postinho.medicamento(
	nome varchar(60),
	codigo_laudo int,
	primary key(nome, codigo_laudo),
	foreign key(codigo_laudo) references postinho.laudo(codigo)
);

create table postinho.consulta(
	cpf_paciente varchar(14),
	crm_medico varchar(13),
	codigo_laudo int,
	data_realizacao date,
	status varchar(20),
	pressao int,
	peso double precision,
	prioridade int,
	primary key(cpf_paciente, crm_medico, codigo_laudo),
	foreign key(cpf_paciente) references postinho.paciente(cpf_pessoa),
	foreign key(crm_medico) references postinho.medico(crm),
	foreign key(codigo_laudo) references postinho.laudo(codigo)
);