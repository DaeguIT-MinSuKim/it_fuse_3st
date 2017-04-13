package kr.or.dgit.donghun2.product;

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
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.ProductSellInfoTable;

public class ProductSellInfoPanel extends JPanel {

	private ComboPanel<Product> pProductForCombo;
	private ProductService pdao;
	private CalculatedValueService cvdao;
	private JPanel pCombo;
	private JScrollPane scrollPane;
	private ProductSellInfoTable table;

	/**
	 * Create the panel.
	 */
	public ProductSellInfoPanel() {
		pProductForCombo = new ComboPanel<>();
		pProductForCombo.setTitle("제품");

		GridBagLayout pgridBagLayout = new GridBagLayout();
		pgridBagLayout.columnWidths = new int[]{100, 425, 0};		pgridBagLayout.rowHeights = new int[]{51, 0};		pgridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};		pgridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pProductForCombo.setLayout(pgridBagLayout);
		
		GridBagConstraints pgbc_lbl = new GridBagConstraints();
		pgbc_lbl.fill = GridBagConstraints.BOTH;		pgbc_lbl.insets = new Insets(0, 0, 0, 5);		pgbc_lbl.gridx = 0;		pgbc_lbl.gridy = 0;
		
		GridBagConstraints pgbc_combo = new GridBagConstraints();
		
		List<Product> pList = pdao.getInstance().selectProductByAll();
		Vector<Product> pVector = new Vector<>();
		pVector.add(new Product());
		for(int i = 0 ; i < pList.size(); i++){
			pVector.addElement(pList.get(i));
		}
		pProductForCombo.setcomboData(pVector);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{556, 0};
		gbl_contentPane.rowHeights = new int[]{92, 185, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		pCombo = new JPanel();
		pCombo.add(pProductForCombo,pgbc_lbl);
		pCombo.add(pProductForCombo, pgbc_combo);
		
		pCombo.add(pProductForCombo);
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
		
		table = new ProductSellInfoTable();
		scrollPane.setViewportView(table);
		
		
		pProductForCombo.getTf().addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Product pRes = (Product) pProductForCombo.getSelectItem();
						
						Map<String, String> item = new HashMap<>();
						item.put("pcode", pRes.getCode());
						List<CalculatedValue> calculatedValues = cvdao.getInstance().vw_InfoByProductByCode(item);
						if (pRes.getCode() == null) {
							table.loadData();
						} else {
							table.loadDateByCode(pRes);
						}
					}
				}
				
		);
		
	}

}
