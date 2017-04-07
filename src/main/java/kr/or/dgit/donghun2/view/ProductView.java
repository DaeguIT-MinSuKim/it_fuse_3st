package kr.or.dgit.donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.dao.CustomerMapper;
import kr.or.dgit.donghun2.dao.ProductMapper;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.panel.ProductPanel;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.ProductTable;

public class ProductView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSave;
	private JButton btnDele;
	private JButton btnSearch;
	private ProductPanel pProduct;
	private ProductTable pTable;

	private static ProductService dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pProduct = ProductPanel.getInstance();
		contentPane.add(pProduct);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);

		btnDele = new JButton("삭제");
		btnDele.addActionListener(this);
		pBtn.add(btnDele);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);

		pTable = new ProductTable();
		contentPane.add(pTable);
		pTable.setVisible(true);

		pProduct.clear();
		setinit();
	}

	public static void setDao(ProductService dao) {
		ProductView.dao = dao;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnDele) {
			actionPerformedBtnDele(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}

	protected void actionPerformedBtnSave(ActionEvent e) {
		if (pProduct.isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백이 존재");
		} else {
			if (pProduct.getObject().getCode() != null) {
				Product pRes = pProduct.getObject();
				String pcode = pRes.getCode();
				boolean ok = Pattern.matches("^P[0-9]{3}$", pcode);
				if (ok == true) {
					if (Integer.parseInt(pProduct.getpSalePrice().getTfValue().toString()) < Integer
							.parseInt(pProduct.getpOrigiPrice().getTfValue().toString())) {
						JOptionPane.showMessageDialog(null, "정가보다 원가가 클 수 없음");
						return;
					}
					String msg = "추가됨";
					Product item = pProduct.getObject();

					if (dao.getInstance().selectProductByNo(item) != null) {

						msg = "데이터가 이미 존재하므로 덮어씀";
					}
					dao.getInstance().insertProduct(item);
					JOptionPane.showMessageDialog(null, msg);
					pProduct.clear();
					pTable.loadData();
					setinit();
				}
			}
		}

		if (Integer.parseInt(pProduct.getpSalePrice().getTfValue().toString()) <
				Integer.parseInt(pProduct.getpOrigiPrice().getTfValue().toString())) {
			JOptionPane.showMessageDialog(null, "정가보다 원가가 클 수 없음");
			return;
		}
		String msg = "추가됨";
		Product item = pProduct.getObject();

		if (dao.getInstance().selectProductByNo(item) != null) {

			msg = "데이터가 이미 존재하므로 덮어씀";
		}
		dao.getInstance().insertProduct(item);
		JOptionPane.showMessageDialog(null, msg);
		pProduct.clear();
		pTable.loadData();
	}

	private void setinit() {
	      List<Product> products = dao.getInstance().selectProductByAll();
	      products.get(products.size() - 1).getCode();
	      String value = String.format(setNoFormat(),
	            Integer.parseInt(products.get(products.size() - 1).getCode().substring(1)) + 1);
	     pProduct.getpCode().setTfValue(value);
	     pProduct.getpCode().gettF().setFocusable(true);
	   }
	
	protected String setNoFormat() {
		return "P%03d";
	}
	
	protected void actionPerformedBtnDele(ActionEvent e) {
		if (pProduct.getpCode().isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백이 존재");
			return;
		}
		Product item = pProduct.getObject();
		if (dao.getInstance().deleteProduct(item) == 0) {
			JOptionPane.showMessageDialog(null, "삭제할 데이터 없음");
		} else {
			JOptionPane.showMessageDialog(null, "삭제 되었습니다");
		}
		pProduct.clear();
		pTable.loadData();
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		Product res = dao.getInstance().selectProductByNo(pProduct.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pProduct.setObject(res);
		}
	}
}
