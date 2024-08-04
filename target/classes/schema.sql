CREATE TABLE dog (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE,
    breed VARCHAR(255),
    weight FLOAT,
    has_chip BOOLEAN,
    photo_url VARCHAR(255)
);
