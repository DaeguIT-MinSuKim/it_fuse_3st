package kr.or.dgit.donghun2.Product;

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

public class ProductInsertTabbedPanel extends JPanel implements ActionListener{

	private ProductService pdao;
	private ProductPanel pProp;
	private JPanel pbtn;
	private JButton PbtnSave;
	private ProductTable pProt;
	
	public ProductInsertTabbedPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pProp = new ProductPanel();
		add(pProp);
		pbtn = new JPanel();
		add(pbtn);
		PbtnSave = new JButton("저장");
		pbtn.add(PbtnSave);
		PbtnSave.addActionListener(this);
		pProt = new ProductTable();
		add(pProt);
		setInit();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	     if (e.getSource() == PbtnSave) {
	         actionPerformedPBtnSave(e);
	      }
	      
	}
	protected void setInit(){
		List<Product> product = pdao.getInstance().selectProductByAll();
		if(product.size()==0){
			pProp.getpCode().setTfValue("P001");
			pProp.getpCode().gettF().setEditable(false);
		}else{
		String lastNum = product.get(product.size()-1).getCode();
		String value = String.format(setFormat(), Integer.parseInt(lastNum.substring(1))+1);
		pProp.getpCode().setTfValue(value);
		pProp.getpCode().gettF().setEditable(false);
		}
	}

	private String setFormat() {
		return "P%03d";
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
		setInit();
	}
	public JButton getPbtnSave(){
		return PbtnSave;
	}

}
