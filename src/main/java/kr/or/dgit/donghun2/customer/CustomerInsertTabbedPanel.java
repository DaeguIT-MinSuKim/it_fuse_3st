package kr.or.dgit.donghun2.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerInsertTabbedPanel extends JPanel implements ActionListener {

	private CustomerPanel pCusp;
	private JPanel pbtn;
	private JButton CbtnSave;
	private CustomerTable pCust;
	private CustomerService cdao;
	/**
	 * Create the panel.
	 */
	public CustomerInsertTabbedPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pCusp = new CustomerPanel();
		add(pCusp);
		pbtn = new JPanel();
		CbtnSave = new JButton("저장");
		add(pbtn);
		pbtn.add(CbtnSave);
		CbtnSave.addActionListener(this);
		pCust = new CustomerTable();
		add(pCust);
		setInit();
	}

	public JButton getCbtnSave() {
		return CbtnSave;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CbtnSave) {
			actionPerformedCBtnSave(e);
		}
	}
	protected void setInit(){
		List<Customer> customer = cdao.getInstance().selectCustomerByAll();
		if(customer.size()==0){
			pCusp.getpCode().setTfValue("C001");
			pCusp.getpCode().gettF().setEditable(false);
		}else{
		String lastNum = customer.get(customer.size()-1).getCode();
		String value = String.format(setFormat(), Integer.parseInt(lastNum.substring(1))+1);
		pCusp.getpCode().setTfValue(value);
		pCusp.getpCode().gettF().setEditable(false);
		}
	}

	private String setFormat() {
		return "C%03d";
	}

	private void actionPerformedCBtnSave(ActionEvent e) {
		boolean CustomerName = Pattern.matches("^[a-zA-Z가-힣]*$", pCusp.getObject().getName());
		 if (pCusp.isEmpty()) {
	         JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
	         return;
	      }else if(CustomerName==false){
	    	  JOptionPane.showMessageDialog(null, "거래처명에는 숫자를 입력 하실 수 없습니다.");
	    	  return;
	      } else {
	    	 cdao.getInstance().insertCustomer(pCusp.getObject());
	         JOptionPane.showMessageDialog(null, "저장되었습니다.");
	         pCust.loadDate();
	         pCusp.clear();
	         setInit();
	      }
	}

}
