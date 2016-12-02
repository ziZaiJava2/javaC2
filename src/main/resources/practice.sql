create database store;
use store;
#创建商品表

create table production(
id int not null auto_increment,
name varchar(100) not null,
description text,
original_price DECIMAL(16, 4),
price DECIMAL(16, 4),
primary key(id)
);

#创建商品分类表
create table category(
id int not null auto_increment,
name varchar(40) not null,
primary key(id)
);



#创建商品和商品分类的关联表
create table production_category(
production_id int,
category_id int
);
insert into production(name, description, original_price, price)

	value('小黄书' , 'zyy最爱的绝版BL小说' , 100 , 199);
insert into production(name, description, original_price, price)

	value('外星人电脑' , '即使不是最牛逼的电脑，也是最贵的电脑' , 20000 , 18999);
insert into production(name, description, original_price, price)

	value('战地1' , '一战题材突突突游戏' , 199 , 99);
insert into production(name, description, original_price, price)

	value('小米mix' , '你有钱也买不到的手机' , 3199 , 3199);
insert into production(name, description, original_price, price)

	value('奥迪跑车' , '最终幻想15限量版奥迪跑车...模型' , 399 , 199);
insert into production(name, description, original_price, price)

	value('java编程思想' , '虽然有些人读了还是不会写代码，但真的是本好书' , 99 , 79);
insert into production(name, description, original_price, price)

	value('lego星球大战-千年隼' , '汉索罗的座驾' , 1999 , 1999);
insert into production(name, description, original_price, price)

	value('lego星球大战-死星' , '帝国大规模杀伤性武器' , 2999 , 2999);
insert into production(name, description, original_price, price)
    
    value('小米无人机' , '便宜是便宜，就是要小心炸机' , 1999 , 1999);








#用户表

create table users(
id int not null auto_increment,
name varchar(40) not null,
nickname varchar(100) not null,
mailbox varchar(40) not null,
address varchar(100) not null,
balance DECIMAL(16, 4) not null,
primary key(id)
);



#向用户表插入数据

insert into users(name,nickname,mailbox,address,balance) values('张昀怡','yi','boss1@bl.com','沪城环路1号',20000);
insert into users(name,nickname,mailbox,address,balance) values('梁绍焕','huan','huhuhu@huhu.com','沪城环路2号',20000);
insert into users(name,nickname,mailbox,address,balance) values('高成','cheng','xixixi@xixi.com','沪城环路3号',20000);
insert into users(name,nickname,mailbox,address,balance) values('宋天建','jian','lololo@lolo.com','沪城环路4号',20000);
insert into users(name,nickname,mailbox,address,balance) values('贾锐','rui','lalala@lala.com','沪城环路5号',20000);
insert into users(name,nickname,mailbox,address,balance) values('任向杰','jie','huohuohuo@huohuo.com','沪城环路6号',20000);
insert into users(name,nickname,mailbox,address,balance) values('彭佳辉','hui','hahaha@haha.com','沪城环路7号',20000);
insert into users(name,nickname,mailbox,address,balance) values('徐嘉亮','liang','heiheihei@heihei.com','沪城环路8号',20000);

#插入分类
insert into category(name) values('toy');
insert into category(name) values('game');
insert into category(name) values('book');
insert into category(name) values('electronic_products');

select * from category;

select * from production;

select * from users;



#向商品分类关联表插入数据

insert into production_category (production_id, category_id)
select p.id, c.id from production p, category c where p.name = '战地1' and c.name = 'game';

insert into production_category (production_id, category_id)
select p.id, c.id from production p, category c where p.name in ('战地1','奥迪跑车','lego星球大战-千年隼','lego星球大战-死星','小米无人机')and c.name = 'toy';

insert into production_category (production_id, category_id)
select p.id, c.id from production p, category c where p.name in ('小黄书','java编程思想') and c.name = 'book';

insert into production_category (production_id, category_id)
select p.id, c.id from production p, category c where p.name in ('外星人电脑','小米Mix','小米无人机') and c.name = 'electronic_products';

