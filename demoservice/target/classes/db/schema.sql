drop table T_SERVICE if exists;
drop table T_DEPENDENCY if exists;
drop table T_CLIENT if exists;

create table T_SERVICE (id bigint identity primary key, name varchar(100),
                        host varchar(50) not null, port varchar(15), version varchar(50) not null, unique(name));
                        
create table T_DEPENDENCY (id bigint identity primary key, dependencies varchar(100),
                        status varchar(50) not null, service_id bigint, foreign key (service_id) references t_service(id));
                        
create table T_CLIENT (id bigint identity primary key, name varchar(100),
                        token varchar(50) not null, service_id bigint, foreign key (service_id) references t_service(id), unique(name));                        