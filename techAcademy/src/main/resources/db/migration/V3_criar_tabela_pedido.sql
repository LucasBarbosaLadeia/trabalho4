CREATE TABLE pedido (
    id_pedido INT NOT NULL PRIMARY key auto_increment,
    id_usuario INT NOT NULL,
    data_pedido DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);
