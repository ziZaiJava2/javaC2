#                   小
#					黄
#					书
#					作		
#					业
create database newstore;
drop database newstore;
use newstore;

select * from production;							#查看产品表
select * from category;								#查看分类表
select * from production_category;					#查看产品分类关联表
select * from users;								#查看用户表
select * from ordertable_production;				#查看订单商品
select * from ordertable;							#查看创建订单
drop table ordertable_production;
#创建产品表
create table production(
	id int not null auto_increment,
    name varchar(40) not null,
    description text,
    original_price DEC(16,4),
    price decimal,
    primary key(id)
);
#插入所有出售产品数据
insert into production(name, description, original_price, price)
	values('小黄书' , 'zyy最爱的绝版BL小说' , 100 , 199);
insert into production(name, description, original_price, price)
	values('小米mix' , '你有钱也买不到的手机' , 3199 , 3199);
insert into production(name, description, original_price, price)
	values('战地1' , '一战题材突突突游戏' , 199 , 99);
insert into production(name, description, original_price, price)
	values('java编程思想' , '虽然有些人读了还是不会写代码，但真的是本好书' , 99 , 79);
insert into production(name, description, original_price, price)
	values('lego星球大战-千年隼' , '汉索罗的座驾' , 1999 , 1999);
insert into production(name, description, original_price, price)
	values('奥迪跑车' , '最终幻想15限量版奥迪跑车...模型' , 399 , 199);
insert into production(name, description, original_price, price)
	values('lego星球大战-死星' , '帝国大规模杀伤性武器' , 2999 , 2999);
insert into production(name, description, original_price, price)
	values('小米无人机' , '便宜是便宜，就是要小心炸机' , 1999 , 1999);
insert into production(name, description, original_price, price)
	values('外星人电脑' , '即使不是最牛逼的电脑，也是最贵的电脑' , 20000 , 18999);

#创建分类表
create table category(
	id int not null auto_increment,
    name varchar(40) not null,
    primary key(id)
);
#往分类表中插入分类
insert into category(name)values('toyclass');
insert into category(name)values('electronicProductclass');
insert into category(name)values('bookclass');
insert into category(name)values('gameclass');

#创建产品分类关联表
create table production_category(
	production_id int,
    category_id int
);
#往产品分类关联表中插入数据
insert into production_category(production_id,category_id)values(1,3);
insert into production_category(production_id,category_id)values(2,2);
insert into production_category(production_id,category_id)values(3,4);
insert into production_category(production_id,category_id)values(4,3);
insert into production_category(production_id,category_id)values(5,1);
insert into production_category(production_id,category_id)values(6,1);
insert into production_category(production_id,category_id)values(7,1);
insert into production_category(production_id,category_id)values(8,2);
insert into production_category(production_id,category_id)values(9,2);
insert into production_category(production_id,category_id)values(8,1);
insert into production_category(production_id,category_id)values(3,1);

#创建用户表
create table users(
   id int not null auto_increment,
   name varchar(40) not null,
   nickname varchar(100) not null,
   mailbox varchar(40) not null,
   address varchar(100) not null,
   balance decimal(16, 4),
   primary key(id)
   );
   update users set users.name='zyy' where users.id=1;
#往用户表中插入用户
insert into users(name, nickname, mailbox, address, balance)
	value('zyy' , '海事管理阿姨' , '1198688584@qq.com', '上海', 20000);
insert into users(name, nickname, mailbox, address, balance)
	value('贾锐' , '海洋大三大佬' , '785110837@qq.com', '安徽',  20000);
insert into users(name, nickname, mailbox, address, balance)
	value('宋天健' , '电机大一大佬' , '524000659@qq.con', '贵州', 20000);
insert into users(name, nickname, mailbox, address, balance)
	value('彭家辉' , '电机大二大佬' , '1572538214@qq.com', '百慕大', 20000);
insert into users(name, nickname, mailbox, address, balance)
	value('徐嘉亮' , '海洋大四兵哥' , '928440876@qq.com', '上海', 20000);
