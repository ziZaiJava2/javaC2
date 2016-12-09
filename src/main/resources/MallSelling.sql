create database shop;
use shop;

create table production(
	id int not null auto_increment,
    name varchar(60) not null,
    description text,
    original_price decimal(16,4),
    price decimal(16,4),
    primary key(id)
    );
insert into production(name , description , original_price , price)
	values('小黄书','zyy最爱的绝版BL小说',100,199);
insert into production(name , description , original_price , price)
	values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑',20000,18999);
insert into production(name , description , original_price , price)
	values('战地1','一战题材突突突游戏',199,99);
insert into production(name , description , original_price , price)
	values('小米mix','你有钱也买不到的手机',3199,3199);
insert into production(name , description , original_price , price)
	values('奥迪跑车','最终幻想15限量版奥迪跑车....模型',399,199);
insert into production(name , description , original_price , price)
	values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书',99,79);
insert into production(name , description , original_price , price)
	values('lego星球大战-千年隼','汉索罗的座驾',1999,1999);
insert into production(name , description , original_price , price)
	values('lego星球大战-死星','帝国大规模杀伤性武器',2999,2999);
insert into production(name , description , original_price , price)
	values('小米无人机','便宜是便宜，就是要小心炸机',1999,1999);
select* from production;

create table serve(
	id int not null auto_increment,
    name varchar(30) not null,
    nick_name varchar(30) ,
    post_box varchar(50),
    address varchar(50),
    balance decimal(16,4),
    primary key(id)
    );
insert into serve(name, nick_name, post_box,address,balance)
	values('张昀怡','班花','boss@bl.com','SH',20000);    
