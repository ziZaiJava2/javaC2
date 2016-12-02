create database shop_new;
use shop_new;

drop table production;
drop table category;
drop table production_category;
drop table users;
drop table orders_production;
drop table orders;



/*商品表*/
create table production(
id int not null auto_increment,
name varchar(40) not null,
description text,
original_price decimal(16,4),
price decimal(16,4),
primary key(id)
);
insert into production(name,description,original_price,price)values('小黄书','老纸最爱的绝版BL小说',100,199);
insert into production(name,description,original_price,price)values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑',20000,18999);
insert into production(name,description,original_price,price)values('战地1','一战题材突突突游戏',199,99);
insert into production(name,description,original_price,price)values('小米mix','你有钱也买不到的手机',3199,3199);
insert into production(name,description,original_price,price)values('奥迪跑车','最终幻想15限量版奥迪跑车....模型',399,199);
insert into production(name,description,original_price,price)values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书',99,79);
insert into production(name,description,original_price,price)values('lego星球大战-千年隼','汉索罗的座驾',1999,1999);
insert into production(name,description,original_price,price)values('lego星球大战-死星','帝国大规模杀伤性武器',2999,2999);
insert into production(name,description,original_price,price)values('小米无人机','便宜是便宜，就是要小心炸机',1999,1999);

select * from production;



/*商品种类*/
create table category(
id int not null auto_increment,
name varchar(40) not null,
primary key(id)
);
insert into category(name) values('玩具');
insert into category(name) values('图书');
insert into category(name) values('游戏');
insert into category(name) values('电子产品');

select * from category;



/*商品-种类*/
create table production_category(
production_id int,
category_id int
);
insert into production_category(production_id,category_id) values(1,2);
insert into production_category(production_id,category_id) values(2,4);
insert into production_category(production_id,category_id) values(3,1);
insert into production_category(production_id,category_id) values(3,3);
insert into production_category(production_id,category_id) values(4,4);
insert into production_category(production_id,category_id) values(5,1);
insert into production_category(production_id,category_id) values(6,2);
insert into production_category(production_id,category_id) values(7,1);
insert into production_category(production_id,category_id) values(8,1);
insert into production_category(production_id,category_id) values(9,1);
insert into production_category(production_id,category_id) values(9,4);

select * from production_category;



/*订单*/
create table orders(
id int not null auto_increment,
create_date date not null,
address varchar(40),
state varchar(40) not null,
user_id int not null,
primary key(id)
);



/*用户*/
create table users(
id int not null auto_increment,
name varchar(40) not null,
cute_name varchar(40) not null,
address varchar(40) not null,
qqaddress varchar(40),
money decimal(16,4),
primary key(id)
);
insert into users(name,cute_name,address,qqaddress,money)values('张昀怡','独领风骚数百年','自己编吧，我编不下去了','boss@bl.com',20000);
insert into users(name,cute_name,address,qqaddress,money)values('任向杰','交作业机器','小叮当工场','pet@bl.com',20000);
insert into users(name,cute_name,address,qqaddress,money)values('宋天建','小娃','小小小屋子','dayi@bl.com',20000);
insert into users(name,cute_name,address,qqaddress,money)values('贾锐','屎了','坟墓','byebye@bl.com',20000);
insert into users(name,cute_name,address,qqaddress,money)values('梁绍焕','基佬1','徐嘉亮家','girlfriend@bl.com',20000);
insert into users(name,cute_name,address,qqaddress,money)values('徐嘉亮','基佬2','梁绍焕家','liangshaohuan@bl.com',20000);
insert into users(name,cute_name,address,qqaddress,money)values('高成','公务员','师父家里','homework@bl.com',20000);
select * from users;



/*订单-商品*/
create table orders_production(
orders_id int,
production_id int,
price decimal(16,4),
count int
);

select * from orders;



/*2016-09-01*/
/*老板娘让程序员给他拉了一下报告，看看有多少个用户了，有多少商品在卖了*/
select count(*) from users;
select count(*) from production;



/*2016-09-02*/
/*任向杰进了商城，查看了一下自己的个人信息*/
select * from users where users.name = '任向杰';

/*他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品*/
select * from production p,category c,production_category pc where c.name = '电子产品' and pc.production_id =p.id and pc.category_id = c.id;

/*然后把所有的电子产品都选上，生成了一个订单*/
insert into orders_production(orders_id ,production_id ,count,price)select 1,p.id,1,p.price from production p,category c ,production_category pc
where c.name = '电子产品' and c.id = pc.category_id and p.id = pc.production_id;
insert into orders(create_date ,address ,state ,user_id )select '2016-09-02',u.address,'未付款',2 from users u where u.name ='任向杰'; 
select * from orders_production;
select * from orders;

