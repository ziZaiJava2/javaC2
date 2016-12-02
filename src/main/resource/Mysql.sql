create database mall character set utf8;
use mall;
create table 物品(
	物品编号 int not null auto_increment,
	物品名 varchar(40) not null,
    描述 text not null,
    原价 double not null,
    现价 double not null,
	primary key(物品编号)
    );
select *from 物品;
insert into 物品(物品名,描述,原价,现价) values('小黄书','zyy最爱的绝版BL小说',100,199);
insert into 物品(物品名,描述,原价,现价) values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑',20000,18999);
insert into 物品(物品名,描述,原价,现价) values('战地1','一战题材突突突游戏',199,99);
insert into 物品(物品名,描述,原价,现价) values('小米mix','你有钱也买不到的手机',3199,3199);    
insert into 物品(物品名,描述,原价,现价) values('奥迪跑车','最终幻想15限量版奥迪跑车....模型',399,199);    
insert into 物品(物品名,描述,原价,现价) values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书',99,79);
insert into 物品(物品名,描述,原价,现价) values('lego星球大战-千年隼','汉索罗的座驾',1999,1999); 
insert into 物品(物品名,描述,原价,现价) values('lego星球大战-死星','帝国大规模杀伤性武器',2999,2999); 
insert into 物品(物品名,描述,原价,现价) values('小米无人机','便宜是便宜',1999,1999);
select * from 物品;

create table 商品分类(
	分类编号 int not null auto_increment,
    分类名称 varchar(250) not null,
    primary key(分类编号)
    );

insert into 商品分类(分类名称) values('玩具类');
insert into 商品分类(分类名称) values('图书类');
insert into 商品分类(分类名称) values('游戏类');
insert into 商品分类(分类名称) values('电子产品类');

create table classify(
	物品分类编号 int not null auto_increment,
	物品号 int not null,
    分类号 int not null,
    primary key(物品分类编号)
    );
    
insert into classify(物品号,分类号) values(1,2);
insert into classify(物品号,分类号) values(2,4);
insert into classify(物品号,分类号) values(3,1);
insert into classify(物品号,分类号) values(4,4);
insert into classify(物品号,分类号) values(5,1);
insert into classify(物品号,分类号) values(6,2);
insert into classify(物品号,分类号) values(7,1);
insert into classify(物品号,分类号) values(8,1);
insert into classify(物品号,分类号) values(9,4);
insert into classify(物品号,分类号) values(3,3);
insert into classify(物品号,分类号) values(9,1);
select * from classify;
select 物.物品名,分类.分类名称 from 物品 物,商品分类 分类,classify cy where 物.物品编号 = cy.物品号 and  分类.分类编号 = cy.分类号 and 分类.分类名称 = '电子产品类';
    
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
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('任祥杰','大宝宝','666656reng@163.com','上海电机学院',20000);
insert into 已注册用户(姓名,昵称,邮箱,地址,账户余额) values('宋天堑','二宝宝','55898896@163.com','上海电机学院',20000);
select *from 已注册用户;
select *from 物品;

create table orders(
	订单编号 int  not null auto_increment,
    用户名称 varchar(50) not null,
    物品名称 varchar(50) not null,
    订购日期 datetime not null,
    到货日期 datetime not null,
    发货日期 datetime not null,
    订单总价 double not null,
    订单状态 varchar(250),
    primary key(订单编号)
    );

create table ordergoods(
	订单物品编号 int not null auto_increment,
    物品号 int not null,
    订单号 int not null,
    数量 int not null,
    primary key(订单物品编号)
    );
select *from ordergoods;

create table totals(
	序号 int not null auto_increment,
	用户 varchar(50) not null,
    订单总数 int not null,
    合计总金额 double not null,
    primary key(序号)
    );

create table 销售(
	销售编号 int not null auto_increment,
    物品 varchar(50) not null,
    销售数量 int not null,
    销售总金额 double not null,
    primary key(销售编号)
    );

create table 商家(
	商家编号 int not null auto_increment,
    商家销售总金额 double not null,
    primary key(商家编号)
    );
    
select *from 已注册用户 where 姓名 = '任祥杰';

select 物.物品名,分类.分类名称 from 物品 物,商品分类 分类,classify cy where 物.物品编号 = cy.物品号 and  分类.分类编号 = cy.分类号 and 分类.分类名称 = '电子产品类';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','外星人电脑','2013-06-25','2015-03-12','2013-08-22',18999,'未付款');
insert into ordergoods(物品号,订单号,数量) values(2,1,1);

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','小米Mix','2013-06-25','2015-03-12','2013-08-22',3199,'未付款');
insert into ordergoods(物品号,订单号,数量) values(4,2,1);

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','小米无人机','2013-06-25','2015-03-12','2013-08-22',1999,'未付款');
insert into ordergoods(物品号,订单号,数量) values(9,3,1);
select *from orders;

select 物.物品名, org.数量, 物.原价, 物.现价, 物.现价/物.原价  from  物品 物, ordergoods org, orders ors  where 物.物品编号 = org.物品号 and ors.订单编号 = org.订单号;

select 用户名称 as orders,count(物品名称)as 订单总数,sum(订单总价)as 合计总金额 from orders group by 用户名称;

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','外星人电脑','2013-06-25','2015-03-12','2013-08-22',18999,'未付款');
insert into ordergoods(物品号,订单号,数量) values(2,4,1);

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','小米Mix','2013-06-25','2015-03-12','2013-08-22',3199,'未付款');
insert into ordergoods(物品号,订单号,数量) values(4,5,1);
select *from orders;

