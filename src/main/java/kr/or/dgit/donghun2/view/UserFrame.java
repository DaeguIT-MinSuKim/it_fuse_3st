package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.Intro.HomePanel;
import kr.or.dgit.donghun2.Intro.UnitAdvancedTabbedPanel;
import kr.or.dgit.donghun2.Intro.UnitBasicTabbedPanel;
import kr.or.dgit.donghun2.Intro.UnitHomePanel;
import kr.or.dgit.donghun2.Intro.UnitInquiryPanel;
import kr.or.dgit.donghun2.employeeChart.EmployeeChartPanel;
import kr.or.dgit.donghun2.main.MainProcess;

@SuppressWarnings("serial")
public class UserFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel pTabbedPane;
	private JTabbedPane tabbedPane;
	private JPanel pBtn;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btnHome;


	public UserFrame() {
		EmployeeChartPanel ecp = new EmployeeChartPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		pTabbedPane = new JPanel();
		pTabbedPane.setLayout(new BoxLayout(pTabbedPane, BoxLayout.Y_AXIS));
		contentPane.add(pTabbedPane, BorderLayout.CENTER);

		/*tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pTabbedPane.add(tabbedPane);*/
		
		UnitHomePanel uhp = new UnitHomePanel();
		pTabbedPane.add(uhp);
		
		
		pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.EAST);
		pBtn.setLayout(new GridLayout(0, 1, 10, 50));
		btn1 = new JButton("기초자료관리");
		btn2 = new JButton("판매관리");
		btn3 = new JButton("조회 현황");
		
		
		
		JPanel panel = new JPanel();
		JPanel pBtn2 = new JPanel();
		btnHome = new JButton("Home");
		btnHome.addActionListener(this);
		
		btn4 = new JButton("로그아웃");
		
		
		
		pBtn.add(btnHome);
		pBtn.add(btn1);
		btn1.addActionListener(this);
		pBtn.add(btn2);
		btn2.addActionListener(this);
		pBtn.add(btn3);
		btn3.addActionListener(this);
		
		
		
		pBtn.add(pBtn2);
		pBtn2.add(panel);
		pBtn2.setLayout(new BoxLayout(pBtn2, BoxLayout.Y_AXIS));
		pBtn2.add(btn4);
		btn4.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn3){
			actionPerformedbtn3(e);
		}
		if(e.getSource()== btn1){
			actionPerformedbtn1(e);
		}
		if(e.getSource() == btn2){
			actionPerformedbtn2(e);
		}
		if(e.getSource() == btn4){
			actionPerformedbtn4(e);
		}
		if(e.getSource() == btnHome){
			actionPerformedbtnHome(e);
		}
	}

	private void actionPerformedbtnHome(ActionEvent e) {
		pTabbedPane.removeAll();
		pTabbedPane.add(new UnitHomePanel());
		revalidate();
		repaint();
	}

	private void actionPerformedbtn4(ActionEvent e) {
		MainProcess mp = new MainProcess();
		if(JOptionPane.showConfirmDialog(null, "로그아웃하시겠습니까?","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
			mp.setVisible(true);
			this.setVisible(false);
		}
	}

	private void actionPerformedbtn2(ActionEvent e) {
		pTabbedPane.removeAll();
		pTabbedPane.add(new UnitAdvancedTabbedPanel());
		revalidate();
		repaint();
	}

	private void actionPerformedbtn1(ActionEvent e) {
		pTabbedPane.removeAll();
		pTabbedPane.add(new UnitBasicTabbedPanel());
		revalidate();
		repaint();
	}

	private void actionPerformedbtn3(ActionEvent e) {
		pTabbedPane.removeAll();
		pTabbedPane.add(new UnitInquiryPanel());
		revalidate();
		repaint();
	}
	

	
}
