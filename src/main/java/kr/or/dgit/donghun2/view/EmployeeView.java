package kr.or.dgit.donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.dao.CustomerMapper;
import kr.or.dgit.donghun2.dao.EmployeeMapper;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.panel.EmployeePanel;
import kr.or.dgit.donghun2.service.EmployeeService;
import kr.or.dgit.donghun2.table.EmployeeTable;

@SuppressWarnings("serial")
public class EmployeeView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSearch;
	private EmployeePanel pEmployee;
	private JPanel pBtn;
	private JButton btnSave;
	private JButton btnDele;

	private static EmployeeService dao;

	private EmployeeTable pTable;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pEmployee = EmployeePanel.getInstance();
		contentPane.add(pEmployee);

		pBtn = new JPanel();
		pEmployee.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);

		btnDele = new JButton("삭제");
		btnDele.addActionListener(this);
		pBtn.add(btnDele);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);
		setinit();
		
		pTable = new EmployeeTable();
		contentPane.add(pTable);
		pTable.loadDate();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDele) {
			actionPerformedBtnDele(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		Employee res = dao.getInstance().selectEmployeeByNo(pEmployee.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다");
		} else {
			if (res.isIsexist() == false) {
				JOptionPane.showMessageDialog(null, "현재 존재하지 않은 사원입니다.");
			} else {
				JOptionPane.showMessageDialog(null, "검색하였습니다.");
				pEmployee.setObject(res);
			}
		}

	}
	protected void setinit(){
		List<Employee> employee = dao.getInstance().selectEmployeeByAll();
		
		String asdf = employee.get(employee.size()-1).getCode();
		String value = String.format(setNoFormat(), Integer.parseInt(asdf.substring(1))+1);
		pEmployee.getpCode().setTfValue(value);
		pEmployee.getpCode().gettF().setFocusable(true);
	}
	protected String setNoFormat(){
		return "E%03d";
	}

	protected void actionPerformedBtnSave(ActionEvent e) {
		if (pEmployee.getpCode().isEmpty()) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다");
		} else {
			if (pEmployee.getInstance().getObject() != null) {
				Employee eRes = pEmployee.getObject();
				String ecode = eRes.getCode();
				boolean ok = Pattern.matches("^E[0-9]{3}$", ecode);
				if (ok == true) {
					dao.getInstance().insertEmployee(pEmployee.getObject());
					JOptionPane.showMessageDialog(null, "저장되었습니다");
					pTable.loadDate();
				} else {
					JOptionPane.showMessageDialog(null, "코드 입력 형식은 E000입니다.");
					
				}
			}
		}

	}

	protected void actionPerformedBtnDele(ActionEvent e) {

		int res = dao.getInstance().deleteEmployee(pEmployee.getObject());

		if (res == 0) {
			JOptionPane.showMessageDialog(null, "삭제실패");
		} else {
			JOptionPane.showMessageDialog(null, "삭제성공");
			pTable.loadDate();
		}

	}
}
