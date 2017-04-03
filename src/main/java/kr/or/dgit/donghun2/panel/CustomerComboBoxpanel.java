package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;



import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class CustomerComboBoxpanel extends JPanel {

	private JPanel panel;

	private static CustomerService cdao;

	public CustomerComboBoxpanel() {

		setBounds(100, 100, 561, 629);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel = new JPanel();
		panel.add(panel);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

	}

}