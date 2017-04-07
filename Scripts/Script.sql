-- 거래처 영업관리 프로그램
DROP database IF EXISTS donghun2;
create database donghun2;

use donghun2;
create table egrade(	-- 사원 등급 테이블이구요
	grade varchar(1) not null primary key,
	dispct int
);
INSERT INTO egrade	-- 사원 등급 테이블에 A등급3%B등급2%C등급3%로 인써트.
(grade, dispct)
VALUES('A', 3),('B',2),('C',1);


CREATE TABLE employee (	-- 사원 테이블
	code  CHAR(4)  NOT NULL COMMENT '사원코드' PRIMARY KEY, 
	name  CHAR(11) NOT NULL COMMENT '사원명', 
	grade CHAR(1)  NOT NULL COMMENT '사원등급',
	isexist BOOLEAN NOT NULL DEFAULT TRUE, 
	CONSTRAINT FK_employee
		FOREIGN KEY (grade) REFERENCES  Egrade (grade)	-- 사원등급을 FK로 받아요
);


CREATE TABLE  product (		-- 제품테이블
	code       CHAR(4)  NOT NULL COMMENT '제품코드' PRIMARY KEY,
	name       CHAR(11) NOT NULL COMMENT '제품명',
	saleprice  INT      NOT NULL COMMENT '판매정가', 
	origiprice INT      NOT NULL COMMENT '판매원가',
	isexist BOOLEAN NOT NULL DEFAULT TRUE
);

create table cgrade(		-- 거래처 등급 테이블이구요
	grade varchar(1) not null primary key,
	dispct int
);

INSERT INTO cgrade
(grade, dispct)
VALUES('L', 4),('M',3),('S',2);		-- 거래처 등급 테이블에 L등급4%M등급3%S등급2%로 인써트.

CREATE TABLE  customer (		-- 거래처테이블
	code  CHAR(4)  NOT NULL COMMENT '거래처코드' PRIMARY KEY,
	name  CHAR(11) NOT NULL COMMENT '거래처명',
	grade CHAR(1)  NOT NULL COMMENT '거래처등급',
	isexist BOOLEAN NOT NULL DEFAULT TRUE, 
	CONSTRAINT FK_customer
		FOREIGN KEY (grade) REFERENCES  cgrade (grade)		-- 거래처등급을 FK로 받아요
);

INSERT INTO customer
(code, name, grade)
VALUES('C003', '빽다방', 'S'),('C001', '콩다방', 'L'),('C002', '별다방', 'M');
INSERT INTO product
(code, name, saleprice, origiprice)
VALUES('P002', '코스타리카',25000,8000),('P001', '콜롬비아',20000,6000),('P003', '예가체프',30000,10000);
INSERT INTO employee
(code, name, grade)
VALUES('E003', '신진욱', 'C'),('E002', '이준욱', 'A'),('E001', '설동훈', 'B');


CREATE TABLE  sellInfo (		-- 거래내역 테이블
	scode	  char(4) not null comment '거래내역코드' PRIMARY KEY,
	ecode     CHAR(4) /*NOT NULL*/,
	pcode     CHAR(4) /*NOT NULL*/, 
	ccode     CHAR(4) /*NOT NULL*/, 
	saledate  DATE    NOT NULL,
	quantity  INT     NOT NULL,
	saleprice int	  not null,
	origiprice int	  not null, 
	dispcts int not null,
	isexist BOOLEAN NOT NULL DEFAULT TRUE, 
	CONSTRAINT FK_sellInfo		-- FK로 사원,제품,거래처 받음
		FOREIGN KEY (ecode) REFERENCES  employee (code),
		FOREIGN KEY (pcode) REFERENCES  product (code),
		FOREIGN KEY (ccode)	REFERENCES  customer (code)
	
);

