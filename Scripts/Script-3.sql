drop view vw_InfoByEmployee;
create view vw_InfoByEmployee as
select e.code ecode, e.name ename, saledate,sellprice, marginprice, marginpct
from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join employee e on s.ecode = e.code
order by e.code asc;

select ecode, ename,  saledate,sellprice,marginprice, marginpct
from vw_InfoByEmployee
where ecode = 'E001';
