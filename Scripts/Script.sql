
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
	CONSTRAINT FK_employee
		FOREIGN KEY (grade) REFERENCES  Egrade (grade)	-- 사원등급을 FK로 받아요
);


CREATE TABLE  product (		-- 제품테이블
	code       CHAR(4)  NOT NULL COMMENT '제품코드' PRIMARY KEY,
	name       CHAR(11) NOT NULL COMMENT '제품명',
	saleprice  INT      NOT NULL COMMENT '판매정가', 
	origiprice INT      NOT NULL COMMENT '판매원가' 
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
	ecode     CHAR(4) /*NOT NULL*/ COMMENT '사원코드',
	pcode     CHAR(4) /*NOT NULL*/ COMMENT '제품코드', 
	ccode     CHAR(4) /*NOT NULL*/ COMMENT '거래처코드', 
	saledate  DATE    /*NOT NULL*/ COMMENT '거래일자' ,
	quantity  INT     NOT NULL COMMENT '판매수량', 
	CONSTRAINT FK_sellInfo		-- FK로 사원,제품,거래처 받음
		FOREIGN KEY (ecode) REFERENCES  employee (code),
		FOREIGN KEY (pcode) REFERENCES  product (code),
		FOREIGN KEY (ccode)	REFERENCES  customer (code)
	
);

CREATE TABLE  sellInfoDetail (		-- 거래내역 상세 테이블 (계산값)
	scode	  char(4) not null comment '거래내역코드',
	unitprice INT     NOT NULL COMMENT '판매단가', 
	sellprice INT     /*NOT NULL*/ COMMENT '판매금액', 
	disprice INT     /*NOT NULL*/ COMMENT '할인금액',
	marginprice INT     /*NOT NULL*/ COMMENT '할인금액',
	marginpct INT     /*NOT NULL*/ COMMENT '할인금액',
	CONSTRAINT FK_sellInfoDetail
		FOREIGN KEY (scode)	REFERENCES  SellInfo (scode) -- 거래내역테이블 PK인 scode를 FK로 받음
		on delete CASCADE		-- 이 제약 조건 해줘야 거래내역 없앴을때 거래내역상세에 있는 값도 같이 삭제됨
);

drop trigger if exists tri_sellinfoDetail_after_insert_sellinfo;
create trigger tri_sellinfoDetail_after_insert_sellinfo
after insert on sellinfo		-- 거래내역테이블에 값 들어왔을때 거래내역상세 테이블에 자동으로 계산되어 들어가는 값들입니다. 
for each row
begin
	SET		
	@unitPrice = (select saleprice from product p where p.code = new.pcode)*
				(1-((select dispct from egrade eg join Employee e on eg.grade=e.grade where e.code=new.ecode)+
				(select dispct from cgrade cg join customer c on cg.grade=c.grade where c.code=new.ccode))
				*0.01), 
-- 판매단가=제품테이블에 판매정가 * (1-((사원테이블과 사원등급테이블 조인해서 받은 사원등급할인율)+(거래처테이블과 거래처등급테이블 조인해서 받은 거래처등급할인율))*0.01)
	@sellPrice = @unitPrice * new.quantity,
-- 판매금액=판매단가*판매수량
	@disprice = (select salePrice from product p where p.code = new.pcode)*new.quantity - @sellprice,
-- 할인금액=판매정가*판매수량-판매금액
    @marginPrice = @sellprice - (select origiprice from product p where p.code = new.pcode)*new.quantity,
-- 마진액=판매금액-(판매원가*판매수량)
    @marginPct = round(@marginPrice / @sellPrice *100, 1);  -- 안먹음..why?
-- 마진율=마진액/판매금액*100, 소수 둘째자리에서 반올림해서 첫째자리까지 표시
	insert into sellinfodetail(scode, unitprice, sellprice, disprice, marginprice, marginpct)
	values(new.scode,@unitprice,@sellprice, @disprice, @marginprice, @marginpct);
end;

     
select * from sellInfo;
select * from sellinfodetail;

insert into sellinfo(scode,pcode,ecode,ccode,quantity,saledate)
values('S003','P001','E002','C002',150,now()),
		('S002','P003','E001','C003',100,now()),
		('S001','P002','E003','C001',50,now()),
		('S004','P003','E002','C003',50,now());
/*delete from sellinfo where scode = 'S001';*/


create view vw_InfoByCustomer as
select saledate, p.code pcode, p.name pname, quantity, sellprice, disprice, marginprice, marginpct
from sellinfo s join sellinfodetail sd on sd.scode= s.scode join product p on p.code=s.pcode
order by saledate desc;

select saledate, pcode, pname, quantity, sellprice, disprice, marginprice, marginpct
from vw_InfoByCustomer;

-- drop view vw_InfoByCustomer;

create view vw_InfoByProduct as
select c.code ccode, c.name cname, quantity, sellprice, disprice, marginprice, marginpct
from sellinfo s join sellinfodetail sd on sd.scode= s.scode join customer c on c.code=s.ccode
order by ccode asc;		-- 주의 사항 처리해야함

select ccode, cname, quantity, sellprice, disprice, marginprice, marginpct
from vw_InfoByProduct;

-- drop view vw_InfoByProduct;

create view vw_InfoByEmployee as
select e.code ecode, e.name ename, sellprice, marginprice, marginpct
from sellinfo s join sellinfodetail sd on sd.scode= s.scode join employee e on e.code=s.ecode
order by ecode asc;

select ecode, ename, sellprice, marginprice, marginpct
from vw_InfoByEmployee;

-- drop view vw_InfoByEmployee;

SELECT scode, unitprice, sellprice, disprice, marginPrice, marginPct  FROM sellinfodetail;
