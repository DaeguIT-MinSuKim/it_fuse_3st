package kr.or.dgit.donghun2.employee;

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
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.table.EmployeeSellInfoTable;

public class EmployeeSellInfoPanel extends JPanel {

	private ComboPanel<Employee> pEmployeeForCombo;
	private EmployeeService edao;
	private EmployeeSellInfoTable pEmployeeSellInfo;
	private JPanel pCombo;
	private JScrollPane scrollPane;
	private EmployeeSellInfoTable table;
	private CalculatedValueService cvdao;

	public EmployeeSellInfoPanel() {
		setLayout(new BorderLayout(0, 0));

		pEmployeeForCombo = new ComboPanel<>();
		pEmployeeForCombo.setTitle("사원");

		GridBagLayout egridBagLayout = new GridBagLayout();
		egridBagLayout.columnWidths = new int[] { 100, 425, 0 };
		egridBagLayout.rowHeights = new int[] { 51, 0 };
		egridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		egridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pEmployeeForCombo.setLayout(egridBagLayout);

		GridBagConstraints egbc_lbl = new GridBagConstraints();
		egbc_lbl.fill = GridBagConstraints.BOTH;
		egbc_lbl.insets = new Insets(0, 0, 0, 5);
		egbc_lbl.gridx = 0;
		egbc_lbl.gridy = 0;

		GridBagConstraints egbc_combo = new GridBagConstraints();

		List<Employee> eList = edao.getInstance().selectEmployeeByAll();
		Vector<Employee> eVector = new Vector<>();
		eVector.add(new Employee());
		for (int i = 0; i < eList.size(); i++) {
			eVector.addElement(eList.get(i));
		}
		pEmployeeForCombo.setcomboData(eVector);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 556, 0 };
		gbl_contentPane.rowHeights = new int[] { 92, 185, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		pCombo = new JPanel();
		pCombo.add(pEmployeeForCombo, egbc_lbl);
		pCombo.add(pEmployeeForCombo, egbc_combo);

		pCombo.add(pEmployeeForCombo);
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

		table = new EmployeeSellInfoTable();
		scrollPane.setViewportView(table);

		pEmployeeForCombo.getTf().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Employee eRes = (Employee) pEmployeeForCombo.getSelectItem();

				Map<String, String> item = new HashMap<>();
				item.put("ecode", eRes.getCode());
				List<CalculatedValue> calculatedValues = cvdao.getInstance().vw_InfoByEmployeeByCode(item);
				if (eRes.getCode() == null) {
					table.loadDateByAll();
				} else {
					table.loadDateByCode(eRes);
				}
			}
		}

		);

	}
}
