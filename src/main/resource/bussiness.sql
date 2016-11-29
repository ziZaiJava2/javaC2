create database bussiness;
use bussiness;
create table store_online(
id int not null auto_increment,
goods varchar(30),
original int not null,
present int not null,
description varchar(50),
primary key(id)
);
select * from store_online;
alter table store_online add column count int default 99;
insert into store_online (goods,original,present,description)values('小黄书',100,199,'zyy最爱的绝版BL小说');
insert into store_online (goods,original,present,description)values('外星人电脑',20000,18999,'即使不是最牛逼的电脑，也是最贵的电脑');
insert into store_online (goods,original,present,description)values('战地1',199,99,'一战题材突突突游戏');
insert into store_online (goods,original,present,description)values('小米mix',3199,3199,'你有钱也买不到的手机');
insert into store_online (goods,original,present,description)values('奥迪跑车',399,199,'最终幻想15限量版奥迪跑车....模型');
insert into store_online (goods,original,present,description)values('java编程思想',99,79,'虽然有些人读了还是不会写代码');
insert into store_online (goods,original,present,description)values('lego星球大战-千年隼',1999,1999,'汉索罗的座驾');
insert into store_online (goods,original,present,description)values('lego星球大战-死星',2999,2999,'帝国大规模杀伤性武器');
insert into store_online (goods,original,present,description)values('小米无人机',1999,1999,'便宜是便宜，就是要小心炸机');
select * from store_online;
create table registered_users(
nickname varchar(20) not null primary key,
name varchar(20) not null,
email varchar(30) not null,
address varchar(30) not null,
account_balance int
);
insert into registered_users(nickname,name,email,address,account_balance)values('班花','张昀怡','boss1@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('我科','贾锐','boss2@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('新兵蛋子','梁绍焕','boss3@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('小短腿','宋天建','boss4@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('辉辉','彭佳辉','boss5@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('干趴印度阿三','徐嘉亮','boss6@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('吃饱就减肥','高成','boss7@bl.com','张江创意工坊',20000);
insert into registered_users(nickname,name,email,address,account_balance)values('帅瞎自己','任向杰','boss8@bl.com','张江创意工坊',20000);
select * from registered_users;
create table book(select * from store_online where goods in ('java编程思想','小黄书'));
create table game(select * from store_online where goods in('战地1'));
create table elect(select * from store_online where goods in('外星人电脑','小米Mix','小米无人机'));
create table toy(select * from store_online where goods in ('lego星球大战-千年隼','lego星球大战-死星','奥迪跑车','小米无人机','战地1'));
select * from registered_users where nickname='帅瞎自己';
select * from elect;
create table ren_order1(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into ren_order1 (user,good_id,create_date,address,state)values('帅瞎自己',2,'2016-09-02','张江创意工坊','未付款');
insert into ren_order1 (user,good_id,create_date,address,state)values('帅瞎自己',4,'2016-09-02','张江创意工坊','未付款');
insert into ren_order1 (user,good_id,create_date,address,state)values('帅瞎自己',9,'2016-09-02','张江创意工坊','未付款');
alter table ren_order1 add column count int;
update ren_order1 set count=1 where good_id in(2,4,9);
select * from ren_order1; 
select sum(present) from elect;
select e.goods,ren.count,e.original,e.present,e.present/e.original from elect e,ren_order1 ren,registered_users regis where e.id=ren.good_id and ren.user=regis.nickname;
create table ren_order2(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into ren_order2 (user,good_id,create_date,address,state)values('帅瞎自己',2,'2016-09-02','张江创意工坊','未付款');
insert into ren_order2 (user,good_id,create_date,address,state)values('帅瞎自己',4,'2016-09-02','张江创意工坊','未付款');
drop table ren_order2;
create table ren_order3(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
count int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
select * from ren_order3;
insert into ren_order3 (user,good_id,create_date,address,count,state)values('帅瞎自己',1,'2016-09-02','张江创意工坊',1,'未付款');
insert into ren_order3 (user,good_id,create_date,address,count,state)values('帅瞎自己',6,'2016-09-02','张江创意工坊',1,'未付款');
update ren_order3 set state='已付款';
update store_online set present=original where goods='小黄书';
create table zhang_order1(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
count int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into zhang_order1(user,good_id,create_date,address,count,state)values('班花',1,'2016-09-11','张江创意工坊',10,'未付款');
select * from ren_order3 ren,book b where ren.good_id=b.id and ren.good_id=1;
update store_online a,book b,game c,elect d,toy e set a.present=a.original, b.present=b.original,c.present=c.original,d.present=d.original,e.present=e.original where a.id and b.id and c.id and d.id and e.id in (1,2,3,4,5,6,7,8,9); 
select * from store_online;
create table song_order1(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
count int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into song_order1(user,good_id,create_date,address,count,state)values('小短腿',2,'2016-10-12','张江创意工坊',99,'未付款');
create table song_order2(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
count int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into song_order2(user,good_id,create_date,address,count,state)values('小短腿',2,'2016-10-12','张江创意工坊',99,'未付款');
create table song_order3(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
count int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into song_order3(user,good_id,create_date,address,count,state)values('小短腿',2,'2016-10-12','张江创意工坊',99,'未付款');
select * from book;
create table jia_order3(
user varchar(20) not null,
good_id int,
create_date date not null,
address varchar(30) not null,
total int,
count int,
state varchar(10) not null,
foreign key(user)references registered_users(nickname)
);
insert into jia_order3(user,good_id,create_date,address,count,state)values('我科',1,'2016-10-15','张江创意工坊',10,'未付款');
insert into jia_order3(user,good_id,create_date,address,count,state)values('我科',6,'2016-10-15','张江创意工坊',10,'未付款');
select * from jia_order3;
update jia_order3 set state='已付款';
update store_online a,book b,game c,elect d,toy e set a.present=a.original/2, b.present=b.original/2,c.present=c.original/2,d.present=d.original/2,e.present=e.original/2 where a.id and b.id and c.id and d.id and e.id in (1,3,4,5,6,7,8,9); 












