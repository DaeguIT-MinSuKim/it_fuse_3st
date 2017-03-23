package kr.or.dgit.donghun2.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.EmployeeMapper;
import kr.or.dgit.donghun2.dao.EmployeeMapperImpl;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class EmployeeService {
	private static final Log log = LogFactory.getLog(EmployeeService.class);

	private static final EmployeeService instance = new EmployeeService();
	public static EmployeeService getInstance() {return instance;};
	
	
	public List<Employee> selectEmployeeByAll(){
		log.debug("selectEmployeeByAll()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			EmployeeMapper EmployeeMapper = new EmployeeMapperImpl(sqlSession);
			return EmployeeMapper.selectEmployeeByAll();
		}
	}

	public int insertEmployee(Employee Employee){
		log.debug("insertEmployee()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			EmployeeMapper EmployeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = EmployeeMapper.insertEmployee(Employee);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateEmployee(Employee Employee){
		log.debug("updateEmployee()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			EmployeeMapper EmployeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = EmployeeMapper.updateEmployee(Employee);
			sqlSession.commit();
			return res;
		}
	}
	public int deleteEmployee(Employee code){
		log.debug("updateEmployee()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			EmployeeMapper EmployeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = EmployeeMapper.deleteEmployee(code);
			sqlSession.commit();
			return res;
		}
	}
	
	public Employee selectEmployeeByNo(Employee code){
		log.debug("selectEmployeeByNo()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			EmployeeMapper EmployeeMapper = new EmployeeMapperImpl(sqlSession);
			return EmployeeMapper.selectEmployeeByNo(code);
		}
	}
}
