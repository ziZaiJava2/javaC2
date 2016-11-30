create database school5;
use school5;


create table products(
   id int not null auto_increment,
   name varchar(40) not null,
   introduction varchar(100) not null,
   original_price int not null,
   current_prience int not null,
   primary key(id)
   );
   
create table user(
   id int not null auto_increment,
   name varchar(40) not null,
   nickname varchar(100) not null,
   mailbox varchar(40) not null,
   address varchar(100) not null,
   balance double not null,
   primary key(id)
   );



insert into products(name,introduction,original_price,current_prience) values('lego星球大战-千年隼','汉索罗的座驾','1999','1999');
insert into products(name,introduction,original_price,current_prience) values('小黄书','zyy最爱的绝版BL小说','100','199');
insert into products(name,introduction,original_price,current_prience) values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书','99','79');
insert into products(name,introduction,original_price,current_prience) values('lego星球大战-死星','帝国大规模杀伤性武器','2999','2999');
insert into products(name,introduction,original_price,current_prience) values('奥迪跑车','最终幻想15限量版奥迪跑车....模型','399','199');
insert into products(name,introduction,original_price,current_prience) values('战地1','一战题材突突突游戏','199','99');
insert into products(name,introduction,original_price,current_prience) values('小米mix','你有钱也买不到的手机','3199','3199');
insert into products(name,introduction,original_price,current_prience) values('小米无人机','便宜是便宜，就是要小心炸机','1999','1999');
insert into products(name,introduction,original_price,current_prience) values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑','20000','18999');

select * from products;


insert into user(name,nickname,mailbox,address,balance) values('张昀怡','班花','1151231@bqq.com','上海杨浦','20000');
insert into user(name,nickname,mailbox,address,balance) values('徐加亮','班猪','1151232@bqq.com','上海奉贤','20000');
insert into user(name,nickname,mailbox,address,balance) values('高  成','班牛','1151233@bqq.com','陕西宝鸡','20000');
insert into user(name,nickname,mailbox,address,balance) values('彭佳慧','班羊','1151234@bqq.com','中国二号','20000');
insert into user(name,nickname,mailbox,address,balance) values('宋天健','班花尾号','1151235@bqq.com','中国三号','20000');
insert into user(name,nickname,mailbox,address,balance) values('任向杰','班花2号','1151236@bqq.com','中国四号','20000');
insert into user(name,nickname,mailbox,address,balance) values('贾锐','班花三号','1151237@bqq.com','安徽一号','20000');
insert into user(name,nickname,mailbox,address,balance) values('金庆玉','班花大大','1151238@bqq.com','中国五号','20000');
insert into user(name,nickname,mailbox,address,balance) values('梁绍焕','班草','1151239@bqq.com','中国广西','20000');

select * from user;

alter table products add column Type varchar(40);
update products set Type = 'toy'  where name = 'lego星球大战-千年隼';
update products set Type = 'toy'  where name = 'lego星球大战-死星';
update products set Type = 'toy'  where name = '奥迪跑车';
update products set Type = 'toy'  where name = '战地1';
update products set Type = 'toy'  where name = '小米无人机';

update products set Type = 'book'  where name = '小黄书';
update products set Type = 'book'  where name = 'java编程思想';

update products set Type = 'game'  where name = '战地1';

update products set Type = 'electronic_product'  where name = '外星人电脑';
update products set Type = 'electronic_product'  where name = '小米mix';
update products set Type = 'electronic_product'  where name = '小米无人机';


select * from user where name = '任向杰';
select * from products where Type = 'electronic_product';

create table  orders(
    id int not null auto_increment,
    spname varchar(40) not null,
    name_id int,
    create_date date not null,
    yhname varchar(40) not null,
    address varchar(100) not null,
    total int,
    state varchar(40) not null,
    foreign key(id)references user(id)
    );




insert into orders(spname,name_id,create_date,yhname,address,state) values('外星人电脑','9','2016-11-30','任向杰','上海电机学院','未付款');
insert into orders(spname,name_id,create_date,yhname,address,state) values('小米mix','7','2016-11-30','任向杰','上海电机学院','未付款');
insert into orders(spname,name_id,create_date,yhname,address,state) values('小米无人机','8','2016-11-30','任向杰','上海电机学院','未付款');


alter table orders add column count int;
update orders set count=1 where name_id in(7,8,9);
select * from orders;
select sum(current_prience) from products where Type = 'electronic_product';
#折扣率不会alter



create table  orders2(
	id int not null auto_increment,
    spname varchar(40) not null,
    name_id int,
    create_date date not null,
    yhname varchar(40) not null,
    address varchar(100) not null,
    total int,
    state varchar(40) not null,
	foreign key(id)references user(id)
    );


