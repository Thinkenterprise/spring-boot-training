CREATE TABLE route (
  id int(11) NOT NULL AUTO_INCREMENT,
  flightNumber varchar(100) NOT NULL,
  departure varchar(100) DEFAULT NULL,
  destination varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);