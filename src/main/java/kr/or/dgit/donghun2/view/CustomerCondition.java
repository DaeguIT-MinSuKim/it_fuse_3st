package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import erp_myframework.TextFiledFormatPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.panel.CustomerPanel;
import kr.or.dgit.donghun2.service.CustomerService;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import kr.or.dgit.donghun2.table.CustomerConditionTable;

public class CustomerCondition extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOk;
	private CustomerConditionTable pTable;
	private CustomerPanel pCustomer;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCondition frame = new CustomerCondition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CustomerCondition() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 748, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pCustomer = new CustomerPanel();
		contentPane.add(pCustomer, BorderLayout.NORTH);
		pCustomer.setLayout(new BoxLayout(pCustomer, BoxLayout.X_AXIS));
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pCustomer.add(btnOk);
		
		JButton btnRun = new JButton("실행");
		pCustomer.add(btnRun);
		
		pTable = new CustomerConditionTable();
		contentPane.add(pTable, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		Customer res = CustomerService.getInstance().selectCustomerByNo(pCustomer.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pCustomer.setObject(res);
		}
	}
}
