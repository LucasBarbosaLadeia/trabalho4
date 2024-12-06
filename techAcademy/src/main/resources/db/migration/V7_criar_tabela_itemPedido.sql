CREATE TABLE item_pedido (
    id_item INT NOT NULL,
    id_pedido INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_item, id_pedido),
    FOREIGN KEY (id_item) REFERENCES item(id_item),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);