package kr.or.dgit.donghun2.dao;

import java.util.List;
import java.util.Vector;
import kr.or.dgit.donghun2.dto.Employee;

public interface EmployeeMapper {
	public int updateEmployee(Employee item);
	public int insertEmployee(Employee item);
	public List<Employee> selectEmployeeByAll();
	public Employee selectEmployeeByNo(Employee item);
	public int deleteEmployee(Employee item);
	
}
