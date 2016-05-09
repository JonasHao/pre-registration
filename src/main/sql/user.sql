CREATE TABLE user (
  id       VARCHAR(20) NOT NULL,
  password VARCHAR(64) NOT NULL,
  phone    VARCHAR(20) NOT NULL,
  email    VARCHAR(100),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB;

