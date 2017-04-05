package kr.or.dgit.donghun2.panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.dgit.donghun2.table.ProductTable;

import java.awt.BorderLayout;

public class InquiryPanel extends JPanel {


   private JTabbedPane tabbedPane;

   public InquiryPanel() {
      setLayout(new BorderLayout(0, 0));
      
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      add(tabbedPane);
      
      EmployeeConditionPanel pEmpCon = new EmployeeConditionPanel();
      pEmpCon.setLayout(new BoxLayout(pEmpCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("영업사원현황", null, pEmpCon, null);
      
      ProductTable pProCon = new ProductTable();
      pProCon.setLayout(new BoxLayout(pProCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("제품현황", null, pProCon, null);
      
      CustomerConditionPanel pCusCon = new CustomerConditionPanel();
      pCusCon.setLayout(new BoxLayout(pCusCon, BoxLayout.Y_AXIS));
      tabbedPane.addTab("거래처현황", null, pCusCon, null);
      
      JPanel pEmpSellInfo = new JPanel();
      pEmpSellInfo.setLayout(new BoxLayout(pEmpSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("영업사원 별 거래 현황", null, pEmpSellInfo, null);
      
      JPanel pProSellInfo = new JPanel();
      pProSellInfo.setLayout(new BoxLayout(pProSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("제품 별 거래 현황", null, pProSellInfo, null);
      
      JPanel pCusSellInfo = new JPanel();
      pCusSellInfo.setLayout(new BoxLayout(pCusSellInfo, BoxLayout.Y_AXIS));
      tabbedPane.addTab("거래처 별 거래 현황", null, pCusSellInfo, null);
   }

}