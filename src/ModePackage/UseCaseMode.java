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
	 * �гyUseCase �[�J�e����
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		BasicObject useCla = new UseClass(e.getPoint()); // �إ߷s�򥻪���
		PaintPanel.getInstance().addShape(useCla); // �[�JArrayList
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