/*订单显示：创建日期，用户，地址，总价，订单状况：未付款。列出了所有相关商品名称，数量，原价，实际价格和折扣率。*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=1 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;
select p.name,op.count,p.original_price ,p.price ,p.price / p.original_price from production p,orders_production op,orders ord where p.id = op.production_id and ord.id = 1 and op.orders_id = ord.id;

/*他看了下总价，发现买不起，只好退出了商城，留下了未付款的订单
数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix，发现还是买不起...,写出生成订单的SQL*/

insert into orders (create_date,address ,state ,user_id) select '2016-09-02',u.address,'未付款',2 from users u where u.id=2;
insert into orders_production(orders_id ,production_id ,count,price) select 2,p.id,1,p.price from production p where p.name = '外星人电脑' or p.name='小米Mix';

/*查看自己订单*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=2 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;
select p.name,op.count,p.original_price ,p.price ,p.price / p.original_price from production p,orders_production op,orders ord where p.id = op.production_id and ord.id = 2 and op.orders_id = ord.id;

/*这次他选择了取消了订单，这张订单被移除掉了，写出SQL*/
delete from orders where orders.id = 2;
delete from orders_production where orders_production.orders_id = 2;

/*他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单。写出SQL*/
insert into orders (create_date,address ,state ,user_id) select '2016-09-02',u.address,'未付款',2 from users u where u.id=2;
insert into orders_production(orders_id ,production_id ,count,price) select 3,p.id,1,p.price from production p where p.name = '小黄书' or p.name='Java编程思想';
/*查看买书的订单*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=3 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;

/*然后付款，写出SQL。虽然数学不好，但是最终还是下单成功*/
start transaction;
update users set money = money - 278 where users.id = 2;
update orders set state = '已付款' where orders.id = 3;
commit;

select * from orders_production;
select * from orders;



/*2016-09-11
老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价。*/
update production set price = original_price where name = '小黄书';
/*守候多时的zyy赶紧跳了出来，下单买了10本小黄书*/
insert into orders (create_date,address ,state ,user_id) select '2016-09-11',u.address,'未付款',1 from users u where u.id=1;
insert into orders_production(orders_id ,production_id ,count,price) select 4,p.id,10,p.price from production p where p.name = '小黄书';
/*查看小黄书总价*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=4 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;

/*然后付款*/
start transaction;
update users set money = money - 1000 where users.id = 1;
update orders set state = '已付款' where orders.id = 4;
commit;
/*查看扣钱成功了没*/
select * from users where name = '张昀怡';


/*任向杰进来看到小黄书买的原价了，他觉得自己好像买贵了，所以回去查看了一下自己的订单，发现果然买贵了。*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=3 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;
select p.name,op.count,p.original_price ,p.price ,p.price / p.original_price from production p,orders_production op,orders ord where p.id = op.production_id and ord.id = 3 and op.orders_id = ord.id;


/*2016-10-10
为了迎接双十一的到来，老板娘决定先把所有商品都调回原价*/
update production set price = original_price;
select * from production;

/*2016-10-12*/
/*宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款*/
insert into orders (create_date,address ,state ,user_id) select '2016-10-12',u.address,'未付款',3 from users u where u.id=3;
insert into orders_production(orders_id ,production_id ,count,price) select 5,p.id,99,p.price from production p where p.name = '外星人电脑';

insert into orders (create_date,address ,state ,user_id) select '2016-10-12',u.address,'未付款',3 from users u where u.id=3;
insert into orders_production(orders_id ,production_id ,count,price) select 6,p.id,99,p.price from production p where p.name = '外星人电脑';

insert into orders (create_date,address ,state ,user_id) select '2016-10-12',u.address,'未付款',3 from users u where u.id=3;
insert into orders_production(orders_id ,production_id ,count,price) select 7,p.id,99,p.price from production p where p.name = '外星人电脑';



/*2016-10-15
贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看*/
select * from production p,category c,production_category pc where c.name = '图书' and pc.production_id = p.id and c.id = pc.category_id;
/*发现只有两本书，觉得好少，只好各买了10本，下单，付款*/
insert into orders (create_date,address ,state ,user_id) select '2016-10-15',u.address,'未付款',4 from users u where u.id=4;
insert into orders_production(orders_id ,production_id ,count,price) select 8,p.id,10,p.price from production p,category c ,production_category pc 
where c.name='图书' and pc.production_id = p.id and c.id = pc.category_id;
start transaction;
update users set money = money - 1990 where users.id = 4;
update orders set state = '已付款' where orders.id = 8;
commit;
/*查看贾锐的订单*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=8 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;
select p.name,op.count,p.original_price ,p.price ,p.price / p.original_price from production p,orders_production op,orders ord where p.id = op.production_id and ord.id = 8 and op.orders_id = ord.id;



/*016-11-10
老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半，一条SQL完成*/
update production set price = original_price /2 where name != '外星人电脑';
/*查看商品*/
select * from production;

