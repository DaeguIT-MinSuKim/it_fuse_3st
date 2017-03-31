package kr.or.dgit.donghun2.test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import kr.or.dgit.donghun2.service.EmployeeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {
	private static EmployeeService employeeService;
	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		employeeService = EmployeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		employeeService = null;
	}

	@Test
	public void aTestSelectEmployeeByAll() {
		List<Employee> employees = employeeService.selectEmployeeByAll();
		for(Employee c : employees){
			System.out.println(c);
		}
		Assert.assertNotNull(employees);
	}
	
	@Test
	public void bTestInsertEmployee() {
		Employee item = new Employee();
		item.setCode("E001");
		item.setName("신진욱");
		item.setGrade("B");
		int res = employeeService.insertEmployee(item);
		Assert.assertEquals(1,res);
	}
	
	
	@Test
	public void cTestUpdateEmployee() {
		Employee	item = new Employee();
		item.setCode("E001");
		item.setName("설동훈");
		item.setGrade("A");
		int res = employeeService.updateEmployee(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void dTestSelectEmployeeByNo() {
		Employee	item = new Employee();
		item.setCode("E001");
		Employee employee = employeeService.selectEmployeeByNo(item);
		
		Assert.assertNotNull(employee);
	}	
	
	@Test
	public void eTestDeleteEmployee() {
		Employee	item = new Employee();
		item.setCode("E001");
		int res = employeeService.deleteEmployee(item);
		Assert.assertEquals(1,res);
	}
	
*/
}
