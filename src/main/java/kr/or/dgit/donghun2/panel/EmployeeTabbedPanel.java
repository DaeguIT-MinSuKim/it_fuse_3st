package kr.or.dgit.donghun2.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.table.EmployeeTable;

public class EmployeeTabbedPanel extends JPanel implements ActionListener {

	private EmployeePanel pEmpp;
	private EmployeeService edao;
	private JPanel pbtn;
	
	private JButton EbtnDele;
	private JButton EbtnSearch;
	private EmployeeTable pEmpt;
	private Employee pEmp;

	public EmployeeTabbedPanel() {
		pEmpp = new EmployeePanel();
		add(pEmpp);
		pbtn = new JPanel();
		add(pbtn);

		
		EbtnDele = new JButton("삭제");
		EbtnSearch = new JButton("검색");
	
	
		EbtnDele.addActionListener(this);
		EbtnSearch.addActionListener(this);
		pbtn.add(EbtnDele);
		pbtn.add(EbtnSearch);

		pEmpt = new EmployeeTable();
		add(pEmpt);

		setInit();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == EbtnDele) {
			actionPerformedEBtnDele(e);
		}
		if (e.getSource() == EbtnSearch) {
			actionPerformedEbtnSearch(e);
			System.out.println("######");
		}
	}

	protected void setInit() {
		List<Employee> employee = edao.getInstance().selectEmployeeByAll();
		pEmpp.getpCode().setFocusable(true);
	}


	private void actionPerformedEbtnSearch(ActionEvent e) {
		Employee res = edao.getInstance().selectEmployeeByNo(pEmpp.getObject());
		if (res.isIsexist()==false) {
			JOptionPane.showMessageDialog(null,"퇴사한회원입니다");
			pEmpp.clear();
		} else if(res==null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		} else if(res!=null){
			JOptionPane.showMessageDialog(null, res);
			pEmpp.setObject(res);
			pEmpp.clear();
		}
	}

	private void actionPerformedEBtnDele(ActionEvent e) {
		Employee res = edao.getInstance().selectEmployeeByNo(pEmpp.getObject());
		if (res.isIsexist() == false) {
			JOptionPane.showMessageDialog(null, "이미 퇴사한 사원입니다.");
			return;
		} else {
			if (JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?") == JOptionPane.YES_OPTION) {
				
				int eRes = edao.getInstance().deleteEmployee(pEmpp.getObject());
				if (eRes == 0) {
					JOptionPane.showMessageDialog(null, "삭제불가 ");
				}else{
					JOptionPane.showMessageDialog(null, "삭제완료");
					pEmpt.loadDate();
					pEmpp.clear();
				}
			}
		}
	}

	public JButton getEBtnDele() {
		return EbtnDele;
	}

	public JButton getEBtnSearch() {
		return EbtnSearch;
	}

}
