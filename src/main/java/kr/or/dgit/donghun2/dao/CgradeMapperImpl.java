package kr.or.dgit.donghun2.dao;

import org.apache.ibatis.session.SqlSession;

public class CgradeMapperImpl implements CgradeMapper {
private String namespace = "kr.or.dgit.donghun2.dao.CgradeMapper.";
	
	private SqlSession sqlSession;
	public CgradeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
/*	@Override
	public Cgrade selectDiscntByGrade() {
		return sqlSession.selectOne(namespace+"selectDiscntByGrade",?);
	}*/

}
