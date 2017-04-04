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
	

	
	private JPanel pBtn;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JTabbedPane tabbedPane;
	
	
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
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		
		pTabbedPane = new JPanel();
		contentPane.add(pTabbedPane, BorderLayout.CENTER);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pTabbedPane.add(tabbedPane);

		
		
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

	

}
