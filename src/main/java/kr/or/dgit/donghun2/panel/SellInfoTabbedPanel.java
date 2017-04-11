package kr.or.dgit.donghun2.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import erp_myframework.ComboPanel;
import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.dto.SellInfo;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.service.SellInfoService;

public class SellInfoTabbedPanel extends JPanel implements ActionListener {
	private static final SellInfoTabbedPanel instance = new SellInfoTabbedPanel();

	public static SellInfoTabbedPanel getInstance() {
		return instance;
	}

	
	private JButton btnOK;
	private ComboPanel<Employee> pEmployeeForCombo;
	private static EmployeeService edao;
	private static CustomerService cdao;
	private static ProductService pdao;
	private ComboPanel<Product> pProductForCombo;
	private ComboPanel<Customer> pCustomerForCombo;
	private SellInfoPanel pSellInfoA;
	private JButton btnSave;
	private CalculatedValueService cvdao;
	private SellInfoService sdao;
	private TextFiledPanel pScode;

	public SellInfoTabbedPanel() {
		setBounds(100, 100, 500, 600);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 10));

		pEmployeeForCombo = new ComboPanel<>();
		pEmployeeForCombo.setLayout(new GridLayout(0, 1, 0, 0));
		pEmployeeForCombo.setTitle("     사        원       ");
		pEmployeeForCombo.setLayout(new BoxLayout(pEmployeeForCombo, BoxLayout.X_AXIS));
		pEmployeeForCombo.setStringcomboData("사원을 선택해주세요.");
		panel.add(pEmployeeForCombo);
		
		
		List<Employee> eList = edao.getInstance().selectEmployeeByAll();
		Vector<Employee> eVector = new Vector<>();
		eVector.add(new Employee());

		for (int i = 0; i < eList.size(); i++) {
			eVector.addElement(eList.get(i));
		}
		eVector.remove(0);
		pEmployeeForCombo.setcomboData(eVector);

		pProductForCombo = new ComboPanel<>();

		pProductForCombo.setTitle("     제        품       ");
		pProductForCombo.setLayout(new BoxLayout(pProductForCombo, BoxLayout.X_AXIS));
		pProductForCombo.setStringcomboData("제품을 선택해주세요.");
		panel.add(pProductForCombo);
		
		

		List<Product> pList = pdao.getInstance().selectProductByAll();
		Vector<Product> pVector = new Vector<>();
		pVector.addElement(new Product());
		for (int i = 0; i < pList.size(); i++) {
			pVector.addElement(pList.get(i));
		}
			pVector.remove(0);
		pProductForCombo.setcomboData(pVector);

		pCustomerForCombo = new ComboPanel<>();

		pCustomerForCombo.setTitle("     거  래  처       ");
		pCustomerForCombo.setLayout(new BoxLayout(pCustomerForCombo, BoxLayout.X_AXIS));
		pCustomerForCombo.setStringcomboData("거래처를 선택해주세요.");
		panel.add(pCustomerForCombo);
		
		

		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		Vector<Customer> cVector = new Vector<>();
		cVector.addElement(new Customer());
		for (int i = 0; i < cList.size(); i++) {
			cVector.addElement(cList.get(i));
		}
		cVector.remove(0);
		pCustomerForCombo.setcomboData(cVector);

		pSellInfoA = new SellInfoPanel();

		btnOK = pSellInfoA.getBtnOk();
		btnOK.addActionListener(this);
		add(pSellInfoA);

		JPanel panel_4 = new JPanel();
		add(panel_4);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		panel_4.add(btnSave);

		pSellInfoA.clear();
		setinit();
	} // constructor ends

	private void setinit() {
		List<SellInfo> sellInfos = sdao.getInstance().selectSellInfoByAll();
		String value = null;
		if (sellInfos.size()==0 ) {
			value = "S001";
		} else {
			value = String.format(setNoFormat(),
					Integer.parseInt(sellInfos.get(sellInfos.size() - 1).getScode().substring(1)) + 1);
		}
		pSellInfoA.getpScode().setTfValue(value);
		pSellInfoA.getpScode().gettF().setFocusable(false);

	}

	protected String setNoFormat() {

		return "S%03d";

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnOK) {

			actionPerformedBtnOK(e);

		}

		if (e.getSource() == btnSave) {

			actionPerformedbtnSave(e);

		}

	}

	private void actionPerformedbtnSave(ActionEvent e) {

		Employee eRes = (Employee) pEmployeeForCombo.getSelectItem();

		Product pRes = (Product) pProductForCombo.getSelectItem();

		Customer cRes = (Customer) pCustomerForCombo.getSelectItem();

		SellInfo sRes = pSellInfoA.getObjectDateQuantity();

		int salePrice = pRes.getSalePrice();

		int edispct = edao.getInstance().selectDiscnt(eRes).geteGrade().getDispct();
		int cdispct = cdao.getInstance().selectDiscnt(cRes).getcGrade().getDispct();
		int dispct = edispct + cdispct;
		int origiprice = pRes.getOrigiPrice();
		int quantity = sRes.getQuantity();
		int unitprice = 0;
		int sellprice = 0;
		unitprice = (int) ((salePrice) * (1 - ((dispct) * 0.01)));
		// 판매금액 = 판매단가*판매수량
		sellprice = unitprice * quantity;
		
		sRes.setEcode(eRes.getCode());
		sRes.setPcode(pRes.getCode());
		sRes.setCcode(cRes.getCode());
		sRes.setSaleprice(salePrice);
		sRes.setOrigiprice(origiprice);
		sRes.setDispcts(dispct);
		sdao.getInstance().insertSellInfo(sRes);
		List<CalculatedValue> calculatedValue = cvdao.getInstance().selectCalculatedValueByAll();
		JOptionPane.showMessageDialog(null, "저장되었습니다.");
		pSellInfoA.clear();
		clear();
		setinit();
	}

	private void clear() {
		pProductForCombo.setSelectedItem(0);
		pCustomerForCombo.setSelectedItem(0);
		pEmployeeForCombo.setSelectedItem(0);
	}

	private void actionPerformedBtnOK(ActionEvent e) {
		Employee eRes = (Employee) pEmployeeForCombo.getSelectItem();
		Product pRes = (Product) pProductForCombo.getSelectItem();
		Customer cRes = (Customer) pCustomerForCombo.getSelectItem();
		SellInfo sRes = null;
		try {
			sRes = pSellInfoA.getObjectDateQuantity();
		} catch (NumberFormatException ne) {
			ne.getStackTrace();

		}
		/*
		 * if (eRes.getCode() == null) { JOptionPane.showMessageDialog(null,
		 * "사원을 선택 하십시오."); }else if(pRes.getCode()==null){
		 * JOptionPane.showMessageDialog(null, "제품을 선택 하십시오."); } else
		 * if(cRes.getCode()==null){ JOptionPane.showMessageDialog(null,
		 * "거래처를 선택 하십시오."); }
		 */
		if (eRes.getCode() == null || pRes.getCode() == null || cRes.getCode() == null) {
			JOptionPane.showMessageDialog(null, "사원, 제품, 거래처를 모두 선택 했는지 확인해주세요");
		}
		if (pSellInfoA.getObjectDateQuantity().getQuantity() <= 0) {
			JOptionPane.showMessageDialog(null, "양수를 입력하세요");
		} else {
			int unitprice = 0;
			int sellprice = 0;
			int disprice = 0;
			int quantity = sRes.getQuantity(); // 판매수량
			// 제품 판매정가 받아오기
			int saleprice = pRes.getSalePrice();
			// 사원 등급에따른 할인율 받아오기
			int edispct = edao.getInstance().selectDiscnt(eRes).geteGrade().getDispct();
			// 거래처 등급에따른 할인율 받아오기
			int cdispct = cdao.getInstance().selectDiscnt(cRes).getcGrade().getDispct();
			// 더하기
			int dispct = edispct + cdispct;
			// DB에서 해주는 것이나 확정값이 아직 아니기에 java로 임시 처리
			// 판매단가 = 판매정가 *할인율
			unitprice = (int) ((saleprice) * (1 - ((dispct) * 0.01)));
			// 판매금액 = 판매단가*판매수량
			sellprice = unitprice * quantity;
			// 할인금액 = 판매정가*판매수량-판매금액
			disprice = saleprice * quantity - sellprice;
			// 뷰에 입력
			pSellInfoA.setpUnPrice(unitprice);
			pSellInfoA.setpSellPrice(sellprice);
			pSellInfoA.setpDisPrice(disprice);
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
		}

	}

	public TextFiledPanel getpScode() {
		return pScode;
	}
}
