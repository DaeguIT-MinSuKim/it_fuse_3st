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
INSERT INTO employee
(code, name, grade, isexist)
values
('E001', '신진욱', 'A',1),
('E002', '조시은', 'A',1),
('E003', '설동훈', 'A',1),
('E004', '이준욱', 'A',1),
('E005', '이교민', 'B',1),
('E006', '김성환', 'B',1),
('E007', '김두환', 'B',1),
('E008', '황인영', 'B',1),
('E009', '이승우', 'C',1),
('E010', '이원준', 'C',1),
('E011', '김동욱', 'C',1),
('E012', '허강민', 'C',1);

CREATE TABLE  product (		-- 제품테이블
	code       CHAR(4)  NOT NULL COMMENT '제품코드' PRIMARY KEY,
	name       CHAR(20) NOT NULL COMMENT '제품명',
	saleprice  INT      NOT NULL COMMENT '판매정가', 
	origiprice INT      NOT NULL COMMENT '판매원가',
	isexist BOOLEAN NOT NULL DEFAULT TRUE
);
INSERT INTO product
(code, name, saleprice, origiprice, isexist)
values
('P001', '언어의온도', 13800,8000,1),
('P002', '자존감수업',14000,7000,1),
('P003', '국가란 무엇인가',15000,7500,1),
('P004', '원피스 84',5000,2500,1),
('P005', '기린의날개',16800,8400,1),
('P006', '나미의 잡화점의 기적',15000,7500,1),
('P007', '나에게 건네는말',15000,7500,1),
('P008', '공터에서',15000,7500,1),
('P009', '하늘과 바람과 별과 시',15000,7500,1),
('P010', '고슴도치의 소원',13500,6750,1),
('P011', '제4차 산업혁명',15000,7500,1),
('P012', '새는 날아가면서 뒤돌',14000,7000,1),
('P013','설민석의 조선왕조실록',22000, 11000,1),
('P014','센서티브',14000, 7000,1),
('P015','영어책 한 권 외워봤니?',14000, 7000,1),
('P016','완벽한 공부법',19800, 9900,1),
('P017','나는 나로 살기로 했다',13800, 6900,1),
('P018','어쩌면 별들이 너의 슬픔', 12800, 6400,1),
('P019','숨결이 바람이 될떄', 14000, 7000,1),
('P020','그릿',12000, 6000,1);
insert into product values('P021','원파스',10000,1000,1);

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
(code, name, grade, isexist)
values
('C001', '예스24', 'L', 1),
('C002', '알라딘', 'L', 1),
('C003', '인터파크도서', 'L',1),
('C004', '교보문고', 'L',1),
('C005', '반디앤루니스', 'L',1),
('C006', '영풍문고', 'L',1),
('C007', '도서 11번가', 'L',1),
('C008', '물레책방', 'M',1),
('C009', '더폴락', 'M',1),
('C010', '코스모스북', 'M',1),
('C011', '예스서적문구', 'M',1),
('C012', '카페북', 'M',1),
('C013', '제프크북', 'M',1),
('C014', '스타북', 'M',1),
('C015', '북카페나그놀', 'S',1),
('C016', '세븐북카페', 'S',1),
('C017', '호야북카페', 'S',1),
('C018', '작은씨앗', 'S',1),
('C019', '대구하루', 'S',1),
('C020', '공중그네', 'S',1),
('C021', '커피브로리', 'S',1),
('C022', '내가쉬는다락방', 'S',1),
('C023', '책의집', 'S',1),
('C024', '타임카페타스', 'S',1);

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
 (s.saleprice * (1-((eg.dispct+cg.dispct)*0.01))) as unitPrice,-- 1000 * 0.93
-- 판매정가  * (1-(사원등급할인율+거래처등급할인율)*0.01) = 판매단가 (930)
 ((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity as sellPrice,
-- 판매단가*판매수량  = 판매금액(93000)
 (s.saleprice) * (quantity) -  (((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity) as disprice,
-- 판매정가*판매수량-판매금액  = 할인금액- (100000 - 93000= 7000
 (((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity) - (s.origiprice * quantity) as marginprice,
-- 판매금액-(판매원가*판매수량) = 마진액 93000-(50000) == 43000
 ROUND( ((((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity) - (s.origiprice * quantity))/(((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity)*100 ,1) as marginPct
-- 마진액/판매금액*100 = 마진율 // 소수 둘째자리에서 반올림해서 첫째자리까지 표시
from sellinfo s 
join employee e on s.ecode= e.code 
join egrade eg on eg.grade=e.grade
join customer c on s.ccode = c.code		-- sellinfo가 있다는것은 employee custom모두 값이 있다는 전제이므로
join cgrade cg on cg.grade=c.grade
join product p on s.pcode = p.code;


delete from sellinfo;

select * from vw_calculate_sellInfo;

insert into sellinfo values ('S010','E001','P021','C001','2017-04-07',100,10000,1000,3,1); -- 수량, 단가, 원가, 할인률, 

create view vw_InfoByCustomer as
select s.ccode ccode,saledate, p.code pcode, p.name pname, quantity, sellprice, disprice, marginprice, marginpct
from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join product p on s.pcode = p.code
order by saledate desc;

select saledate, pcode, pname, quantity, sellprice, disprice, marginprice, marginpct
from vw_InfoByCustomer 
where ccode='C001';

-- drop view vw_InfoByCustomer;

create view vw_InfoByProduct as
select s.pcode pcode, c.code ccode, c.name cname, sum(quantity) quantity, sum(sellprice) sellprice, sum(disprice) disprice, sum(marginprice) marginprice, avg(marginpct) marginpct
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
where ecode = 'E002';

select e.code , e.name , sellprice, marginprice, marginpct
	from vw_InfoByEmployee vw
	join employee e 
	on vw.ecode = e.code
	order by e.code asc;

-- drop view vw_InfoByEmployee;

select * from sellinfo;
select * from vw_calculate_sellinfo;
select * from customer;
