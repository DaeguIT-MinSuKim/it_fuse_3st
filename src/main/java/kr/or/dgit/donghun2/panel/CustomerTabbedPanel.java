package kr.or.dgit.donghun2.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerTabbedPanel extends JPanel implements ActionListener {

	private CustomerPanel pCusp;
	private JPanel pbtn;
	private JButton CbtnDele;
	private JButton CbtnSearch;
	private CustomerTable pCust;
	private CustomerService cdao;
	/**
	 * Create the panel.
	 */
	public CustomerTabbedPanel() {
		pCusp = new CustomerPanel();
		add(pCusp);
		pbtn = new JPanel();
		
		CbtnDele = new JButton("삭제");
		CbtnSearch = new JButton("검색");
		add(pbtn);
		
		pbtn.add(CbtnDele);
		CbtnDele.addActionListener(this);
		pbtn.add(CbtnSearch);
		CbtnSearch.addActionListener(this);
		pCust = new CustomerTable();
		add(pCust);
		setInit();
	}

	public JButton getCbtnDele() {
		return CbtnDele;
	}

	public JButton getCbtnSearch() {
		return CbtnSearch;
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == CbtnDele) {
			actionPerformedCBtnDele(e);
		}
		if (e.getSource() == CbtnSearch) {
			actionPerformedCbtnSearch(e);
		}
	}
	protected void setInit(){
		List<Customer> customer = cdao.getInstance().selectCustomerByAll();
		pCusp.getpCode().setFocusable(true);
	}


	private void actionPerformedCbtnSearch(ActionEvent e) {
		  Customer res = cdao.getInstance().selectCustomerByNo(pCusp.getObject());
	      if (res == null) {
	         JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
	      } else {
	         JOptionPane.showMessageDialog(null, res);
	         pCusp.setObject(res);
	         pCusp.clear();
	      }
	}

	private void actionPerformedCBtnDele(ActionEvent e) {
		int res = cdao.getInstance().deleteCustomer(pCusp.getObject());
	      if (res == 0) {
	         JOptionPane.showMessageDialog(null, "삭제안댐");
	      } else {
	    	  if(JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?")==JOptionPane.YES_NO_OPTION){
	         pCust.loadDate();
	         pCusp.clear();
	    	  }
	      }
	}


}
