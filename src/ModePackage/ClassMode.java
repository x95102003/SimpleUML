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
	 * �гyUmlClass �[�J�e����
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		BasicObject cla = new UmlClass(e.getPoint()); // �إ߷s�򥻪���
		PaintPanel.getInstance().addShape(cla); // �[�JArrayList
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
