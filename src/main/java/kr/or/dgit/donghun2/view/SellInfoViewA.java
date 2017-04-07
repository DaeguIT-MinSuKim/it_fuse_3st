package kr.or.dgit.donghun2.view;

import java.awt.EventQueue;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;

import java.awt.GridLayout;

import java.awt.Insets;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.List;

import java.util.Vector;

import javax.swing.BoxLayout;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;

import erp_myframework.SpinnerPanel;

import kr.or.dgit.donghun2.dto.CalculatedValue;

import kr.or.dgit.donghun2.dto.Cgrade;

import kr.or.dgit.donghun2.dto.Customer;

import kr.or.dgit.donghun2.dto.Employee;

import kr.or.dgit.donghun2.dto.Product;

import kr.or.dgit.donghun2.dto.SellInfo;

import kr.or.dgit.donghun2.panel.CustomerPanel;

import kr.or.dgit.donghun2.panel.EmployeePanel;

import kr.or.dgit.donghun2.panel.ProductPanel;

import kr.or.dgit.donghun2.panel.SellInfoPanelA;

import kr.or.dgit.donghun2.service.CustomerService;

import kr.or.dgit.donghun2.service.EmployeeService;

import kr.or.dgit.donghun2.service.ProductService;

import kr.or.dgit.donghun2.service.SellInfoService;

import kr.or.dgit.donghun2.service.CalculatedValueService;

public class SellInfoViewA extends JFrame implements ActionListener {

	private JPanel contentPane;

	private SellInfoPanelA pSellInfoA;

	private SellInfo pSellInfo;

	private JButton btnOK;

	private JButton btnSave;

	private EmployeePanel pEmployee;

	private ProductPanel pProduct;

	private CustomerPanel pCustomer;

	private Product product;

	private static CalculatedValueService cvdao;

	private static ProductService pdao;

	private static EmployeeService edao;

	private static CustomerService cdao;

	private static SellInfoService sdao;

	private ComboPanel<Employee> pEmployeeForCombo;

	private ComboPanel<Product> pProductForCombo;

	private ComboPanel<Customer> pCustomerForCombo;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					SellInfoViewA frame = new SellInfoViewA();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	   public SellInfoViewA() {
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      setBounds(100, 100, 500, 600);
		      contentPane = new JPanel();
		      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		      setContentPane(contentPane);
		      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		      
		      JPanel panel = new JPanel();
		      contentPane.add(panel);
		      panel.setLayout(new GridLayout(0, 1, 0, 10));
		      
		      pEmployeeForCombo = new ComboPanel<>();
		      
		      pEmployeeForCombo.setTitle("사원");
		      
		      GridBagLayout egridBagLayout = new GridBagLayout();
		      egridBagLayout.columnWidths = new int[]{50,100,0};      egridBagLayout.rowHeights = new int[]{51, 0};      egridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};      egridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		      pEmployeeForCombo.setLayout(egridBagLayout);
		      
		      GridBagConstraints egbc_lbl = new GridBagConstraints();
		      egbc_lbl.fill = GridBagConstraints.BOTH;      egbc_lbl.insets = new Insets(0, 0, 0, 5);      egbc_lbl.gridx = 0;      egbc_lbl.gridy = 0;
		      panel.add(pEmployeeForCombo,egbc_lbl);
		      
		      GridBagConstraints egbc_combo = new GridBagConstraints();
		      egbc_combo.fill = GridBagConstraints.BOTH;      egbc_combo.gridx = 1;      egbc_combo.gridy = 0;
		      panel.add(pEmployeeForCombo, egbc_combo);
		      
		      List<Employee> eList = edao.getInstance().selectEmployeeByAll();
		      Vector<Employee> eVector = new Vector<>();
		      eVector.add(new Employee());

		      for(int i = 0 ; i < eList.size(); i++){
		         eVector.addElement(eList.get(i));
		      }
		      pEmployeeForCombo.setcomboData(eVector);
		      
		      
		      pProductForCombo = new ComboPanel();
		      
