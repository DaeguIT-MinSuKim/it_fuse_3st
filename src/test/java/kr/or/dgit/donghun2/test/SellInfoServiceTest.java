package kr.or.dgit.donghun2.test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SellInfoServiceTest {
	/*private static SellInfoService sellInfoService;*/
/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		sellInfoService = SellInfoService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		sellInfoService = null;
	}
	
	@Test
	public void aTestSelectSellInfoByAll() {
		List<SellInfo> sellInfos = sellInfoService.selectSellInfoByAll();
		for(SellInfo s : sellInfos){
			System.out.println(s);
		}
		Assert.assertNotNull(sellInfos);
	}*/
	
/*   @Test
	public void bTestInsertSellInfo() {
	   SellInfo item = new SellInfo();
		item.setScode("S001");
		System.out.println(item);
		int res = sellInfoService.insertSellInfo(item);
		Assert.assertEquals(1,res);
	}*/
   /*
	@Test
	public void cTestUpdateSellInfo() {
		SellInfo	item = new SellInfo();
		item.setCode("S001");
		int res = sellInfoService.updateSellInfo(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void dTestDeleteSellInfo() {
		SellInfo	item = new SellInfo();
		item.setCode("S001");
		int res = sellInfoService.deleteSellInfo(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void eTestSelectSellInfoByNo() {
		SellInfo	item = new SellInfo();
		item.setCode("S001");
		SellInfo sellInfo = sellInfoService.selectSellInfoByNo(item);
		
		Assert.assertNotNull(sellInfo);
	}	*/
	

}
