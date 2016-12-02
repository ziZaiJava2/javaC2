create database market;
use market;
#drop database market;

#### 2016-09-01
#老板娘让程序员给他拉了一下报告，看看有多少个用户了，有多少商品在卖了。写出SQL
create table production(
   id int not null auto_increment,
   name varchar(40) not null,
   description text,
   original_price decimal(16,4),
   price decimal(16,4),
   primary key(id)
   );

insert into production(name,description,original_price,price)
  values('lego星球大战-死星','帝国大规模杀伤性武器','2999','2999');
insert into production(name,description,original_price,price)
  values('lego星球大战-千年隼','汉索罗的座驾','1999','1999');
insert into production(name,description,original_price,price)
  values('小黄书','zyy最爱的绝版BL小说','100','199');
insert into production(name,description,original_price,price)
  values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书','99','79');
insert into production(name,description,original_price,price)
  values('奥迪跑车','最终幻想15限量版奥迪跑车....模型','399','199');
insert into production(name,description,original_price,price)
  values('战地1','一战题材突突突游戏','199','99');
insert into production(name,description,original_price,price)
  values('小米mix','你有钱也买不到的手机','3199','3199');
insert into production(name,description,original_price,price)
  values('小米无人机','便宜是便宜，就是要小心炸机','1999','1999');
insert into production(name,description,original_price,price)
  values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑','20000','18999');


create table user(
   id int not null auto_increment,
   name varchar(40) not null,
   nickname varchar(100) not null,
   mailbox varchar(40) not null,
   address varchar(100) not null,
   balance decimal(16,4) not null,
   primary key(id)
   );
   
insert into user(name,nickname,mailbox,address,balance) values('任向杰','班花2号','111111@qq.com','上海电机学院','20000');
insert into user(name,nickname,mailbox,address,balance) values('宋天健','班花3号','222222@qq.com','上海电机学院','20000');
insert into user(name,nickname,mailbox,address,balance) values('ZYY','班花','333333@qq.com','上海海事大学','20000');
insert into user(name,nickname,mailbox,address,balance) values('贾锐','班草','444444@qq.com','上海海洋大学','20000');
insert into user(name,nickname,mailbox,address,balance) values('梁绍焕','班草2号','555555@qq.com','上海海洋大学','20000');
insert into user(name,nickname,mailbox,address,balance) values('徐嘉亮','班草3号','666666@qq.com','上海海洋大学','20000');
insert into user(name,nickname,mailbox,address,balance) values('高成','班草4号','777777@qq.com','上海海洋大学','20000');




# lego星球大战-千年隼， lego星球大战-死星，奥迪跑车，战地1，小米无人机，归入玩具分类
# java编程思想，小黄书，归入了图书分类
# 战地1，归入到了游戏分类
# 外星人电脑，小米Mix，小米无人机，归入到了电子产品分类
create table category(
   id int not null auto_increment,
   name varchar(40) not null,
   primary key(id)
   );
   
insert into category(name) values('游戏');
insert into category(name) values('图书');
insert into category(name) values('电子产品');
insert into category(name) values('玩具');

create table production_category(
   production_id int,
   category_id int
   ); 
insert into production_category(production_id,category_id) 
  values(6,1);
insert into production_category(production_id,category_id) 
  values(3,2);
insert into production_category(production_id,category_id) 
  values(4,2);
insert into production_category(production_id,category_id) 
  values(7,3);
insert into production_category(production_id,category_id) 
  values(8,3);
insert into production_category(production_id,category_id) 
  values(9,3);
insert into production_category(production_id,category_id) 
  values(1,4);
insert into production_category(production_id,category_id) 
  values(2,4);
insert into production_category(production_id,category_id) 
  values(5,4);
insert into production_category(production_id,category_id) 
  values(8,4);
insert into production_category(production_id,category_id) 
  values(6,4);


#select p.id, c.id from production p, category c
#where p.name = '战地1' and c.name = '游戏';


#订单显示：创建日期，用户，地址，总价，订单状况：未付款
create table orders(
  id int not null auto_increment,
  user_id int not null,
  create_date date not null,
  address varchar(100) not null,
  total decimal(16,4),
  state varchar(40) not null,
  primary key(id)
  );



create table orders_production(
   orders_id int,
   production_name varchar(40) not null,
   price decimal(16,4) not null,
   count int,
   state varchar(40) not null
   );


#### 2016-09-02
#任向杰进了商城，查看了一下自己的个人信息，写出SQL
select * from user where nickname = '班花2号';

#他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品，写出SQL
select * from production p,category c,production_category pc where p.id=pc.production_id and category_id=c.id and c.name='电子产品';

