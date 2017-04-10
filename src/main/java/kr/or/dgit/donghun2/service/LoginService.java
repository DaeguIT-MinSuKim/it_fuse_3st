package kr.or.dgit.donghun2.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.LoginMapper;
import kr.or.dgit.donghun2.dto.Login;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class LoginService {
	private static final Log log = LogFactory.getLog(LoginService.class);

	private static final LoginService instance = new LoginService();
	public static LoginService getInstance() {return instance;};
	
	public int insertLogin(Login login){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			int res = sqlSession.getMapper(LoginMapper.class).insertLogin(login);
			sqlSession.commit();
			return res;
		}
	}
}
