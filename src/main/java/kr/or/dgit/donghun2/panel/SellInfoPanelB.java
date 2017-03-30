package kr.or.dgit.donghun2.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.SellInfo;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SellInfoPanelB extends JPanel {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private TextFiledPanel pScode;
	private TextFiledPanel pSaleDate;
	private TextFiledPanel pQuantity;
	private TextFiledPanel pUnPrice;
	private TextFiledPanel pSellPrice;
	private TextFiledPanel pDisPrice;
	private JButton btnOk;
	/**
	 * Create the panel.
	 */
	public SellInfoPanelB() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 450, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		SellInfoPanelA panel = new SellInfoPanelA();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

	}
	public SellInfo getObject(){
		Date saleDate = null;
		try {saleDate = sdf.parse(pSaleDate.getTfValue());
		} catch (ParseException e) {e.printStackTrace();}
		String scode = pScode.getTfValue();
		int quantity = Integer.parseInt(pQuantity.getTfValue());
		return new SellInfo(scode, saleDate, quantity);
	}
	

	public void clear(){
		pScode.setTfValue("");
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
		return btnOk;
	}

}
