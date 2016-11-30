create database mall;
use mall;
#创建toy表
create table toy(
id int not null,
name varchar(40) not null,
price int not null,
nowPrice int not null,
primary key(id)
);
#创建book表
create table book(
id int not null,
name varchar(40) not null,
price int not null,
nowPrice int not null,
primary key(id)
);
#创建game表
create table game(
id int not null,
name varchar(40) not null,
price int not null,
nowPrice int not null,
primary key(id)
);
创建电子产品表
create table eGood(
id int not null,
name varchar(40) not null,
price int not null,
nowPrice int not null,
primary key(id)
);
#将各类商品分类
insert into toy(id, name, price, nowprice)values(01, 'lego星球大战-千年隼', 1999, 1999);
insert into toy(id, name, price, nowprice)values(02, 'lego星球大战-死星', 2999 ,2999);
insert into toy(id, name, price, nowprice)values(03, '奥迪跑车', 399, 199);
insert into toy(id, name, price, nowprice)values(04, '小米无人机', 1999, 1999);
insert into book(id, name, price, nowprice)values(05,'java编程思想', 99, 79);
insert into book(id, name, price, nowprice)values(06, '小黄书', 100, 99);
insert into game(id, name, price, nowprice)values(07, '战地1', 199, 99);
insert into eGood(id, name, price, nowprice)values(08, '外星人电脑', 20000, 18999);
insert into eGood(id, name, price, nowprice)values(09, '小米Mix', 3199, 3199);
insert into eGood(id, name, price, nowprice)values(010, '小米无人机', 1999, 1999);
insert into toy(id, name, price, nowprice)values(011, '小米无人机', 1999, 1999);


#创建用户信息表
create table user(
id int not null,
name varchar(40) not null,
eamil varchar(200) not null,
account int not null,
primary key(id)
);
insert into user(id, name, eamil, account)values(11, '任祥杰', '11@qq.com' , 20000);
insert into user(id, name, eamil, account)values(22, '宋天健', '22@qq.com' , 10000);
insert into user(id, name, eamil, account)values(66, '徐嘉良', '22@qq.com' , 15000);
insert into user(id, name, eamil, account)values(33, '贾瑞', '33@qq.com' , 8000);
insert into user(id, name, eamil, account)values(44, '梁教官', '44@qq.com' , 5000);
insert into user(id, name, eamil, account)values(55, 'zyy', '55@qq.com' , 3000);
insert into user(id, name, eamil, account)values(77, '高成', '77@qq.com' , 3000);
#创建订单表
create table orders(
id int ,
goodId int,
custome_id int ,
order_date date,
selled int ,
state varchar(30),
price int 
);
#看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品，写出SQL
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(1, 8, 11, '2016-12-1', 1, '未支付', 18999);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(1, 9, 11, '2016-12-1', 1, '未支付', 3199);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(1, 10, 11, '2016-12-1', 1, '未支付', 1999);
select  nowPrice / price, name  from book;
#数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix，发现还是买不起...,写出生成订单的SQL
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(2, 8, 11, '2016-12-1', 1, '未支付', 18999);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(2, 9, 11, '2016-12-1', 1, '未支付', 3199);
#他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单。写出SQL
#然后付款，写出SQL。虽然数学不好，但是最终还是下单成功
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(3, 5, 11, '2016-12-1', 1, '未支付', 79);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(3, 6, 11, '2016-12-1', 1, '未支付', 99);
#老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价。写出SQL
update orders set state = '已支付' where id = 3 ;
update user set account  = account - 178 where id = 11; 
update book set nowPrice = 99 where name = '小黄书';
#守候多时的zyy赶紧跳了出来，下单买了10本小黄书，写出SQL
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(4, 6, 55, '2016-12-1', 10, '支付', 990);
update user set account = account - 990 where id = 55;
#老板娘决定先把所有商品都调回原价，请用一条SQL完成
update toy t, book b , egood e set t.nowPrice = t.price ,  b.nowPrice = b.price , e.nowPrice = e.price;

#宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款。写出SQL
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(5, 8, 22, '2016-12-1', 99, '未支付', 18999*99);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(6, 8, 22, '2016-12-1', 99, '未支付', 18999*99);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(7, 8, 22, '2016-12-1', 99, '未支付', 18999*99);

select * from bool;
#贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看，写出SQL
#发现只有两本书，觉得好少，只好各买了10本，下单，付款，写出SQL
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(8, 5, 33, '2016-12-1', 10, '未支付', 990);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(8, 6, 33, '2016-12-1', 10, '未支付', 1000);
#老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半，一条SQL完成
update toy t, book b, egood e set t.nowPrice = t.nowPrice / 2 , b.nowprice  = b.nowprice / 2 , e.nowPrice = e.nowPrice / 2;

update user set account = 19000 where id = 44;

update user set account = 1000 where id = 66;

update user set account = 19198 where id = 44;
update user set account = 10000-198 where id = 22;
#梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块。写出SQL
#然后梁邵焕下单买了一台外星人电脑和两张战地1，付款，写出SQL
#高成买了台小米无人机，并下单付款，写出SQL
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(9, 7, 44, '2016-12-1', 2, '支付', 198);
insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(9, 8, 44, '2016-12-1', 1,'支付', 18999);

update user set account = account - (198+18999) where id = 44;

insert into orders(id, goodId, custome_id, order_date, selled, state, price)values(10, 10, 77, '2016-12-1', 10, '支付', 1999);
update user set account = account - 1999 where id = 77;

alter table toy add column selled int;
alter table book add column selled int;
alter table egood add column selled int;
alter table game add column selled int;

select selled from orders where goodid = 5 and state = '支付';
update book set selled  = 11*99 where  id = 5;
select selled from orders where goodid = 6 and state = '支付';
update book set selled  = 21*100 where  id = 6;
select selled from orders where goodid = 7 and state = '支付';
update game set selled = 1*99 where id = 7;
select selled from orders where goodid = 8 and state = '支付';
update toy set selled = 1*18999 where id = 8;

#各种商品及他们销售量的列表
#花钱最多的客户的名称
#每个客户的订单数量的列表

update orders set state = '支付' where custome_id = 33; 
select user.
#他找出了创建未完成订单数量最多的人，SQL
#并将他的账号删除了，SQL
select user.name, orders.id as order_id, orders.order_date,orders.goodId,orders.selled,orders.price  from user  , orders where custome_id = user.id and orders.state != '未支付';  
select c.name, count(c.state) as mostnoPay  from (select user.name , orders.state , orders.custome_id from orders, user where orders.state = '未支付' and user.id = orders.custome_id and count(orders.state) > 5) as c ;
delete from user where name = '任祥杰';

#订单金额最大的订单
select user.name, orders.id as order_id, orders.order_date,orders.goodId,orders.selled,orders.price  from user  , orders where custome_id = user.id and orders.state != '未支付' order by price desc;
#每个客户的订单数量的列表
select user.name, orders.id as order_id, orders.order_date,orders.goodId,orders.selled  from user  , orders where custome_id = user.id and orders.state != '未支付' order by selled desc;    
