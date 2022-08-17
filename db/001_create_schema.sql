CREATE TABLE rule (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE accident_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE accident (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    text VARCHAR(1000),
    address VARCHAR(100),
    accident_type_id INT REFERENCES accident_type (id)
);

CREATE TABLE accident_rule (
    id SERIAL PRIMARY KEY,
    accident_id INT REFERENCES accident(id),
    rule_id INT REFERENCES rule(id)
);