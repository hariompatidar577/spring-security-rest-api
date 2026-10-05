INSERT IGNORE INTO `users` VALUES ('user', '{noop}12345', '1');

INSERT IGNORE INTO `authorities` VALUES ('user', 'read');


INSERT IGNORE INTO `users` VALUES ('admin', '{bcrypt}$2a$12$8OGEPAEmQbP8ti7pMNYofuIy670eFfINnWWqTwexNLcOV3J9O27hO', '1');

INSERT IGNORE INTO `authorities` VALUES ('admin', 'admin');



CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(500) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO customer (email, password, role) VALUES ( 'hariom@gmail.com','{noop}12345', 'READ');
INSERT INTO customer (email, password, role) VALUES ( 'adnin@gmail.com','{bcrypt}$2a$12$8OGEPAEmQbP8ti7pMNYofuIy670eFfINnWWqTwexNLcOV3J9O27hO', 'ADMIN');