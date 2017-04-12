package kr.or.dgit.donghun2.Employee;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

import erp_myframework.ComboPanel;
import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Employee;

public class EmployeePanel extends JPanel{
	private static final EmployeePanel instance = new EmployeePanel();
	public static EmployeePanel getInstance() {return instance;}
	
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private ComboPanel<String> pGrade;

	public EmployeePanel() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("사원코드");
		add(pCode);
		
		pName = new TextFiledPanel();
		pName.setTitle("사 원 명");
		add(pName);
		
		Vector<String> list = new Vector<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		pGrade = new ComboPanel();
		pGrade.setTitle("사원등급");
		pGrade.setcomboData(list);
		add(pGrade);

	}
	public TextFiledPanel getpCode() {
		return pCode;
	}
	public TextFiledPanel getpName() {
		return pName;
	}
	public ComboPanel<String> getpGrade() {
		return pGrade;
	}
	public Employee getObject(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		String grade = (String) pGrade.getSelectItem();
		return new Employee(code, name,grade);
	}
	public void setObject(Employee item){
		pCode.setTfValue(item.getCode());
		pName.setTfValue(item.getName());
		pGrade.setSelectedItem(item.getGrade());
	//	pName.gettF().setEditable(false); 	//이거하면 공백존재한다고 뜸.
	//	pGrade.setEnabled(false);	// 어캐 setEnabled 수정못하게 disable하지..

	}
	public void clear(){
		pCode.setTfValue("");
		pName.setTfValue("");
		pGrade.setSelectedItem("");;
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





