create database online_shopping;
use online_shopping;
create table production(
    id int not null auto_increment,
    name varchar(40) not null,
    description text,
    original_price decimal(16,4),
    price decimal(16,4),
    primary key(id)
);



create table category(
    id int not null auto_increment,
    name varchar(40) not null,
    primary key(id)
);



create table production_category(
    production_id int,
    category_id int
);



create table orders(
    id int not null auto_increment,
    create_date date not null,
    address varchar(40),
    state varchar(40) not null,
    user_id int not null,
    primary key(id)
);


create table users(
    id int not null auto_increment,
    login_name varchar(40) unique not null,
    nick_name varchar(40) not null,
    default_address_id int,
    email varchar(40) unique not null,
    password varchar(40),
    primary key(id)
);

create table user_address(
    id int not null auto_increment,
    address varchar(100) not null,
    user_id int not null,
    primary key(id)
);