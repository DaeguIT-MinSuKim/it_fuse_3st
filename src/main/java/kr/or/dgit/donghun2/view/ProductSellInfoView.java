package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import erp_myframework.ComboPanel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.ProductSellInfoTable;

public class ProductSellInfoView extends JFrame {

	private JPanel contentPane;
	private ProductService pdao;
	private JPanel pCombo;
	private ComboPanel<Product> pProductForCombo;
	private CalculatedValueService cvdao;
	private JScrollPane scrollPane;
	private ProductSellInfoTable table;

	public static void main(String[] args) {
		 try {
		 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		 
		}catch (Exception e) {}
		 ProductSellInfoView pv = new ProductSellInfoView();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductSellInfoView frame = new ProductSellInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductSellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
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
		contentPane.setLayout(gbl_contentPane);
		
		pCombo = new JPanel();
		pCombo.add(pProductForCombo,pgbc_lbl);
		pCombo.add(pProductForCombo, pgbc_combo);
		
		pCombo.add(pProductForCombo);
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
						for(CalculatedValue cv : calculatedValues){
							System.out.println(cv);
						}
					//	table.loadDateByCode(pRes);
						
						
					}
				}
				
		);
		


	}
}
