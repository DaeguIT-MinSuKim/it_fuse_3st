package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;

import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

public class test extends JFrame {

	private CustomerService cdao;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		ComboPanel<Customer> pCustomerForCombo = new ComboPanel();
		pCustomerForCombo.setTitle("거래처");

		GridBagLayout cgridBagLayout = new GridBagLayout();
		cgridBagLayout.columnWidths = new int[]{100, 425, 0};		cgridBagLayout.rowHeights = new int[]{51, 0};		cgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		cgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pCustomerForCombo.setLayout(cgridBagLayout);
		
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;		cgbc_lbl.insets = new Insets(0, 0, 0, 5);		cgbc_lbl.gridx = 0;		cgbc_lbl.gridy = 0;
		panel.add(pCustomerForCombo,cgbc_lbl);
		
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		panel.add(pCustomerForCombo, cgbc_combo);
		
		
		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		Vector<Customer> cVector = new Vector<>();
		for(int i = 0 ; i < cList.size(); i++){
			cVector.addElement(cList.get(i));
		}
		pCustomerForCombo.setcomboData(cVector);
		panel.add(pCustomerForCombo);
	}

}
