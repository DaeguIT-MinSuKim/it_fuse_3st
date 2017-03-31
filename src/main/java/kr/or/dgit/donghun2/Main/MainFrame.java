package kr.or.dgit.donghun2.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.panel.CustomerPanel;
import kr.or.dgit.donghun2.panel.EmployeePanel;
import kr.or.dgit.donghun2.panel.ProductPanel;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;
import kr.or.dgit.donghun2.table.EmployeeTable;
import kr.or.dgit.donghun2.table.ProductTable;
import kr.or.dgit.donghun2.view.CustomerView;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
			 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			 
			}catch (Exception e) {}
			CustomerView cv = new CustomerView();
			
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
		setBounds(100, 100, 534, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
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
		
		JButton CbtnDele = new JButton("삭제");
		pCusb.add(CbtnDele);
		
		JButton CbtnSearch = new JButton("검색");
		pCusb.add(CbtnSearch);
		
		pCust = new CustomerTable();
		pCustomer.add(pCust);
		pCust.loadDate();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CbtnSave) {
			actionPerformedCBtnSave(e);
		}
	}
	protected void actionPerformedCBtnSave(ActionEvent e) {
		if(pCusp.isEmpty()){
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		}else{
			dao.getInstance().insertCustomer(pCusp.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pCust.loadDate();
		}
	}
}
