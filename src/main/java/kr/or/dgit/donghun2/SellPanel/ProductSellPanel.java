package kr.or.dgit.donghun2.SellPanel;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Product;

public class ProductSellPanel extends JPanel {
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private TextFiledPanel pSalePrice;

	public ProductSellPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("제품코드");
		add(pCode);
		
		JPanel pBtn = new JPanel();
		add(pBtn);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.X_AXIS));
		
		pName = new TextFiledPanel();
		pName.setTitle("제 품 명");
		add(pName);
		
		pSalePrice = new TextFiledPanel();
		pSalePrice.setTitle("판매정가");
		add(pSalePrice);

	}

	public Product getObject(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		int salePrice = Integer.parseInt(pSalePrice.getTfValue());
		return new Product(code, name, salePrice);
	}
	public Product getObjectSearch(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		return new Product(code, name);
	}
	
	
	public void setObject(Product item){
		pCode.setTfValue(item.getCode());
		pName.setTfValue(item.getName());
		pSalePrice.setTfValue(String.valueOf(item.getSalePrice()));
	}

	public void clear(){
		pCode.setTfValue("");
		pName.setTfValue("");
		pSalePrice.setTfValue("0");
	}
	public boolean isEmpty(){
		boolean result = false;
		for(Component c : getComponents()){
			if(c instanceof TextFiledPanel){
				TextFiledPanel tfp =(TextFiledPanel)c;
				if(tfp.isEmpty()){
					return true;
				}
			}
		}
		return false;
	}
	
	

	
}
