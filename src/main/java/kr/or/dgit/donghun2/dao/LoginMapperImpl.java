package kr.or.dgit.donghun2.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.Login;

public class LoginMapperImpl implements LoginMapper{
private String namespace = "kr.or.dgit.donghun2.dao.LoginMapper.";
	
	private SqlSession sqlSession;
	public LoginMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int insertLogin(Login login) {
		return sqlSession.insert(namespace+"insertLogin", login);
	}
}
