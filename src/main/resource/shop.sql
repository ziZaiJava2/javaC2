create database shop;
use shop;
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
create table production_category(
    production_id int,
    category_id int
);
insert into production(name, description, original_price, price)
	value('小米mix' , '你有钱也买不到的手机' , 3199 , 3199);
insert into production(name, description, original_price, price)
	value('java编程思想' , '虽然有些人读了还是不会写代码，但真的是本好书' , 99 , 79);
insert into production(name, description, original_price, price)
	value('lego星球大战-千年隼' , '汉索罗的座驾' , 1999 , 1999);
insert into production(name, description, original_price, price)
	value('奥迪跑车' , '最终幻想15限量版奥迪跑车...模型' , 399 , 199);
insert into production(name, description, original_price, price)
	value('lego星球大战-死星' , '帝国大规模杀伤性武器' , 2999 , 2999);
insert into production(name, description, original_price, price)
	value('小米无人机' , '便宜是便宜，就是要小心炸机' , 1999 , 1999);
insert into production(name, description, original_price, price)
	value('战地1' , '一战题材突突突游戏' , 199 , 99);
insert into production(name, description, original_price, price)
	value('外星人电脑' , '即使不是最牛逼的电脑，也是最贵的电脑' , 20000 , 18999);
insert into production(name, description, original_price, price)
	value('小黄书' , 'zyy最爱的绝版BL小说' , 100 , 199);
create table users(
   id int not null auto_increment,
   name varchar(40) not null,
   nickname varchar(100) not null,
   mailbox varchar(40) not null,
   address varchar(100) not null,
   balance DECIMAL(16, 4) not null,
   primary key(id)
);
insert into users(name,nickname,mailbox,address,balance) values('张昀怡','班花','boss1@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('贾锐','我科','boss2@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('梁绍焕','新兵蛋子','boss3@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('宋天建','小短腿','boss4@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('彭佳辉','辉辉','boss5@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('徐嘉亮','干趴印度阿三','boss6@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('高成','吃饱就减肥','boss7@bl.com','张江创意工坊',20000);
insert into users(name,nickname,mailbox,address,balance) values('任向杰','帅瞎自己','boss8@bl.com','张江创意工坊',20000);
insert into category(name) values('玩具');
insert into category(name) values('游戏');
insert into category(name) values('图书');
insert into category(name) values('电子产品');
select * from category;
select * from production;
select * from users;
insert into production_category 
(production_id, category_id)
select p.id, c.id from production p, category c
where p.name = '战地1' and c.name = '游戏';
insert into production_category 
(production_id, category_id)
select p.id, c.id from production p, category c
where p.name in ('lego星球大战-千年隼','lego星球大战-死星','奥迪跑车','战地1','小米无人机')and c.name = '玩具';
insert into production_category 
(production_id, category_id)
select p.id, c.id from production p, category c
where p.name in ('java编程思想','小黄书') and c.name = '图书';
insert into production_category 
(production_id, category_id)
select p.id, c.id from production p, category c
where p.name in ('外星人电脑','小米Mix','小米无人机') and c.name = '电子产品';
select * from users where nickname='帅瞎自己';
select * from production a,category b,production_category c where a.id=c.production_id and b.id=c.category_id and b.name='电子产品';
create table orders(
  id int not null auto_increment, 
  create_date date not null,
  address varchar(100) not null,
  user_name varchar(20) not null,
  primary key(id)
);
create table orders_production(
	orders_id int, 
    production_id int, 
    price decimal(16, 4),
    count int,
    state varchar(10)
);

insert into orders(
  create_date,
  address,
  user_name
) values (
	'2016-11-30',
    '张江创意工坊',
    '帅瞎自己'
); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 1, p.id, p.price, 1,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and c.name = '电子产品'; 
select sum(count * price) from orders_production where orders_id=1;
select p.name,op.count,p.original_price,op.price,op.price/p.original_price from production p,orders_production op where op.production_id=p.id;
insert into orders_production(
	orders_id,
    production_id,
    price,
    count
)
select 1, p.id, p.price, 1 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name in ('外星人电脑','小米Mix');
delete from orders_production where production_id in(1,8) limit 2;
insert into orders_production(
	orders_id,
    production_id,
    price,
    count
)
select 1, p.id, p.price, 1 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name in ('java编程思想','小黄书');
select * from orders;
select * from orders_production;
update orders_production set state='已付款' where production_id in (2,9);
update production p set p.price = p.original_price; 
insert into orders(
  create_date,
  address,
  user_name
) values (
	'2016-09-11',
    '张江创意工坊',
    '班花'
); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 2, p.id, p.price, 10,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '小黄书'; 
update orders_production set state='已付款' where production_id in (9);
select * from orders_production where orders_id=1;
insert into orders(
  create_date,
  address,
  user_name
) values (
	'2016-09-11',
    '张江创意工坊',
    '小短腿'
); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 3, p.id, p.price, 99,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '外星人电脑'; 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 3, p.id, p.price, 99,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '外星人电脑'; 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 3, p.id, p.price, 99,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '外星人电脑'; 
select p.name from production p,category c,production_category pc where p.id=pc.production_id and category_id=c.id and c.name='图书'; 
insert into orders(
  create_date,
  address,
  user_name
) values (
	'2016-10-15',
    '张江创意工坊',
    '我科'
); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 4, p.id, p.price, 10,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name in('java编程思想','小黄书'); 
update orders_production set state='已付款' where production_id in (2,9);
update production p set p.price = p.original_price/2 where p.name != '外星人电脑';
update users set balance=25000 where users.id=3;
update users set balance=15000 where users.id=6;
insert into orders(
  create_date,
  address,
  user_name
) values (
	'2016-10-15',
    '张江创意工坊',
    '新兵蛋子'
); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 5, p.id, p.price, 1,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name in('外星人电脑'); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 5, p.id, p.price, 2,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name in('战地1');
update orders_production set state='已付款' where production_id in (7,8) and orders_id=5;
insert into orders(
  create_date,
  address,
  user_name
) values (
	'2016-10-15',
    '张江创意工坊',
    '吃饱就减肥'
); 
insert into orders_production(
	orders_id,
    production_id,
    price,
    count,
    state
)
select 6, p.id, p.price, 1,'未付款' 
from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name in('小米无人机');
update orders_production set state='已付款' where production_id in (6) and orders_id=6;
select sum(price*count) from orders_production where state='已付款';
select p.name,op.count from production p,orders_production op where op.production_id=p.id group by(p.name);






