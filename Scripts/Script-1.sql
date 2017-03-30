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
