create database mall;
use mall;
#品名：小黄书，描述：zyy最爱的绝版BL小说，原价：100，现价：199
#外星人电脑，即使不是最牛逼的电脑，也是最贵的电脑，原价：20000，现价：18999
#战地1，一战题材突突突游戏，原价：199，现价：99
#小米mix，你有钱也买不到的手机，原价：3199，现价：3199
#奥迪跑车，最终幻想15限量版奥迪跑车....模型，原价：399，现价：199
#java编程思想，虽然有些人读了还是不会写代码，但真是本好书，原价：99，现价：79
#lego星球大战-千年隼，汉索罗的座驾，原价：1999， 现价：1999
#lego星球大战-死星，帝国大规模杀伤性武器，原价：2999， 现价：2999
#小米无人机，便宜是便宜，就是要小心炸机，原价：1999，现价：1999

create table production(
   id int not null auto_increment,
   name varchar(40) not null,
   discription text,
   original_price decimal(16,4),
   price decimal(16,4),
   primary key(id)
   );

insert into production(name,discription,original_price,price)
  values('lego星球大战-死星','帝国大规模杀伤性武器','2999','2999');
insert into production(name,discription,original_price,price)
  values('lego星球大战-千年隼','汉索罗的座驾','1999','1999');
insert into production(name,discription,original_price,price)
  values('小黄书','zyy最爱的绝版BL小说','100','199');
insert into production(name,discription,original_price,price)
  values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书','99','79');
insert into production(name,discription,original_price,price)
  values('奥迪跑车','最终幻想15限量版奥迪跑车....模型','399','199');
insert into production(name,discription,original_price,price)
  values('战地1','一战题材突突突游戏','199','99');
insert into production(name,discription,original_price,price)
  values('小米mix','你有钱也买不到的手机','3199','3199');
insert into production(name,discription,original_price,price)
  values('小米无人机','便宜是便宜，就是要小心炸机','1999','1999');
insert into production(name,discription,original_price,price)
  values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑','20000','18999');
  
create table category(
   id int not null auto_increment,
   name varchar(40) not null,
   primary key(id)
   );

insert into category(name)values('游戏');
insert into category(name)values('图书');
insert into category(name)values('电子产品');
insert into category(name)values('玩具');

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
  
    create table user(
  id int not null auto_increment,
  name varchar(40),
  nickname varchar(100),
  email varchar(200),
  adress varchar(200),
  account decimal(16, 4) not null,
  primary key(id)

  );
  
insert into user( name, nickname,email, adress, account)values( '任向杰', '交作业的御用宠物', '11@qq.com', '上海电机学院', '20000');
insert into user( name, nickname,email, adress, account)values( '贾瑞', '假瑞', '22@qq.com', '上海海洋大学', '20000');
insert into user( name, nickname,email, adress, account)values( '高成', '永远在赶作业', '33@qq.com', '上海海洋大学', '20000');
insert into user( name, nickname,email, adress, account)values( 'zyy', '班花', '44@qq.com', '上海海事大学', '20000');
insert into user( name, nickname,email, adress, account)values( '梁教官', '被女朋友潜规则', '55@qq.com', '上海海洋大学', '20000');
insert into user( name, nickname,email, adress, account)values( '宋天健', '超级帅', '66@qq.com', '上海电机学院', '20000');
insert into user( name, nickname,email, adress, account)values( '徐嘉良', '拳打印度人', '77@qq.com', '上海海洋大学', '20000');
drop table orders;
create table orders(
  id int not null auto_increment, 
  create_date date not null,
  address varchar(200) not null ,
  state varchar(40) not null,
  user_id int not null,
  primary key(id)
  );
drop table production_order;
  create table production_order(
  productiono_id int,
  orders_id int,
  number int,
  price decimal(16,4)
);

#老板娘让程序员给他拉了一下报告，看看有多少个用户了，有多少商品在卖了。写出SQL
select * from production;
select * from user;

#任向杰进了商城，查看了一下自己的个人信息，写出SQL

