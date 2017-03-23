package kr.or.dgit.donghun2.dao;

import java.util.Vector;

import kr.or.dgit.donghun2.dto.SellInfo;

public interface SellInfoMapper {
	public int updateSellInfo(SellInfo item);
	public int insertSellInfo(SellInfo item);
	public Vector<SellInfo> selectItemByAll();
	public SellInfo selectItemByNo(SellInfo item);
	public int deleteSellInfo(SellInfo item);
	
}
