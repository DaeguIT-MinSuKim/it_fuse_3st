<<<<<<< HEAD


drop table employee;

INSERT INTO cgrade
(grade, dispct)
VALUES('M',4),('S',3);

insert into egrade (grade,dispct) values ('A',3),('B',2),('C',1);
select * from egrade;
select * from cgrade;
-- 사원
CREATE TABLE Employee (
	code    VARCHAR(4)  NOT NULL COMMENT '사원코드', -- 사원코드
	name    VARCHAR(11) NOT NULL COMMENT '사원명', -- 사원명
	grade   VARCHAR(1)  NOT NULL COMMENT '사원등급', -- 사원등급
	isexist BOOLEAN     NOT NULL COMMENT '존재유무' -- 존재유무
)
COMMENT '사원';

-- 사원
ALTER TABLE Employee
	ADD CONSTRAINT PK_Employee -- 사원 기본키
		PRIMARY KEY (
			code -- 사원코드
		);

-- 제품
CREATE TABLE Product (
	code       VARCHAR(4)  NOT NULL COMMENT '제품코드', -- 제품코드
	name       VARCHAR(11) NOT NULL COMMENT '제품명', -- 제품명
	saleprice  INT         NOT NULL COMMENT '판매정가', -- 판매정가
	origiprice INT         NOT NULL COMMENT '판매원가', -- 판매원가
	isexist    BOOLEAN     NOT NULL COMMENT '존재유무' -- 존재유무
)
COMMENT '제품';

-- 제품
ALTER TABLE Product
	ADD CONSTRAINT PK_Product -- 제품 기본키
		PRIMARY KEY (
			code -- 제품코드
		);

-- 거래처
CREATE TABLE Customer (
	code    VARCHAR(4)  NOT NULL COMMENT '거래처코드', -- 거래처코드
	name    VARCHAR(11) NOT NULL COMMENT '거래처명', -- 거래처명
	grade   VARCHAR(1)  NOT NULL COMMENT '거래처등급', -- 거래처등급
	isexist BOOLEAN     NOT NULL COMMENT '존재유무' -- 존재유무
)
COMMENT '거래처';

-- 거래처
ALTER TABLE Customer
	ADD CONSTRAINT PK_Customer -- 거래처 기본키
		PRIMARY KEY (
			code -- 거래처코드
		);

-- 사원등급
CREATE TABLE EGrade (
	grade  VARCHAR(1) NOT NULL COMMENT '사원등급', -- 사원등급
	dispct INT        NOT NULL COMMENT '할인율' -- 할인율
)
COMMENT '사원등급';

-- 사원등급
ALTER TABLE EGrade
	ADD CONSTRAINT PK_EGrade -- 사원등급 기본키
		PRIMARY KEY (
			grade -- 사원등급
		);

-- 거래처등급
CREATE TABLE CGrade (
	grade  VARCHAR(1) NOT NULL COMMENT '거래처등급', -- 거래처등급
	dispct INT        NOT NULL COMMENT '할인율' -- 할인율
)
COMMENT '거래처등급';

-- 거래처등급
ALTER TABLE CGrade
	ADD CONSTRAINT PK_CGrade -- 거래처등급 기본키
		PRIMARY KEY (
			grade -- 거래처등급
		);

-- 거래내역
CREATE TABLE SellInfo (
	scode      VARCHAR(4) NOT NULL COMMENT '거래처내역코드', -- 거래처내역코드
	ecode       VARCHAR(4) NOT NULL COMMENT '사원코드', -- 사원코드
	pcode      VARCHAR(4) NOT NULL COMMENT '제품코드', -- 제품코드
	ccode      VARCHAR(4) NOT NULL COMMENT '거래처코드', -- 거래처코드
	saledate   DATE       NOT NULL COMMENT '거래일자', -- 거래일자
	quantity   INT        NOT NULL COMMENT '판매수량', -- 판매수량
	saleprice  INT        NOT NULL COMMENT '판매정가', -- 판매정가
	origiprice INT        NOT NULL COMMENT '판매원가', -- 판매원가
	dispct		INT		not null COMMENT '할인율', -- 할인율
	isexist    BOOLEAN    NOT NULL COMMENT '존재유무' -- 존재유무
)
COMMENT '거래내역';
drop table sellinfo;
drop table sellinfodetail;
-- 거래내역
ALTER TABLE SellInfo
	ADD CONSTRAINT PK_SellInfo -- 거래내역 기본키
		PRIMARY KEY (
			scode -- 거래처내역코드
		);



-- 사원
ALTER TABLE Employee
	ADD CONSTRAINT FK_EGrade_TO_Employee -- 사원등급 -> 사원
		FOREIGN KEY (
			egrade -- 사원등급
		)
		REFERENCES EGrade ( -- 사원등급
			grade -- 사원등급
		);

