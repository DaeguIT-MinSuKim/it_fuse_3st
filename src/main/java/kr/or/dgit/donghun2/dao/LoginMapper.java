package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.Login;


public interface LoginMapper {
	
	public Login selectLoginById(Login login);
	
	public int insertLogin(Login login);

	public List<Login> selectLoginByPw();

	public Login selectLoginByGrade(Login login);
}
