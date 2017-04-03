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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.panel.CustomerPanel;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerConditionView extends JFrame {

	private JPanel contentPane;
	private CustomerPanel pCustomer;
	private JPanel pbtn;
	private CustomerTable pTable;
	
	public static void main(String[] args) {
		 try {
		 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		 
		}catch (Exception e) {}
		CustomerConditionView cv = new CustomerConditionView();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerConditionView frame = new CustomerConditionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerConditionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pbtn = new JPanel();
		contentPane.add(pbtn);
		pbtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		pTable = new CustomerTable();
		 contentPane.add(pTable);
		 pTable.setVisible(true);
	}

}