insert into users(name, nickname, mailbox, address, balance)
	value('梁绍焕' , '海洋大四武警哥' , '1572538214@qq.com', '广西', 20000);
insert into users(name, nickname, mailbox, address, balance)
	value('高成' , '胖益达' , '1742036996@qq.com', '留尼旺岛', 20000);
insert into users(name, nickname, mailbox, address, balance)
	value('任向杰' , '电机大二学生' , '1021031476@qq.com', '河北', 20000);

#创建订单表
create table ordertable(
	id int not null auto_increment,
    date date,
    users_name varchar(40)not null,
	address varchar(40) not null,
    total decimal(16, 4),
	whethertopay varchar(40),
    primary key(id)
);

#创建订单商品关联表
create table ordertable_production(
	ordersnumber int not null,
    name varchar(40),
    count int,
    originalprice decimal,
    currentprice decimal
);



delete from production where id=10 or id=11 or id=12 or id =13;
##################################          2016-09-01          ##################################

#老板娘让程序员给他拉了一下报告，看看有多少个用户了，有多少商品在卖了。写出SQL
select * from users;
#老板娘觉得商品太多太乱，所以决定添加一些分类，把商品归结到不同分类下面去，这部分SQL也放入到最开头去吧。

##################################          2016-09-02          ##################################

#任向杰进了商城，查看了一下自己的个人信息，写出SQL
select * from users where users.name='任向杰';
#他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品，写出SQL
select p.* from production p,category c, production_category pc 
	where p.id=pc.production_id 
    and c.id=pc.category_id 
    and c.name='electronicProductclass';
#然后把所有的电子产品都选上，生成了一个订单，写出SQL，
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-09-02', '任向杰', '河北', null,'未付款'); 
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 1, p.name, 1, p.original_price, p.price from production p, category c,production_category pc
		where c.name='electronicProductclass'
        and  p.id=pc.production_id
        and  c.id=pc.category_id;
#他看了下总价，发现买不起，只好退出了商城，留下了未付款的订单
update ordertable set ordertable.total=24197 where ordertable.id=1;
#update ordertable set ordertable.total=sum(ordertable_production.count * ordertable_production.currentprice) 
#数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-09-02', '任向杰', '河北', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 2, p.name, 1, p.original_price, p.price from production p
		where p.name='外星人电脑' or p.name='小米mix';
#，发现还是买不起...,
update ordertable set ordertable.total=22198 where ordertable.id=2;
#这次他选择了取消了订单，这张订单被移除掉了，写出SQL
delete  from ordertable where ordertable.id=2;
#他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单。写出SQL
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-09-02', '任向杰', '河北', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 3, p.name, 1, p.original_price, p.price from production p
		where p.name='Java编程思想' or p.name='小黄书';
#看了总价，发现买得起，随即付款。虽然数学不好，但是最终还是下单成功
update ordertable set ordertable.total=278 where ordertable.id=3;
update users set users.balance=(users.balance - 278) where users.name='任向杰';
update ordertable set ordertable.whethertopay='已付款' where ordertable.id=3;

##################################          2016-09-11          ##################################

#老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价。写出SQL
update production set production.price=production.original_price where production.name='小黄书';
#守候多时的zyy赶紧跳了出来，下单买了10本小黄书，写出SQL
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-09-11', 'zyy', '上海', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 4, p.name, 10, p.original_price, p.price from production p
		where p.name='小黄书';
#然后付款，写出SQL。
update ordertable set ordertable.total=1000 where ordertable.id=4;
update users set users.balance=(users.balance - 1000) where users.name='zyy';
update ordertable set ordertable.whethertopay='已付款' where ordertable.id=4;
#任向杰进来看到小黄书买的原价了，他觉得自己好像买贵了，所以回去查看了一下自己的订单，发现果然买贵了。写出SQL
#(有点问题，想不出来)
select * from ordertable o, ordertable_production op 
	where o.users_name='任向杰' 							
	and o.whethertopay='已付款'
	and o.id=op.ordersnumber;

