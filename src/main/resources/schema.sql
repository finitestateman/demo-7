CREATE TABLE pokemon (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    hp INTEGER,
    legendary BOOLEAN,
    height DOUBLE PRECISION,
    weight REAL,
    capture_date VARCHAR(255),
    stardust_cost INTEGER
);