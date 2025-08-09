CREATE TABLE IF NOT EXISTS endereco_tb (
    id SERIAL PRIMARY KEY,
    rua VARCHAR(255),
    numero VARCHAR(255),
    bairro VARCHAR(255),
    complemento VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    cep VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS imovel_tb (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    endereco_id INTEGER NOT NULL,
    capacidade INTEGER NOT NULL,
    num_quartos INTEGER NOT NULL,
    disponibilidade BOOLEAN NOT NULL,
    CONSTRAINT fk_imovel_endereco FOREIGN KEY (endereco_id)
        REFERENCES endereco_tb(id)
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS equipe_tb (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    num_membros INTEGER NOT NULL,
    status_alocacao BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS quarto_tb (
    id SERIAL PRIMARY KEY,
    num_do_quarto VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    imovel_id INTEGER NOT NULL,
    ocupado BOOLEAN NOT NULL,
    CONSTRAINT fk_quarto_imovel FOREIGN KEY (imovel_id)
        REFERENCES imovel_tb(id)
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS alocacao_tb (
    id SERIAL PRIMARY KEY,
    equipe_id INTEGER NOT NULL,
    quarto_designado_id INTEGER NOT NULL,
    imovel_id INTEGER NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    CONSTRAINT fk_alocacao_equipe FOREIGN KEY (equipe_id)
        REFERENCES equipe_tb(id)
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_alocacao_quarto FOREIGN KEY (quarto_designado_id)
        REFERENCES quarto_tb(id)
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_alocacao_imovel FOREIGN KEY (imovel_id)
        REFERENCES imovel_tb(id)
        ON UPDATE NO ACTION ON DELETE NO ACTION
);
