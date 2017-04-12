package kr.or.dgit.donghun2.customerChart;

import javax.swing.JFrame;

public class MainApp extends JFrame{
	public static void main(String[] args) {
		MainApp ma = new MainApp();
	}
	public MainApp(){
		setBounds(100,100,1000,1000);
		CustomerChartPanel vc = new CustomerChartPanel();
		add(vc);
		setVisible(true);
	}
}