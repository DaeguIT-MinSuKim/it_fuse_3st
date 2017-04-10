package kr.or.dgit.donghun2.panel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.donghun2.view.EmployeeView;

public class BasicTabbedPanel extends JTabbedPane implements ChangeListener{
	private JPanel pEmployeeInsert;
	private EmployeeTabbedPanel employeeTabbedPanel;
	
	
   public BasicTabbedPanel() {
	   addChangeListener(this);
	   pEmployeeInsert = new JPanel();
	     
	   addTab("영업사원등록", null, pEmployeeInsert, null);
	   pEmployeeInsert.setLayout(new BoxLayout(pEmployeeInsert, BoxLayout.Y_AXIS));
	      if(employeeTabbedPanel != null){
	         pEmployeeInsert.removeAll();
	      }
	      employeeTabbedPanel = new EmployeeTabbedPanel();
	      pEmployeeInsert.add(employeeTabbedPanel);

   }


@Override
public void stateChanged(ChangeEvent e) {
	
}

   
  
   
   
}