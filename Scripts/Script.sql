-- 거래처 영업관리 프로그램
DROP database IF EXISTS donghun2;
create database donghun2;
-- 거래처 영업관리 프로그램
use donghun2;

create table egrade(
	grade varchar(1) not null primary key,
	dispct int
);
INSERT INTO egrade
(grade, dispct)
VALUES('A', 3),('B',2),('C',1);
-- 영원사원
CREATE TABLE employee (
	code  CHAR(4)  NOT NULL COMMENT '사원코드' PRIMARY KEY, 
	name  CHAR(11) NOT NULL COMMENT '사원명', 
	grade CHAR(1)  NOT NULL COMMENT '사원등급',
	CONSTRAINT FK_employee
		FOREIGN KEY (grade) REFERENCES  Egrade (grade)
)
COMMENT '영원사원';

-- 제품
CREATE TABLE  product (
	code       CHAR(4)  NOT NULL COMMENT '제품코드' PRIMARY KEY,
	name       CHAR(11) NOT NULL COMMENT '제품명',
	saleprice  INT      NOT NULL COMMENT '판매정가', 
	origiprice INT      NOT NULL COMMENT '판매원가' 
)
COMMENT '제품';

create table cgrade(
	grade varchar(1) not null primary key,
	dispct int
);

INSERT INTO cgrade
(grade, dispct)
VALUES('L', 4),('M',3),('S',2);
-- 거래처
CREATE TABLE  customer (
	code  CHAR(4)  NOT NULL COMMENT '거래처코드' PRIMARY KEY,
	name  CHAR(11) NOT NULL COMMENT '거래처명',
	grade CHAR(1)  NOT NULL COMMENT '거래처등급',
	CONSTRAINT FK_customer
		FOREIGN KEY (grade) REFERENCES  cgrade (grade)
)
COMMENT '거래처';

INSERT INTO customer
(code, name, grade)
VALUES('C001', '손님', 'L');
INSERT INTO product
(code, name, saleprice, origiprice)
VALUES('P001', '커피',2000,500);
INSERT INTO employee
(code, name, grade)
VALUES('E001', '직원', 'C');


-- 거래내역
CREATE TABLE  sellInfo (
	scode	  char(4) not null comment '거래내역코드' PRIMARY KEY,
	ecode     CHAR(4) /*NOT NULL*/ COMMENT '사원코드',
	pcode     CHAR(4) /*NOT NULL*/ COMMENT '제품코드', 
	ccode     CHAR(4) /*NOT NULL*/ COMMENT '거래처코드', 
	saleDate  DATE    /*NOT NULL*/ COMMENT '거래일자' ,
	quantity  INT     NOT NULL COMMENT '판매수량', 
	CONSTRAINT FK_sellInfo
		FOREIGN KEY (ecode) REFERENCES  employee (code),
		FOREIGN KEY (pcode) REFERENCES  product (code),
		FOREIGN KEY (ccode)	REFERENCES  customer (code)
	
)
COMMENT '거래내역';

CREATE TABLE  sellInfoDetail (
	scode	  char(4) not null comment '거래내역코드',
	unitprice INT     NOT NULL COMMENT '판매단가', 
	sellprice INT     /*NOT NULL*/ COMMENT '판매금액', 
	disprice INT     /*NOT NULL*/ COMMENT '할인금액',
	marginPrice INT     /*NOT NULL*/ COMMENT '할인금액',
	marginPct INT     /*NOT NULL*/ COMMENT '할인금액',
	CONSTRAINT FK_sellInfoDetail
		FOREIGN KEY (scode)	REFERENCES  SellInfo (scode)
		on delete cascade
)
COMMENT '거래내역상세';

drop trigger if exists tri_sellinfoDetail_after_insert_sellinfo;
create trigger tri_sellinfoDetail_after_insert_sellinfo
after insert on sellinfo
for each row
begin
	set
	@unitPrice = (select salePrice from product p where p.code = new.pcode)*
				((select disPct from egrade eg join Employee e on eg.grade=e.grade where e.code=new.ecode)+
				(select disPct from cgrade cg join customer c on cg.grade=c.grade where c.code=new.ccode))
				*0.01,
	@sellPrice = @unitPrice * new.quantity,
	@disprice = (select salePrice from product p where p.code = new.pcode)*new.quantity - @sellprice,
    @marginPrice = @sellprice - (select origiprice from product p where p.code = new.pcode),
    @marginPct = @marginPrice / @sellPrice *100;
	insert into sellinfodetail(scode, unitprice, sellprice, disprice, marginPrice, marginPct)
	values(new.scode,@unitprice,@sellprice, @disprice, @marginPrice, @marginPct);
	
	/*
   set @salesPrice = new.price * new.quantity,
   @vatCost= ceil(@salesPrice/11),
   @supplyPrice=  @salesPrice - @vatCost,
   @profit= round(@supplyPrice* (new.marginPercentage/100));
   set
   @disprice = ,
   @marginPrice = ,
   @marginPct = ;
   insert into sellinfodetail(scode, unitprice, sellprice, disprice, marginPrice, marginPct)
	values(new.scode,@unitprice,@sellprice, @disprice, @marginPrice, @marginPct);
	*/
end;

      
select * from sellInfo;
select * from sellinfodetail;

insert into sellinfo(scode,pcode,ecode,ccode,quantity)values('S001','P001','E001','C001',100);
delete from sellinfo where scode = 'S001';










