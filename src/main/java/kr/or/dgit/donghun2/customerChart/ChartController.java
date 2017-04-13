package kr.or.dgit.donghun2.customerChart;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.CustomerService;

//고객사별 주문 수량
public class ChartController implements Initializable{
   @FXML
   private BarChart<String, Integer> barChart;
   private List<Customer> customerNameList;
   private String[] arrayClientNames;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   customerNameList = CustomerService.getInstance().selectCustomerByAll();
      arrayClientNames = new String[customerNameList.size()];
      for(int i=0; i<customerNameList.size(); i++){
         arrayClientNames[i] = customerNameList.get(i).getName();
         System.out.println("Add Employee Name :" + arrayClientNames[i]);
      }
      
      int[] arrSaleAmount = createArraySaleAmount();
      //시리즈 생성
      XYChart.Series series = new XYChart.Series();
      for (int i = 0; i < arrSaleAmount.length; i++) {
         series.getData().add(new XYChart.Data<>(arrayClientNames[i], arrSaleAmount[i]));
         System.out.println("@@@@@@@@@@ 고객사: " + arrayClientNames[i] +" 판매량 : " + arrSaleAmount[i]);
      }
      
      barChart.getData().add(series);
   }

   private int[] createArraySaleAmount() {
      List<CalculatedValue> list = CalculatedValueService.getInstance().selectCalculatedValueByCustomerChart();
      int[] arraySaleAmount = new int[customerNameList.size()];
//
      for (int i=0; i< list.size(); i++){
         //인자로 받은 list의 i번째 인자의 수량과 클라이언트
         int amount = list.get(i).getSellprice();
         String clientName = list.get(i).getCustomer().getName();

         //client Name이 몇 번째 배열에 있는지 확인
         int idx = -1;
         for(int j=0; j<customerNameList.size(); j++){
            if(arrayClientNames[j].equals(clientName))
               idx = j;
         }
         System.out.println("인덱스 확인 : " + clientName + " : " + idx);

         //해당 client의 판매 수량 누적
         if(idx != -1){
            arraySaleAmount[idx] += amount;
            System.out.println("고객사: "+clientName +"  판매량: "+arraySaleAmount[idx]+"\n\n");
         }
      }
      return arraySaleAmount;
   }
}