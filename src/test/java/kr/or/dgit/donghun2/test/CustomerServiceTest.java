package kr.or.dgit.donghun2.test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import kr.or.dgit.donghun2.service.CustomerService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceTest {
	private static CustomerService customerService;
	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		customerService = CustomerService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		customerService = null;
	}
	
<<<<<<< HEAD
	
=======
	/*@Test
	public void fTestSelectDiscnt() {
		Customer	item = new Customer();
		item.setCode("C001");
		Customer res = customerService.selectDiscnt(item);
	}*/
	/*
>>>>>>> refs/remotes/origin/jinuk
	@Test
	public void aTestSelectCustomerByAll() {
		List<Customer> customers = customerService.selectCustomerByAll();
		for(Customer c : customers){
			System.out.println(c);
		}
		Assert.assertNotNull(customers);
	}
	
	
	@Test
	public void bTestInsertCustomer() {
		Customer item = new Customer();
		item.setCode("C001");
		item.setName("스벅꾸");
		item.setGrade("B");
		int res = customerService.insertCustomer(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void cTestUpdateCustomer() {
		Customer	item = new Customer();
		item.setCode("C001");
		item.setName("스타벅스");
		item.setGrade("A");
		int res = customerService.updateCustomer(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void dTestDeleteCustomer() {
		Customer	item = new Customer();
		item.setCode("C001");
		int res = customerService.deleteCustomer(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void eTestSelectCustomerByNo() {
		Customer	item = new Customer();
		item.setCode("C1");
		Customer Customer = customerService.selectCustomerByNo(item);
		
		Assert.assertNotNull(Customer);
	}	
	
		@Test
	public void fTestSelectDiscnt() {
		Customer	item = new Customer();
		item.setCode("C001");
		Customer c = customerService.selectDiscnt(item);
		
		System.out.println(c.getcGrade().getDispct());
	}

	*/

	
	
}
