USE jwxt;
CREATE TABLE test(
  uid INT NOT NULL UNIQUE auto_increment,
  uname VARCHAR (20),
  PRIMARY KEY(uid)
)