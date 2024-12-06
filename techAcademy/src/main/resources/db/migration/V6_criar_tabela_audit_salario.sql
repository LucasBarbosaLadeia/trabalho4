create table audit_preco (
id_audit_preco_item int not null primary key auto_increment,
id_item int not null,
data_modificacao date not null,
preco_antigo DECIMAL(10, 2) NOT NULL,
preco_novo DECIMAL(10, 2) NOT NULL,
Motivo VARCHAR(50) not null,
FOREIGN KEY (id_item) REFERENCES item(id_item)
);