package kr.or.dgit.donghun2.chart;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends JFrame{
	public static void main(String[] args) {
		MainApp ma = new MainApp();
	}
	public MainApp(){
		setBounds(100,100,1000,1000);
		ViewChart vc = new ViewChart();
		add(vc);
		setVisible(true);
	}
}