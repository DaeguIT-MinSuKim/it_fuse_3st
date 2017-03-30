package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.CalculatedValue;

public interface CalculatedValueMapper {
	public List<CalculatedValue> selectCalculatedValueByAll();
	public CalculatedValue selectCalculatedValueByNo(CalculatedValue code);
}
