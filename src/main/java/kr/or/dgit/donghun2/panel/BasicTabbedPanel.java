package kr.or.dgit.donghun2.panel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BasicTabbedPanel extends JPanel{

   private JTabbedPane tabbedPane;
   private SellInfoPanel pSellInfo;
   private EmployeeTabbedPanel pEmployee;
   private ProductTabbedPanel pProduct;
   private CustomerTabbedPanel pCustomer;

   public BasicTabbedPanel() {
      setLayout(new BorderLayout(0, 0));
      
      
      
      /*JPanel pBasic = new JPanel();
      add(pBasic);*/
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(100, 100, 574, 400);
      add(tabbedPane);
      /*pBasic.add(tabbedPane);*/
      
      pEmployee = new EmployeeTabbedPanel();
      tabbedPane.addTab("영업사원관리", null, pEmployee, null);
      pEmployee.setLayout(new BoxLayout(pEmployee, BoxLayout.Y_AXIS));

     

      pProduct = new ProductTabbedPanel();
      tabbedPane.addTab("제품관리", null, pProduct, null);
      pProduct.setLayout(new BoxLayout(pProduct, BoxLayout.Y_AXIS));

    

      pCustomer = new CustomerTabbedPanel();
      tabbedPane.addTab("거래처관리", null, pCustomer, null);
      pCustomer.setLayout(new BoxLayout(pCustomer, BoxLayout.Y_AXIS));


      pSellInfo = new SellInfoPanel();
      tabbedPane.addTab("거래내역관리", null, pSellInfo, null);
      pSellInfo.setLayout(new BoxLayout(pSellInfo, BoxLayout.Y_AXIS));

    

   }

   
  
   
   
}