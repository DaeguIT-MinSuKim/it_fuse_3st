package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridLayout;

import kr.or.dgit.donghun2.panel.CustomerPanel;
import kr.or.dgit.donghun2.panel.ProductPanel;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.CustomerTable;
import kr.or.dgit.donghun2.table.ProductTable;

public class ProductConditionView extends JFrame {

	private JPanel contentPane;
	private ProductPanel pProduct;
	private JPanel pbtn;
	private ProductTable pTable;

	public static void main(String[] args) {
		 try {
		 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		 
		}catch (Exception e) {}
		 ProductConditionView cv = new ProductConditionView();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductConditionView frame = new ProductConditionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductConditionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pbtn = new JPanel();
		contentPane.add(pbtn);
		pbtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		pTable = new ProductTable();
		 contentPane.add(pTable);
		 pTable.setVisible(true);
	}
}
