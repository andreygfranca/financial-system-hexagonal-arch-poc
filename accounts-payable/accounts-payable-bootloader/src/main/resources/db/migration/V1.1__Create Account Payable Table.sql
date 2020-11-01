CREATE TABLE t_account_payable
  (
     id                 BINARY(255) NOT NULL,
     dt_maturity        DATE,
     ds_observation     VARCHAR(255),
     en_type            INTEGER,
     vl_account_payable DECIMAL(19, 2),
     PRIMARY KEY (id)
  )
engine=innodb;
