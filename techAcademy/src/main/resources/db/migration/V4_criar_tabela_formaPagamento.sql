CREATE TABLE forma_pagamento (
    id_forma_pagamento INT NOT NULL PRIMARY key auto_increment,
    nome VARCHAR(50) NOT NULL,
    taxa DECIMAL(5, 2) DEFAULT 0.00
);