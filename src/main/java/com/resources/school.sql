create database shop;
use shop;

drop table goods;
drop table orders;
drop table consumer;

create table goods(
id int not null auto_increment,
name varchar(20),
introduction varchar(40),
beforeprice int ,
nowprice int ,
primary key(id)
);

create table consumer(
id int not null auto_increment,
name varchar(20),
cute_name varchar(30),
address varchar(50),
qqaddress varchar(50),
money int,
primary key(id)
);

create table orders(
id int not null auto_increment,
order_number int,
consumer_id int,
goods_id int,
count int,
buy_day date,
if_give_money boolean,
primary key(id),
foreign key(consumer_id) references consumer(id) on update no action
);

insert into goods(name,introduction,beforeprice,nowprice)values('小黄书','老纸最爱的绝版BL小说',100,199);
insert into goods(name,introduction,beforeprice,nowprice)values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑',20000,18999);
insert into goods(name,introduction,beforeprice,nowprice)values('战地1','一战题材突突突游戏',199,99);
insert into goods(name,introduction,beforeprice,nowprice)values('小米mix','你有钱也买不到的手机',3199,3199);
insert into goods(name,introduction,beforeprice,nowprice)values('奥迪跑车','最终幻想15限量版奥迪跑车....模型',399,199);
insert into goods(name,introduction,beforeprice,nowprice)values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书',99,79);
insert into goods(name,introduction,beforeprice,nowprice)values('lego星球大战-千年隼','汉索罗的座驾',1999,1999);
insert into goods(name,introduction,beforeprice,nowprice)values('lego星球大战-死星','帝国大规模杀伤性武器',2999,2999);
insert into goods(name,introduction,beforeprice,nowprice)values('小米无人机','便宜是便宜，就是要小心炸机',1999,1999);
select * from goods;

insert into consumer(name,cute_name,address,qqaddress,money)values('张昀怡','独领风骚数百年','自己编吧，我编不下去了','boss@bl.com',20000);
insert into consumer(name,cute_name,address,qqaddress,money)values('任向杰','交作业机器','小叮当工场','pet@bl.com',20000);
insert into consumer(name,cute_name,address,qqaddress,money)values('宋天建','小娃','小小小屋子','dayi@bl.com',20000);
insert into consumer(name,cute_name,address,qqaddress,money)values('贾锐','独领风骚数百年','自己编吧，我编不下去了','boss@bl.com',20000);
insert into consumer(name,cute_name,address,qqaddress,money)values('梁绍焕','基佬1','徐嘉亮家','girlfriend@bl.com',20000);
insert into consumer(name,cute_name,address,qqaddress,money)values('徐嘉亮','基佬2','梁绍焕家','liangshaohuan@bl.com',20000);
insert into consumer(name,cute_name,address,qqaddress,money)values('高成','公务员','师父家里','homework@bl.com',20000);
select * from consumer;

/*2016-09-01老板娘让程序员给他拉了一下报告，看看有多少个用户了，有多少商品在卖了。*/
select count(*) from consumer;
select count(*) from goods;


/*老板娘觉得商品太多太乱，所以决定添加一些分类，把商品归结到不同分类下面去*/
alter table goods add column kinds varchar(10);

/*lego星球大战-千年隼， lego星球大战-死星，奥迪跑车，战地1，小米无人机，归入玩具分类*/
update goods set kinds = '玩具' where goods.name = 'lego星球大战-千年隼' or goods.name ='lego星球大战-死星' 
or goods.name = '战地1' or goods.name ='小米无人机' or goods.name = '奥迪跑车';

/*java编程思想，小黄书，归入了图书分类*/
update goods set kinds ='图书' where goods.name ='java编程思想' or goods.name = '小黄书';

/*战地1，归入到了游戏分类*/
update goods set kinds ='游戏' where goods.name = '战地1';

/*外星人电脑，小米Mix，小米无人机，归入到了电子产品分类*/
update goods set kinds ='电子产品' where goods.name='外星人电脑' or goods.name = '小米无人机' or goods.name = '小米Mix';



/*2016-09-02
任向杰进了商城，查看了一下自己的个人信息
他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品*/
select * from consumer where consumer.name = '任向杰';

/*他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品*/
select * from goods where goods.kinds = '电子产品';

/*然后把所有的电子产品都选上，生成了一个订单*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(1,2,2,1,'2016-09-02',false);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(1,2,4,1,'2016-09-02',false);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(1,2,9,1,'2016-09-02',false);

select * from orders;

/*订单显示：创建日期，用户，地址，总价，订单状况：未付款。
列出了所有相关商品名称，数量，原价，实际价格和折扣率
他看了下总价，发现买不起，只好退出了商城，留下了未付款的订单*/
select ord.buy_day,con.name,con.address,sum(ord.count * goo.nowprice),ord.if_give_money  from orders ord , goods goo, consumer con 
where ord.order_number = 1 and ord.consumer_id = con.id and ord.goods_id = goo.id;
select goo.name, ord.count, goo.beforeprice, goo.nowprice ,goo.nowprice / goo.beforeprice from goods goo,orders ord,consumer con 
where ord.order_number = 1 and ord.consumer_id = con.id and ord.goods_id = goo.id ;


