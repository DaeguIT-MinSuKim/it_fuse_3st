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
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.dto.Product;
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
	private JButton btnOK;
	private EmployeePanel pEmployee;
	private ProductPanel pProduct;
	private CustomerPanel pCustomer;
	
	private static CalculatedValueService cvdao;
	private static ProductService pdao;
	private static EmployeeService edao;
	private static CustomerService cdao;
	private static SellInfoService sdao;

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
		setBounds(100, 100, 561, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 10));
		
		ComboPanel<Employee> pEmployeeForCombo = new ComboPanel<>();
		
		pEmployeeForCombo.setTitle("사원");
		GridBagLayout egridBagLayout = new GridBagLayout();
		egridBagLayout.columnWidths = new int[]{100, 425, 0};		egridBagLayout.rowHeights = new int[]{51, 0};		egridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		egridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pEmployeeForCombo.setLayout(egridBagLayout);
		GridBagConstraints egbc_lbl = new GridBagConstraints();
		egbc_lbl.fill = GridBagConstraints.BOTH;		egbc_lbl.insets = new Insets(0, 0, 0, 5);		egbc_lbl.gridx = 0;		egbc_lbl.gridy = 0;
		panel.add(pEmployeeForCombo,egbc_lbl);
		GridBagConstraints egbc_combo = new GridBagConstraints();
		egbc_combo.fill = GridBagConstraints.BOTH;		egbc_combo.gridx = 1;		egbc_combo.gridy = 0;
		panel.add(pEmployeeForCombo, egbc_combo);
		
		List<Employee> eList = edao.getInstance().selectEmployeeByAll();
		for(Employee c : eList){
			System.out.println(c);
		}
		Vector<Employee> eVector = new Vector<>();
		for(int i = 0 ; i < eList.size(); i++){
			eVector.addElement(eList.get(i));
		}
		pEmployeeForCombo.setcomboData(eVector);
		
		
		ComboPanel<Product> pProductForCombo = new ComboPanel();
		
		pProductForCombo.setTitle("제품");
		GridBagLayout pgridBagLayout = new GridBagLayout();
		pgridBagLayout.columnWidths = new int[]{100, 425, 0};		pgridBagLayout.rowHeights = new int[]{51, 0};		pgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		pgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pProductForCombo.setLayout(pgridBagLayout);
		GridBagConstraints pgbc_lbl = new GridBagConstraints();
		pgbc_lbl.fill = GridBagConstraints.BOTH;		pgbc_lbl.insets = new Insets(0, 0, 0, 5);		pgbc_lbl.gridx = 0;		pgbc_lbl.gridy = 0;
		panel.add(pProductForCombo,pgbc_lbl);
		GridBagConstraints pgbc_combo = new GridBagConstraints();
		pgbc_combo.fill = GridBagConstraints.BOTH;		pgbc_combo.gridx = 1;		pgbc_combo.gridy = 0;
		panel.add(pProductForCombo, pgbc_combo);

		List<Product> pList = pdao.getInstance().selectProductByAll();
		for(Product p : pList){
			System.out.println(p);
		}
		Vector<Product> pVector = new Vector<>();
		for(int i = 0 ; i < pList.size(); i++){
			pVector.addElement(pList.get(i));
		}
		pProductForCombo.setcomboData(pVector);
		
		
		ComboPanel<Customer> pCustomerCombo = new ComboPanel();
		
		pCustomerCombo.setTitle("거래처");
		GridBagLayout cgridBagLayout = new GridBagLayout();
		cgridBagLayout.columnWidths = new int[]{100, 425, 0};		cgridBagLayout.rowHeights = new int[]{51, 0};		cgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		cgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pCustomerCombo.setLayout(cgridBagLayout);
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;		cgbc_lbl.insets = new Insets(0, 0, 0, 5);		cgbc_lbl.gridx = 0;		cgbc_lbl.gridy = 0;
		panel.add(pCustomerCombo,cgbc_lbl);
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		panel.add(pCustomerCombo, cgbc_combo);
		
		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		for(Customer c : cList){
			System.out.println(c);
		}
		Vector<Customer> cVector = new Vector<>();
		for(int i = 0 ; i < cList.size(); i++){
			cVector.addElement(cList.get(i));
		}
		pCustomerCombo.setcomboData(cVector);
		
		
		pSellInfoA = new SellInfoPanelA();
		pSellInfoA.getBtnOk().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int unitprice = 0;
				int sellprice = 0;
				int disprice = 0;
				
				Product pRes = (Product) pProductForCombo.getSelectItem();
				int selectedsaleprice = pRes.getSalePrice();
				System.out.println(selectedsaleprice);
				Employee eRes = (Employee) pEmployeeForCombo.getSelectItem();
				String eCode = eRes.getCode();
		//		edao.s
				Customer cRes  = (Customer) pCustomerCombo.getSelectItem();
				String cCode = cRes.getCode();
				
				
				
			}
		});
		contentPane.add(pSellInfoA);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnNewButton = new JButton("저장");
		panel_4.add(btnNewButton);
		
		pSellInfoA.clear();

	}		// constructor ends

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
	}
	
	private void actionPerformedBtnOK(ActionEvent e) {
		Employee eRes = pEmployee.getObject();
		Product pRes = pProduct.getObject();
		Customer cRes = pCustomer.getObject();
		if(eRes == null || pRes == null || cRes ==null ){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
			
		}else{
			int salePrice = pRes.getSalePrice(); 	//판매정가
			String egrade = eRes.getGrade(); //사원등급
			String cgrade = cRes.getGrade(); //거래처등급
			int dispercentage=0;
			if(egrade.equals("A")){
				dispercentage += 3;
			}else if(egrade.equals("B")){
				dispercentage += 2;
			}else if(egrade.equals("C")){
				dispercentage += 1;
			}
			if(cgrade.equals("L")){
				dispercentage += 4;
			}else if(cgrade.equals("M")){
				dispercentage += 3;
			}else if(cgrade.equals("S")){
				dispercentage += 2;
			}
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
		}	
	}
	
}
