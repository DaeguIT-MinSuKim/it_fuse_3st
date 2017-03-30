package kr.or.dgit.donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.FlowLayout;
import kr.or.dgit.donghun2.panel.EmployeeComboPanel;
import kr.or.dgit.donghun2.panel.ProductComboPanel;
import kr.or.dgit.donghun2.panel.CustomerComboPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import kr.or.dgit.donghun2.panel.SellInfoPanelB;

public class SellInfoViewA extends JFrame implements ActionListener {
	

	private JPanel contentPane;
	private SellInfoPanelA pSellInfo;
	private JButton btnOK;
	private EmployeePanel pEmployee;
	private ProductPanel pProduct;
	private CustomerPanel pCustomer;
	
	private static SellInfoService dao;
	private static ProductService pdao;
	private static EmployeeService edao;
	private static CustomerService cdao;

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
		setBounds(100, 100, 561, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 10));
		
		EmployeeComboPanel panel_1 = new EmployeeComboPanel();
		panel.add(panel_1);
		
		ProductComboPanel panel_2 = new ProductComboPanel();
		panel.add(panel_2);
		
		CustomerComboPanel panel_5 = new CustomerComboPanel();
		panel.add(panel_5);
		
		SellInfoPanelB panel_3 = new SellInfoPanelB();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnNewButton = new JButton("저장");
		panel_4.add(btnNewButton);


	}

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
			
			int unitPrice = (int) (salePrice*(1-(dispercentage*0.01)));
			int sellPrice = unitPrice*(pSellInfo.getObjectDateQuantity().getQuantity());
			int disPrice = salePrice*(pSellInfo.getObjectDateQuantity().getQuantity())-sellPrice;
					
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
		}	
	}
	
}