#他看了下总价，发现买不起，只好退出了商城，留下了未付款的订单
insert into orders(user_id,create_date,address,total,state)
  values(1,'2016-09-02','上海电机学院','25999','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  1,p.name, p.price, 1 ,'未付款'
		from production p, production_category pc, category c 
			where p.id = pc.production_id and c.id = pc.category_id and c.name = '电子产品'; 
  
#select 1,p.id,1,p.price from production p,category c,production_category pc where p.id = pc.production_id and c.id = pc.category_id and c.name = '电子产品';
   
#列出了所有相关商品名称，数量，原价，实际价格和折扣率。
select p.name,op.count,p.original_price,p.price,p.price/original_price
     from production p ,orders_production op
	 where op.production_name = p.name and op.orders_id = 1  ;



#数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix，发现还是买不起...,写出生成订单的SQL
insert into orders(user_id,create_date,address,total,state)
  values(1,'2016-09-02','上海电机学院','22198','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  2,p.name, p.price, 1 ,'未付款'
		from production p
			where  p.name in ('外星人电脑' , '小米mix');

#这次他选择了取消了订单，这张订单被移除掉了，写出SQL
delete from orders where id = 2;
  
#他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单。写出SQL
insert into orders(user_id,create_date,address,total,state)
  values(1,'2016-09-02','上海电机学院','278','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  3,p.name, p.price, 1 ,'未付款'
		from production p
			where  p.name in ('java编程思想' , '小黄书');
            
#然后付款，写出SQL。虽然数学不好，但是最终还是下单成功
update orders set state = '已付款' where id = 3;
update orders_production set state = '已付款' where orders_id = 3;
update user set balance = '19722' where id = 1;
  


#### 2016-09-11
#老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价。写出SQL
update production set price = original_price where name = '小黄书';

#守候多时的zyy赶紧跳了出来，下单买了10本小黄书，写出SQL
insert into orders(user_id,create_date,address,total,state)
  values(3,'2016-09-11','上海海事大学','1000','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  4,p.name, p.price, 10 ,'未付款'
		from production p
			where  p.name = '小黄书';
#然后付款，写出SQL。
update orders set state ='已付款' where id = 4;
update orders_production set state = '已付款' where orders_id = 4;
update user set balance = '19000' where id = 3;
  
  
#任向杰进来看到小黄书买的原价了，他觉得自己好像买贵了，所以回去查看了一下自己的订单，发现果然买贵了。写出SQL
select * from production where name = '小黄书';
select * from orders_production where orders_id = 3;


#### 2016-10-10
#为了迎接双十一的到来，老板娘决定先把所有商品都调回原价，请用一条SQL完成
update production set price = original_price;

##### 2016-10-12

#宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款。写出SQL
insert into orders(user_id,create_date,address,total,state)
  values(2,'2016-10-12','上海电机学院','1980000','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  5,p.name, p.price, 99 ,'未付款'
		from production p
			where  p.name = '外星人电脑';
            
insert into orders(user_id,create_date,address,total,state)
  values(2,'2016-10-12','上海电机学院','1980000','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  6,p.name, p.price, 99 ,'未付款'
		from production p
			where  p.name = '外星人电脑';
            
insert into orders(user_id,create_date,address,total,state)
  values(2,'2016-10-12','上海电机学院','1980000','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  7,p.name, p.price, 99 ,'未付款'
		from production p
			where  p.name = '外星人电脑';

#### 2016-10-15
#贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看，写出SQL
select * from production p,category c,production_category pc where p.id=pc.production_id and category_id=c.id and c.name='图书';


#发现只有两本书，觉得好少，只好各买了10本，下单，付款，写出SQL
insert into orders(user_id,create_date,address,total,state)
  values(4,'2016-10-15','上海海洋学院','1990','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  8,p.name, p.price, 10 ,'未付款'
		from production p, production_category pc, category c 
			where p.id = pc.production_id and c.id = pc.category_id and c.name = '图书';
update orders set state = '已付款' where id = 8;
update orders_production set state = '已付款' where orders_id = 8;
update user set balance = '18010' where id = 4;


#### 2016-11-10
# 老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半，一条SQL完成
update production set price = original_price/2 where name != '外星人电脑';

##### 2016-11-11
#梁绍焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块。写出SQL
update user set balance = 25000 where name = '梁绍焕';
update user set balance = 15000 where name = '徐嘉亮';

#然后梁绍焕下单买了一台外星人电脑和两张战地1，付款，写出SQL
insert into orders(user_id,create_date,address,total,state)
  values(5,'2016-11-11','上海海洋学院','20199','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  9,p.name, p.price, 1 ,'未付款'
		from production p
			where  p.name = '外星人电脑';
insert into orders_production(orders_id ,production_name,price,count,state)
	select  9,p.name, p.price, 2 ,'未付款'
		from production p
			where  p.name = '战地1';
update orders set state = '已付款' where id = 9;
update orders_production set state = '已付款' where orders_id = 9;
update user set balance = '4801' where id = 5;

# 高成买了台小米无人机，并下单付款，写出SQL
insert into orders(user_id,create_date,address,total,state)
  values(7,'2016-11-11','上海海洋学院','999.5','未付款');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  10,p.name, p.price, 1 ,'未付款'
		from production p
			where  p.name = '小米无人机';
update orders_production set state = '已付款' where orders_id = 10;
update orders set state = '已付款' where id = 10;
update user set balance = '19000.5' where id = 7;


#### 2016-11-12
#双11之前总的销售额
select sum(total) from orders where create_date < '2016-11-11' and  state = '已付款';

#双11当天总的销售额
select sum(total) from orders where create_date = '2016-11-11' and  state = '已付款';

#总共的销售额
select sum(total) from orders where state = '已付款';

#各种商品及他们销售量的列表
select production_name, sum(count)
   from orders_production
   where state = '已付款' 
   group by production_name;

# 花钱最多的客户的名称
select p.name,op.count,p.original_price,p.price,p.price/original_price
     from production p ,orders_production op
	 where op.production_name = p.name and op.orders_id = 1  ;


# 每个客户的订单数量的列表(错误)
select u.name,op.count
from orders o,user u,orders_production op
where  u.id = op.orders_id and o.user_id =u.id ;




# 订单金额最大的订单
select max(total) 
from orders  where state = '已付款' ;




# 哪些商品至今销量为0
select name from production 
   where name not in (
   select production_name from orders_production where production_name=production.name
   );


# 老板娘觉得未完成订单有点多, 他找出了创建未完成订单数量最多的人，SQL，并将他的账号删除了，SQL（错误）
select u.name, op.count 
from orders o,user u,orders_production op
	where  u.id=o.user_id   and o.state = '未付款' 
    group by u.name;
      
    
    
delete from user where name = '宋天健';


