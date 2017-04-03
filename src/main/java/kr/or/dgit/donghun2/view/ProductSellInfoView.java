package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
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
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.ProductTable;

public class ProductSellInfoView extends JFrame {

	private JPanel contentPane;
	private ProductService pdao;
	private ProductTable pTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public ProductSellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0,1,0,0));
		
		JPanel pCombo = new JPanel();
		
		ComboPanel<Product> pProductForCombo = new ComboPanel<>();
		pProductForCombo.setTitle("제품");
		
		GridBagLayout pgridBagLayout = new GridBagLayout();
		pgridBagLayout.columnWidths = new int[]{100,425,0};
		pgridBagLayout.rowHeights = new int[]{51,0};
		pgridBagLayout.columnWeights = new double[]{0.0 , 0.0, Double.MIN_VALUE};
		pgridBagLayout.rowWeights = new double[]{0.0,Double.MIN_VALUE};
		pProductForCombo.setLayout(pgridBagLayout);
		
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;
		cgbc_lbl.insets = new Insets(0,0,0,5);
		cgbc_lbl.gridx=0;
		cgbc_lbl.gridy=0;
		pCombo.add(pProductForCombo, cgbc_lbl);
		
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		pCombo.add(pProductForCombo, cgbc_combo);
		
		List<Product> pList = pdao.getInstance().selectProductByAll();
		Vector<Product> pVecter = new Vector<>();
		for(int i=0; i<pList.size(); i++){
			pVecter.addElement(pList.get(i));
		}
		pProductForCombo.setcomboData(pVecter);
		
		pCombo.add(pProductForCombo);
		contentPane.add(pCombo);
		pCombo.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		pTable = new ProductTable();
		contentPane.add(pTable);
		pTable.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
	}

}