-- 거래처
ALTER TABLE Customer
	ADD CONSTRAINT FK_CGrade_TO_Customer -- 거래처등급 -> 거래처
		FOREIGN KEY (
			cgrade -- 거래처등급
		)
		REFERENCES CGrade ( -- 거래처등급
			grade -- 거래처등급
		);

-- 거래내역
ALTER TABLE SellInfo
	ADD CONSTRAINT FK_Employee_TO_SellInfo -- 사원 -> 거래내역
		FOREIGN KEY (
			ecode -- 사원코드
		)
		REFERENCES Employee ( -- 사원
			code -- 사원코드
		);

-- 거래내역
ALTER TABLE SellInfo
	ADD CONSTRAINT FK_Product_TO_SellInfo -- 제품 -> 거래내역
		FOREIGN KEY (
			pcode -- 제품코드
		)
		REFERENCES Product ( -- 제품
			code -- 제품코드
		);

-- 거래내역
ALTER TABLE SellInfo
	ADD CONSTRAINT FK_Customer_TO_SellInfo -- 거래처 -> 거래내역
		FOREIGN KEY (
			ccode -- 거래처코드
		)
		REFERENCES Customer ( -- 거래처
			code -- 거래처코드
		);



INSERT INTO customer
(code, name, grade,isexist)
VALUES('C003', '빽다방', 'S',true),('C002', '콩다방', 'L',true),('C004', '별다방', 'M',true);
INSERT INTO product
(code, name, saleprice, origiprice,isexist)
VALUES('P002', '코스타리카',25000,8000,true),('P004', '콜롬비아',20000,6000,true),('P003', '예가체프',30000,10000,true);
select * from product;
INSERT INTO employee
(code, name, grade,isexist)
VALUES('E003', '신진욱', 'C',true),('E002', '이준욱', 'A',true),('E001', '설동훈', 'B',true);


/*
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
*/

     
select * from sellInfo;

		
INSERT INTO donghun2.sellinfo
(scode, ecode, pcode, ccode, saledate, quantity, saleprice, origiprice,dispct,isexist)
values('S003','E001','P002','C002',now(),150,25000,8000,8,true),
		('S002','E003','P001','C003',now(),50,5000,500,6,true),
		('S001','E002','P003','C001',now(),30,30000,10000,6,true),
		('S004','E004','P004','C004',now(),40,20000,6000,8,true);
		
select * from employee;
select * from product;
select * from customer;

drop view if exists vw_calculate_sellInfo;
create view vw_calculate_sellInfo as
select s.scode,
(saleprice)*(1-(eg.dispct+cg.dispct)*0.01) as unitPrice,
(saleprice)*(1-(eg.dispct+cg.dispct)*0.01)*(quantity) as sellPrice,
(saleprice) * (quantity) -(saleprice*(1-(eg.dispct+cg.dispct)*0.01)*quantity) as disprice,
(saleprice*(1-(eg.dispct+cg.dispct)*0.01)*quantity)-(origiprice*quantity) as marginprice,
ROUND(((saleprice*(1-(eg.dispct+cg.dispct)*0.01)*quantity)-origiprice*quantity) / ((saleprice*(1-(eg.dispct+cg.dispct)*0.01))*(quantity))*100, 1) as marginPct
from sellinfo s
join employee e on s.ecode=e.code
join egrade EG on EG.grade=e.grade
join customer c on s.ccode=c.code
join cgrade CG on CG.grade=c.grade;

select * from vw_calculate_sellInfo;
		


create view vw_InfoByProduct as
select c.code ccode, c.name cname, quantity, sellprice, disprice, marginprice, marginpct
from sellinfo s join vw_calculate_sellInfo vwcs on vwcs.scode= s.scode join customer c on c.code=s.ccode
order by ccode asc;		-- 주의 사항 처리해야함

select ccode, cname, quantity, sellprice, disprice, marginprice, marginpct
from vw_InfoByProduct;

 drop view vw_InfoByProduct;

create view vw_InfoByEmployee as
select e.code ecode, e.name ename, sellprice, marginprice, marginpct
from sellinfo s join vw_calculate_sellInfo vwcs on vwcs.scode= s.scode join employee e on e.code=s.ecode
order by ecode asc;

select ecode, ename, sellprice, marginprice, marginpct
from vw_InfoByEmployee;

drop view vw_InfoByEmployee;

=======
-- 거래처 영업 관리 프로그램
DROP SCHEMA IF EXISTS donghun2;

-- 거래처 영업 관리 프로그램
CREATE SCHEMA donghun2;

-- 사원
CREATE TABLE donghun2.Employee (
	code    VARCHAR(4)  NOT NULL, -- 사원코드
	name    VARCHAR(11) NOT NULL, -- 사원명
	grade   VARCHAR(1)  NOT NULL, -- 사원등급
	isexist BOOLEAN     NOT NULL  -- 존재유무
);