/*数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix，发现还是买不起...,写出生成订单*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(2,2,2,1,'2016-09-02',false);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(2,2,4,1,'2016-09-02',false);
select ord.buy_day,con.name,con.address,sum(ord.count * goo.nowprice),ord.if_give_money  from orders ord , goods goo, consumer con 
where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id;
select goo.name, ord.count, goo.beforeprice, goo.nowprice ,goo.nowprice / goo.beforeprice from goods goo,orders ord,consumer con 
where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id ;
/*这次他选择了取消了订单，这张订单被移除掉了*/
delete from orders where order_number = 2;

/*他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单
然后付款，写出SQL。虽然数学不好，但是最终还是下单成功*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(2,2,1,1,'2016-09-02',false);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(2,2,6,1,'2016-09-02',false);
start transaction;
update orders set if_give_money = true where order_number =2;
select sum(ord.count * goo.nowprice) as a from orders ord , goods goo, consumer con where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id
update consumer,goods,orders,select sum(ord.count * goo.nowprice) as a from orders ord , goods goo, consumer con where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id 
set consumer.money = consumer.money - a where orders.order_number = 2;
commit;

(select sum(ord.count * goo.nowprice) from orders ord , goods goo, consumer con where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id)a;




/*2016-09-11
老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价。写出SQL*/
update goods set nowprice = goods.beforeprice where name = '小黄书' ;

/*守候多时的zyy赶紧跳了出来，下单买了10本小黄书，写出SQL
然后付款，写出SQL。*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(3,1,1,10,'2016-09-11',false);
start transaction;
update orders set if_give_money = true where order_number =3;
update consumer,goods,orders set consumer.money = consumer.money - orders.count * goods.nowprice where orders.order_number = 3;
commit;
select * from consumer where consumer.name = '张昀怡';

/*任向杰进来看到小黄书买的原价了，他觉得自己好像买贵了，所以回去查看了一下自己的订单，发现果然买贵了。写出SQ*/
select ord.buy_day,con.name,con.address,ord.count * goo.nowprice,ord.if_give_money  from orders ord , goods goo, consumer con 
where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id;
select goo.name, ord.count, goo.beforeprice, goo.nowprice ,goo.nowprice / goo.beforeprice from goods goo,orders ord,consumer con 
where ord.order_number = 2 and ord.consumer_id = con.id and ord.goods_id = goo.id ;



/*2016-10-10为了迎接双十一的到来，老板娘决定先把所有商品都调回原价，请用一条SQL完成*/
update goods set nowprice = goods.beforeprice;


/*2016-10-12
宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款。写出SQL*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(4,3,2,99,'2016-10-12',false);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(5,3,2,99,'2016-10-12',false);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(6,3,2,99,'2016-10-12',false);



/*2016-10-15
贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看，写出SQL*/
select * from goods where kinds='图书';

/*发现只有两本书，觉得好少，只好各买了10本，下单，付款，写出SQL*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(7,4,1,10,'2016-10-15',true);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(7,4,6,10,'2016-10-15',true);

/*2016-11-10老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半，一条SQL完成*/
update goods set goods.nowprice = goods.beforeprice / 2 where goods.name !='外星人电脑';

/*2016-11-11
梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块。写出SQL
然后梁邵焕下单买了一台外星人电脑和两张战地1，付款，写出SQL*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(8,5,2,1,'2016-11-11',true);
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(8,5,3,2,'2016-11-11',true);



/*高成买了台小米无人机，并下单付款，写出SQL*/
insert into orders(order_number,consumer_id,goods_id,count,buy_day,if_give_money)values(9,7,9,1,'2016-11-11',true);

/*2016-11-12老板想看看最近的销售情况，让程序员写了一些SQL
双11之前总的销售额*/
(where orders.buy_day <'2016-11-11')
/*双11当天总的销售额*/
(where orders.buy_day = '2016-11-11')
/*总共的销售额*/
(sum函数求和)
/*各种商品及他们销售量的列表*/
(select goo.name,ord.count from goods goo ,orders ord  group by goods.name)
/*花钱最多的客户的名称*/
(select con.name from consumer con ,orders ord limit 1 offset 1 group by ord.consumer_id order by(sum_money)
/*每个客户的订单数量的列表*/
(select con.name,ord.number from consumer con, orders ord where ord.consumer_id = con.id group by ord.number)
/*订单金额最大的订单*/
(按照升序排列，限制只显示一个)
/*哪些商品至今销量为0*/
(select goo.name from good goo ,orders ord where group by)
/*老板娘觉得未完成订单有点多
他找出了创建未完成订单数量最多的人，SQL
并将他的账号删除了，SQL*/
（where ord.if_give_money = false group by name order by(if_give_money)）
delete from consumer where consumer.name = '宋天建';