delete from orders where 订单编号 in(4,5);
delete from ordergoods where 订单详表编号 in(4,5);
select *from orders;

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','Java编程思想','2013-06-25','2015-03-12','2013-08-22',79,'已付款');
insert into ordergoods(物品号,订单号,数量) values(6,6,1);
update 已注册用户 set 账户余额 = 账户余额 - 79 where 姓名 = '任祥杰';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('任祥杰','小黄书','2013-06-25','2015-03-12','2013-08-22',199,'已付款');
insert into ordergoods(物品号,订单号,数量) values(1,7,1);
update 已注册用户 set 账户余额 = 账户余额 - 199 where 姓名 = '任祥杰';
select *from orders;

update 物品 set 现价 = 原价 where 物品名 = '小黄书';
select *from 物品;

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('高城','小黄书','2013-06-25','2015-03-12','2013-08-22',1000,'已付款');
insert into ordergoods(物品号,订单号,数量) values(1,8,10);
update 已注册用户 set 账户余额 = 账户余额 - 1000 where 姓名 = '高城';
select *from orders;

select *from orders where 用户名称 = '任祥杰' and 物品名称 = '小黄书';

update 物品 set 现价 = 原价;
select *from 物品;

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('宋天堑','外星人电脑','2013-06-25','2015-03-12','2013-08-22',18999*99,'未付款');
insert into ordergoods(物品号,订单号,数量) values(2,9,99);

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('宋天堑','外星人电脑','2013-06-25','2015-03-12','2013-08-22',18999*99,'未付款');
insert into ordergoods(物品号,订单号,数量) values(2,10,99);

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('宋天堑','外星人电脑','2013-06-25','2015-03-12','2013-08-22',18999*99,'未付款');
insert into ordergoods(物品号,订单号,数量) values(2,11,99);


select 物.物品名,分类.分类名称 from 物品 物,商品分类 分类,classify cy where 物.物品编号 = cy.物品号 and  分类.分类编号 = cy.分类号 and 分类.分类名称 = '图书类';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('贾瑞','小黄书','2013-06-25','2015-03-12','2013-08-22',1000,'已付款');
insert into ordergoods(物品号,订单号,数量) values(1,12,10);
update 已注册用户 set 账户余额 = 账户余额 - 1000 where 姓名 = '贾瑞';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('贾瑞','Java编程思想','2013-06-25','2015-03-12','2013-08-22',790,'已付款');
insert into ordergoods(物品号,订单号,数量) values(6,13,10);
update 已注册用户 set 账户余额 = 账户余额 - 790 where 姓名 = '贾瑞';

update 物品 set 现价 = 原价/2 where 物品名 not in('小黄书');

update 已注册用户 set 账户余额 = 账户余额-5000 where 姓名 = '贾乃亮';
update 已注册用户 set 账户余额 = 账户余额+5000 where 姓名 = '梁少焕';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('梁少焕','外星人电脑','2013-11-11','2015-03-12','2013-08-22',10000,'已付款');
insert into ordergoods(物品号,订单号,数量) values(2,14,1);
update 已注册用户 set 账户余额 = 账户余额 - 10000 where 姓名 = '梁少焕';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('梁少焕','战地1','2013-11-11','2015-03-12','2013-08-22',199,'已付款');
insert into ordergoods(物品号,订单号,数量) values(3,15,2);
update 已注册用户 set 账户余额 = 账户余额 - 199 where 姓名 = '梁少焕';

insert into orders(用户名称,物品名称,订购日期,到货日期,发货日期,订单总价,订单状态) values('高城','小米无人机','2013-11-11','2015-03-12','2013-08-22',1999,'已付款');
insert into ordergoods(物品号,订单号,数量) values(9,16,1);
update 已注册用户 set 账户余额 = 账户余额 - 1999 where 姓名 = '高城';


select 商家编号 as 商家, sum(订单总价)as 商家销售总金额 from orders 商家 where date<date(2013-11-11) and orders.订单状态 = '已付款' group by 商家编号;

select 商家编号 as 商家, sum(订单总价)as 商家销售总金额 from orders 商家 where date=date(2013-11-11) and orders.订单状态 = '已付款' group by 商家编号;

select 商家编号 as 商家, sum(订单总价)as 商家销售总金额 from orders 商家 where orders.订单状态 = '已付款' group by 商家编号;

select 物品名称 as ors,sum(数量)as 销售数量,sum(订单总价)as 销售总金额 from orders ors,ordergoods org,销售 where ors.订单状态 = '已付款' group by 物品名称;

select isnull(min(账户余额),0) as 账户余额 from 已注册用户;

select 用户名称 as orders,count(物品名称)as 订单总数,sum(订单总价)as 合计总金额 from orders,totals where orders.订单状态 = '已付款' group by 用户名称;

select isnull(max(订单总价),0) as 订单总价 from orders;

select 物品名称 as ors,sum(数量)as 销售数量,sum(订单总价)as 销售总金额 from orders ors,ordergoods org,销售 where ors.订单总价 = 0 group by 物品名称;

select 用户名称 as orders,count(物品名称)as 订单总数,sum(订单总价)as 合计总金额 from orders,totals where orders.订单状态 = '未付款' and max(totals.订单总数) group by 用户名称;

delete from 已注册用户 where (select 用户名称 as orders,count(物品名称)as 订单总数,sum(订单总价)as 合计总金额 from orders,totals where orders.订单状态 = '未付款' and max(totals.订单总数) group by 用户名称) and totals.用户名称 = 已注册用户。姓名;