/*2016-11-11
梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块。*/
start transaction;
update users set money = money + 5000 where name = '梁绍焕';
update users set money = money - 5000 where name = '徐嘉亮';
commit;
/*查看他们两个现金*/
select * from users where name = '梁绍焕' or name = '徐嘉亮';

/*然后梁邵焕下单买了一台外星人电脑和两张战地1，付款*/
insert into orders (create_date,address ,state ,user_id) select '2016-11-11',u.address,'未付款',5 from users u where u.id=5;
insert into orders_production(orders_id ,production_id ,count,price) select 9,p.id,1,p.price from production p where p.name = '外星人电脑';
insert into orders_production(orders_id ,production_id ,count,price) select 9,p.id,2,p.price from production p where p.name = '战地1';
/*查看订单*/
select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op
where ord.id=9 and u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id;
select p.name,op.count,p.original_price ,p.price ,p.price / p.original_price from production p,orders_production op,orders ord where p.id = op.production_id and ord.id = 9 and op.orders_id = ord.id;
/*付款*/
start transaction;
update users set money = money - 20199 where users.id = 5;
update orders set state = '已付款' where orders.id = 9;
commit;

/*高成买了台小米无人机，并下单付款*/
insert into orders (create_date,address ,state ,user_id) select '2016-11-11',u.address,'未付款',7 from users u where u.id=7;
insert into orders_production(orders_id ,production_id ,count,price) select 10,p.id,1,p.price from production p where p.name = '小米无人机';
start transaction;
update users set money = money - 999.5 where users.id = 7;
update orders set state = '已付款' where orders.id = 10;
commit;



/*2016-11-12
双11之前总的销售额*/
select sum(op.price * op.count) from orders_production op ,orders ord where ord.create_date < '2016-11-11' and op.orders_id = ord.id and ord.state = '已付款';
/*双11当天总的销售额*/
select sum(op.price * op.count) from orders_production op ,orders ord where ord.create_date = '2016-11-11' and op.orders_id = ord.id and ord.state = '已付款';
/*总共的销售额*/
select sum(op.price * op.count) from orders_production op ,orders ord where op.orders_id = ord.id and ord.state = '已付款';
/*各种商品及他们销售量的列表*/
select p.name ,sum(op.count) from production p,orders_production op ,orders ord where op.orders_id = ord.id and op.production_id = p.id group by(p.name);
/*花钱最多的客户的名称*/
select u.name from production p,users u, orders_production op ,orders ord 
where ord.state = '已付款' and op.orders_id = ord.id and op.production_id = p.id and ord.user_id = u.id
group by(u.name) order by(sum(op.count * p.price)) desc limit 1;/*为什么 limit 1,1 显示的是高成*/

/*每个客户的订单数量的列表*/
select u.name , count(A.orders_id) from(select * from orders_production group by(orders_production.orders_id))A, users u,orders ord 
where A.orders_id = ord.id and ord.user_id = u.id group by(u.name);

/*订单金额最大的订单*/
select ord.create_date,u.name,ord.address,sum(p.price * op.count),ord.state from(select ord.create_date,u.name,ord.address,sum(op.price * op.count),ord.state from orders ord,users u,production p, orders_production op 
where u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id group by(op.orders_id))A, users u,orders ord ,orders_production op,production p
where u.id = ord.user_id and op.orders_id = ord.id and op.production_id = p.id group by(ord.id) order by(sum(p.price * op.count)) desc
limit 1 ;

/*哪些商品至今销量为0*/
/*没做出来!!*/
select p.name ,op.count from
(select p.name ,sum(op.count) from production p,orders_production op ,orders ord where op.orders_id = ord.id and op.production_id = p.id group by(op.production_id))A,
 production p,orders_production op ,orders ord
 where p.name != A.name and op.production_id = p.id;

(select p.name ,sum(op.count) from production p,orders_production op ,orders ord where op.orders_id = ord.id and op.production_id = p.id group by(op.production_id))A;

/*老板娘觉得未完成订单有点多
他找出了创建未完成订单数量最多的人，
并将他的账号删除了*/
select u.name , count(A.orders_id) from(select * from orders_production group by(orders_production.orders_id))A, users u,orders ord 
where A.orders_id = ord.id and ord.user_id = u.id and ord.state = '未付款' group by(u.name) order by count(A.orders_id) desc limit 1;

delete from users where users.name = '宋天建';
select * from users;


/*上课笔记*/
/*判断时间可以用 大于等于 and  小于 */
/*或者between '日期' and '日期' */

/*求和函数： select sum(列名) from ……*/
/*或者*/

/*单个写某一天的话，要算0：00-0:00*/

/**/
/*update production p set p.prince = p.original_price/2 where p.name !='外星人电脑'; */