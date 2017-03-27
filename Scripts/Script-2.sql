-- 거래처 영업 관리 프로그램
DROP SCHEMA IF EXISTS donghun2;

-- 거래처 영업 관리 프로그램
CREATE SCHEMA donghun2;

drop table sellinfodetail;
drop table sellinfo;
drop table employee;
drop table customer;
drop table egrade;
drop table cgrade;
drop table product;
-- 사원
CREATE TABLE donghun2.Employee (
	code  VARCHAR(4)  NOT NULL, -- 사원코드
	grade VARCHAR(1)  NOT NULL, -- 사원등급
	name  VARCHAR(11) NOT NULL  -- 사원명
);

-- 사원
ALTER TABLE donghun2.Employee
	ADD CONSTRAINT PK_Employee -- 사원 기본키
		PRIMARY KEY (
			code -- 사원코드
		);

-- 제품
CREATE TABLE donghun2.product (
	code       VARCHAR(4)  NOT NULL, -- 제품코드
	name       VARCHAR(11) NOT NULL, -- 제품명
	salePrice  INT         NOT NULL, -- 판매정가
	origiPrice INT         NOT NULL  -- 판매원가
);

-- 제품
ALTER TABLE donghun2.product
	ADD CONSTRAINT PK_product -- 제품 기본키
		PRIMARY KEY (
			code -- 제품코드
		);

-- 거래처
CREATE TABLE donghun2.customer (
	code  VARCHAR(4)  NOT NULL, -- 거래처코드
	grade VARCHAR(1)  NOT NULL, -- 거래처등급
	name  VARCHAR(11) NOT NULL  -- 거래처명
);

-- 거래처
ALTER TABLE donghun2.customer
	ADD CONSTRAINT PK_customer -- 거래처 기본키
		PRIMARY KEY (
			code -- 거래처코드
		);

-- 거래내역
CREATE TABLE donghun2.sellInfo (
	scode    VARCHAR(4) NOT NULL, -- 거래내역코드
	ecode    VARCHAR(4) NOT NULL, -- 사원코드
	pcode    VARCHAR(4) NOT NULL, -- 제품코드
	ccode   VARCHAR(4) NOT NULL, -- 거래처코드
	quantity INT        NOT NULL, -- 판매수량
	saleDate INT        NOT NULL  -- 거래일자
);

-- 거래내역
ALTER TABLE donghun2.sellInfo
	ADD CONSTRAINT PK_sellInfo -- 거래내역 기본키
		PRIMARY KEY (
			scode -- 거래내역코드
		);



-- 사원등급
CREATE TABLE donghun2.EGrade (
	grade  VARCHAR(1) NOT NULL, -- 사원등급
	disPct INT        NULL      -- 할인율
);

-- 사원등급
ALTER TABLE donghun2.EGrade
	ADD CONSTRAINT PK_EGrade -- 사원등급 기본키
		PRIMARY KEY (
			grade -- 사원등급
		);

-- 거래내역상세
CREATE TABLE donghun2.SellInfoDetail (
	scode       VARCHAR(4) NOT NULL, -- 거래내역코드
	unitPrice   INT        NOT NULL, -- 판매단가
	sellPrice   INT        NOT NULL, -- 판매금액
	disPrice    INT        NOT NULL, -- 할인금액
	marginPrice INT        NULL,     -- 마진액
	marginPct   INT        NULL      -- 마진율
);

-- 거래내역상세
ALTER TABLE donghun2.SellInfoDetail
	ADD CONSTRAINT PK_SellInfoDetail -- 거래내역상세 기본키
		PRIMARY KEY (
			scode -- 거래내역코드
		);

-- 거래처등급
CREATE TABLE donghun2.CGrade (
	grade  VARCHAR(1) NOT NULL, -- 거래처등급
	disPct INT        NULL      -- 할인율
);

-- 거래처등급
ALTER TABLE donghun2.CGrade
	ADD CONSTRAINT PK_CGrade -- 거래처등급 기본키
		PRIMARY KEY (
			grade -- 거래처등급
		);



