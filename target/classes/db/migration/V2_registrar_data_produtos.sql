ALTER TABLE products
ADD COLUMN dateCreation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN dateUpdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;