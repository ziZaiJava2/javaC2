create database shop;
use shop;
create table product(
	id int not null auto_increment,
    name varchar(60) not null,
    description varchar(100) ,
    originalcost double not null,
    price double not null,
    primary key(id)
    );
drop table product;
    
create table serve(
	id int not null auto_increment,
    name varchar(30) not null,
    nick_name varchar(30) ,
    post_box varchar(50),
    address varchar(50),
    account_balance double ,
    primary key(id)
    );
drop table serve;

insert into product(name, description,originalcost,price)
	values ('小黄书','zyy最爱的绝版BL小说','100','199');

insert into product(name, description,originalcost,price)
	values('外星人电脑','即使不是最牛逼的电脑，也是最贵的电脑','20000','18999');
    
insert into product(name, description,originalcost,price)
	values('战地1','一战题材突突突游戏','199','99');
    
insert into product(name, description,originalcost,price)
	values('小米mix','你有钱也买不到的手机','3199','3199');
    
insert into product(name, description,originalcost,price)
	values('奥迪跑车','最终幻想15限量版奥迪跑车....模型','399','199');
    
insert into product(name, description,originalcost,price)
	values('java编程思想','虽然有些人读了还是不会写代码，但真是本好书','99','79');
    
insert into product(name, description,originalcost,price)
	values('lego星球大战-千年隼','汉索罗的座驾','1999','1999');
    
insert into product(name, description,originalcost,price)
	values('lego星球大战-死星','帝国大规模杀伤性武器','2999','2999');
    
insert into product(name, description,originalcost,price)
	values('小米无人机','便宜是便宜，就是要小心炸机','1999','1999');
    
    
    
    
    
insert into serve(name, nick_name, post_box,address,account_balance)
	values('张昀怡','班花','boss@bl.com','自己编吧，我编不下去了','20000');
    
insert into serve(name, nick_name, post_box,address,account_balance)
	values('徐嘉亮','班草','bancao@58.com','你停在了这条我们熟悉的街','20000');
    
 insert into serve(name, nick_name, post_box,address,account_balance)
	values('梁绍焕','班草','bancao@58.com','把你准备好的台词全念一遍','20000');
    
insert into serve(name, nick_name, post_box,address,account_balance)
	values('高成','班草','bancao@58.com','我还在逞强 说着谎','20000');
    
 insert into serve(name, nick_name, post_box,address,account_balance)
	values('贾锐','班草','bancao@58.com','也没能力遮挡 你去的方向','20000');
    
 insert into serve(name, nick_name, post_box,address,account_balance)
	values('金倩玉','班花','boss@58.com','至少分开的时候我落落大方遍','20000');
    
 insert into serve(name, nick_name, post_box,address,account_balance)
	values('彭佳辉','班草','bancao@58.com','我后来都会选择绕过那条街','20000');
    
 insert into serve(name, nick_name, post_box,address,account_balance)
	values('任向杰','班草','bancao@58.com','我还在逞强 说着谎','20000');
    
 insert into serve(name, nick_name, post_box,address,account_balance)
	values('宋天健','班草','bancao@58.com','我还在逞强 说着谎','20000');
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    