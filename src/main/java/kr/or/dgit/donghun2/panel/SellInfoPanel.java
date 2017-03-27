package kr.or.dgit.donghun2.panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.SellInfo;

public class SellInfoPanel extends JPanel {
	private static final SellInfoPanel instance = new SellInfoPanel();
	public static SellInfoPanel getInstance() {return instance;}
	
	private TextFiledPanel pSaleDate;
	private TextFiledPanel pQuantity;
	private TextFiledPanel pUnPrice;
	private TextFiledPanel pSellPrice;
	private TextFiledPanel pDisPrice;
	private JButton btnOK;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private SellInfoPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 450, 0};
		gridBagLayout.rowHeights = new int[]{60, 60, 60, 60, 60, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		pSaleDate = new TextFiledPanel();
		pSaleDate.setTitle("거래일자");
		GridBagConstraints gbc_pSaleDate = new GridBagConstraints();
		gbc_pSaleDate.insets = new Insets(0, 0, 5, 5);
		gbc_pSaleDate.fill = GridBagConstraints.BOTH;
		gbc_pSaleDate.gridx = 0;
		gbc_pSaleDate.gridy = 0;
		add(pSaleDate, gbc_pSaleDate);
		
		pQuantity = new TextFiledPanel();
		pQuantity.setTitle("판매수량");
		GridBagConstraints gbc_pQuantity = new GridBagConstraints();
		gbc_pQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_pQuantity.fill = GridBagConstraints.BOTH;
		gbc_pQuantity.gridx = 0;
		gbc_pQuantity.gridy = 1;
		add(pQuantity, gbc_pQuantity);
		
		btnOK = new JButton("확인");
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.insets = new Insets(0, 0, 5, 0);
		gbc_btnOK.gridx = 1;
		gbc_btnOK.gridy = 1;
		add(btnOK, gbc_btnOK);
		
		pUnPrice = new TextFiledPanel();
		pUnPrice.setTitle("판매단가");
		GridBagConstraints gbc_pUnPrice = new GridBagConstraints();
		gbc_pUnPrice.insets = new Insets(0, 0, 5, 5);
		gbc_pUnPrice.fill = GridBagConstraints.BOTH;
		gbc_pUnPrice.gridx = 0;
		gbc_pUnPrice.gridy = 2;
		add(pUnPrice, gbc_pUnPrice);
		
		pSellPrice = new TextFiledPanel();
		pSellPrice.setTitle("판매금액");
		GridBagConstraints gbc_pSellPrice = new GridBagConstraints();
		gbc_pSellPrice.insets = new Insets(0, 0, 5, 5);
		gbc_pSellPrice.fill = GridBagConstraints.BOTH;
		gbc_pSellPrice.gridx = 0;
		gbc_pSellPrice.gridy = 3;
		add(pSellPrice, gbc_pSellPrice);
		
		pDisPrice = new TextFiledPanel();
		pDisPrice.setTitle("할인금액");
		GridBagConstraints gbc_pDisPrice = new GridBagConstraints();
		gbc_pDisPrice.insets = new Insets(0, 0, 0, 5);
		gbc_pDisPrice.fill = GridBagConstraints.BOTH;
		gbc_pDisPrice.gridx = 0;
		gbc_pDisPrice.gridy = 4;
		add(pDisPrice, gbc_pDisPrice);

	}

	public SellInfo getObjectDateQuantity(){
		Date saleDate = null;
		try {saleDate = sdf.parse(pSaleDate.getTfValue());
		} catch (ParseException e) {e.printStackTrace();}
		int quantity = Integer.parseInt(pQuantity.getTfValue());
		return new SellInfo(saleDate, quantity);
	}
	public SellInfo getObjectAllSell(){
		Date saleDate = null;
		try {saleDate = sdf.parse(pSaleDate.getTfValue());
		} catch (ParseException e) {e.printStackTrace();}
		int quantity = Integer.parseInt(pQuantity.getTfValue());
		int unitprice = Integer.parseInt(pUnPrice.getTfValue());
		int sellprice = Integer.parseInt(pSellPrice.getTfValue());
		int disprice = Integer.parseInt(pDisPrice.getTfValue());
		return new SellInfo(saleDate, quantity, unitprice, sellprice, disprice);
	}
	
	public void setObject(SellInfo item){
		pUnPrice.setTfValue(String.valueOf(item.getUnitprice()));
		pSellPrice.setTfValue(String.valueOf(item.getSellprice()));
		pDisPrice.setTfValue(String.valueOf(item.getDisprice()));
	}

	public void clear(){
		pSaleDate.setTfValue(sdf.format(new Date()));
		pQuantity.setTfValue("0");
		pUnPrice.setTfValue("0");
		pSellPrice.setTfValue("0");
		pDisPrice.setTfValue("0");
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
	
	public JButton getBtnOk() {
		return btnOK;
	}
	
	
	
	
	
	

}
