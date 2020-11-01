CREATE TABLE t_cash_flow_entry
  (
     id                BINARY(255) NOT NULL,
     en_classification INTEGER,
     dt_entry          DATETIME,
     dt_payment        DATETIME,
     settlement_id     VARCHAR(255),
     PRIMARY KEY (id)
  )
engine=innodb