		      pProductForCombo.setTitle("제품");
		      GridBagLayout pgridBagLayout = new GridBagLayout();
		      pgridBagLayout.columnWidths = new int[]{50, 100, 0};      pgridBagLayout.rowHeights = new int[]{51, 0};      pgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};      pgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		      pProductForCombo.setLayout(pgridBagLayout);
		      GridBagConstraints pgbc_lbl = new GridBagConstraints();
		      pgbc_lbl.fill = GridBagConstraints.BOTH;      pgbc_lbl.insets = new Insets(0, 0, 0, 5);      pgbc_lbl.gridx = 0;      pgbc_lbl.gridy = 0;
		      panel.add(pProductForCombo,pgbc_lbl);
		      GridBagConstraints pgbc_combo = new GridBagConstraints();
		      pgbc_combo.fill = GridBagConstraints.BOTH;      pgbc_combo.gridx = 1;      pgbc_combo.gridy = 0;
		      panel.add(pProductForCombo, pgbc_combo);

		      List<Product> pList = pdao.getInstance().selectProductByAll();
		      Vector<Product> pVector = new Vector<>();
		      pVector.addElement(new Product());
		      for(int i = 0 ; i < pList.size(); i++){
		         pVector.addElement(pList.get(i));
		      }
		      pProductForCombo.setcomboData(pVector);
		      
		      
		      pCustomerForCombo = new ComboPanel();
		      
		      pCustomerForCombo.setTitle("거래처");
		      
		      GridBagLayout cgridBagLayout = new GridBagLayout();
		      cgridBagLayout.columnWidths = new int[]{50,100,0};      cgridBagLayout.rowHeights = new int[]{51, 0};      cgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};      cgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		      pCustomerForCombo.setLayout(cgridBagLayout);
		      
		      GridBagConstraints cgbc_lbl = new GridBagConstraints();
		      cgbc_lbl.fill = GridBagConstraints.BOTH;      cgbc_lbl.insets = new Insets(0, 0, 0, 5);      cgbc_lbl.gridx = 0;      cgbc_lbl.gridy = 0;
		      panel.add(pCustomerForCombo,cgbc_lbl);
		      
		      GridBagConstraints cgbc_combo = new GridBagConstraints();
		      panel.add(pCustomerForCombo, cgbc_combo);
		      
		      List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		      Vector<Customer> cVector = new Vector<>();
		      cVector.addElement(new Customer());
		      for(int i = 0 ; i < cList.size(); i++){
		         cVector.addElement(cList.get(i));
		      }
		      pCustomerForCombo.setcomboData(cVector);
		      
		      
		      pSellInfoA = new SellInfoPanelA();
		      
		      btnOK = pSellInfoA.getBtnOk();
		      btnOK.addActionListener(this);

		      contentPane.add(pSellInfoA);
		      
		      JPanel panel_4 = new JPanel();
		      contentPane.add(panel_4);
		      
		      btnSave = new JButton("저장");
		      btnSave.addActionListener(this);
		      panel_4.add(btnSave);
		      
		      pSellInfoA.clear();
		      
		      setinit();

		   }    // constructor ends

	private void setinit() {

		List<SellInfo> sellInfos = sdao.getInstance().selectSellInfoByAll();

		String asdf = sellInfos.get(sellInfos.size() - 1).getScode();
		System.out.println(asdf);
		String value = String.format(setNoFormat(),

				Integer.parseInt(asdf.substring(1)) + 1);
		System.out.println(value);
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
		int quantity = sRes.getQuantity();
		int unitprice = 0;
		int sellprice = 0;
		unitprice = (int) ((salePrice) * (1 - (dispct) * 0.01));
		// 판매금액 = 판매단가*판매수량
		sellprice = unitprice * quantity;
		sRes.setEcode(eRes.getCode());
		sRes.setPcode(pRes.getCode());
		sRes.setCcode(cRes.getCode());
		sRes.setSaleprice(salePrice);
		sRes.setOrigiprice(sellprice);
		sRes.setDispcts(dispct);
		System.out.println(sRes);
		sdao.getInstance().insertSellInfo(sRes);
		List<CalculatedValue> calculatedValue =
				cvdao.getInstance().selectCalculatedValueByAll();
		for (CalculatedValue c : calculatedValue) {
			System.out.println(c);
		}
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
		if (eRes == null || pRes == null || cRes == null || sRes == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
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
			unitprice = (int) ((saleprice) * (1 - (dispct) * 0.01));
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
}