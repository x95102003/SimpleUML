package ModePackage;
import java.awt.event.MouseEvent;


import ContainerPackage.PaintPanel;
import ShapePackage.BasicObject;
import ShapePackage.UmlClass;

public class ClassMode extends Mode {

	public ClassMode() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 創造UmlClass 加入畫布中
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		BasicObject cla = new UmlClass(e.getPoint()); // 建立新基本物件
		PaintPanel.getInstance().addShape(cla); // 加入ArrayList
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
