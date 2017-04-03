package kr.or.dgit.donghun2.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.CustomerTable;
import kr.or.dgit.donghun2.table.EmployeeTable;
import kr.or.dgit.donghun2.table.ProductTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class BasicTabbedPanel extends JPanel implements ActionListener {

	private JTabbedPane tabbedPane;
	private JPanel pEmployee;
	private EmployeePanel pEmpp;
	private JPanel pEmpb;
	private JButton EbtnSave;
	private JButton EbtnDele;
	private JButton EbtnSearch;
	private EmployeeTable pEmpt;
	private JPanel pProduct;
	private ProductPanel pProp;
	private JPanel pProb;
	private JButton PbtnSave;
	private JButton PbtnDele;
	private JButton PbtnSearch;
	private ProductTable pProt;
	private JPanel pCustomer;
	private CustomerPanel pCusp;
	private JButton CbtnSave;
	private JButton CbtnDele;
	private Container pCusb;
	private JButton CbtnSearch;
	private CustomerTable pCust;
	private JPanel pSellInfo;
	private ComboPanel pEmployeeForCombo;

	private EmployeeService edao;
	private ProductService pdao;
	private CustomerService cdao;
	private ComboPanel pProductForCombo;
	private ComboPanel pCustomerForCombo;
	private JPanel psellInfoDetail;
	private JPanel psellInfobtn;
	private JButton btnSave;
	private JPanel pBtn;
	private Container contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	public BasicTabbedPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pBasic = new JPanel();
		add(pBasic);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pBasic.add(tabbedPane);
		
		pEmployee = new JPanel();
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
		pSellInfo.add(psellInfobtn);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CbtnSave) {
			actionPerformedCBtnSave(e);
		}
		if (e.getSource() == CbtnDele) {
			actionPerformedCBtnDele(e);
		}
		if (e.getSource() == CbtnSearch) {
			actionPerformedCbtnSearch(e);
		}
		if (e.getSource() == PbtnSave) {
			actionPerformedPBtnSave(e);
		}
		if (e.getSource() == PbtnDele) {
			actionPerformedPBtnDele(e);
		}
		if (e.getSource() == PbtnSearch) {
			actionPerformedPbtnSearch(e);
		}
		if (e.getSource() == EbtnSave) {
			actionPerformedEBtnSave(e);
		}
		if (e.getSource() == EbtnDele) {
			actionPerformedEBtnDele(e);
		}
		if (e.getSource() == EbtnSearch) {
			actionPerformedEbtnSearch(e);
		}
	}

	private void actionPerformedEbtnSearch(ActionEvent e) {
		Employee res = edao.getInstance().selectEmployeeByNo(pEmpp.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pEmpp.setObject(res);
		}
		
	}

	private void actionPerformedEBtnDele(ActionEvent e) {
		int res = edao.getInstance().deleteEmployee(pEmpp.getObject());
		if (res == 0) {
			JOptionPane.showMessageDialog(null, "삭제안댐");
		} else {
			JOptionPane.showMessageDialog(null, "삭제댐");
			pEmpt.loadDate();
		}
		
	}

	private void actionPerformedEBtnSave(ActionEvent e) {
		if (pEmpp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			edao.getInstance().insertEmployee(pEmpp.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pEmpt.loadDate();
		}
		
	}

	private void actionPerformedPbtnSearch(ActionEvent e) {
		Product res = pdao.getInstance().selectProductByNo(pProp.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pProp.setObject(res);
		}
		
	}

	private void actionPerformedPBtnDele(ActionEvent e) {
		int res = pdao.getInstance().deleteProduct(pProp.getObject());
		if (res == 0) {
			JOptionPane.showMessageDialog(null, "삭제안댐");
		} else {
			JOptionPane.showMessageDialog(null, "삭제댐");
			pProt.loadData();
		}
		
	}

	private void actionPerformedPBtnSave(ActionEvent e) {
		if (pProp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			pdao.getInstance().insertProduct(pProp.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pProt.loadData();
		}
		
	}

	private void actionPerformedCbtnSearch(ActionEvent e) {
		Customer res = cdao.getInstance().selectCustomerByNo(pCusp.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pCusp.setObject(res);
		}
	}

	private void actionPerformedCBtnDele(ActionEvent e) {
		int res = cdao.getInstance().deleteCustomer(pCusp.getObject());
		if (res == 0) {
			JOptionPane.showMessageDialog(null, "삭제안댐");
		} else {
			JOptionPane.showMessageDialog(null, "삭제댐");
			pCust.loadDate();
		}
	}

	private void actionPerformedCBtnSave(ActionEvent e) {
		if (pCusp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			cdao.getInstance().insertCustomer(pCusp.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pCust.loadDate();
		}
	}
}
