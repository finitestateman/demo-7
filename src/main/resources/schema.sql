CREATE TABLE IF NOT EXISTS pokemon (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    hp INTEGER,
    legendary BOOLEAN,
    height FLOAT8,
    weight FLOAT4,
    capture_date DATE,
    stardust_cost NUMERIC,
    picture BYTEA
);
