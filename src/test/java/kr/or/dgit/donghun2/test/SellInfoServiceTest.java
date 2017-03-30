package kr.or.dgit.donghun2.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.donghun2.dto.SellInfo;
import kr.or.dgit.donghun2.service.SellInfoService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SellInfoServiceTest {
	private static SellInfoService sellInfoService;

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
	/*
	@Test
	public void aTestSelectSellInfoByAll() {
		List<SellInfo> sellInfos = sellInfoService.selectSellInfoByAll();
		for(SellInfo s : sellInfos){
			System.out.println(s);
		}
		Assert.assertNotNull(sellInfos);
	}
	
   @Test
	public void bTestInsertSellInfo() {
	   SellInfo item = new SellInfo();
		item.setScode("S001");
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
