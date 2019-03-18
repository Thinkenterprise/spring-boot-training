
insert into route(id, flight_Number, departure, destination) values(101, 'LH7902','MUC','IAH');
insert into route(id, flight_Number, departure, destination) values(102, 'LH1602','MUC','IBZ');
insert into route(id, flight_Number, departure, destination) values(103, 'LH401','FRA','NYC');

insert into flight(id, route_id, price, date) values(1, 101, '120.45', '2018-06-17');
insert into flight(id, route_id, price, date) values(2, 102, '111.45', '2018-07-17');
insert into flight(id, route_id, price, date) values(3, 103, '60.45', '2018-08-17');