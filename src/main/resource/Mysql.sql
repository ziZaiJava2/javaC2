create database mall character set utf8;
use mall;
create table 物品(
	物品编号 int not null auto_increment,
    分类编号 int not null,
	物品名 varchar(40) not null,
    描述 text not null,
    原价 int not null,
    现价 int not null,
	primary key(物品编号),
    foreign key(分类编号) references 商品分类(分类编号)
    );
select *from 物品;
insert into 物品(分类编号,物品名,描述,原价,现价) values(2,'小黄书','zyy最爱的绝版BL小说',100,199);
insert into 物品(分类编号,物品名,描述,原价,现价) values(4,'外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑',20000,18999);
insert into 物品(分类编号,物品名,描述,原价,现价) values(3,'战地1','一战题材突突突游戏',199,99);
insert into 物品(分类编号,物品名,描述,原价,现价) values(4,'小米mix','你有钱也买不到的手机',3199,3199);    
insert into 物品(分类编号,物品名,描述,原价,现价) values(1,'奥迪跑车','最终幻想15限量版奥迪跑车....模型',399,199);    
insert into 物品(分类编号,物品名,描述,原价,现价) values(2,'java编程思想','虽然有些人读了还是不会写代码，但真是本好书',99,79);
insert into 物品(分类编号,物品名,描述,原价,现价) values(1,'lego星球大战-千年隼','汉索罗的座驾',1999,1999); 
insert into 物品(分类编号,物品名,描述,原价,现价) values(1,'lego星球大战-死星','帝国大规模杀伤性武器',2999,2999); 
insert into 物品(分类编号,物品名,描述,原价,现价) values(4,'小米无人机','便宜是便宜',1999,1999);
select *from 物品; 

create table 商品分类(
	分类编号 int not null,
    分类名称 varchar(250) not null,
    primary key(分类编号)
    );
alter table 商品分类 change 分类编号 分类编号 int not null auto_increment;
insert into 商品分类(分类名称) values('玩具类');
insert into 商品分类(分类名称) values('图书类');
insert into 商品分类(分类名称) values('游戏类');
insert into 商品分类(分类名称) values('电子产品类');
select *from 商品分类; 

create table 已注册用户(
	用户ID int not null auto_increment,
    姓名 varchar(40) not null,
    昵称 varchar(40) not null,
    邮箱 varchar(40) not null,
    地址 varchar(250) not null,
    账户余额 int not null,
    primary key(用户ID)
    );
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('张韵艺','班花','464684666@qq.com','上海海事大学',20000);
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('高城','大熊','1368543499@qq.com','上海海洋大学',20000);    
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('梁少焕','教官','665656566@qq.com','上海海洋大学',20000); 
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('贾瑞','帅帅','111122235@qq.com','上海海洋大学',20000);
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('贾乃亮','兵种','75674669@163.com','上海海洋大学',20000);
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('彭辉弟','豪豪','556556peng@163.com','上海电机学院',20000);
select *from 已注册用户;


create table 订单(
	订单编号 int  not null auto_increment,
    用户ID int not null,
    姓名 varchar(50) not null,
    物品名称 varchar(50) not null,
    订购日期 datetime not null,
    到货日期 datetime not null,
    发货日期 datetime not null,
    订单状态 varchar(250),
    primary key(订单编号),
    foreign key(用户ID) references 已注册用户(用户ID)
    );


create table 订单项表(
	订单项表号 int not null auto_increment,
    订单编号 int not null,
    物品编号 int not null,
    物品数量 int not null,
    订单总价格 int not null,
    primary key(订单项表号),
    foreign key(订单编号) references 订单(订单编号),
    foreign key(物品编号) references 物品(物品编号)
    );

select * from 已注册用户 where 昵称='大熊';
select 物.物品名,分类.分类名称 from 物品 物,商品分类 分类 where 物.分类编号 = 4 and 分类.分类名称 = '电子产品类';

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','外星人电脑','2013-06-25','2015-03-12','2013-08-22','未付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(1,2,1,18999);

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','小米mix','2013-06-25','2015-03-12','2013-08-22','未付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(2,4,10,31990);

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','小米无人机','2013-06-25','2015-03-12','2013-08-22','未付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(3,9,10,19990);

select * from 订单;

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','外星人电脑','2013-06-25','2015-03-12','2013-08-22','未付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(4,2,1,18999);

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','小米mix','2013-06-25','2015-03-12','2013-08-22','未付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(5,4,10,31990);

delete from 订单 where 订单编号 in(4,5); 
  
insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','小黄书','2013-06-25','2015-03-12','2013-08-22','已付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(4,1,10,1990);

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(2,'高城','Java编程思想','2013-06-25','2015-03-12','2013-08-22','已付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(5,6,1,79);
select * from 订单;

update 物品 set 现价=原价 where 物品名称='小黄书';
select * from 物品;

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(3,'梁少焕','小黄书','2013-06-25','2015-03-12','2013-08-22','已付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(6,1,10,1990);
select * from 订单;

update 物品 set 现价=原价;
select * from 物品;

insert into 订单(用户ID,姓名,订购日期,到货日期,发货日期,订单状态,姓名) values(4,'贾瑞','外星人电脑','2013-06-25','2015-03-12','2013-08-22','未付款');
insert into 订单项表(订单编号,物品编号,物品数量,订单总价格) values(7,2,99,(18999*99));






