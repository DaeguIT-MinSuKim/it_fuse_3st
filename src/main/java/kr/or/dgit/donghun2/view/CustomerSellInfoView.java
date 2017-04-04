package kr.or.dgit.donghun2.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerSellInfoTable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerSellInfoView extends JFrame {

	private JPanel contentPane;
	private CustomerService cdao;
	private JPanel pCombo;
	private ComboPanel<String> pCustomerForCombo;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private CustomerSellInfoTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSellInfoView frame = new CustomerSellInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**ㅇㅣ거!!!
	 * Create the frame.
	 */
	public CustomerSellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		pCombo = new JPanel();
		
		
		
		
		pCustomerForCombo = new ComboPanel();
		pCustomerForCombo.setTitle("거래처");

		GridBagLayout cgridBagLayout = new GridBagLayout();
		cgridBagLayout.columnWidths = new int[]{100, 425, 0};		cgridBagLayout.rowHeights = new int[]{51, 0};		cgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		cgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pCustomerForCombo.setLayout(cgridBagLayout);
		
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;		cgbc_lbl.insets = new Insets(0, 0, 0, 5);		cgbc_lbl.gridx = 0;		cgbc_lbl.gridy = 0;
		pCombo.add(pCustomerForCombo,cgbc_lbl);
		
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		pCombo.add(pCustomerForCombo, cgbc_combo);
		
		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		Vector<String> cVector = new Vector<>();
		String cinit = "데이터를 선택하세요";
		cVector.addElement(cinit);
		for(int i = 0 ; i < cList.size(); i++){
			cVector.addElement(cList.get(i).toString());
		}
		pCustomerForCombo.setcomboData(cVector);
		
		pCombo.add(pCustomerForCombo);
		contentPane.add(pCombo);
		pCombo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pTable = new JPanel();
		contentPane.add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new CustomerSellInfoTable();
		scrollPane.setViewportView(table);
		
	}

}
