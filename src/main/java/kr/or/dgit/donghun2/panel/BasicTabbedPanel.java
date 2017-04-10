package kr.or.dgit.donghun2.panel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BasicTabbedPanel extends JPanel{

   private JTabbedPane tabbedPane;
   private EmployeeTabbedPanel pEmployee;
   private EmployeeInsertTabbedPanel pEmployeeInsert;
   private ProductTabbedPanel pProduct;
   private CustomerTabbedPanel pCustomer;
   private ProductInsertTabbedPanel pProductInsert;
   private CustomerInsertTabbedPanel pCustomerInsert;

   public BasicTabbedPanel() {
      setLayout(new BorderLayout(0, 0));
      
      
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(100, 100, 574, 400);
      add(tabbedPane);
      
      pEmployeeInsert = new EmployeeInsertTabbedPanel();
      tabbedPane.addTab("영업사원등록", null, pEmployeeInsert, null);
      pEmployeeInsert.setLayout(new BoxLayout(pEmployeeInsert, BoxLayout.Y_AXIS));

      
      pEmployee = new EmployeeTabbedPanel();
      tabbedPane.addTab("영업사원관리", null, pEmployee, null);
      pEmployee.setLayout(new BoxLayout(pEmployee, BoxLayout.Y_AXIS));
      
      pProductInsert = new ProductInsertTabbedPanel();
      tabbedPane.addTab("제품등록", null, pProductInsert, null);
      pProductInsert.setLayout(new BoxLayout(pProductInsert, BoxLayout.Y_AXIS));
      
     
      pProduct = new ProductTabbedPanel();
      tabbedPane.addTab("제품관리", null, pProduct, null);
      pProduct.setLayout(new BoxLayout(pProduct, BoxLayout.Y_AXIS));

      pCustomerInsert = new CustomerInsertTabbedPanel();
      tabbedPane.addTab("거래처등록", null, pCustomerInsert, null);
      pCustomerInsert.setLayout(new BoxLayout(pCustomerInsert, BoxLayout.Y_AXIS));

      pCustomer = new CustomerTabbedPanel();
      tabbedPane.addTab("거래처관리", null, pCustomer, null);
      pCustomer.setLayout(new BoxLayout(pCustomer, BoxLayout.Y_AXIS));


 
    

   }

   
  
   
   
}