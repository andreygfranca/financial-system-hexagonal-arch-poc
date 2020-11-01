CREATE TABLE t_account_payable_settlement
  (
     id                 BINARY(255) NOT NULL,
     vl_settlement      DECIMAL(19, 2),
     account_payable_id BINARY(255) NOT NULL,
     PRIMARY KEY (id)
  )
engine=innodb;

ALTER TABLE t_account_payable_settlement
  ADD CONSTRAINT fk2dah3jx5awlce42r0ommlbq02 FOREIGN KEY (account_payable_id)
  REFERENCES t_account_payable (id);