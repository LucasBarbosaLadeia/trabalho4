create table item (
id_item int not null primary key auto_increment,
nome_item varchar (50) not null,
descricao_item varchar (200) not null,
quantidade_item int not null,
preco decimal not null
);
