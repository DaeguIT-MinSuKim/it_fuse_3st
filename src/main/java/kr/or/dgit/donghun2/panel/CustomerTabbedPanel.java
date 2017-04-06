package kr.or.dgit.donghun2.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.birosoft.liquid.util.Panel;

import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerTabbedPanel extends JPanel implements ActionListener {

	private CustomerPanel pCusp;
	private JPanel pbtn;
	private JButton CbtnSave;
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
		CbtnSave = new JButton("저장");
		CbtnDele = new JButton("삭제");
		CbtnSearch = new JButton("검색");
		add(pbtn);
		pbtn.add(CbtnSave);
		CbtnSave.addActionListener(this);
		pbtn.add(CbtnDele);
		CbtnDele.addActionListener(this);
		pbtn.add(CbtnSearch);
		CbtnSearch.addActionListener(this);
		pCust = new CustomerTable();
		add(pCust);
	}

	public JButton getCbtnSave() {
		return CbtnSave;
	}

	public JButton getCbtnDele() {
		return CbtnDele;
	}

	public JButton getCbtnSearch() {
		return CbtnSearch;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CbtnSave) {
			actionPerformedCBtnSave(e);
		}
		if (e.getSource() == CbtnDele) {
			actionPerformedCBtnDele(e);
		}
		if (e.getSource() == CbtnSearch) {
			actionPerformedCbtnSearch(e);
		}
	}

	private void actionPerformedCbtnSearch(ActionEvent e) {
		  Customer res = cdao.getInstance().selectCustomerByNo(pCusp.getObject());
	      if (res == null) {
	         JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
	      } else {
	         JOptionPane.showMessageDialog(null, "검색하였습니다.");
	         pCusp.setObject(res);
	      }
	}

	private void actionPerformedCBtnDele(ActionEvent e) {
		int res = cdao.getInstance().deleteCustomer(pCusp.getObject());
	      if (res == 0) {
	         JOptionPane.showMessageDialog(null, "삭제안댐");
	      } else {
	         JOptionPane.showMessageDialog(null, "삭제댐");
	         pCust.loadDate();
	      }
	}

	private void actionPerformedCBtnSave(ActionEvent e) {
		 if (pCusp.isEmpty()) {
	         JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
	      } else {
	         cdao.getInstance().insertCustomer(pCusp.getObject());
	         JOptionPane.showMessageDialog(null, "저장되었습니다.");
	         pCust.loadDate();
	      }
	}

}
