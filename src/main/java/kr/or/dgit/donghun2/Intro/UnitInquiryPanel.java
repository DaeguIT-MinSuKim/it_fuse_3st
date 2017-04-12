package kr.or.dgit.donghun2.Intro;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.dgit.donghun2.Customer.CustomerConditionPanel;
import kr.or.dgit.donghun2.Customer.CustomerSellInfoPanel;
import kr.or.dgit.donghun2.Employee.EmployeeSellInfoPanel;
import kr.or.dgit.donghun2.Product.ProductSellInfoPanel;
import kr.or.dgit.donghun2.table.ProductTable;

public class UnitInquiryPanel extends JPanel {


   private JTabbedPane tabbedPane;
   private EmployeeSellInfoPanel pEmpSellInfo;
   private CustomerSellInfoPanel pCusSellInfo;
   private ProductSellInfoPanel pProSellInfo;

   public UnitInquiryPanel() {
      setLayout(new BorderLayout(0, 0));
      
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      add(tabbedPane);
      
      ProductTable pProCon = new ProductTable();
      pProCon.setLayout(new BoxLayout(pProCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("제품현황", null, pProCon, null);
      
      CustomerConditionPanel pCusCon = new CustomerConditionPanel();
      pCusCon.setLayout(new BoxLayout(pCusCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("거래처현황", null, pCusCon, null);
      
      pProSellInfo = new ProductSellInfoPanel();
      pProSellInfo.setLayout(new BoxLayout(pProSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("제품 별 거래 현황", null, pProSellInfo, null);
      
      pCusSellInfo = new CustomerSellInfoPanel();
      pCusSellInfo.setLayout(new BoxLayout(pCusSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("거래처 별 거래 현황", null, pCusSellInfo, null);
   }

}