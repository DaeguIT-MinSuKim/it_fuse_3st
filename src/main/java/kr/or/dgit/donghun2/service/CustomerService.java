
package kr.or.dgit.donghun2.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.CustomerMapper;
import kr.or.dgit.donghun2.dao.EmployeeMapper;
import kr.or.dgit.donghun2.dto.Cgrade;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class CustomerService {
	private static final Log log = LogFactory.getLog(CustomerService.class);

	private static final CustomerService instance = new CustomerService();
	public static CustomerService getInstance() {return instance;};
	
	
	public List<Customer> selectCustomerByAll(){
		log.debug("selectCustomerByAll()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			List<Customer> list =sqlSession.getMapper(CustomerMapper.class).selectCustomerByAll();
			return list;
/*			CustomerMapper customerMapper = new CustomerMapperImpl(sqlSession);
			return customerMapper.selectCustomerByAll();*/
		}
	}
	
	public int insertCustomer(Customer customer){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			int res = sqlSession.getMapper(CustomerMapper.class).insertCustomer(customer);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateCustomer(Customer customer){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			int res = customerMapper.updateCustomer(customer);
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
	
	public int deleteCustomer(Customer code){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			int res = sqlSession.getMapper(CustomerMapper.class).deleteCustomer(code);
			sqlSession.commit();
			return res;
		}
	}
	
	
	public Customer selectCustomerByNo(Customer code){
		log.debug("selectCustomerByNo()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			Customer customer = sqlSession.getMapper(CustomerMapper.class).selectCustomerByNo(code);
			return customer;
		}
	}


	public Customer selectDiscnt(Customer code) {
		log.debug("selectDiscnt()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			Customer customer = sqlSession.getMapper(CustomerMapper.class).selectDiscnt(code);
			System.out.println("********");
			
			return customer;
		}
	}
	public List<Customer> selectCustomerByAllDesc(){
		log.debug("selectCustomerByAllDesc()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			List<Customer> list =sqlSession.getMapper(CustomerMapper.class).selectCustomerByAllDesc();
			return list;
		}
	}
	
}
