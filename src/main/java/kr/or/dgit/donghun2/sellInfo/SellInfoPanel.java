package kr.or.dgit.donghun2.sellInfo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.SellInfo;
import kr.or.dgit.donghun2.service.SellInfoService;

public class SellInfoPanel extends JPanel {
	private static final SellInfoPanel instance = new SellInfoPanel();

	public static SellInfoPanel getInstance() {
		return instance;
	}
	private TextFiledPanel pScode;
	private TextFiledPanel pSaleDate;
	private TextFiledPanel pQuantity;
	private TextFiledPanel pUnPrice;
	private TextFiledPanel pSellPrice;
	private TextFiledPanel pSalePrice;
	private TextFiledPanel pDisPrice;
	private TextFiledPanel pOrigiPrice;
	private TextFiledPanel pDisPcts;
	boolean isexist;
	private JButton btnOk;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private SellInfoService sdao;
	private SellInfoTabbedPanel pSellp;
	/**
	 * Create the panel.
	 */
	public SellInfoPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel basePanel = new JPanel();
		add(basePanel);
		basePanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel contentPanel = new JPanel();

		contentPanel.setLayout(new GridLayout(0, 1, 0, 10));

		pScode = new TextFiledPanel();
		pScode.setTitle("  거래내역코드   ");
		contentPanel.add(pScode);
		pScode.setLayout(new BoxLayout(pScode, BoxLayout.X_AXIS));

		pSaleDate = new TextFiledPanel();
		pSaleDate.setTitle("  거  래  일  자     ");
		contentPanel.add(pSaleDate);
		pSaleDate.setLayout(new BoxLayout(pSaleDate, BoxLayout.X_AXIS));

		pQuantity = new TextFiledPanel();
		pQuantity.setTitle("  판  매  수  량     ");
		contentPanel.add(pQuantity);
		pQuantity.setLayout(new BoxLayout(pQuantity, BoxLayout.X_AXIS));

		btnOk = new JButton("확인");
		pQuantity.add(btnOk);

		pUnPrice = new TextFiledPanel();
		pUnPrice.setTitle("  판  매  단  가     ");
		contentPanel.add(pUnPrice);
		pUnPrice.setLayout(new BoxLayout(pUnPrice, BoxLayout.X_AXIS));

		pSellPrice = new TextFiledPanel();
		pSellPrice.setTitle("  판  매  금  액     ");
		contentPanel.add(pSellPrice);
		pSellPrice.setLayout(new BoxLayout(pSellPrice, BoxLayout.X_AXIS));

		pDisPrice = new TextFiledPanel();
		pDisPrice.setTitle("  할  인  금  액     ");
		contentPanel.add(pDisPrice);
		pDisPrice.setLayout(new BoxLayout(pDisPrice, BoxLayout.X_AXIS));

		basePanel.add(contentPanel);

		JPanel empty = new JPanel();
		basePanel.add(empty);
	}
	public void setpUnPrice(int pUnPrice) {
		this.pUnPrice.setTfValue(String.valueOf(pUnPrice));
	}


	public void setpSellPrice(int pSellPrice) {
		this.pSellPrice.setTfValue(String.valueOf(pSellPrice));
	}


	public void setpDisPrice(int pDisPrice) {
		this.pDisPrice.setTfValue(String.valueOf(pDisPrice));
	}


	public SellInfo getObjectDateQuantity(){
		Date saleDate = null;
		int quantity = 0;
		try {saleDate = sdf.parse(pSaleDate.getTfValue());
		} catch (ParseException e) {e.printStackTrace();}
		
		String scode = pScode.getTfValue();
		
		try {quantity = Integer.parseInt(pQuantity.getTfValue());
		} catch (NumberFormatException e){
			e.fillInStackTrace();
		}
		return new SellInfo(scode, saleDate, quantity);

	}
	public String getQuantity(){
		String Squantity = pQuantity.getTfValue();
		return Squantity;
	}	
	public TextFiledPanel getpOrigiPrice() {
		return pOrigiPrice;
	}
	

	


	public void clear() {

		pScode.gettF().setEnabled(false);
		pSaleDate.setTfValue(sdf.format(new Date()));
		pQuantity.setTfValue("0");
		pUnPrice.setTfValue("0");
		pSellPrice.setTfValue("0");
		pDisPrice.setTfValue("0");
	}

	public boolean isEmpty() {
		boolean result = false;
		for (Component c : getComponents()) {
			if (c instanceof TextFiledPanel) {
				TextFiledPanel tfp = (TextFiledPanel) c;
				if (tfp.isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public TextFiledPanel getpScode() {
		return pScode;
	}
}
