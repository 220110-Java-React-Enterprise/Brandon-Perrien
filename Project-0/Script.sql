CREATE TABLE users(
user_id INT AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(50) UNIQUE,
password VARCHAR(50),
CONSTRAINT users_pk PRIMARY KEY (user_id)
);

CREATE TABLE accounts(
user_id INT NOT NULL,
account_name VARCHAR(50),
balance DECIMAL (10, 2),
CONSTRAINT accounts_pk PRIMARY KEY (account_name),
CONSTRAINT accounts_users_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

DROP TABLE accounts;
DROP TABLE users;

SELECT * FROM accounts;
SELECT * FROM users;


