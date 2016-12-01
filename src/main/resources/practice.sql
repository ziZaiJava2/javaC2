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