-- 사원
ALTER TABLE donghun2.Employee
	ADD CONSTRAINT FK_EGrade_TO_Employee -- 사원등급 -> 사원2
		FOREIGN KEY (
			grade -- 사원등급
		)
		REFERENCES donghun2.EGrade ( -- 사원등급
			grade -- 사원등급
		);

-- 거래처
ALTER TABLE donghun2.customer
	ADD CONSTRAINT FK_cGrade_TO_customer -- 거래처등급 -> 거래처
		FOREIGN KEY (
			grade -- 거래처등급
		)
		REFERENCES donghun2.cGrade ( -- 거래처등급
			grade -- 거래처등급
		);



-- 거래내역
ALTER TABLE donghun2.sellInfo
	ADD CONSTRAINT FK_Employee_TO_sellInfo -- 사원 -> 거래내역
		FOREIGN KEY (
			ecode -- 사원코드
		)
		REFERENCES donghun2.Employee ( -- 사원
			code -- 사원코드
		);

-- 거래내역
ALTER TABLE donghun2.sellInfo
	ADD CONSTRAINT FK_product_TO_sellInfo -- 제품 -> 거래내역
		FOREIGN KEY (
			pcode -- 제품코드
		)
		REFERENCES donghun2.product ( -- 제품
			code -- 제품코드
		);

-- 거래내역
ALTER TABLE donghun2.sellInfo
	ADD CONSTRAINT FK_customer_TO_sellInfo -- 거래처 -> 거래내역
		FOREIGN KEY (
			ccode -- 거래처코드
		)
		REFERENCES donghun2.customer ( -- 거래처
			code -- 거래처코드
		);

-- 거래내역상세
ALTER TABLE donghun2.SellInfoDetail
	ADD CONSTRAINT FK_sellInfo_TO_SellInfoDetail -- 거래내역 -> 거래내역상세
		FOREIGN KEY (
			scode -- 거래내역코드
		)
		REFERENCES donghun2.sellInfo ( -- 거래내역
			scode -- 거래내역코드
		);
		

insert into egrade values('A', 3);
insert into egrade values('B', 2);
insert into egrade values('C', 1);
insert into cgrade values('L', 4);
insert into cgrade values('M', 5);
insert into cgrade values('S', 6);
insert into customer(code, name, grade) values('C001','DGIT','L');
insert into employee(code, name, grade) values ('E001','설동훈','A');
insert into product values('P001','자바',1000,100);

;
delete from sellinfo where scode = 'S001';
select * from sellinfo;
select * from customer;
select * from employee;
select * from product;
select * from sellinfodetail;

select saleprice, origiprice, eg.dispct, cg.dispct unitprice,sellprice,disprice,marginprice,marginpct 
from product p 
join sellinfo sel on p.code = sel.pcode 
join sellinfodetail seld on sel.scode = seld.scode 
join employee e on e.code=sel.ecode
join customer c on c.code=sel.ecode
join egrade eg on e.grade = eg.grade
join cgrade cg on c.grade = cg.grade;


drop trigger tri_sellinfo_insert_after_detail;
-- insert trigger
create trigger tri_sellinfo_insert_after_detail
after insert on sellinfo
for each row 
begin
	set @unitPrice = (select salePrice from product p where p.code = new.pcode)*
				((select disPct from egrade eg join Employee e on eg.grade=e.grade where e.code=new.ecode)+
				(select disPct from cgrade cg join customer c on cg.grade=c.grade where c.code=new.ccode))
				*0.01,
		@sellPrice = @unitPrice*new.quantity,
		@disPrice = (select saleprice from product p where pcode = new.pcode) * new.quantity - @sellPrice,
		@marginPrice = @sellprice-(select origiPrice from product p where pcode = new.pcode)*(new.quantity),
		@marginpct = @marginPrice/@sellprice*100;
	INSERT INTO sellinfodetail(unitPrice,salePrice,disPrice,marginPrice,marginPct)
	VALUES(@unitprice, @addtax, @supprice, @marPrice);

	
end;


