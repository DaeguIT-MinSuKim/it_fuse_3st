package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.Customer;

public class CustomerMapperImpl implements CustomerMapper{
	private String namespace = "kr.or.dgit.donghun2.dao.CustomerMapper.";
	
	private SqlSession sqlSession;
	public CustomerMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Customer> selectCustomerByAll() {
		return sqlSession.selectList(namespace+"selectCustomerByAll");
	}
	
	@Override
	public int insertCustomer(Customer customer) {
		return sqlSession.update(namespace+"insertCustomer",customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return sqlSession.update(namespace+"updateCustomer",customer);
	}

	@Override
	public int deleteCustomer(Customer code) {
		return sqlSession.delete(namespace+"deleteCustomer",code);
	}

	@Override
	public Customer selectCustomerByNo(Customer code) {
		return sqlSession.selectOne(namespace+"selectCustomerByNo",code);
	}

	@Override
	public Customer selectDiscnt(Customer code) {
		return sqlSession.selectOne(namespace+"selectDiscnt",code);
	}

	@Override
	public List<Customer> selectCustomerTrue(Customer isexist) {
		System.out.println("####");
		return sqlSession.selectList(namespace+"selectCustomerTrue", isexist);
	}


	
}
