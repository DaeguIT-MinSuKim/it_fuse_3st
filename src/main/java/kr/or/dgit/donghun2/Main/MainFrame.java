package kr.or.dgit.donghun2.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.panel.BasicTabbedPanel;
import kr.or.dgit.donghun2.panel.CustomerPanel;
import kr.or.dgit.donghun2.panel.EmployeePanel;
import kr.or.dgit.donghun2.panel.InquiryPanel;
import kr.or.dgit.donghun2.panel.ProductPanel;
import kr.or.dgit.donghun2.panel.SellInfoPanelA;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.CustomerTable;
import kr.or.dgit.donghun2.table.EmployeeTable;
import kr.or.dgit.donghun2.table.ProductTable;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pCustomer;
	private JPanel pProduct;
	private JPanel pEmployee;
	private JButton CbtnSave;
	private JPanel pCusb;
	private CustomerPanel pCusp;
	private CustomerTable pCust;
	private CustomerService dao;
	private EmployeeTable pEmpt;
	private JPanel pEmpb;
	private EmployeePanel pEmpp;
	private JButton EbtnSearch;
	private JButton EbtnDele;
	private JButton EbtnSave;
	private ProductPanel pProp;
	private JPanel pProb;
	private ProductTable pProt;
	private JButton PbtnSave;
	private JButton PbtnDele;
	private JButton PbtnSearch;
	private JPanel pSellInfo;

	private EmployeeService edao;
	private ProductService pdao;
	private CustomerService cdao;
	private ComboPanel<Employee> pEmployeeForCombo;
	private ComboPanel<Product> pProductForCombo;
	private ComboPanel<Customer> pCustomerForCombo;
	private TextFiledPanel pScode;
	private TextFiledPanel pSaleDate;
	private TextFiledPanel pQuantity;
	private JButton btnOk;
	private TextFiledPanel pUnPrice;
	private TextFiledPanel pSellPrice;
	private TextFiledPanel pDisPrice;
	private JPanel psellInfoDetail;
	private JPanel pBtn;
	private JButton btnSave;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JTabbedPane tabbedPane;
	
	private JPanel psellInfobtn;
	private JButton CbtnSearch;
	private JButton CbtnDele;
	private JPanel pTabbedPane;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		} catch (Exception e) {
		}
		MainFrame mf = new MainFrame();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		
		pTabbedPane = new JPanel();
		contentPane.add(pTabbedPane, BorderLayout.CENTER);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pTabbedPane.add(tabbedPane);

		/*pEmployee = new JPanel();
		tabbedPane.addTab("영업사원관리", null, pEmployee, null);
		pEmployee.setLayout(new BoxLayout(pEmployee, BoxLayout.Y_AXIS));

		pEmpp = new EmployeePanel();
		pEmployee.add(pEmpp);

		pEmpb = new JPanel();
		pEmployee.add(pEmpb);

		EbtnSave = new JButton("저장");
		pEmpb.add(EbtnSave);

		EbtnDele = new JButton("삭제");
		pEmpb.add(EbtnDele);

		EbtnSearch = new JButton("검색");
		pEmpb.add(EbtnSearch);

		pEmpt = new EmployeeTable();
		pEmployee.add(pEmpt);

		pProduct = new JPanel();
		tabbedPane.addTab("제품관리", null, pProduct, null);
		pProduct.setLayout(new BoxLayout(pProduct, BoxLayout.Y_AXIS));

		pProp = new ProductPanel();
		pProduct.add(pProp);

		pProb = new JPanel();
		pProduct.add(pProb);

		PbtnSave = new JButton("저장");
		pProb.add(PbtnSave);

		PbtnDele = new JButton("삭제");
		pProb.add(PbtnDele);

		PbtnSearch = new JButton("검색");
		pProb.add(PbtnSearch);

		pProt = new ProductTable();
		pProduct.add(pProt);

		pCustomer = new JPanel();
		tabbedPane.addTab("거래처관리", null, pCustomer, null);
		pCustomer.setLayout(new BoxLayout(pCustomer, BoxLayout.Y_AXIS));

		pCusp = new CustomerPanel();
		pCustomer.add(pCusp);

		pCusb = new JPanel();
		pCustomer.add(pCusb);

		CbtnSave = new JButton("저장");
		CbtnSave.addActionListener(this);
		pCusb.add(CbtnSave);

		CbtnDele = new JButton("삭제");
		CbtnDele.addActionListener(this);
		pCusb.add(CbtnDele);

		CbtnSearch = new JButton("검색");
		pCusb.add(CbtnSearch);

		pCust = new CustomerTable();
		pCustomer.add(pCust);
		pCust.loadDate();

		pSellInfo = new JPanel();
		tabbedPane.addTab("거래내역관리", null, pSellInfo, null);
		pSellInfo.setLayout(new BoxLayout(pSellInfo, BoxLayout.Y_AXIS));

		pEmployeeForCombo = new ComboPanel<>();
		pSellInfo.add(pEmployeeForCombo);
		pEmployeeForCombo.setLayout(new BoxLayout(pEmployeeForCombo, BoxLayout.Y_AXIS));

		pEmployeeForCombo.setTitle("사원");
		List<Employee> eList = edao.getInstance().selectEmployeeByAll();
		for (Employee c : eList) {
			System.out.println(c);
		}
		Vector<Employee> eVector = new Vector<>();
		for (int i = 0; i < eList.size(); i++) {
			eVector.addElement(eList.get(i));
		}
		pEmployeeForCombo.setcomboData(eVector);

		pProductForCombo = new ComboPanel<>();
		pSellInfo.add(pProductForCombo);
		pProductForCombo.setLayout(new BoxLayout(pProductForCombo, BoxLayout.Y_AXIS));

		pProductForCombo.setTitle("제품");
		List<Product> pList = pdao.getInstance().selectProductByAll();
		for (Product c : pList) {
			System.out.println(c);
		}
		Vector<Product> pVector = new Vector<>();
		for (int i = 0; i < pList.size(); i++) {
			pVector.addElement(pList.get(i));
		}
		pProductForCombo.setcomboData(pVector);
		
		pCustomerForCombo = new ComboPanel<>();
		pSellInfo.add(pCustomerForCombo);
		pCustomerForCombo.setLayout(new BoxLayout(pCustomerForCombo, BoxLayout.Y_AXIS));

		pCustomerForCombo.setTitle("제품");
		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		for (Customer c : cList) {
			System.out.println(c);
		}
		Vector<Customer> cVector = new Vector<>();
		for (int i = 0; i < cList.size(); i++) {
			cVector.addElement(cList.get(i));
		}
		pCustomerForCombo.setcomboData(cVector);
		
		psellInfoDetail = new JPanel();
		
		
		psellInfoDetail = new SellInfoPanelA();
		pSellInfo.add(psellInfoDetail);
		
		psellInfobtn = new JPanel();
		btnSave = new JButton("저장");
		psellInfobtn.add(btnSave);
		pSellInfo.add(psellInfobtn);*/
		
		pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.EAST);
		pBtn.setLayout(new GridLayout(0, 1, 10, 50));
		btn1 = new JButton("기초자료관리");
		btn2 = new JButton("기초자료 현황");
		btn3 = new JButton("거래내역 조회");
		pBtn.add(btn1);
		btn1.addActionListener(this);
		pBtn.add(btn2);
		btn2.addActionListener(this);
		pBtn.add(btn3);
		System.out.println("**");
	}

	

	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == CbtnSave) {
			actionPerformedCBtnSave(e);
		}
		if(e.getSource() == CbtnDele){
			actionPerformedCBtnDele(e);
		}*/
		if(e.getSource() == btn2){
			actionPerformedbtn2(e);
		}
		if(e.getSource()== btn1){
			actionPerformedbtn1(e);
		}
	}
	

	

	private void actionPerformedbtn1(ActionEvent e) {
		pTabbedPane.removeAll();
		pTabbedPane.add(new BasicTabbedPanel());
		revalidate();
		repaint();
		
	}

	private void actionPerformedbtn2(ActionEvent e) {
		pTabbedPane.removeAll();
		pTabbedPane.add(new InquiryPanel());
		revalidate();
		repaint();
	}

	/*private void actionPerformedCBtnDele(ActionEvent e) {
		int res = dao.getInstance().deleteCustomer(pCusp.getObject());
		if(res==0){
			JOptionPane.showMessageDialog(null, "삭제안댐");
		}else{
			JOptionPane.showMessageDialog(null, "삭제댐");
			pCust.loadDate();
		}
	}

	protected void actionPerformedCBtnSave(ActionEvent e) {
		if (pCusp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			dao.getInstance().insertCustomer(pCusp.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pCust.loadDate();
		}
	}*/

}
