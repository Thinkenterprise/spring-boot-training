CREATE TABLE route (
  id int(11) AUTO_INCREMENT PRIMARY KEY,
  flightNumber varchar(100) NOT NULL,
  departure varchar(100) DEFAULT NULL,
  destination varchar(100) DEFAULT NULL
)