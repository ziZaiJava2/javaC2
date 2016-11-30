create database store;
use store;

create table catalogue(
id int not null auto_increment,
name varchar(100) not null,
introduction varchar(100) not null,
original_price int,
current_prience int,
classify varchar(100) not null,
primary key(id)
);
insert into catalogue(name,introduction,original_price,current_prience,classify)
values('小米无人机','便宜是便宜，就是要小心炸机',1999,1999,'Electronic components');#Electronic components



create table registered_member(
id int not null auto_increment,
name varchar (20) not null,
nickname varchar(20)not null unique,
mail varchar(40) not null,
address varchar(40) not null,
account_balance int,
 primary key(id));
insert into registered_member(name,nickname,mail,address,account_balance)
values('张昀怡','班花','boss@bl.com','沪城环路8号','20000');


alter table indent add constraint id foreign key(id) references registered_member(id);

create table indent(
id int not null auto_increment,
productId int,
memberId int,
price int,
number int,
primary key(id)
);
alter table indent add column count int;
alter table indent add column  purchase_date date;
alter table indent add column  account_paid boolean;
alter table indent drop number;

#创建外键约束
alter table indent add constraint indent_id foreign key(order_number) references registered_member (id);

select*from indent;

#2016-09-01老板娘让程序员给他拉了一下报告，看看有多少个用户了，有多少商品在卖了.
select * from catalogue;
select * from registered_member;
update catalogue set classify='game' where catalogue.name='战地1';
#任向杰进了商城，查看了一下自己的个人信息，写出SQL
select * from registered_member  where name='任向杰'; 
#他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品，写出SQL
select *from catalogue where classify='Electronic components';
#然后把所有的电子产品都选上，生成了一个订单，写出SQL，并写出下面信息的查询SQL，总价可以额外写SQL计算 
insert into indent(order_number,memberId,productId,count,purchase_date,account_paid)values(1,2,2,1,'2016-09-02',false);
insert into indent(order_number,memberId,productId,count,purchase_date,account_paid)values(1,2,4,1,'2016-09-02',false);
insert into indent(order_number,memberId,productId,count,purchase_date,account_paid)values(1,2,9,1,'2016-09-02',false);
 
select sum(indent.count+catalogue.current_prience) from catalogue where catalogue_id=2 and catalogue_id=4 and catalogue_id=9;






