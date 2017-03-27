package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.dto.Employee;

public class EmployeeMapperImpl implements EmployeeMapper{
private String namespace = "kr.or.dgit.donghun2.dao.EmployeeMapper.";
	
	private SqlSession sqlSession;
	public EmployeeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		return sqlSession.selectList(namespace+"selectEmployeeByAll");
	}
	
	@Override
	public int insertEmployee(Employee employee) {
		return sqlSession.update(namespace+"insertEmployee",employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return sqlSession.update(namespace+"updateEmployee",employee);
	}

	@Override
	public int deleteEmployee(Employee code) {
		return sqlSession.delete(namespace+"deleteEmployee",code);
	}

	@Override
	public Employee selectEmployeeByNo(Employee code) {
		return sqlSession.selectOne(namespace+"selectEmployeeByNo",code);
	}


	
}
