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

import java.awt.GridLayout;
import javax.swing.JLabel;

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
	private TextFiledPanel pScode;

	public SellInfoPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{225, 225, 0};
		gridBagLayout.rowHeights = new int[]{58, 58, 58, 58, 58, 58, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		
		TextFiledPanel pSode = new TextFiledPanel();
		pSode.setTitle("거래코드");
		GridBagConstraints gbc_pSode = new GridBagConstraints();
		gbc_pSode.fill = GridBagConstraints.BOTH;
		gbc_pSode.insets = new Insets(0, 0, 5, 5);
		gbc_pSode.gridx = 0;
		gbc_pSode.gridy = 0;
		add(pSode, gbc_pSode);
		
		
		pSaleDate = new TextFiledPanel();
		pSaleDate.setTitle("거래일자");
		GridBagConstraints gbc_pSaleDate = new GridBagConstraints();
		gbc_pSaleDate.fill = GridBagConstraints.BOTH;
		gbc_pSaleDate.insets = new Insets(0, 0, 5, 5);
		gbc_pSaleDate.gridx = 0;
		gbc_pSaleDate.gridy = 1;
		add(pSaleDate, gbc_pSaleDate);
		
		pQuantity = new TextFiledPanel();
		pQuantity.setTitle("판매수량");
		GridBagConstraints gbc_pQuantity = new GridBagConstraints();
		gbc_pQuantity.fill = GridBagConstraints.BOTH;
		gbc_pQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_pQuantity.gridx = 0;
		gbc_pQuantity.gridy = 2;
		add(pQuantity, gbc_pQuantity);
		
		btnOK = new JButton("확인");
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.fill = GridBagConstraints.BOTH;
		gbc_btnOK.insets = new Insets(0, 0, 5, 0);
		gbc_btnOK.gridx = 1;
		gbc_btnOK.gridy = 2;
		add(btnOK, gbc_btnOK);
		
		pUnPrice = new TextFiledPanel();
		pUnPrice.setTitle("판매단가");
		GridBagConstraints gbc_pUnPrice = new GridBagConstraints();
		gbc_pUnPrice.fill = GridBagConstraints.BOTH;
		gbc_pUnPrice.insets = new Insets(0, 0, 5, 5);
		gbc_pUnPrice.gridx = 0;
		gbc_pUnPrice.gridy = 3;
		add(pUnPrice, gbc_pUnPrice);
		
		pSellPrice = new TextFiledPanel();
		pSellPrice.setTitle("판매금액");
		GridBagConstraints gbc_pSellPrice = new GridBagConstraints();
		gbc_pSellPrice.fill = GridBagConstraints.BOTH;
		gbc_pSellPrice.insets = new Insets(0, 0, 5, 5);
		gbc_pSellPrice.gridx = 0;
		gbc_pSellPrice.gridy = 4;
		add(pSellPrice, gbc_pSellPrice);
		
		pDisPrice = new TextFiledPanel();
		pDisPrice.setTitle("할인금액");
		GridBagConstraints gbc_pDisPrice = new GridBagConstraints();
		gbc_pDisPrice.fill = GridBagConstraints.BOTH;
		gbc_pDisPrice.insets = new Insets(0, 0, 0, 5);
		gbc_pDisPrice.gridx = 0;
		gbc_pDisPrice.gridy = 5;
		add(pDisPrice, gbc_pDisPrice);

	}

	public SellInfo getObjectDateQuantity(){
		Date saleDate = null;
		try {saleDate = sdf.parse(pSaleDate.getTfValue());
		} catch (ParseException e) {e.printStackTrace();}
		String scode = pScode.getTfValue();
		int quantity = Integer.parseInt(pQuantity.getTfValue());
		return new SellInfo(scode, saleDate, quantity);
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