-- 판매단가unitPrice,판매금액sellprice,할인금액disprice,마진액marginprice,마진율marginpct 계산된 뷰 테이블
drop view if exists vw_calculate_sellInfo;
create view vw_calculate_sellInfo as
select s.scode,e.code ecode, p.code pcode, c.code ccode,
 (s.saleprice) * (1-(eg.dispct+cg.dispct)*0.01) as unitPrice,
-- 판매정가  * (1-(사원등급할인율+거래처등급할인율)*0.01) = 판매단가
 (s.saleprice*(1-(eg.dispct+cg.dispct)*0.01)) * (quantity) as sellPrice,
-- 판매단가*판매수량  = 판매금액
 (s.saleprice) * (quantity) - (s.saleprice*(1-(eg.dispct+cg.dispct)*0.01)*quantity) as disprice,
-- 판매정가*판매수량-판매금액  = 할인금액
 (s.saleprice*(1-(eg.dispct+cg.dispct)*0.01)*quantity) - s.origiprice * quantity as marginprice,
-- 판매금액-(판매원가*판매수량) = 마진액
 ROUND(((s.saleprice*(1-(eg.dispct+cg.dispct)*0.01)*quantity)-s.origiprice*quantity) / ((s.saleprice*(1-(eg.dispct+cg.dispct)*0.01))*(quantity))*100, 1) as marginPct
-- 마진액/판매금액*100 = 마진율 // 소수 둘째자리에서 반올림해서 첫째자리까지 표시
from sellinfo s 
join employee e on s.ecode= e.code 
join egrade eg on eg.grade=e.grade
join customer c on s.ccode = c.code		-- sellinfo가 있다는것은 employee custom모두 값이 있다는 전제이므로
join cgrade cg on cg.grade=c.grade
join product p on s.pcode = p.code;



select * from sellinfo;

select * from vw_calculate_sellInfo;

select * from vw_calculate_sellInfo where scode='s001';

insert into sellinfo(scode,pcode,ecode,ccode,saleprice,origiprice,quantity,saledate,dispcts)
values('S003','P001','E002','C002',20000,6000,150,now(),1),
		('S002','P003','E001','C003',30000,10000,100,now(),1),
		('S001','P002','E003','C001',25000,8000,50,now(),1),
		('S004','P003','E002','C003',30000,10000,50,now(),1);
/*delete from sellinfo where scode = 'S001';*/

create view vw_InfoByCustomer as
select s.ccode,saledate, p.code pcode, p.name pname, quantity, sellprice, disprice, marginprice, marginpct
from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join product p on s.pcode = p.code
order by saledate desc;

select saledate, pcode, pname, quantity, sellprice, disprice, marginprice, marginpct
from vw_InfoByCustomer 
where ccode='C001';

-- drop view vw_InfoByCustomer;

create view vw_InfoByProduct as
select s.pcode, c.code ccode, c.name cname, sum(quantity) quantity, sum(sellprice) sellprice, sum(disprice) disprice, sum(marginprice) marginprice, avg(marginpct) marginpct
from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join customer c on s.ccode = c.code
group by ccode
order by ccode asc ;

select ccode, cname, quantity, sellprice, disprice, marginprice, marginpct
from vw_infobyproduct 
where pcode='P001';
/*select  ccode,cname,sum(quantity),sum(sellprice),sum(disprice),sum(marginprice),avg(marginpct)
from vw_InfoByProduct where pcode='P001';  ??*/

-- drop view vw_InfoByProduct;

create view vw_InfoByEmployee as
select e.code ecode, e.name ename, sellprice, marginprice, marginpct
from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join employee e on s.ecode = e.code
order by e.code asc;

select ecode, ename, sellprice, marginprice, marginpct
from vw_InfoByEmployee
where ecode = 'E001';

select e.code , e.name , sellprice, marginprice, marginpct
	from vw_InfoByEmployee vw
	join employee e 
	on vw.ecode = e.code
	order by e.code asc;

-- drop view vw_InfoByEmployee;

select * from sellinfo;
select * from customer;
