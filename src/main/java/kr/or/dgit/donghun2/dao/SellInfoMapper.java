package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.SellInfo;

public interface SellInfoMapper {
	public int updateSellInfo(SellInfo sellInfo);
	public int insertSellInfo(SellInfo sellInfo);
	public List<SellInfo> selectSellInfoByAll();
	public SellInfo selectSellInfoByNo(SellInfo code);
	public int deleteSellInfo(SellInfo code);
	
}
