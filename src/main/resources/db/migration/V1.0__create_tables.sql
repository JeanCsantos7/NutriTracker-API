CREATE TABLE usuario
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome            VARCHAR(150) NOT NULL,
    email           VARCHAR(150) NOT NULL,
    senha_hash      VARCHAR(255) NOT NULL,
    data_nascimento DATE NULL,
    altura          DECIMAL(5, 2) NULL,
    peso_atual      DECIMAL(5, 2) NULL,
    objetivo        ENUM('CUTTING', 'BULKING', 'MANUTENCAO') NULL,
    data_cadastro   DATE NOT NULL,

    CONSTRAINT uq_usuario_email UNIQUE (email)
);


CREATE TABLE meta
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id        BIGINT NOT NULL,
    peso_meta         DECIMAL(5, 2) NULL,
    calorias_diarias  INT NULL,
    proteinas_diarias DECIMAL(6, 2) NULL,
    data_inicio       DATE NOT NULL,
    data_fim          DATE NULL,
    status            ENUM('EM_PROGRESSO', 'CONCLUIDA', 'CANCELADA') NOT NULL DEFAULT 'EM_PROGRESSO',

    CONSTRAINT fk_meta_usuario
        FOREIGN KEY (usuario_id)
            REFERENCES usuario (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX idx_meta_usuario_id
    ON meta (usuario_id);


CREATE TABLE registro_peso
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id    BIGINT NOT NULL,
    peso          DECIMAL(5, 2) NOT NULL,
    data_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_registro_peso_usuario
        FOREIGN KEY (usuario_id)
            REFERENCES usuario (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX idx_registro_peso_usuario_id
    ON registro_peso (usuario_id);


CREATE TABLE alimento
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome         VARCHAR(150) NOT NULL,
    calorias     DECIMAL(7, 2) NOT NULL,
    proteinas    DECIMAL(6, 2) NULL,
    carboidratos DECIMAL(6, 2) NULL
);


CREATE TABLE refeicao
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    data       DATETIME NOT NULL,
    tipo       ENUM(
        'CAFE_DA_MANHA',
        'ALMOCO',
        'CAFE_DA_TARDE',
        'JANTAR',
        'OUTRO'
    ) NOT NULL,

    CONSTRAINT fk_refeicao_usuario
        FOREIGN KEY (usuario_id)
            REFERENCES usuario (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX idx_refeicao_usuario_id
    ON refeicao (usuario_id);


CREATE TABLE refeicao_alimento
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    refeicao_id BIGINT NOT NULL,
    alimento_id BIGINT NOT NULL,
    quantidade  DECIMAL(7, 2) NOT NULL,

    CONSTRAINT fk_refeicao_alimento_refeicao
        FOREIGN KEY (refeicao_id)
            REFERENCES refeicao (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_refeicao_alimento_alimento
        FOREIGN KEY (alimento_id)
            REFERENCES alimento (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX idx_refeicao_alimento_refeicao_id
    ON refeicao_alimento (refeicao_id);

CREATE INDEX idx_refeicao_alimento_alimento_id
    ON refeicao_alimento (alimento_id);


CREATE TABLE exercicio
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(150) NOT NULL,
    grupo_muscular VARCHAR(100) NOT NULL,
    equipamento    VARCHAR(100) NOT NULL
);


CREATE TABLE treino
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    nome       VARCHAR(150) NOT NULL,
    ativo      TINYINT(1) NOT NULL DEFAULT 1,

    CONSTRAINT fk_treino_usuario
        FOREIGN KEY (usuario_id)
            REFERENCES usuario (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX idx_treino_usuario_id
    ON treino (usuario_id);


CREATE TABLE ficha_treino
(
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    treino_id            BIGINT NOT NULL,
    exercicio_id         BIGINT NOT NULL,
    series_previstas     VARCHAR(50) NOT NULL,
    repeticoes_previstas VARCHAR(50) NOT NULL,
    carga_prevista       DECIMAL(6, 2) NOT NULL,
    observacao           VARCHAR(500) NULL,

    CONSTRAINT fk_ficha_treino_treino
        FOREIGN KEY (treino_id)
            REFERENCES treino (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_ficha_treino_exercicio
        FOREIGN KEY (exercicio_id)
            REFERENCES exercicio (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX idx_ficha_treino_treino_id
    ON ficha_treino (treino_id);

CREATE INDEX idx_ficha_treino_exercicio_id
    ON ficha_treino (exercicio_id);


CREATE TABLE treino_realizado
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id      BIGINT NOT NULL,
    treino_id       BIGINT NOT NULL,
    data            DATETIME NOT NULL,
    duracao_minutos INT NULL,
    observacao      VARCHAR(500) NULL,

    CONSTRAINT fk_treino_realizado_usuario
        FOREIGN KEY (usuario_id)
            REFERENCES usuario (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_treino_realizado_treino
        FOREIGN KEY (treino_id)
            REFERENCES treino (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX idx_treino_realizado_usuario_id
    ON treino_realizado (usuario_id);

CREATE INDEX idx_treino_realizado_treino_id
    ON treino_realizado (treino_id);


CREATE TABLE exercicio_realizado
(
    id                    BIGINT AUTO_INCREMENT PRIMARY KEY,
    treino_realizado_id   BIGINT NOT NULL,
    exercicio_id          BIGINT NOT NULL,
    series_realizadas     VARCHAR(50) NOT NULL,
    repeticoes_realizadas VARCHAR(50) NOT NULL,
    carga_utilizada       DECIMAL(6, 2) NOT NULL,

    CONSTRAINT fk_exercicio_realizado_treino_realizado
        FOREIGN KEY (treino_realizado_id)
            REFERENCES treino_realizado (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT fk_exercicio_realizado_exercicio
        FOREIGN KEY (exercicio_id)
            REFERENCES exercicio (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX idx_exercicio_realizado_treino_realizado_id
    ON exercicio_realizado (treino_realizado_id);

CREATE INDEX idx_exercicio_realizado_exercicio_id
    ON exercicio_realizado (exercicio_id);


INSERT INTO usuario
(
    nome,
    email,
    senha_hash,
    data_nascimento,
    altura,
    peso_atual,
    objetivo,
    data_cadastro
)
VALUES
    (
        'Administrador',
        'gerente@nutritrack.com',
        '$2a$12$vIalsxk.nmgKUmG55y0.duZgp7Wpr40t4nDTIy7kcBVRJh5PxGpMu',
        '2003-07-28',
        1.72,
        79.00,
        'CUTTING',
        '2026-08-17'
    );