-- 사원
ALTER TABLE donghun2.Employee
	ADD CONSTRAINT PK_Employee -- 사원 기본키
		PRIMARY KEY (
			code -- 사원코드
		);

-- 제품
CREATE TABLE donghun2.Product (
	code       VARCHAR(4)  NOT NULL, -- 제품코드
	name       VARCHAR(11) NOT NULL, -- 제품명
	saleprice  INT         NOT NULL, -- 판매정가
	origiprice INT         NOT NULL, -- 판매원가
	isexist    BOOLEAN     NOT NULL  -- 존재유무
);

-- 제품
ALTER TABLE donghun2.Product
	ADD CONSTRAINT PK_Product -- 제품 기본키
		PRIMARY KEY (
			code -- 제품코드
		);

-- 거래처
CREATE TABLE donghun2.Customer (
	code    VARCHAR(4)  NOT NULL, -- 거래처코드
	name    VARCHAR(11) NOT NULL, -- 거래처명
	grade   VARCHAR(1)  NOT NULL, -- 거래처등급
	isexist BOOLEAN     NOT NULL  -- 존재유무
);

-- 거래처
ALTER TABLE donghun2.Customer
	ADD CONSTRAINT PK_Customer -- 거래처 기본키
		PRIMARY KEY (
			code -- 거래처코드
		);

-- 사원등급
CREATE TABLE donghun2.EGrade (
	grade   VARCHAR(1) NOT NULL, -- 사원등급
	edispct INT        NOT NULL, -- 할인율
	isexist BOOLEAN    NOT NULL  -- 존재유무
);

-- 사원등급
ALTER TABLE donghun2.EGrade
	ADD CONSTRAINT PK_EGrade -- 사원등급 기본키
		PRIMARY KEY (
			grade -- 사원등급
		);

-- 거래처등급
CREATE TABLE donghun2.CGrade (
	grade   VARCHAR(1) NOT NULL, -- 거래처등급
	cdispct INT        NOT NULL, -- 할인율
	isexist BOOLEAN    NOT NULL  -- 존재유무
);

-- 거래처등급
ALTER TABLE donghun2.CGrade
	ADD CONSTRAINT PK_CGrade -- 거래처등급 기본키
		PRIMARY KEY (
			grade -- 거래처등급
		);

-- 거래내역
CREATE TABLE donghun2.SellInfo (
	scode      VARCHAR(4) NOT NULL, -- 거래처내역코드
	code       VARCHAR(4) NOT NULL, -- 사원코드
	code2      VARCHAR(4) NOT NULL, -- 제품코드
	code3      VARCHAR(4) NOT NULL, -- 거래처코드
	saledate   DATE       NOT NULL, -- 거래일자
	quantity   INT        NOT NULL, -- 판매수량
	saleprice  INT        NOT NULL, -- 판매정가
	origiprice INT        NOT NULL, -- 판매원가
	dispct     INT        NOT NULL, -- 할인율
	isexist    BOOLEAN    NOT NULL  -- 존재유무
);

-- 거래내역
ALTER TABLE donghun2.SellInfo
	ADD CONSTRAINT PK_SellInfo -- 거래내역 기본키
		PRIMARY KEY (
			scode -- 거래처내역코드
		);




-- 사원
ALTER TABLE donghun2.Employee
	ADD CONSTRAINT FK_EGrade_TO_Employee -- 사원등급 -> 사원
		FOREIGN KEY (
			grade -- 사원등급
		)
		REFERENCES donghun2.EGrade ( -- 사원등급
			grade -- 사원등급
		);

-- 거래처
ALTER TABLE donghun2.Customer
	ADD CONSTRAINT FK_CGrade_TO_Customer -- 거래처등급 -> 거래처
		FOREIGN KEY (
			grade -- 거래처등급
		)
		REFERENCES donghun2.CGrade ( -- 거래처등급
			grade -- 거래처등급
		);

-- 거래내역
ALTER TABLE donghun2.SellInfo
	ADD CONSTRAINT FK_Employee_TO_SellInfo -- 사원 -> 거래내역
		FOREIGN KEY (
			code -- 사원코드
		)
		REFERENCES donghun2.Employee ( -- 사원
			code -- 사원코드
		);

-- 거래내역
ALTER TABLE donghun2.SellInfo
	ADD CONSTRAINT FK_Product_TO_SellInfo -- 제품 -> 거래내역
		FOREIGN KEY (
			code2 -- 제품코드
		)
		REFERENCES donghun2.Product ( -- 제품
			code -- 제품코드
		);

-- 거래내역
ALTER TABLE donghun2.SellInfo
	ADD CONSTRAINT FK_Customer_TO_SellInfo -- 거래처 -> 거래내역
		FOREIGN KEY (
			code3 -- 거래처코드
		)
		REFERENCES donghun2.Customer ( -- 거래처
			code -- 거래처코드
		);
>>>>>>> refs/remotes/origin/master