##################################          2016-10-10          ##################################

#为了迎接双十一的到来，老板娘决定先把所有商品都调回原价，请用一条SQL完成
update production set production.price=production.original_price;

##################################          2016-10-12          ##################################

#宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款。写出SQL
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-10-12', '宋天健', '贵州', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 5, p.name, 99, p.original_price, p.price from production p
		where p.name='外星人电脑';
update ordertable set ordertable.total=1980000 where ordertable.id=5;

insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-10-12', '宋天健', '贵州', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 6, p.name, 99, p.original_price, p.price from production p
		where p.name='外星人电脑';
update ordertable set ordertable.total=1980000 where ordertable.id=6;

insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-10-12', '宋天健', '贵州', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 7, p.name, 99, p.original_price, p.price from production p
		where p.name='外星人电脑';
update ordertable set ordertable.total=1980000 where ordertable.id=7;
        
##################################          2016-10-15          ##################################

#贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看，写出SQL
select p.* from production p,category c, production_category pc 
	where p.id=pc.production_id 
    and c.id=pc.category_id 
    and c.name='bookclass';
#发现只有两本书，觉得好少，只好各买了10本，下单，付款，写出SQL
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-10-15', '贾锐', '安徽', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 8, p.name, 10, p.original_price, p.price from production p
		where p.name='java编程思想' or p.name='小黄书';
update ordertable set ordertable.total=1990 where ordertable.id=8;
update ordertable set ordertable.whethertopay='已付款' where ordertable.id=8;
update users set users.balance=(users.balance - 1990) where users.name='贾锐';


##################################          2016-11-10          ##################################

#老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半，一条SQL完成
update production set production.price=(production.original_price/2) where production.name!='外星人电脑';

##################################          2016-11-11          ##################################

#梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块。写出SQL
update users set users.balance=(users.balance - 5000) where users.name='徐嘉亮';
update users set users.balance=(users.balance + 5000) where users.name='梁绍焕';
#然后梁邵焕下单买了一台外星人电脑和两张战地1，付款，写出SQL
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-11-11', '梁绍焕', '山西', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 9, p.name, 1, p.original_price, p.price from production p
		where p.name='外星人电脑' ;
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 9, p.name, 2, p.original_price, p.price from production p
		where p.name='战地1';
update ordertable set ordertable.total=22000 where ordertable.id=9;
update ordertable set ordertable.whethertopay='已付款' where ordertable.id=9;
update users set users.balance=(users.balance - 22000) where users.name='梁绍焕';
#高成买了台小米无人机，并下单付款，写出SQL
insert into ordertable(date, users_name, address, total, whethertopay)
	value('2016-11-11', '高成', '留尼旺岛', null,'未付款');
insert into ordertable_production(ordersnumber, name, count, originalprice, currentprice)
	select 10, p.name, 1, p.original_price, p.price from production p
		where p.name='小米无人机' ;
update ordertable set ordertable.total=1000 where ordertable.id=10;
update ordertable set ordertable.whethertopay='已付款' where ordertable.id=10;
update users set users.balance=(users.balance - 1000) where users.name='高成';

##################################          2016-11-11          ##################################

#老板想看看最近的销售情况，让程序员写了一些SQL
#双11之前总的销售额
select sum(total) from ordertable o 
	where o.whethertopay='已付款'
    and o.date <'2016-11-11';
#双11当天总的销售额
select sum(total) from ordertable o 
	where o.whethertopay='已付款'
    and o.date ='2016-11-11';
#总共的销售额
select sum(total) from ordertable o 
	where o.whethertopay='已付款';
#各种商品及他们销售量的列表

#花钱最多的客户的名称

#每个客户的订单数量的列表

#订单金额最大的订单

#哪些商品至今销量为0

#老板娘觉得未完成订单有点多
#他找出了创建未完成订单数量最多的人，SQL

#并将他的账号删除了，SQL



 