insert into serve(name, nick_name, post_box,address,balance)
	values('徐嘉亮','班草','bancao@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('梁邵焕','班草','bancao@58.com','SH',20000);    
insert into serve(name, nick_name, post_box,address,balance)
	values('高成','班草','bancao@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('贾锐','班草','bancao@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('金倩玉','班花','boss@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('彭佳辉','班草','bancao@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('任向杰','班草','bancao@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('宋天健','班草','bancao@58.com','SH',20000);
select* from serve;

create table category(
	id int not null auto_increment,
	name varchar(40) not null,
    primary key(id)
);
insert into category(name) values('玩具');
insert into category(name) values('游戏');
insert into category(name) values('图书');
insert into category(name) values('电子产品');
select* from category;

create table production_category(
	production_id int, 
	category_id int
);
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '战地1' and c.name = '游戏';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = 'lego星球大战-千年隼' and c.name = '玩具';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = 'lego星球大战-死星' and c.name = '玩具';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '奥迪跑车' and c.name = '玩具';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '战地1' and c.name = '玩具';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '小米无人机' and c.name = '玩具';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = 'java编程思想' and c.name = '图书';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '小黄书' and c.name = '图书';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '外星人电脑' and c.name = '电子产品';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '小米Mix' and c.name = '电子产品';
insert into production_category (production_id, category_id)
	select p.id, c.id from production p, category c where p.name = '小米无人机' and c.name = '电子产品';
select* from production_category;

#2016-09-02 
#任向杰进了商城，查看了一下自己的个人信息，写出SQL
select *from serve where name = '任向杰';
#选中了电子产品，查看了一下所有的电子产品
select * from production p, category c, production_category pc where c.name = '电子产品' and pc.production_id= p.id and pc.category_id  = c.id;
#把所有的电子产品都选上，生成了一个订单
create table orders(
	id int not null ,
    create_date date not null,
    serve_name varchar(20),
    address varchar(100) not null,   
    total decimal(16,4),
	state text,
    primary key(id)
    );
insert into orders(id,create_date,address,state,serve_name)
	values(1,'2016-09-02','SH','未付款','任向杰');    
select*from orders;
create table orders_production(
orders_id int,
production_name varchar(40),
price decimal(16,4),
count int,
state varchar(20)
);
insert into orders_production(orders_id ,production_name,price,count,state)
	select  1,p.name, p.price, 1 ,'未付款'
		from production p, production_category pc, category c 
			where p.id = pc.production_id and c.id = pc.category_id and c.name = '电子产品'; 
#列出了所有相关商品名称，数量，原价，实际价格和折扣率。
select p.name,op.count,p.original_price,p.price,p.price/p.original_price 
	from production p,orders_production op 
		where op.production_name=p.name and op.orders_id = 1;
#总价
select sum(price*count) from orders_production where orders_id =1;
update orders set total=24197 where id = 1;
#创了一个订单，
insert into orders(id,create_date,address,state,serve_name)
	values(2,'2016-09-02','SH','未付款','任向杰');
#这次选了外星人电脑和小米Mix
insert into orders_production(orders_id ,production_name,price,count,state)
	select  2,p.name, p.price, 1 ,'未付款'
		from production p
			where p.name in ('外星人电脑','小米Mix');
#列出了所有相关商品名称，数量，原价，实际价格和折扣率。
select p.name,op.count,p.original_price,p.price,p.price/p.original_price 
	from production p,orders_production op 
		where op.production_name=p.name and op.orders_id = 2;
#总价
select sum(price*count) from orders_production where orders_id =2;
update orders set total=22198 where id = 2;
#选择了取消了订单，这张订单被移除掉了
delete from orders_production where orders_id = 2;
#决定Java编程思想和小黄书各买一本回去学习，下订单
insert into orders(id,create_date,address,state,serve_name)
	values(3,'2016-09-02','SH','未付款','任向杰');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  3,p.name, p.price, 1 ,'未付款'
		from production p
			where  p.name in ('Java编程思想','小黄书');
select sum(price*count) from orders_production where orders_id =3;
update orders set total=278 where id = 3;
update orders_production set state='已付款' where orders_id = 3;  
update orders set state='已付款' where id = 3;  
#扣钱    
update serve set balance= 20000-278 where name = '任向杰';  
select*from serve;       
		
#2016-09-11
#老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价
update production p set p.price = p.original_price where name = '小黄书'; 
#守候多时的zyy赶紧跳了出来，下单买了10本小黄书
insert into orders(id,create_date,address,state,serve_name)
	values(4,'2016-09-11','SH','未付款','张昀怡');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  4,p.name, p.price, 10 ,'未付款'
		from production p
			where  p.name ='小黄书';    
#总价
select sum(price*count) from orders_production where orders_id =4;    
update orders set total=1000 where id = 4;
update orders_production set state='已付款' where orders_id = 4;  
update orders set state='已付款' where id = 4;
#扣钱    
update serve set balance= 20000-1000 where name = '张昀怡';  
select*from serve;    
#任向杰进来看到小黄书买的原价了，他觉得自己好像买贵了，所以回去查看了一下自己的订单，发现果然买贵了
select * from orders_production where orders_id=3;

#2016-10-10
#为了迎接双十一的到来，老板娘决定先把所有商品都调回原价
update production p set p.price = p.original_price;
select*from production;

#2016-10-12
#宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款
#1
insert into orders(id,create_date,address,state,serve_name)
	values(5,'2016-10-10','SH','未付款','宋天健');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  5,p.name, p.price, 99 ,'未付款'
		from production p
			where p.name ='外星人电脑'; 
select sum(price*count) from orders_production where orders_id =5;
update orders set total=1980000 where id = 5;
#2
insert into orders(id,create_date,address,state,serve_name)
	values(6,'2016-10-10','SH','未付款','宋天健');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  6,p.name, p.price, 99 ,'未付款'
		from production p
			where  p.name ='外星人电脑'; 
select sum(price*count) from orders_production where orders_id =6;
update orders set total=1980000 where id = 6;            
#3
insert into orders(id,create_date,address,state,serve_name)
	values(7,'2016-10-10','SH','未付款','宋天健');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  7,p.name, p.price, 99 ,'未付款'
		from production p
			where  p.name ='外星人电脑';    
select sum(price*count) from orders_production where orders_id =7;
update orders set total=1980000 where id = 7;            

#2016-10-15
#贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看
select *from production p,production_category pc ,category c 
	where p.id = pc.production_id and c.id = pc.category_id and c.name = '图书';
#发现只有两本书，觉得好少，只好各买了10本，下单，付款
insert into orders(id,create_date,address,state,serve_name)
	values(8,'2016-10-15','SH','未付款','贾锐');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  8,p.name, p.price, 10 ,'未付款'
		from production p, production_category pc, category c 
			where p.id = pc.production_id and c.id = pc.category_id and c.name ='图书'; 
#总价            
select sum(price*count) from orders_production where orders_id =8;  
update orders set total=1990 where id = 8;             
update orders_production set state='已付款' where orders_id = 8;       
update orders set state='已付款' where id = 8;             
#扣钱    
update serve set balance= 20000-1990 where name = '贾锐';  
select*from serve;               

#2016-11-10
#老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半  
update production set price=original_price/2 where name != '外星人电脑'; 
select*from production;

#2016-11-11
#梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块
update serve set balance= 20000-5000 where name = '徐嘉亮';  
update serve set balance= 20000+5000 where name = '梁邵焕';  
#然后梁邵焕下单买了一台外星人电脑和两张战地1，付款
insert into orders(id,create_date,address,state,serve_name)
	values(9,'2016-11-11','SH','未付款','梁邵焕');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  9,p.name, p.price, 1 ,'未付款'
		from production p
			where p.name ='外星人电脑'; 
insert into orders_production(orders_id ,production_name,price,count,state)
	select  9,p.name, p.price, 2 ,'未付款'
		from production p
			where p.name ='战地1'; 
#总价
select sum(price*count) from orders_production where orders_id =9; 
update orders set total=20199 where id = 9;   
update orders_production set state='已付款' where orders_id = 9;
update orders set state='已付款' where id = 9;   
#扣钱    
update serve set balance= 25000-20199 where name = '梁邵焕';  
select*from serve;               
#高成买了台小米无人机，并下单付款
insert into orders(id, create_date,address,state,serve_name)
	values(10,'2016-11-11','SH','未付款','高成');
insert into orders_production(orders_id ,production_name,price,count,state)
	select  10,p.name, p.price, 1 ,'未付款'
		from production p
			where p.name ='小米无人机'; 
#总价
select sum(price*count) from orders_production where orders_id =10; 
update orders set total=999.5 where id = 10;   
update orders_production set state='已付款' where orders_id = 10;   
update orders set state='已付款' where id = 10;   
#扣钱    
update serve set balance= 20000-999.5 where name = '高成';  
select*from serve;                
 
#2016-11-12
#双11之前总的销售额    
select sum(total) from orders 
	where  create_date<'2016-11-11'  and state ='已付款'; 
    
#双11当天总的销售额
select sum(total) from orders 
	where  create_date>'2016-11-10' and create_date<'2016-11-12' and state ='已付款'; 
#select sum(op.price*op.count) from orders_production op,orders o, production p,serve s
#	where  o.serve_name = s.name and o.create_date>'2016-11-10' and  o.create_date<'2016-11-12' 
#		and o.id = op.orders_id and op.state = '已付款' and o.state ='已付款';    
      
#总共的销售额            
select sum(total) from orders 
	where state ='已付款';
    
#各种商品及他们销售量的列表
select production_name,sum(count) as count 
	from orders_production 
		where state = '已付款' group by production_name;

#花钱最多的客户的名称
select o.serve_name ,sum(total) from orders_production op,orders o 
	where op.count*op.price = (select MAX(count*price) 
		from orders_production op where op.state = '已付款') and o.id = op.orders_id;
        
#每个客户的订单数量的列表
select o.serve_name,op.production_name,op.count 
	from orders_production op,orders o 
		where  o.id = op.orders_id;

#订单金额最大的订单
select *from orders
	where total =(select max(total) from orders);

#哪些商品至今销量为0
select name from production 
 where   name not in 
	(select production_name 
		from orders_production 
			where production_name=production.name and orders_production.state = '已付款');

#他找出了创建未完成订单数量最多的人,并将他的账号删除了
select serve_name , count(*) from orders 
	where  state = '未付款' group by serve_name;
delete from serve where name = '宋天健';
