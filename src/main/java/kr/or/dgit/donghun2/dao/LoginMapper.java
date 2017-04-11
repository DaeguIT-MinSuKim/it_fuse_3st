package kr.or.dgit.donghun2.dao;

import kr.or.dgit.donghun2.dto.Login;

	
import java.util.List;


public interface LoginMapper {
	
	public Login selectLoginById(Login login);
	
	public int insertLogin(Login login);

	public List<Login> selectLoginByPw();
	public boolean selectLoginByGrade(Login login);
}
