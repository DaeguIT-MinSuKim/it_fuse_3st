package kr.or.dgit.donghun2.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerSellInfoTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerSellInfoView extends JFrame {
	private CustomerService cdao;
	private JPanel pCombo;
	private ComboPanel<Customer> pCustomerForCombo;
	private CalculatedValueService cvdao;
	private JScrollPane scrollPane;
	private CustomerSellInfoTable table;
	private JPanel contentPane;
	private CustomerTable pTable;

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
	public CustomerSellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		pCustomerForCombo = new ComboPanel<>();
		pCustomerForCombo.setTitle("거래처");

		GridBagLayout cgridBagLayout = new GridBagLayout();
		cgridBagLayout.columnWidths = new int[]{100, 425, 0};		cgridBagLayout.rowHeights = new int[]{51, 0};		cgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		cgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pCustomerForCombo.setLayout(cgridBagLayout);
		
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;		cgbc_lbl.insets = new Insets(0, 0, 0, 5);		cgbc_lbl.gridx = 0;		cgbc_lbl.gridy = 0;
		
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		
		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		Vector<Customer> cVector = new Vector<>();
		cVector.add(new Customer());
		for(int i = 0 ; i < cList.size(); i++){
			cVector.addElement(cList.get(i));
		}
		pCustomerForCombo.setcomboData(cVector);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{556, 0};
		gbl_contentPane.rowHeights = new int[]{92, 185, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		pCombo = new JPanel();
		pCombo.add(pCustomerForCombo,cgbc_lbl);
		pCombo.add(pCustomerForCombo, cgbc_combo);
		
		pCombo.add(pCustomerForCombo);
		GridBagConstraints gbc_pCombo = new GridBagConstraints();
		gbc_pCombo.fill = GridBagConstraints.BOTH;
		gbc_pCombo.insets = new Insets(0, 0, 5, 0);
		gbc_pCombo.gridx = 0;
		gbc_pCombo.gridy = 0;
		contentPane.add(pCombo, gbc_pCombo);
		pCombo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pTable = new JPanel();
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 1;
		contentPane.add(pTable, gbc_pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new CustomerSellInfoTable();
		scrollPane.setViewportView(table);
		
		
		pCustomerForCombo.getTf().addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Customer cRes = (Customer) pCustomerForCombo.getSelectItem();
						
						Map<String, String> item = new HashMap<>();
						item.put("ccode", cRes.getCode());
						List<CalculatedValue> calculatedValues = cvdao.getInstance().vw_InfoByCustomerByCode(item);
						for(CalculatedValue cv : calculatedValues){
							System.out.println(cv);
						}
					//	table.loadDateByCode(cRes);
						
						
					}
				}
				
		);
		
		pTable = new CustomerTable();
		contentPane.add(pTable);
		pTable.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
	}
}
