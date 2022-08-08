CREATE TABLE accident (
   id SERIAL PRIMARY KEY,
   name VARCHAR(2000),
   text TEXT,
   address TEXT,
   type_id INT REFERENCES rule (id)
);