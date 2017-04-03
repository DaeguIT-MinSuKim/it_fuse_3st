package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.panel.CustomerComboBoxpanel;
import kr.or.dgit.donghun2.service.CustomerService;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

public class sadfsadfasdf extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private ComboPanel<Customer> pCustomerForCombo;
	private CustomerService cdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		} catch (Exception e) {
		}
		sadfsadfasdf cv = new sadfsadfasdf();

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

	/**
	 * Create the frame.
	 */
	public sadfsadfasdf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0 };
		gbl_contentPane.rowHeights = new int[] { 0 };
		gbl_contentPane.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		ComboPanel<Customer> pCustomerForCombo = new ComboPanel();

		pCustomerForCombo.setTitle("거래처");
		GridBagLayout cgridBagLayout = new GridBagLayout();
		cgridBagLayout.columnWidths = new int[] { 100, 425, 0 };
		cgridBagLayout.rowHeights = new int[] { 51, 0 };
		cgridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		cgridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		
		pCustomerForCombo.setLayout(cgridBagLayout);
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;
		cgbc_lbl.insets = new Insets(0, 0, 0, 5);
		cgbc_lbl.gridx = 0;
		cgbc_lbl.gridy = 0;
		panel.add(pCustomerForCombo, cgbc_lbl);
		
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		panel.add(pCustomerForCombo, cgbc_combo);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		for (Customer c : cList) {
			System.out.println(c);
		}
		Vector<Customer> cVector = new Vector<>();
		for (int i = 0; i < cList.size(); i++) {
			cVector.addElement(cList.get(i));
		}
		pCustomerForCombo.setcomboData(cVector);
	}

}
