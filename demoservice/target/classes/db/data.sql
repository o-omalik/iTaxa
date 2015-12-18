

insert into T_SERVICE (name,host,port,version) values ('Demoservice1', 'apz-x', '8010', '1.1');
insert into T_SERVICE (name,host,port,version) values ('Demoservice2', 'apz-x', '8011', '1.2');
insert into T_SERVICE (name,host,port,version) values ('Tokenservice1', 'apz-z', '8020', '1.4');
insert into T_SERVICE (name,host,port,version) values ('Tokenservice2', 'apz-z', '8021', '1.4');

insert into T_DEPENDENCY (dependencies, status, service_id) values ('http://apz-x:8010/tokenservice1','ok', '1');

insert into T_CLIENT (name, token, service_id) values ('ios', '12312-12-123-233', '1');
insert into T_CLIENT (name, token, service_id) values ('chrome', '12312-12-123-233', '1');