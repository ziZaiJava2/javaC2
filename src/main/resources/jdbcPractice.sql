create database store2;
use store2;
create table production(
id int not null auto_increment,
name varchar(100) not null,
description text,
original_price DECIMAL(16, 4),
price DECIMAL(16, 4),
primary key(id)
);
create table category(
id int not null auto_increment,
name varchar(40) not null,
primary key(id)
);

create table user(
id int not null auto_increment,
name varchar(40) not null,
nickname varchar(100) not null,
mailbox varchar(40) not null,
address varchar(100) not null,
balance DECIMAL(16, 4) not null,
primary key(id)
);

create table orders(
id int not null auto_increment, 
create_date date not null,
address varchar(100) not null,
user_name varchar(20) not null,
state varchar(20) not null,
primary key(id)
);