insert into orders2(spname,name_id,create_date,yhname,address,state) values('外星人电脑','9','2016-11-30','任向杰','上海电机学院','未付款');
insert into orders2(spname,name_id,create_date,yhname,address,state) values('小米mix','7','2016-11-30','任向杰','上海电机学院','未付款');

drop table orders2;





create table  orders3(
    id int not null auto_increment,
    spname varchar(40) not null,
    name_id int,
    create_date date not null,
    yhname varchar(40) not null,
    address varchar(100) not null,
    total int,
    state varchar(40) not null,
	foreign key(id)references user(id)

    );


insert into orders3(spname,name_id,create_date,yhname,address,state) values('小黄书','2','2016-11-30','任向杰','上海电机学院','已付款');
insert into orders3(spname,name_id,create_date,yhname,address,state) values('java编程思想','3','2016-11-30','任向杰','上海电机学院','已付款');

select * from orders3;


update products set current_prience=original_price where name='小黄书';


create table zyyorders(
   id int not null auto_increment,
   spname varchar(40) not null,
   name_id int,
   create_date date not null,
   yhname varchar(40) not null,
   address varchar(30) not null,
   total int,
   count int,
   state varchar(10) not null  ,
   foreign key(id)references user(id)

   );
   
   
insert into zyyorders(spname,name_id,create_date,yhname,address,count,state) values('小黄书','2','2016-11-30','张昀怡','上海海事大学','10','未付款');
update zyyorders set state = '已付款' ;
update user set balance = 19000 where name = '张昀怡';


select * from orders3;



update  products set original_price=current_prience ;


create table stjorders(
    id int not null auto_increment,
   spname varchar(40) not null,
   name_id int,
   create_date date not null,
   yhname varchar(40) not null,
   address varchar(30) not null,
   total int,
   count int,
   state varchar(10) not null ,  
   foreign key(id)references user(id)
   );
   
insert into stjorders(spname,name_id,create_date,yhname,address,count,state) values('外星人电脑','9','2016-11-30','宋天健','上海电机学院','99','未付款');
   create table stjorders2(
   id int not null auto_increment,
   spname varchar(40) not null,
   name_id int,
   create_date date not null,
   yhname varchar(40) not null,
   address varchar(30) not null,
   total int,
   count int,
   state varchar(10) not null ,
   foreign key(id)references user(id)
   );
   
insert into stjorders2(spname,name_id,create_date,yhname,address,count,state) values('外星人电脑','9','2016-11-30','宋天健','上海电机学院','99','未付款');
   create table stjorders3(
   id int not null auto_increment,
   spname varchar(40) not null,
   name_id int,
   create_date date not null,
   yhname varchar(40) not null,
   address varchar(30) not null,
   total int,
   count int,
   state varchar(10) not null ,  
   foreign key(id)references user(id)
   );
   
   insert into stjorders3(spname,name_id,create_date,yhname,address,count,state) values('外星人电脑','9','2016-11-30','宋天健','上海电机学院','99','未付款');
   

select * from products where Type = 'book';


  create table jrorders( 
   id int not null auto_increment,
   spname varchar(40) not null,
   name_id int,
   create_date date not null,
   yhname varchar(40) not null,
   address varchar(30) not null,
   total int,
   count int,
   state varchar(10) not null ,
   foreign key(id)references user(id)
   );
   
   
insert into jrorders(spname,name_id,create_date,yhname,address,count,state) values('java编程思想','3','2016-11-30','贾锐','上海海洋大学','10','未付款');
update zyyorders set state = '已付款' ;
update user set balance = 20000-790 where name = '贾锐';


update products set current_prience=original_price/2 where  name != '外星人电脑';

update user set balance = 25000 where name = '梁绍焕';
update user set balance = 15000 where name = '徐加亮';

  create table lshorders( 
   id int not null auto_increment,
   spname varchar(40) not null,
   name_id int,
   create_date date not null,
   yhname varchar(40) not null,
   address varchar(30) not null,
   total int,
   count int,
   state varchar(10) not null ,
   foreign key(id)references user(id)
   );


insert into lshorders(spname,name_id,create_date,yhname,address,count,state) values('外星人电脑','9','2016-11-30','梁绍焕','上海海洋大学','1','未付款');
insert into lshorders(spname,name_id,create_date,yhname,address,count,state) values('战地1','3','2016-11-30','梁绍焕','上海海洋大学','2','未付款');
update user set balance = 25000-20099 where name = '梁绍焕';




