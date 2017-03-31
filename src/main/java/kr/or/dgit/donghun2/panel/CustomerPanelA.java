package kr.or.dgit.donghun2.panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerPanelA extends JPanel implements ActionListener {

	private CustomerPanel pCustomer;
	private JPanel pbtn;
	private JButton btnSave;
	private JButton btnDele;
	private JButton btnSearch;
	private CustomerTable pTable;
	private static CustomerService dao;
	
	/**
	 * Create the panel.
	 */
	public CustomerPanelA() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pCustomer = new CustomerPanel();
		add(pCustomer);
		
		pbtn = new JPanel();
		add(pbtn);
		
		btnSave = new JButton("저장");
		pbtn.add(btnSave);
		
		btnDele = new JButton("삭제");
		pbtn.add(btnDele);
		
		btnSearch = new JButton("검색");
		pbtn.add(btnSearch);
		
		pTable = new CustomerTable();
		add(pTable);
		pTable.loadDate();

	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnDele) {
			actionPerformedBtnDele(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}
	protected void actionPerformedBtnSave(ActionEvent e) {
		if(pCustomer.isEmpty()){
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		}else{
			dao.getInstance().insertCustomer(pCustomer.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pTable.loadDate();
		}
		
		
	}
	protected void actionPerformedBtnDele(ActionEvent e) {
		int res = dao.getInstance().deleteCustomer(pCustomer.getObject());
		if(res==0){
			JOptionPane.showMessageDialog(null, "삭제안댐");
		}else{
			JOptionPane.showMessageDialog(null, "삭제댐");
			pTable.loadDate();
		}
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Customer res = dao.getInstance().selectCustomerByNo(pCustomer.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pCustomer.setObject(res);
		}
		
	}
	public JButton getBtnSave() {
		return btnSave;
	}
	public JButton getBtnDele() {
		return btnDele;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public boolean isEmpty(){
		boolean result = false;
		for(Component c : getComponents()){
			if(c instanceof TextFiledPanel){
				TextFiledPanel tfp =(TextFiledPanel)c;
				if(tfp.isEmpty()){
					return true;
				}
			}
		}
		return false;
	}
	
}
