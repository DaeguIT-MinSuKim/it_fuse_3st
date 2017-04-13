package kr.or.dgit.donghun2.Intro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.initSetting.InitSettingService;

public class UnitHomePanel extends JPanel{
	
	private JButton bBackup;
	private JButton bInit;
	private JButton bRestore;
	private InitSettingService initSettingService;
	
	public UnitHomePanel() {
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel pHello = new JPanel();
		add(pHello);
		String path = "icon/Hello.jpg";
	    JPanel pImage = new JPanel(new BorderLayout());
	    JLabel label = new JLabel(new ImageIcon(path));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    pImage.add(label);
	    pHello.add(pImage);
		
	}

	
}
