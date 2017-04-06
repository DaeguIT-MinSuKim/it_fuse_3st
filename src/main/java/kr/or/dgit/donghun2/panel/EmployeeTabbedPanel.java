package kr.or.dgit.donghun2.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.table.EmployeeTable;

public class EmployeeTabbedPanel extends JPanel implements ActionListener{

	
	private EmployeePanel pEmpp;
	private EmployeeService edao;
	private JPanel pbtn;
	private JButton EbtnSave;
	private JButton EbtnDele;
	private JButton EbtnSearch;
	private EmployeeTable pEmpt;

	public EmployeeTabbedPanel() {
		pEmpp = new EmployeePanel();
		add(pEmpp);
		pbtn = new JPanel();
		add(pbtn);
		
		EbtnSave = new JButton("저장");
		EbtnDele = new JButton("삭제");
		EbtnSearch = new JButton("검색");
		pbtn.add(EbtnSave);
		EbtnSave.addActionListener(this);
		EbtnDele.addActionListener(this);
		EbtnSearch.addActionListener(this);
		pbtn.add(EbtnDele);
		pbtn.add(EbtnSearch);
		
		pEmpt = new EmployeeTable();
		add(pEmpt);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == EbtnSave) {
	         actionPerformedEBtnSave(e);
	      }
	      if (e.getSource() == EbtnDele) {
	         actionPerformedEBtnDele(e);
	      }
	      if (e.getSource() == EbtnSearch) {
	         actionPerformedEbtnSearch(e);
	      }
	}

	private void actionPerformedEbtnSearch(ActionEvent e) {
		 Employee res = edao.getInstance().selectEmployeeByNo(pEmpp.getObject());
	      if (res == null) {
	         JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
	      } else {
	         JOptionPane.showMessageDialog(null, "검색하였습니다.");
	         pEmpp.setObject(res);
	      }
	}

	private void actionPerformedEBtnDele(ActionEvent e) {
		int res = edao.getInstance().deleteEmployee(pEmpp.getObject());
	      if (res == 0) {
	         JOptionPane.showMessageDialog(null, "삭제안댐");
	      } else {
	         JOptionPane.showMessageDialog(null, "삭제댐");
	         pEmpt.loadDate();
	      }
	}

	private void actionPerformedEBtnSave(ActionEvent e) {
		  if (pEmpp.isEmpty()) {
		         JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		      } else {
		         edao.getInstance().insertEmployee(pEmpp.getObject());
		         JOptionPane.showMessageDialog(null, "저장되었습니다.");
		         pEmpt.loadDate();
		      }
	}
	public JButton getEBtnSave(){
		return EbtnSave;
	}
	public JButton getEBtnDele(){
		return EbtnDele;
	}
	public JButton getEBtnSearch(){
		return EbtnSearch;
	}
	
	
	

}
