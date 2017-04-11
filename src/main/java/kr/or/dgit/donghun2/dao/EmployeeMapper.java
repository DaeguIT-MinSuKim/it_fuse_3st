package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.Employee;

public interface EmployeeMapper {
	
	List<Employee> selectEmployeeByAll();
	
	int insertEmployee(Employee employee);

	int updateEmployee(Employee employee);
	
	int deleteEmployee(Employee employee);
	
	Employee selectEmployeeByNo(Employee employee);
	
	Employee selectDiscnt(Employee code);
	List<Employee> selectEmployeeByAllDesc();
}
