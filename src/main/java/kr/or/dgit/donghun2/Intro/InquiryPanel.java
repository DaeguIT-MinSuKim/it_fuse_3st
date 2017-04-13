package kr.or.dgit.donghun2.Intro;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.dgit.donghun2.customer.CustomerConditionPanel;
import kr.or.dgit.donghun2.customer.CustomerSellInfoPanel;
import kr.or.dgit.donghun2.employee.EmployeeConditionPanel;
import kr.or.dgit.donghun2.employee.EmployeeSellInfoPanel;
import kr.or.dgit.donghun2.product.ProductConditionPanel;
import kr.or.dgit.donghun2.product.ProductSellInfoPanel;
import kr.or.dgit.donghun2.table.ProductTable;

public class InquiryPanel extends JPanel {


   private JTabbedPane tabbedPane;
   private EmployeeSellInfoPanel pEmpSellInfo;
   private CustomerSellInfoPanel pCusSellInfo;
   private ProductSellInfoPanel pProSellInfo;

   public InquiryPanel() {
      setLayout(new BorderLayout(0, 0));
      
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      add(tabbedPane);
      
      EmployeeConditionPanel pEmpCon = new EmployeeConditionPanel();
      pEmpCon.setLayout(new BoxLayout(pEmpCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("영업사원현황", null, pEmpCon, null);
      
      ProductConditionPanel pProCon = new ProductConditionPanel();
      pProCon.setLayout(new BoxLayout(pProCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("제품현황", null, pProCon, null);
      
      CustomerConditionPanel pCusCon = new CustomerConditionPanel();
      pCusCon.setLayout(new BoxLayout(pCusCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("거래처현황", null, pCusCon, null);
      
      pEmpSellInfo = new EmployeeSellInfoPanel();
      pEmpSellInfo.setLayout(new BoxLayout(pEmpSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("영업사원 별 거래 현황", null, pEmpSellInfo, null);
      
      pProSellInfo = new ProductSellInfoPanel();
      pProSellInfo.setLayout(new BoxLayout(pProSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("제품 별 거래 현황", null, pProSellInfo, null);
      
      pCusSellInfo = new CustomerSellInfoPanel();
      pCusSellInfo.setLayout(new BoxLayout(pCusSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("거래처 별 거래 현황", null, pCusSellInfo, null);
   }

}