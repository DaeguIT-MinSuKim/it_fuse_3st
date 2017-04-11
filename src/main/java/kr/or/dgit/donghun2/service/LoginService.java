package kr.or.dgit.donghun2.service;


import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.LoginMapper;
import kr.or.dgit.donghun2.dao.LoginMapperImpl;
import kr.or.dgit.donghun2.dto.Login;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class LoginService {
	private static final Log log=LogFactory.getLog(LoginService.class);
	
	private static final LoginService instance = new LoginService();
	public static LoginService getInstance(){return instance;};
	
	public Login selectLoginById(Login login){
		log.debug("selectLoginById()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			LoginMapper loginMapper = new LoginMapperImpl(sqlSession);
			return loginMapper.selectLoginById(login);
		}
	}
	public List<Login> selectLoginByPw(){
		log.debug("selectLoginByPw()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			LoginMapper loginMapper = new LoginMapperImpl(sqlSession);
			return loginMapper.selectLoginByPw();
		}
	}
	public int insertLogin(Login login){
		log.debug("insertLogin()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			LoginMapper loginMapper = new LoginMapperImpl(sqlSession);
			int res = loginMapper.insertLogin(login);
			sqlSession.commit();
			return res;
		}
	}
	public boolean selectLoginByGrade(Login login){
		log.debug("selectLoginByGrade()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			LoginMapper loginMapper = new LoginMapperImpl(sqlSession);
			return loginMapper.selectLoginByGrade(login);
		}
	}
}
