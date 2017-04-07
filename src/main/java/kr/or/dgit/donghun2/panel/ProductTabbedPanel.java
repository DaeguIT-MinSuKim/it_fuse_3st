package kr.or.dgit.donghun2.panel;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.ProductService;
import kr.or.dgit.donghun2.table.ProductTable;

public class ProductTabbedPanel extends JPanel implements ActionListener{

	private ProductService pdao;
	private ProductPanel pProp;
	private JPanel pbtn;
	private JButton PbtnSave;
	private JButton PbtnDele;
	private JButton PbtnSearch;
	private ProductTable pProt;
	
	
	
	public ProductTabbedPanel() {
		pProp = new ProductPanel();
		add(pProp);
		pbtn = new JPanel();
		add(pbtn);
		PbtnSave = new JButton("저장");
		PbtnDele = new JButton("삭제");
		PbtnSearch = new JButton("검색");
		pbtn.add(PbtnSave);
		PbtnSave.addActionListener(this);
		PbtnDele.addActionListener(this);
		PbtnSearch.addActionListener(this);
		pbtn.add(PbtnDele);
		pbtn.add(PbtnSearch);
		pProt = new ProductTable();
		add(pProt);
		setInit();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	     if (e.getSource() == PbtnSave) {
	         actionPerformedPBtnSave(e);
	      }
	      if (e.getSource() == PbtnDele) {
	         actionPerformedPBtnDele(e);
	      }
	      if (e.getSource() == PbtnSearch) {
	         actionPerformedPbtnSearch(e);
	      }
	}
	protected void setInit(){
		List<Product> product = pdao.getInstance().selectProductByAll();
		
		String lastNum = product.get(product.size()-1).getCode();
		String value = String.format(setFormat(), Integer.parseInt(lastNum.substring(1))+1);
		pProp.getpCode().setTfValue(value);
		pProp.getpCode().setFocusable(true);
	}

	private String setFormat() {
		return "P%03d";
	}



	private void actionPerformedPbtnSearch(ActionEvent e) {
		  Product res = pdao.getInstance().selectProductByNo(pProp.getObject());
	      if (res == null) {
	         JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
	      } else {
	         JOptionPane.showMessageDialog(null, "검색하였습니다.");
	         pProp.setObject(res);
	      }
	}



	private void actionPerformedPBtnDele(ActionEvent e) {
		int res = pdao.getInstance().deleteProduct(pProp.getObject());
	      if (res == 0) {
	         JOptionPane.showMessageDialog(null, "삭제안댐");
	      } else {
	         JOptionPane.showMessageDialog(null, "삭제댐");
	         pProt.loadData();
	         pProp.clear();
	      }
	}



	private void actionPerformedPBtnSave(ActionEvent e) {
		if (pProp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백이 존재");
			return;
		}
		if (Integer.parseInt(pProp.getpSalePrice().getTfValue().toString()) <
				Integer.parseInt(pProp.getpOrigiPrice().getTfValue().toString()) || 
				Integer.parseInt(pProp.getpSalePrice().getTfValue().toString())==0 ||
				Integer.parseInt(pProp.getpOrigiPrice().getTfValue().toString())==0
				) {
			JOptionPane.showMessageDialog(null, "정가보다 원가가 클 수 없음");
			return;
		}
		String msg = "추가됨";
		Product item = pProp.getObject();

		if (pdao.getInstance().selectProductByNo(item) != null) {

			msg = "데이터가 이미 존재하므로 덮어씀";
		}
		pdao.getInstance().insertProduct(item);
		JOptionPane.showMessageDialog(null, msg);
		pProp.clear();
		pProt.loadData();
	}
	public JButton getPbtnSave(){
		return PbtnSave;
	}
	public JButton getPbtnDele(){
		return PbtnDele;
	}
	public JButton getPbtnSearch(){
		return PbtnSearch;
	}

}
