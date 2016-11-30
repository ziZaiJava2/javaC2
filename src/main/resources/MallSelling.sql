create database shop;
use shop;
drop database shop;

create table production(
	id int not null auto_increment,
    name varchar(60) not null,
    description text,
    original_price decimal(16,4),
    price decimal(16,4),
    primary key(id)
    );
select* from production;

create table category(
	id int not null auto_increment,
	name varchar(40) not null,
    primary key(id)
);
select* from category;
create table production_category(
	production_id int, 
	category_id int
);
select* from production_category;
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

insert into category(name) values('玩具');
insert into category(name) values('游戏');
insert into category(name) values('图书');
insert into category(name) values('电子产品');

insert into production_category(production_id,category_id)values();
insert into production_category(production_id,category_id)values();
insert into production_category(production_id,category_id)values();
insert into production_category(production_id,category_id)values();

insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '战地1' and c.name = '游戏';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = 'lego星球大战-千年隼' and c.name = '玩具';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = 'lego星球大战-死星' and c.name = '玩具';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '奥迪跑车' and c.name = '玩具';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '战地1' and c.name = '玩具';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '小米无人机' and c.name = '玩具';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = 'java编程思想' and c.name = '图书';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '小黄书' and c.name = '图书';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '外星人电脑' and c.name = '电子产品';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '小米Mix' and c.name = '电子产品';
insert into production_category (production_id, category_id)select p.id, c.id from production p, category c where p.name = '小米无人机' and c.name = '电子产品';


select * from production p, category c, production_category pc where c.name = '电子产品' and pc.production_id= p.id and pc.category_id  = c.id;

create table orders(
	id int not null auto_increment,
    create_date date not null,
    address varchar(100) not null,
    state text,
    serve_id int,
    total decimal(16,4),
    primary key(id)
    );

drop table orders;
create table serve(
	id int not null auto_increment,
    name varchar(30) not null,
    nick_name varchar(30) ,
    post_box varchar(50),
    address varchar(50),
    balance decimal(16,4),
    primary key(id)
    );
select* from serve;
  drop table serve;
insert into serve(name, nick_name, post_box,address,balance)
	values('张昀怡','班花','boss@bl.com','SH',20000);    
insert into serve(name, nick_name, post_box,address,balance)
	values('徐嘉亮','班草','bancao@58.com','SH',20000);    
 insert into serve(name, nick_name, post_box,address,balance)
	values('梁绍焕','班草','bancao@58.com','SH',20000);    
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
    
create table orders_production(
orders_id int ,
production_id int,
price decimal(16,4),
count int
);

insert into orders(create_date,address,state,serve_id)
	values('2016-11-30','SH','未付款',8);
select *from orders;
insert into orders_production(
	orders_id,
    production_id,
    count,
    price
)
select 8,p.id ,8,p.price from production p, category c, production_category pc where c.name = '电子产品' and pc.production_id= p.id and pc.category_id  = c.id;

#2016-09-01  
select *from serve;
select *from product;

#2016-09-02
select *from serve where name = '任向杰';
select * from product where sort = 'electronics';
create table ren1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);

insert into ren1(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', '外星人电脑','1','2016-09-02','SH','18999','未付款');
insert into ren1(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', '小米Mix','1','2016-09-02','SH','3199','未付款');
insert into ren1(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', '小米无人机','1','2016-09-02','SH','1999','未付款');
select name , originalcost , price , price/originalcost from product where sort ='electronics';
select sum(price) from product where sort ='electronics';

create table ren2(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into ren2(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', '外星人电脑','1','2016-09-02','SH','18999','未付款');
insert into ren2(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', '小米Mix','1','2016-09-02','SH','3199','未付款');
select sum(price) from product where name ='外星人电脑'or name = '小米Mix';
drop table ren2;
create table ren3(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into ren3(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', 'Java编程思想','1','2016-09-02','SH','18999','未付款');
insert into ren3(serve_name, product_name, count,create_date,address,total,state )
	values('任向杰', '小黄书','1','2016-09-02','SH','199','未付款');
update ren3 set     state = '付款';
select sum(price) from product where name ='Java编程思想'or name = '小黄书';
update serve set account_balance=20000-278 where name = '任向杰';
    
#2016-09-11    
update product set price='100' where name = '小黄书';
create table zyy1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into zyy1(serve_name, product_name, count,create_date,address,total,state )
	values('张昀怡', '小黄书','10','2016-09-11','SH','100','未付款');
update zyy1 set     state = '付款';
select sum(price)*10 from product where name ='小黄书';    
update serve set account_balance=20000-1000 where name = '张昀怡';
select total from ren3 where product_name= '小黄书';
#2016-10-10
update product set originalcost=price;

#2016-10-12
create table song1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30), 
	foreign key(id)references  serve(id)
);
insert into song1(serve_name, product_name, count,create_date,address,total,state )
	values('宋天健', '外星人电脑','99','2016-09-12','SH','20000','未付款');
create table song2(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into song3(serve_name, product_name, count,create_date,address,total,state )
	values('宋天健', '外星人电脑','99','2016-09-12','SH','20000','未付款');
create table song1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into song1(serve_name, product_name, count,create_date,address,total,state )
	values('宋天健', '外星人电脑','99','2016-09-12','SH','20000','未付款');

#2016-10-15
select *from product where sort = 'book';
create table jia1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into jia1(serve_name, product_name, count,create_date,address,total,state )
	values('贾锐', '小黄书','10','2016-09-15','SH','100','未付款');
create table jia2(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into jia2(serve_name, product_name, count,create_date,address,total,state )
	values('贾锐', 'java编程思想','10','2016-09-15','SH','99','未付款');
update jia1 set state='付款';
update jia2 set state='付款';

#2016-11-10
update product set price=originalcost/2 where name != '外星人电脑';

#2016-11-11
update serve set account_balance='25000' where name = '梁绍焕';
update serve set account_balance='15000' where name = '徐嘉亮';
create table liang1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into liang1(serve_name, product_name, count,create_date,address,total,state )
	values('梁绍焕', '外星人电脑','1','2016-11-11','SH','20000','未付款');
insert into liang1(serve_name, product_name, count,create_date,address,total,state )
	values('梁绍焕', '战地1','2','2016-11-11','SH','199','未付款');
update liang1 set state='付款';
create table gao1(
	id int not null auto_increment,
	serve_name varchar(60)not null,
    product_name varchar(40),
    count int ,
    create_date date,
    address varchar(30),
    total double ,
    state varchar(30),
	foreign key(id)references  serve(id)
);
insert into gao1(serve_name, product_name, count,create_date,address,total,state )
	values('高成', '小米无人机','1','2016-11-11','SH','20000','未付款');
update gao1 set state='付款';