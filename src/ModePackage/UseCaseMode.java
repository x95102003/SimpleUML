package ModePackage;
import java.awt.event.MouseEvent;

import ContainerPackage.PaintPanel;
import ShapePackage.BasicObject;
import ShapePackage.UseClass;


public class UseCaseMode extends Mode {

	public UseCaseMode() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 創造UseCase 加入畫布中
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		BasicObject useCla = new UseClass(e.getPoint()); // 建立新基本物件
		PaintPanel.getInstance().addShape(useCla); // 加入ArrayList
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
