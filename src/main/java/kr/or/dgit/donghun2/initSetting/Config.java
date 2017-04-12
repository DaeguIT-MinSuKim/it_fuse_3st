package kr.or.dgit.donghun2.initSetting;

public class Config {
	public static final String DB_NAME = "donghun2";
	public static final String USER   = "root";
	public static final String PWD    = "rootroot";
	public static final String URL    = "jdbc:mysql://localhost:3306/";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static final String[] TABLE_NAME = {"egrade","employee","product","cgrade","customer","sellinfo"};
	
	public static final String[] CREATE_SQL_TABLE={
			//영업사원 등급
			"create table egrade(	"
			+ "	grade varchar(1) not null primary key,"
			+ "	dispct int)	",
			
			//영업사원
			"CREATE TABLE employee (	"
			+ "	code  CHAR(4)  NOT NULL COMMENT '사원코드' PRIMARY KEY, "
			+ "	name  CHAR(11) NOT NULL COMMENT '사원명', "
			+ "	grade CHAR(1)  NOT NULL COMMENT '사원등급',"
			+ "	isexist BOOLEAN NOT NULL DEFAULT TRUE, "
			+ "	CONSTRAINT FK_employee"
			+ "		FOREIGN KEY (grade) REFERENCES  Egrade (grade)	)	"	,
			
			//제품
			"CREATE TABLE  product (		"
			+ "	code       CHAR(4)  NOT NULL COMMENT '제품코드' PRIMARY KEY,"
			+ "	name       CHAR(20) NOT NULL COMMENT '제품명',"
			+ "	saleprice  INT      NOT NULL COMMENT '판매정가', "
			+ "	origiprice INT      NOT NULL COMMENT '판매원가',"
			+ "	isexist BOOLEAN NOT NULL DEFAULT TRUE)	"	,
			
			//거래처등급
			"create table cgrade(		"
			+ "	grade varchar(1) not null primary key,"
			+ "	dispct int) "	,
			
			//거래처
			"CREATE TABLE  customer (		"
			+ "	code  CHAR(4)  NOT NULL COMMENT '거래처코드' PRIMARY KEY,"
			+ "	name  CHAR(11) NOT NULL COMMENT '거래처명',"
			+ "	grade CHAR(1)  NOT NULL COMMENT '거래처등급',"
			+ "	isexist BOOLEAN NOT NULL DEFAULT TRUE, "
			+ "	CONSTRAINT FK_customer"
			+ "	FOREIGN KEY (grade) REFERENCES  cgrade (grade)	) "	,
			//거래내역
			"CREATE TABLE  sellInfo (		"
			+ "	scode	  char(4) not null comment '거래내역코드' PRIMARY KEY,"
			+ "	ecode     CHAR(4) /*NOT NULL*/,"
			+ "	pcode     CHAR(4) /*NOT NULL*/, "
			+ "	ccode     CHAR(4) /*NOT NULL*/, "
			+ "	saledate  DATE    NOT NULL,"
			+ "	quantity  INT     NOT NULL,"
			+ "	saleprice int	  not null,"
			+ "	origiprice int	  not null, "
			+ "	dispcts int not null,"
			+ "	isexist BOOLEAN NOT NULL DEFAULT TRUE, "
			+ "	CONSTRAINT FK_sellInfo		"
			+ "		FOREIGN KEY (ecode) REFERENCES  employee (code),"
			+ "		FOREIGN KEY (pcode) REFERENCES  product (code),"
			+ "		FOREIGN KEY (ccode)	REFERENCES  customer (code)		) "	
			
	};

	public static final String[] CREATE_VIEW={
			// 거래내역 계산뷰
			"create view vw_calculate_sellInfo as"
			+ " select s.scode,e.code ecode, p.code pcode, c.code ccode,"
			+ " (s.saleprice * (1-((eg.dispct+cg.dispct)*0.01))) as unitPrice,"
			+ " ((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity as sellPrice,"
			+ " (s.saleprice) * (quantity) -  (((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity) as disprice,"
			+ " (((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity) - (s.origiprice * quantity) as marginprice,"
			+ " ROUND( ((((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity) - (s.origiprice * quantity))/(((s.saleprice * (1-((eg.dispct+cg.dispct)*0.01)))) * quantity)*100 ,1) as marginPct"
			+ " from sellinfo s "
			+ " join employee e on s.ecode= e.code "
			+ " join egrade eg on eg.grade=e.grade "
			+ " join customer c on s.ccode = c.code	"
			+ " join cgrade cg on cg.grade=c.grade "
			+ " join product p on s.pcode = p.code "	,
			// 거래처뷰
			" create view vw_InfoByCustomer as"
			+ " select s.ccode ccode,saledate, p.code pcode, p.name pname, quantity, sellprice, disprice, marginprice, marginpct"
			+ " from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join product p on s.pcode = p.code"
			+ " order by saledate desc "	,
			
			// 제품뷰
			" create view vw_InfoByProduct as"
			+ " select s.pcode pcode, c.code ccode, c.name cname, sum(quantity) quantity, sum(sellprice) sellprice, sum(disprice) disprice, sum(marginprice) marginprice, avg(marginpct) marginpct"
			+ " from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join customer c on s.ccode = c.code "
			+ " group by pcode"
			+ " order by pcode asc "	,
			
			// 사원뷰
			" create view vw_InfoByEmployee as "
			+ " select e.code ecode, e.name ename, saledate,sellprice, marginprice, marginpct"
			+ " from vw_calculate_sellInfo vw join sellinfo s on vw.scode= s.scode join employee e on s.ecode = e.code"
			+ " order by e.code asc " 	
	};

						
	public static final String EXPORT_IMPORT_DIR = System.getProperty("user.dir")+ "\\BackupFiles\\";
}
