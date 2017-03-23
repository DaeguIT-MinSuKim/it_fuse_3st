package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.Employee;

public class EmployeeMapperImpl implements EmployeeMapper{
	private String namespace = "kr.or.dgit.donghun2.dao.EmployeeMapper.";
	
	private SqlSession sqlSession;
	public EmployeeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<Employee> selectEmployeeByAll() {
		return sqlSession.selectList(namespace+"selectEmployeeByAll");
	}
	
	
	public int insertEmployee(Employee Employee) {
		return sqlSession.insert(namespace+"insertEmployee",Employee);
	}
	
	public int deleteEmployee(Employee code) {
		return sqlSession.delete(namespace+"deleteEmployee",code);
	}
	
	public int updateEmployee(Employee Employee) {
		return sqlSession.update(namespace+"updateEmployee",Employee);
	}

	
	public Employee selectEmployeeByNo(Employee code) {
		return sqlSession.selectOne(namespace+"selectEmployeeByNo",code);
	}


	

	
}
