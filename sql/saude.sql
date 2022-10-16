-- Modelo Físico do Projeto Saude+

-- create database saude;

create schema postinho;

create table postinho.pessoa(
	cpf bigint,
	senha varchar(20) not null,
	nome varchar(60) not null,
	bairro varchar(20),
	rua varchar(60),
	numero bigint,
	primary key(cpf)
);

create table postinho.telefone(
	numero bigint,
	cpf_pessoa bigint,
	primary key(numero, cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf)
);

create table postinho.paciente(
	cpf_pessoa bigint,
	rg bigint,
	data_nascimento date,
        email varchar(40),
	primary key(cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf)
);

create table postinho.administrador(
	cpf_pessoa bigint,
	primary key(cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf)
);

create table postinho.tecnico(
	cpf_pessoa bigint,
	cpf_administrador bigint,
	primary key(cpf_pessoa),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf),
	foreign key(cpf_administrador) references postinho.administrador(cpf_pessoa)
);

create table postinho.medico(
	crm varchar(8),
	cpf_pessoa bigint,
	cpf_tecnico bigint,
	especializacao varchar(40),
	primary key(crm),
	foreign key(cpf_pessoa) references postinho.pessoa(cpf),
	foreign key(cpf_tecnico) references postinho.tecnico(cpf_pessoa)
);

create table postinho.prontuario(
	codigo bigint,
	data_criacao date,
	descricao text,
	primary key(codigo)
);

create table postinho.medicamento(
	nome varchar(60),
	codigo_prontuario bigint,
	primary key(nome, codigo_prontuario),
	foreign key(codigo_prontuario) references postinho.prontuario(codigo)
);

create table postinho.consulta(
	cpf_paciente bigint,
	crm_medico varchar(8),
	codigo_prontuario bigint,
	data_realizacao date,
	status varchar(20),
	pressao int,
	peso double precision,
	prioridade int,
	primary key(cpf_paciente, crm_medico, codigo_prontuario),
	foreign key(cpf_paciente) references postinho.paciente(cpf_pessoa),
	foreign key(crm_medico) references postinho.medico(crm),
	foreign key(codigo_prontuario) references postinho.prontuario(codigo)
);

create table postinho.horario(
        data date,
        descricao text,
        cpf_tecnico bigint,
        primary key(data),
        foreign key(cpf_tecnico) references postinho.tecnico(cpf_pessoa)
);