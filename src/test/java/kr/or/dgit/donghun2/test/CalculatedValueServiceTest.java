package kr.or.dgit.donghun2.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.service.CalculatedValueService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatedValueServiceTest {
	private static CalculatedValueService calculatedValueService;
	
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
//		CalculatedValue	item = new CalculatedValue();
//		item.setScode("S001");
		List<CalculatedValue> calculatedValues = calculatedValueService.vw_InfoByCustomer();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
	}
	
	@Test
	public void dTestvw_InfoByProduct() {
//		CalculatedValue	item = new CalculatedValue();
//		item.setScode("S001");
		List<CalculatedValue> calculatedValues = calculatedValueService.vw_InfoByProduct();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
	}
	
	@Test
	public void eTestvw_InfoByEmployee() {
//		CalculatedValue	item = new CalculatedValue();
//		item.setScode("S001");
		List<CalculatedValue> calculatedValues = calculatedValueService.vw_InfoByEmployee();
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
	}
	/*
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
	
	@Test
	public void cTestvw_InfoByCustomer() {
		CalculatedValue	item = new CalculatedValue();
		item.setScode("S001");
		CalculatedValue calculatedValue = calculatedValueService.vw_InfoByCustomer(item);
		
		Assert.assertNotNull(calculatedValue);
	}

*/
}
