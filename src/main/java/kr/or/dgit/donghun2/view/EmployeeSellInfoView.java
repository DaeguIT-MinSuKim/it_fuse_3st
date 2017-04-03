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
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.table.EmployeeTable;

public class EmployeeSellInfoView extends JFrame {

	private JPanel contentPane;
	private EmployeeService edao;
	private EmployeeTable pTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSellInfoView frame = new EmployeeSellInfoView();
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
	public EmployeeSellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1,0,0));
		
		JPanel pCombo = new JPanel();
		
		ComboPanel<Employee> pEmployeeForCombo = new ComboPanel<>();
		pEmployeeForCombo.setTitle("사원");
		
		GridBagLayout egridBagLayout = new GridBagLayout();
		egridBagLayout.columnWidths = new int[]{100,425,0}; 
		egridBagLayout.rowHeights = new int[] {51,0}; 
		egridBagLayout.columnWeights = new double[]{0.0,0.0,Double.MIN_VALUE}; 
		egridBagLayout.rowWeights = new double[]{0.0,Double.MIN_VALUE};
		pEmployeeForCombo.setLayout(egridBagLayout);
		
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH; cgbc_lbl.insets=new Insets(0,0,0,5); cgbc_lbl.gridx=0; cgbc_lbl.gridy=0;
		pCombo.add(pEmployeeForCombo, cgbc_lbl);
		
		GridBagConstraints cgbc_combo=new GridBagConstraints();
		pCombo.add(pEmployeeForCombo,cgbc_combo);
		
		List<Employee> eList = edao.getInstance().selectEmployeeByAll();
		Vector<Employee> eVector = new Vector<>();
		for(int i=0;i<eList.size(); i++){
			eVector.addElement(eList.get(i));
		}
		pEmployeeForCombo.setcomboData(eVector);
		
		pCombo.add(pEmployeeForCombo);
		contentPane.add(pCombo);
		pCombo.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		pTable = new EmployeeTable();
		contentPane.add(pTable);
		pTable.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
	}
	

}
