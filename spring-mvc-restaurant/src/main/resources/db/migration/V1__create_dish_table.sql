create table dish
(
id integer not null auto_increment,
 created datetime,
 deleted integer,
 description varchar(255),
  modified datetime not null,
  name varchar(255),
  price integer,
  product_type varchar(255),
  primary key (id)
  ) engine=InnoDB