select * from user where name = '任向杰';
#他看到余额有两万，心理暗爽一把，选中了电子产品，查看了一下所有的电子产品，写出SQL
select * from production p, category c , production_category pc where p.id = pc.production_id and c.id = pc.category_id and c.name = '电子产品';
#然后把所有的电子产品都选上，生成了一个订单，写出SQL，并写出下面信息的查询SQL，总价可以额外写SQL计算
 insert into orders(create_date, address, state, user_id)values('2016-9-02', '上海电机学院','未知付', 1);
  insert into production_order(productiono_id, orders_id,  number, price )
  select  
  p.id,
  1,
  1,
  p.price
  from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id and c.name = '电子产品';
 #数学没学好的他想了想，又进来创了一个订单，这次选了外星人电脑和小米Mix，发现还是买不起...,写出生成订单的SQL 
  insert into orders(create_date, address, state, user_id)values('2016-9-02', '上海电机学院','未知付', 1);
insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 2, 1,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id and p.name !=  '小米无人机' and c.name = '电子产品';
#订单显示：创建日期，用户，地址，总价，订单状况：未付款。
#列出了所有相关商品名称，数量，原价，实际价格和折扣率。
#提示：我们写sql可以多个字段进行计算的，比如可以写：

select * , po.price*po.number as allpay from orders , production_order po where state = '未知付' ; 

#他十分沮丧，决定学好知识，决定Java编程思想和小黄书各买一本回去学习，下订单。写出SQL
insert into orders(create_date, address, state, user_id)values('2016-9-02', '上海电机学院','支付', 1);
insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 3, 1,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and c.name = '图书';
  
  #老板娘看到小黄书卖不动，觉得可能是价格定太高，所以下调价格到了原价。写出SQL
  update production set price = original_price where name = '小黄书';
  
  #守候多时的zyy赶紧跳了出来，下单买了10本小黄书，写出SQL
  insert into orders(create_date, address, state, user_id)values('2016-9-02', '上海海洋大学','支付', 4);
  insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 4, 10,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '小黄书';
  
  #为了迎接双十一的到来，老板娘决定先把所有商品都调回原价，请用一条SQL完成
  update production set price = original_price ;
  
  #宋天健跑进来，发现线上居然比线下还买的贵，很气愤，创建了3个订单，每个订单都买了99台外星人电脑，然后不付款。写出SQL
    insert into orders(create_date, address, state, user_id)values('2016-10-12', '上海电机学院','未支付', 6);
    insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 5, 99,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '外星人电脑';
  
   insert into orders(create_date, address, state, user_id)values('2016-10-12', '上海电机学院','未支付', 6);
    insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 6, 99,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '外星人电脑';
  
   insert into orders(create_date, address, state, user_id)values('2016-10-12', '上海电机学院','未支付', 6);
    insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 7, 99,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '外星人电脑';
  
  #贾锐最近书看完了，所以跑到商城点开了图书分类，查看一下有什么书能买来看看，写出SQL
#发现只有两本书，觉得好少，只好各买了10本，下单，付款，写出SQL

 insert into orders(create_date, address, state, user_id)values('2016-10-12', '上海电机学院','支付', 6);
    insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 8, 10,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  c.name = '图书';
  
  #老板娘在双十一之前把所有商品，除了外星人电脑外，价格调整为原价的一半，一条SQL完成
  update production set price = original_price / 2 where name != '外星人电脑';
  
  #梁邵焕想买一台外星人，然后两张战地1回去和女朋友联机玩，但是钱不够，所以他和徐嘉亮借了5000块。写出SQL
  update user set account = account + 5000 where name = '梁教官';
    update user set account = account - 5000 where name = '徐嘉良';
    
    #然后梁邵焕下单买了一台外星人电脑和两张战地1，付款，写出SQL
     insert into orders(create_date, address, state, user_id)values('2016-10-12', '上海电机学院','支付', 5);
    insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 9, 1,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '外星人电脑';
     insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 9, 2,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '战地1';
  
  #高成买了台小米无人机，并下单付款，写出SQL
    insert into orders(create_date, address, state, user_id)values('2016-11-11', '上海电机学院','支付', 5);
      insert into production_order(productiono_id, orders_id,  number, price )
  select  p.id, 10, 1,p.price from production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id  and  p.name = '小米无人机';
    
    
    #双11之前总的销售额
    select sum(po.price * po.number) as allpay from production_order po , orders o where o.create_date = '2016-9-02' and o.state = '支付';
    
    #双11当天总的销售额
    select sum(po.price * po.number) as allpay from production_order po , orders o where o.create_date = '2016-11-11' and o.state = '支付';
    
    #各种商品及他们销售量的列表
    select po.number as sellnumber , p.name from production_order po , orders o ,production p , category c, production_category pc where  p.id = pc.production_id and c.id = pc.category_id and o.state = '支付';