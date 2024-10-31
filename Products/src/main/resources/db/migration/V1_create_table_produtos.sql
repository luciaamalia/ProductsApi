CREATE TABLE products (
     id_product BINARY(16) PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     price DECIMAL(10, 2) NOT NULL,
     type_product ENUM('ELECTRONICS', 'CLOTHING', 'FOOD', 'TOYS','BOOKS','COSMETICS') NOT NULL
);