select * from users where nickname='jie';



#订单表
create table orderr(
id int not null auto_increment, 
create_date date not null,
address varchar(100) not null,
user_name varchar(20) not null,
primary key(id)
);

#生成订单
create table orderr_production(
orders_id int, 
production_id int, 
price decimal(16, 4),
state varchar(10),
count int
);

#任向杰进了商城，查看了一下自己的个人信息
select *from users where name='任向杰';
#查看了一下所有的电子产品
select * from production p,category c,production_category p_c 
where p.id=p_c.production_id and c.id=p_c.category_id and c.name='electronic_products';


insert into orderr(create_date,address,user_name) values ('2016-09-02','沪城环路6号','jie'); 
#然后把所有的电子产品都选上，生成了一个订单
insert into orderr_production(orders_id,production_id,price,count,state)
select 1, p.id, p.price, 1,'未付款' 
from production p, production_category p_c, category c where p.id = p_c.production_id 
and c.id = p_c.category_id
and c.name = 'electronic_products'; 
#他看了下总价，发现买不起，只好退出了商城，留下了未付款的订单
select sum(count * price) from orderr_production where orders_id=1;
#数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix，发现还是买不起
insert into orderr_production(orders_id,production_id,price,count)
select 1, p.id, p.price, 1 from production p, production_category p_c, category c 
where p.id = p_c.production_id 
and c.id = p_c.category_id
and p.name in ('外星人电脑','小米Mix');
#这次他选择了取消了订单，这张订单被移除掉了
delete from orderr_production where production_id in(2,4) limit 2;

select*from production;

#他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单
select 1, p.id, p.price, 1 from production p, production_category p_c, category c 
where p.id = p_c.production_id 
and c.id = p_c.category_id
and p.name in ('小黄书','java编程思想');
select*from production;
#然后付款
update orderr_production set state='已付款' where production_id in (1,6);
#老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价
update production set production.price = production.original_price; 
#守候多时的zyy赶紧跳了出来，下单买了10本小黄书
insert into orderr_production(orders_id,production_id,price,count)
select 1, p.id, p.price, 10 from production p, production_category p_c, category c 
where p.id = p_c.production_id 
and c.id = p_c.category_id
and p.name in ('小黄书');
#然后付款
update orderr_production set state='已付款' where production_id in (1);

#任向杰进来看到小黄书买的原价了，他觉得自己好像买贵了，所以回去查看了一下自己的订单，发现果然买贵了
select * from orderr_production where orders_id=1;
#老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半
update production p set p.price = p.original_price/2 where p.name != '外星人电脑';
#宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款
insert into orderr(create_date,address,user_name) values ('2016-10-12','沪城环路4号','jian'); 

insert into orderr_production(orders_id,production_id,price,count,state)
select 3, p.id, p.price, 99,'未付款' from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '外星人电脑'; 
select*from orderr_production;

insert into orderr_production(orders_id,production_id,price,count,state)
select 4, p.id, p.price, 99,'未付款' from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '外星人电脑'; 
select*from orderr_production;

insert into orderr_production(orders_id,production_id,price,count,state)
select 5, p.id, p.price, 99,'未付款' from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = '外星人电脑'; 
select*from orderr_production;

#贾锐最近书看完了，所 以跑到商城点开了图书分类，查看一下有什么书能买来看看
select * from production p,category c,production_category p_c 
where p.id=p_c.production_id and c.id=p_c.category_id and c.name='book';

#发现只有两本书，觉得好少，只好各买了10本，下单，付款
insert into orderr_production(orders_id,production_id,price,count,state)
select 6, p.id, p.price, 10,'已付款' from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = ('小黄书'); 

insert into orderr_production(orders_id,production_id,price,count,state)
select 6, p.id, p.price, 10,'已付款' from production p, production_category pc, category c 
where p.id = pc.production_id 
and c.id = pc.category_id
and p.name = ('java编程思想'); 
delete from orderr_production where production_id in(1) limit 2;
select *from production;
#梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块



