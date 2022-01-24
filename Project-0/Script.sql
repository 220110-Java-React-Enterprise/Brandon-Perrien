CREATE TABLE accounts(
account_id INT AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(50) UNIQUE,
password VARCHAR(50),
CONSTRAINT accounts_pk PRIMARY KEY (account_id)
);

CREATE TABLE bank_accounts(
account_id INT NOT NULL,
account_name VARCHAR(50),
balance DECIMAL (10, 2),
CONSTRAINT bank_accounts_pk PRIMARY KEY (account_name),
CONSTRAINT bank_accounts_accounts_fk FOREIGN KEY (account_id) REFERENCES accounts (account_id)
);

DROP TABLE accounts;
DROP TABLE bank_accounts;

SELECT * FROM accounts;
SELECT * FROM bank_accounts;


