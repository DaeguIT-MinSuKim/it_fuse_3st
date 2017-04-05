package kr.or.dgit.donghun2.panel;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import erp_myframework.SpinnerPanel;
import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Product;


public class ProductPanel extends JPanel {
	private static final ProductPanel instance = new ProductPanel();
	public static ProductPanel getInstance() {return instance;}
	
	
	
	
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private SpinnerPanel pSalePrice;
	private SpinnerPanel pOrigiPrice;

	public ProductPanel() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("제품코드");
		add(pCode);
		
		pName = new TextFiledPanel();
		pName.setTitle("제 품 명");
		add(pName);
		
		pSalePrice = new SpinnerPanel();
		pSalePrice.setTitle("판매정가");
		add(pSalePrice);
		
		pOrigiPrice = new SpinnerPanel();
		pOrigiPrice.setTitle("판매원가");
		add(pOrigiPrice);

	}
	
	public TextFiledPanel getpCode() {
		return pCode;
	}
	public TextFiledPanel getpName() {
		return pName;
	}
	public SpinnerPanel getpSalePrice() {
		return pSalePrice;
	}
	public SpinnerPanel getpOrigiPrice() {
		return pOrigiPrice;
	}
	public Product getObject(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		int salePrice = (int)pSalePrice.getValue();
		int origiPrice = (int)pOrigiPrice.getValue();
		return new Product(code, name, salePrice, origiPrice);
	}
	
	public void setObject(Product item){
		pCode.setTfValue(item.getCode());
		pName.setTfValue(item.getName());
		pSalePrice.setValue(item.getSalePrice());
		pOrigiPrice.setValue(item.getOrigiPrice());
	}

	public void clear(){
		pCode.setTfValue("");
		pName.setTfValue("");
		pSalePrice.setValue(0);
		pOrigiPrice.setValue(0);
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
