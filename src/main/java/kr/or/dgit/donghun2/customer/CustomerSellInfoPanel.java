package kr.or.dgit.donghun2.customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerSellInfoTable;

public class CustomerSellInfoPanel extends JPanel {

	private ComboPanel<Customer> pCustomerForCombo;
	private CustomerService cdao;
	private JPanel pCombo;
	private JScrollPane scrollPane;
	private CustomerSellInfoTable table;
	private CalculatedValueService cvdao;
	/**
	 * Create the panel.
	 */
	public CustomerSellInfoPanel() {
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
		setLayout(gbl_contentPane);
		
		pCombo = new JPanel();
		pCombo.add(pCustomerForCombo,cgbc_lbl);
		pCombo.add(pCustomerForCombo, cgbc_combo);
		
		pCombo.add(pCustomerForCombo);
		GridBagConstraints gbc_pCombo = new GridBagConstraints();
		gbc_pCombo.fill = GridBagConstraints.BOTH;
		gbc_pCombo.insets = new Insets(0, 0, 5, 0);
		gbc_pCombo.gridx = 0;
		gbc_pCombo.gridy = 0;
		add(pCombo, gbc_pCombo);
		pCombo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pTable = new JPanel();
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 1;
		add(pTable, gbc_pTable);
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
					
						if(cRes.getCode()==null){
							table.loadDateByAll();
						}else{
						table.loadDateByCode(cRes);
						}
						
					}
				}
				
		);
	}

}
