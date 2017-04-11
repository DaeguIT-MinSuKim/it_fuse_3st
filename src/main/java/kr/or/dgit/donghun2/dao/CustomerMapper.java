package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.Customer;

public interface CustomerMapper {
	
	List<Customer> selectCustomerByAll();
	
	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);
	
	int deleteCustomer(Customer customer);
	
	Customer selectCustomerByNo(Customer customer);

	Customer selectDiscnt(Customer code);
	List<Customer> selectCustomerByAllDesc();
}	
