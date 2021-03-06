package kr.or.dgit.donghun2.test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import kr.or.dgit.donghun2.service.CalculatedValueService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatedValueServiceTest {
	private static CalculatedValueService calculatedValueService;
	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		calculatedValueService = CalculatedValueService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		calculatedValueService = null;
	}
	
	@Test
	public void cTestvw_InfoByCustomer() {

		List<CalculatedValue> calculatedValues = calculatedValueService.vw_InfoByCustomer();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
	}
		
	@Test
	public void dTestvw_InfoByProduct() {

		List<CalculatedValue> calculatedValues = calculatedValueService.vw_InfoByProduct();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
	}
	
	@Test
	public void eTestvw_InfoByEmployee() {

		List<CalculatedValue> calculatedValues = calculatedValueService.vw_InfoByEmployee();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
	}
	
	@Test
	public void fTestvw_InfoByCustomerByCode() {
		Map<String, String> item = new HashMap<>();
		item.put("ccode", "C001");
		calculatedValueService.vw_InfoByCustomerByCode(item);
	}
	@Test
	public void gTestvw_InfoByProductByCode() {
		Map<String, String> item = new HashMap<>();
		item.put("pcode", "P001");
		calculatedValueService.vw_InfoByProductByCode(item);
	}
	@Test
	public void hTestvw_InfoByEmployeeByCode() {
		Map<String, String> item = new HashMap<>();
		item.put("ecode", "E001");
		calculatedValueService.vw_InfoByEmployeeByCode(item);
	}
	
	
	@Test
	public void aTestSelectSellInfoByAll() {
		List<CalculatedValue> calculatedValues = calculatedValueService.selectCalculatedValueByAll();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
		Assert.assertNotNull(calculatedValues);
	}
	
	@Test
	public void bTestSelectCalculatedValueByNo() {
		CalculatedValue	item = new CalculatedValue();
		item.setScode("S001");
		CalculatedValue calculatedValue = calculatedValueService.selectCalculatedValueByNo(item);
		
		Assert.assertNotNull(calculatedValue);
	}

*/
}
