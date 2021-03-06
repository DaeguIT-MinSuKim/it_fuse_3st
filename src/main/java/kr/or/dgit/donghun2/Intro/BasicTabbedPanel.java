package kr.or.dgit.donghun2.Intro;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.donghun2.customer.CustomerInsertTabbedPanel;
import kr.or.dgit.donghun2.customer.CustomerTabbedPanel;
import kr.or.dgit.donghun2.employee.EmployeeInsertTabbedPanel;
import kr.or.dgit.donghun2.employee.EmployeeTabbedPanel;
import kr.or.dgit.donghun2.product.ProductInsertTabbedPanel;
import kr.or.dgit.donghun2.product.ProductTabbedPanel;


public class BasicTabbedPanel extends JTabbedPane implements ChangeListener{
	private JPanel pEmployeeInsert;
	private JPanel pEmployeeManage;
	private EmployeeInsertTabbedPanel employeeInsertTabbedPanel;
	private EmployeeTabbedPanel employeeTabbedPanel;
	private JPanel pProductInsert;
	private JPanel pProductManage;
	private ProductInsertTabbedPanel productInsertTabbedPanel;
	private ProductTabbedPanel productTabbedPanel;
	private JPanel pCustomerInsert;
	private JPanel pCustomerManage;
	private CustomerInsertTabbedPanel customerInsertTabbedPanel;
	private CustomerTabbedPanel customerTabbedPanel;
	
	
   public BasicTabbedPanel() {
	   addChangeListener(this);
	   pEmployeeInsert = new JPanel();
	     
	   addTab("영업사원등록", null, pEmployeeInsert, null);
	   pEmployeeInsert.setLayout(new BoxLayout(pEmployeeInsert, BoxLayout.Y_AXIS));
	      if(employeeInsertTabbedPanel != null){
	         pEmployeeInsert.removeAll();
	      }
	   employeeInsertTabbedPanel = new EmployeeInsertTabbedPanel();
	   pEmployeeInsert.add(employeeInsertTabbedPanel);
	   
	   pEmployeeManage = new JPanel();
	   addTab("영업사원관리", null, pEmployeeManage, null);
	   
	   pProductInsert = new JPanel();
	   addTab("제품등록", null, pProductInsert, null);
	   
	   pProductManage = new JPanel();
	   addTab("제품관리", null, pProductManage, null);
	   
	   pCustomerInsert = new JPanel();
	   addTab("거래처등록", null, pCustomerInsert, null);
	   
	   pCustomerManage = new JPanel();
	   addTab("거래처관리", null, pCustomerManage, null);
   }


	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==this){
			stateChangedThis(this.getSelectedIndex());
		}
	}


	private void stateChangedThis(int selectedIndex) {
		if(this.getTitleAt(selectedIndex).equals("영업사원등록")){
			pEmployeeInsert.setLayout(new BoxLayout(pEmployeeInsert, BoxLayout.Y_AXIS));
			if(employeeInsertTabbedPanel != null){
				pEmployeeInsert.removeAll();
			}
			employeeInsertTabbedPanel = new EmployeeInsertTabbedPanel();
			pEmployeeInsert.add(employeeInsertTabbedPanel);
		} else if(this.getTitleAt(selectedIndex).equals("영업사원관리")){
			pEmployeeManage.setLayout(new BoxLayout(pEmployeeManage, BoxLayout.Y_AXIS));
			if(employeeTabbedPanel != null){
				pEmployeeManage.removeAll();
			}
			employeeTabbedPanel = new EmployeeTabbedPanel();
			pEmployeeManage.add(employeeTabbedPanel);
		}  else if(this.getTitleAt(selectedIndex).equals("제품등록")){
			pProductInsert.setLayout(new BoxLayout(pProductInsert, BoxLayout.Y_AXIS));
			if(productInsertTabbedPanel != null){
				pProductInsert.removeAll();
			}
			productInsertTabbedPanel = new ProductInsertTabbedPanel();
			pProductInsert.add(productInsertTabbedPanel);
		}  else if(this.getTitleAt(selectedIndex).equals("제품관리")){
			pProductManage.setLayout(new BoxLayout(pProductManage, BoxLayout.Y_AXIS));
			if(productTabbedPanel != null){
				pProductManage.removeAll();
			}
			productTabbedPanel = new ProductTabbedPanel();
			pProductManage.add(productTabbedPanel);
		}  else if(this.getTitleAt(selectedIndex).equals("거래처등록")){
			pCustomerInsert.setLayout(new BoxLayout(pCustomerInsert, BoxLayout.Y_AXIS));
			if(customerInsertTabbedPanel != null){
				pCustomerInsert.removeAll();
			}
			customerInsertTabbedPanel = new CustomerInsertTabbedPanel();
			pCustomerInsert.add(customerInsertTabbedPanel);
		}  else if(this.getTitleAt(selectedIndex).equals("거래처관리")){
			pCustomerManage.setLayout(new BoxLayout(pCustomerManage, BoxLayout.Y_AXIS));
			if(customerTabbedPanel != null){
				pCustomerManage.removeAll();
			}
			customerTabbedPanel = new CustomerTabbedPanel();
			pCustomerManage.add(customerTabbedPanel);
		}
		
	}

	

   
  
   
   
}