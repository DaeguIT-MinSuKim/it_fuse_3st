package kr.or.dgit.donghun2.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.EmployeeMapper;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class EmployeeService {
	private static final Log log = LogFactory.getLog(EmployeeService.class);

	private static final EmployeeService instance = new EmployeeService();
	public static EmployeeService getInstance() {return instance;};
	
	
	public List<Employee> selectEmployeeByAll(){
		log.debug("selectEmployeeByAll()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			List<Employee> list =sqlSession.getMapper(EmployeeMapper.class).selectEmployeeByAll();
			return list;
		}
	}
	
	public int insertEmployee(Employee employee){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			int res = sqlSession.getMapper(EmployeeMapper.class).insertEmployee(employee);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateEmployee(Employee employee){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			int res = employeeMapper.updateEmployee(employee);
			sqlSession.commit();
			return res;
		} catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteEmployee(Employee code){
		log.debug("deleteEmployee()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			int res = sqlSession.getMapper(EmployeeMapper.class).deleteEmployee(code);
			sqlSession.commit();
			return res;
		}
	}
	
	
	public Employee selectEmployeeByNo(Employee code){
		log.debug("selectEmployeeByNo()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			Employee employee = sqlSession.getMapper(EmployeeMapper.class).selectEmployeeByNo(code);
			return employee;
		}
	}
	
	
	public Employee selectDiscnt(Employee code){
		log.debug("selectDiscnt()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			Employee employee = sqlSession.getMapper(EmployeeMapper.class).selectDiscnt(code);
			return employee;
		}
	}
	public List<Employee> selectEmployeeByAllDesc(){
		log.debug("selectEmployeeByAllDesc()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			List<Employee> list =sqlSession.getMapper(EmployeeMapper.class).selectEmployeeByAllDesc();
			return list;
		}
	}
	


}
