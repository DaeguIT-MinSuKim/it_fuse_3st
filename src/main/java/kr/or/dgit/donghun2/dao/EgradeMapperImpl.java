package kr.or.dgit.donghun2.dao;

import org.apache.ibatis.session.SqlSession;

public class EgradeMapperImpl implements CgradeMapper {
private String namespace = "kr.or.dgit.donghun2.dao.EgradeMapper.";
	
	private SqlSession sqlSession;
	public EgradeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
/*	@Override
	public Egrade selectDiscntByGrade() {
		return sqlSession.selectOne(namespace+"selectDiscntByGrade",?);
	}*/

}
