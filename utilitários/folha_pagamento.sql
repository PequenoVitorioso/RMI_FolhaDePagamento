create database folha_pagamento;
use folha_pagamento;

CREATE TABLE cargo (
  id_cargo int NOT NULL auto_increment primary key,
  nome_cargo varchar(100) NOT NULL,
  descricao varchar(50) DEFAULT NULL,
  salario_base float DEFAULT NULL
);


CREATE TABLE departamento (
  id_departamento int NOT NULL auto_increment primary key,
  nome_departamento varchar(100) NOT NULL,
  localizacao varchar(100) DEFAULT NULL
);

CREATE TABLE funcionario (
  id_funcionario int NOT NULL auto_increment primary key,
  nome varchar(100) NOT NULL,
  id_departamento int DEFAULT NULL,
  id_cargo int DEFAULT NULL,
  constraint funcionario_departamento foreign key (id_departamento) references departamento (id_departamento),
  constraint funcionario_cargo foreign key (id_cargo) references cargo (id_cargo)
);

CREATE TABLE pagamento (
  id_pagamento int NOT NULL auto_increment primary key,
  id_funcionario int DEFAULT NULL,
  valor_liquido float DEFAULT NULL,
  constraint pagamento_funcionario foreign key (id_funcionario) references funcionario (id_funcionario)
);

INSERT INTO cargo (nome_cargo, descricao, salario_base) VALUES
('Analista de Sistemas', 'Analisa sistemas', 4500.00),
('Programador', 'Desenvolve softwares', 3500.00),
('Gerente de TI', 'Responsável pelo setor', 7000.00),
('Estagiário', 'Apoio ao desenvolvimento', 1200.00);

INSERT INTO departamento (nome_departamento, localizacao) VALUES
('Tecnologia da Informação', 'Bloco A'),
('Recursos Humanos', 'Bloco B'),
('Financeiro', 'Bloco C');

INSERT INTO funcionario (nome, id_departamento, id_cargo) VALUES
('João Silva', 1, 2),
('Maria Oliveira', 1, 1),
('Carlos Souza', 3, 3),
('Ana Pereira', 1, 4);

INSERT INTO pagamento (id_funcionario, valor_liquido) VALUES
(1, 3200.00),
(2, 4400.00),
(3, 6800.00),
(4, 1100.00);

