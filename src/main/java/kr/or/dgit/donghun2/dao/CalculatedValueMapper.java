package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.CalculatedValue;

public interface CalculatedValueMapper {
	public List<CalculatedValue> selectCalculatedValueByAll();
	public CalculatedValue selectCalculatedValueByNo(CalculatedValue scode);
	public List<CalculatedValue> vw_InfoByCustomer();
	public List<CalculatedValue> vw_InfoByProduct();
	public List<CalculatedValue> vw_InfoByEmployee();
	public CalculatedValue vw_InfoByCustomerByCode(CalculatedValue ccode);
	public CalculatedValue vw_InfoByProductByCode(CalculatedValue pcode);
	public CalculatedValue vw_InfoByEmployeeByCode(CalculatedValue ecode);
}
