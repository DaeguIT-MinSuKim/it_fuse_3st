-- 거래처 영업관리 프로그램
DROP database IF EXISTS donghun2;
create database donghun2;
-- 거래처 영업관리 프로그램
use donghun2;
-- 영원사원
CREATE TABLE employee (
	code  CHAR(4)  NOT NULL COMMENT '사원코드' PRIMARY KEY, 
	name  CHAR(11) NOT NULL COMMENT '사원명', 
	grade CHAR(1)  NOT NULL COMMENT '사원등급' 
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

-- 거래처
CREATE TABLE  customer (
	code  CHAR(4)  NOT NULL COMMENT '거래처코드' PRIMARY KEY,
	name  CHAR(11) NOT NULL COMMENT '거래처명',
	grade CHAR(1)  NOT NULL COMMENT '거래처등급'
)
COMMENT '거래처';

-- 거래내역
CREATE TABLE  sellInfo (
	scode	  char(4) not null comment '거래내역코드' PRIMARY KEY,
	ecode     CHAR(4) NOT NULL COMMENT '사원코드',
	pcode     CHAR(4) NOT NULL COMMENT '제품코드', 
	ccode     CHAR(4) NOT NULL COMMENT '거래처코드', 
	saleDate  DATE    NOT NULL COMMENT '거래일자' ,
	quantity  INT     NOT NULL COMMENT '판매수량', 
	unitprice INT     NOT NULL COMMENT '판매단가', 
	sellprice INT     NOT NULL COMMENT '판매금액', 
	disprice INT     NOT NULL COMMENT '할인금액'
)
COMMENT '거래내역';

-- 거래내역
ALTER TABLE  sellInfo
	ADD CONSTRAINT FK_sellInfo
		FOREIGN KEY (ecode) REFERENCES  employee (code),
		FOREIGN KEY (pcode) REFERENCES  product (code),
		FOREIGN KEY (ccode)	REFERENCES  customer (code);

select * from product;

/*
DROP view IF EXISTS v_totalinfo;
create view v_totalinfo
as select 
e.code ecode,e.name ename,e.grade egrade,
p.code pcode,p.name pname,p.saleprice,p.origiprice,
c.code ccode,c.name cname,c.grade cgrade,
saleDate,quantity,unitprice,sellprice,disprice
from saleinfo s, employee e,product p,customer c
where s.ecode=e.code
and s.pcode=p.code
and s.ccode=c.code;

select * from v_totalinfo;
*/

INSERT INTO customer
(code, name, grade)
VALUES('C001', '손님', 'L');
INSERT INTO product
(code, name, saleprice, origiprice)
VALUES('P001', '커피',10,50);
INSERT INTO employee
(code, name, grade)
VALUES('E001', '직원', 'C');



      
select * from sellInfo;



