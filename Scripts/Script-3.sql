drop view vw_InfoByEmployee;
create view vw_InfoByEmployee as
select e.code ecode, e.name ename, saledate,sellprice, marginprice, marginpct
from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join employee e on s.ecode = e.code
order by e.code asc;

select ecode, ename,  saledate,sellprice,marginprice, marginpct
from vw_InfoByEmployee
where ecode = 'E001';

-- 로그인
CREATE TABLE donghun2.Login (
	id       VARCHAR(12) NOT NULL, -- 아이디
	password VARCHAR(15) NOT NULL  -- 비밀번호
);

-- 로그인
ALTER TABLE donghun2.Login
	ADD CONSTRAINT PK_Login -- 로그인 기본키
		PRIMARY KEY (
			id -- 아이디
		);



