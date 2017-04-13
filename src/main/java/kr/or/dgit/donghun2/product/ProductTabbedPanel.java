package kr.or.dgit.donghun2.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
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
	
	private JButton PbtnDele;
	private JButton PbtnSearch;
	private ProductTable pProt;
	
	
	
	public ProductTabbedPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pProp = new ProductPanel();
		add(pProp);
		pbtn = new JPanel();
		add(pbtn);
		
		PbtnDele = new JButton("삭제");
		PbtnSearch = new JButton("검색");
		
		
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
	    
	      if (e.getSource() == PbtnDele) {
	         actionPerformedPBtnDele(e);
	      }
	      if (e.getSource() == PbtnSearch) {
	         actionPerformedPbtnSearch(e);
	      }
	}
	protected void setInit(){
		List<Product> product = pdao.getInstance().selectProductByAll();
		pProp.getpCode().setFocusable(true);
	}

	private void actionPerformedPbtnSearch(ActionEvent e) {
		  Product res = pdao.getInstance().selectProductByNo(pProp.getObject());
	      if(res.isIsexist()==false){
	    	  JOptionPane.showMessageDialog(null, "삭제된 제품입니다.");
	    	  pProp.clear();
	      }else if (res == null) {
	         JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
	      } else {
	         JOptionPane.showMessageDialog(null, res);
	         pProp.setObject(res);
	         pProp.clear();
	      }
	}



	private void actionPerformedPBtnDele(ActionEvent e) {
		Product res = pdao.getInstance().selectProductByNo(pProp.getObject());
		if(res.isIsexist()==false){
			JOptionPane.showMessageDialog(null, "이미 삭제된 제품입니다.");
			return;
		}else{ 
			if(JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?")==JOptionPane.YES_OPTION){
				int pRes = pdao.getInstance().deleteProduct(pProp.getObject());
			      if (pRes == 0) {
			         JOptionPane.showMessageDialog(null, "삭제불가");
			      } else {
			    	  JOptionPane.showMessageDialog(null, "삭제완료");
			    	  pProt.loadData();
				      pProp.clear();
			      }
	        
	    	  }
			
		}
		
		
	}

	
	public JButton getPbtnDele(){
		return PbtnDele;
	}
	public JButton getPbtnSearch(){
		return PbtnSearch;
	}

}
