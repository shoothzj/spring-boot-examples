create table user ( id bigint not null, password varchar(64), username varchar(256), primary key (id));
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);