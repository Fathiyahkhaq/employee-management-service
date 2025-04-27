CREATE TABLE employee (
                          id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          position VARCHAR(255),
                          salary DOUBLE
);