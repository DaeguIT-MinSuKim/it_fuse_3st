package kr.or.dgit.donghun2.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.donghun2.dto.Login;
import kr.or.dgit.donghun2.service.LoginService;

public class LoginServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test 
	public void insertLogin(){
		Login item = new Login();
		item.setId("ehdgnsdms321");
		item.setPassword("1234567");
		int res = LoginService.getInstance().insertLogin(item);
	}
}
