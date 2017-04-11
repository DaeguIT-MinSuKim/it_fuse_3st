package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.Login;

public class LoginMapperImpl implements LoginMapper {
	private String namespace="kr.or.dgit.donghun2.dao.LoginMapper.";
	
	private SqlSession sqlSession;
	
	public LoginMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Login selectLoginById(Login login) {
		return sqlSession.selectOne(namespace+"selectLoginById",login);
	}

	public int insertLogin(Login login) {
		return sqlSession.insert(namespace+"insertLogin",login);
	}

	public List<Login> selectLoginByPw() {
		return sqlSession.selectList(namespace+"selectLoginBypw");
	}

	public boolean selectLoginByGrade(String string) {
		return sqlSession.selectOne(namespace+"selectLoginByGrade");
	}

	

}
