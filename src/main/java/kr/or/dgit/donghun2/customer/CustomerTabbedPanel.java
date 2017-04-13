package kr.or.dgit.donghun2.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import erp_myframework.ComboPanel;
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
	private ComboPanel<Customer> pCustomerForCombo;

	/**
	 * Create the panel.
	 */
	public CustomerTabbedPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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

	protected void setInit() {
		List<Customer> customer = cdao.getInstance().selectCustomerByAll();
		pCusp.getpCode().setFocusable(true);
	}

	private void actionPerformedCbtnSearch(ActionEvent e) {
		Customer res = cdao.getInstance().selectCustomerByNo(pCusp.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
			pCusp.clear();
			return;
		}else if (res.isIsexist() == false) {
			JOptionPane.showMessageDialog(null, "퇴사한 회원입니다.");
			return;
		} else {
			JOptionPane.showMessageDialog(null, res);
			pCusp.setObject(res);
			pCusp.clear();
		}
	}

	private void actionPerformedCBtnDele(ActionEvent e) {
		Customer res = cdao.getInstance().selectCustomerByNo(pCusp.getObject());
		if(res==null){
			JOptionPane.showMessageDialog(null, "삭제 할 거래처가 없습니다.");
			pCusp.clear();
			return;
		}else if (res.isIsexist() == false) {
			JOptionPane.showMessageDialog(null, "삭제된 거래처입니다.");
			pCusp.clear();
			return;
		} else {
			if (JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?") == JOptionPane.YES_NO_OPTION) {

			}
			int cRes = cdao.getInstance().deleteCustomer(pCusp.getObject());
			if (cRes == 0) {
				JOptionPane.showMessageDialog(null, "삭제불가");
			} else {
				JOptionPane.showMessageDialog(null, "삭제완료");
				pCust.loadDate();
				pCusp.clear();
			}
		}
	}

}
