package kr.or.dgit.donghun2.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.ProductService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {
	private static ProductService productService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		productService = ProductService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		productService = null;
	}

	@Test
	public void aTestSelectProductByAll() {
		List<Product> products = productService.selectProductByAll();
		for(Product p : products){
			System.out.println(p);
		}
		Assert.assertNotNull(products);
	}
/*	
   @Test
	public void bTestInsertProduct() {
		Product item = new Product();
		item.setCode("P007");
		item.setName("딸기요거트");
		item.setSalePrice(6000);
		item.setOrigiPrice(3000);
		int res = productService.insertProduct(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void cTestUpdateProduct() {
		Product	item = new Product();
		item.setCode("P005");
		item.setName("아메리카노");
		item.setSalePrice(1000);
		item.setOrigiPrice(500);
		int res = productService.updateProduct(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void dTestDeleteProduct() {
		Product	item = new Product();
		item.setCode("P001");
		int res = productService.deleteProduct(item);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void eTestSelectProductByNo() {
		Product	item = new Product();
		item.setCode("P005");
		Product product = productService.selectProductByNo(item);
		
		Assert.assertNotNull(product);
	}	
	
	@Test
	public void fTestSelectProductByNoForSellInfo() {
		Product	item = new Product();
		item.setCode("P005");
		Product product = productService.selectProductByNoForSellInfo(item);
		
		Assert.assertNotNull(product);
	}
	*/
	
}
