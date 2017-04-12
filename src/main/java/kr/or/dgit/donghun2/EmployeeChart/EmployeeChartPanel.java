package kr.or.dgit.donghun2.EmployeeChart;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class EmployeeChartPanel extends JPanel{
	private BorderPane rootLayout;
	
	public EmployeeChartPanel() {
		setLayout(new BorderLayout(0, 0));
		JFXPanel jfxPanel = new JFXPanel();
		add(jfxPanel,"Center");
		
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	            initFX(jfxPanel);
	        }
	   });
	}

    private void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

	private Scene createScene(){
		Scene scene = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(EmployeeChartPanel.class.getResource("EmployeeChartTab.fxml"));
			rootLayout = (BorderPane) loader.load();
			scene = new Scene(rootLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scene;
	}
}