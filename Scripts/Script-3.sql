select saledate, p.code, p.name,quantity, sellprice,disprice, marginprice, marginpct
from product p join sellinfo sel on p.code=sel.pcode join sellinfodetail seld on sel.scode = seld.scode;