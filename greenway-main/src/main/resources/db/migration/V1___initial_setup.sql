CREATE TABLE users (
                       id NUMERIC PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       role VARCHAR(255) NOT NULL
);

CREATE SEQUENCE user_id_seq;

ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('user_id_seq');

CREATE TABLE collects (
                          id NUMERIC PRIMARY KEY,
                          collection_date DATE,
                          waste_type VARCHAR(255),
                          user_id BIGINT,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE SEQUENCE collect_id_seq;

ALTER TABLE collects ALTER COLUMN id SET DEFAULT nextval('collect_id_seq');
