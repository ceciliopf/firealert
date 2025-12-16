-- 1. Sequences
CREATE SEQUENCE floresta_codigo_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE pessoa_codigo_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE alert_codigo_seq START WITH 1 INCREMENT BY 1;

-- 2. Tabela Floresta
CREATE TABLE floresta (
    id BIGINT NOT NULL DEFAULT nextval('floresta_codigo_seq'),
    name VARCHAR(255) NOT NULL,
    endereco VARCHAR(255),
    CONSTRAINT pk_floresta PRIMARY KEY (id)
);

-- 3. Tabela Pessoa
CREATE TABLE pessoa (
    codigo BIGINT NOT NULL DEFAULT nextval('pessoa_codigo_seq'),
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(20),
    data_nascimento DATE,
    pessoa_tipo VARCHAR(50) NOT NULL, 
    floresta_id BIGINT,
    CONSTRAINT pk_pessoa PRIMARY KEY (codigo),
    CONSTRAINT fk_pessoa_floresta FOREIGN KEY (floresta_id) REFERENCES floresta(id)
);

-- 4. Tabela Alert
CREATE TABLE alert (
    id BIGINT NOT NULL DEFAULT nextval('alert_codigo_seq'),
    descricao TEXT,                
    alert_gravidade VARCHAR(50),   
    alert_status VARCHAR(50),      
    floresta_id BIGINT,
    pessoa_id BIGINT,              
    
    CONSTRAINT pk_alert PRIMARY KEY (id),
    CONSTRAINT fk_alert_floresta FOREIGN KEY (floresta_id) REFERENCES floresta(id),
    CONSTRAINT fk_alert_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(codigo)
);