package kr.or.dgit.donghun2.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.table.EmployeeTable;

public class EmployeeInsertTabbedPanel extends JPanel implements ActionListener {

	private EmployeePanel pEmpp;
	private EmployeeService edao;
	private JPanel pbtn;
	private JButton EbtnSave;
	private EmployeeTable pEmpt;

	public EmployeeInsertTabbedPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pEmpp = new EmployeePanel();
		add(pEmpp);
		pbtn = new JPanel();
		add(pbtn);

		EbtnSave = new JButton("저장");
		
		pbtn.add(EbtnSave);
		EbtnSave.addActionListener(this);

		pEmpt = new EmployeeTable();
		add(pEmpt);

		setInit();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == EbtnSave) {
			actionPerformedEBtnSave(e);
		}
		
	}

	protected void setInit() {
		List<Employee> employee = edao.getInstance().selectEmployeeByAll();
		if(employee.size()==0){
			pEmpp.getpCode().setTfValue("E001");
			pEmpp.getpCode().gettF().setEditable(false);
		}else{
			String lastNum = employee.get(employee.size() - 1).getCode();
			String value = String.format(setNoFormat(), Integer.parseInt(lastNum.substring(1)) + 1);
			pEmpp.getpCode().setTfValue(value);
			pEmpp.getpCode().gettF().setEditable(false);
		}
	}

	private String setNoFormat() {
		return "E%03d";
	}

	private void actionPerformedEBtnSave(ActionEvent e) {
		boolean EmployeeName = Pattern.matches("^[a-zA-Z가-힣]*$", pEmpp.getObject().getName());
		if (pEmpp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else if(EmployeeName == false) {
			JOptionPane.showMessageDialog(null, "사원명에 숫자를 넣지 마십시오.");
		} else{
			edao.getInstance().insertEmployee(pEmpp.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pEmpt.loadDate();
			pEmpp.clear();
			setInit();
		}
	}
		

	public JButton getEBtnSave() {
		return EbtnSave;
	}

}
