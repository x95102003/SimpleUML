package ModePackage;
import java.awt.event.MouseEvent;

import ContainerPackage.PaintPanel;
import ShapePackage.CompositionLine;
import ShapePackage.UmlLine;
import ShapePackage.UmlShape;


public class CompositeLineMode extends Mode {
	private UmlLine tempLine;

	public CompositeLineMode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		pressPoint=e.getPoint();
		UmlShape shape = PaintPanel.getInstance().checkShape(e.getPoint());
		if (shape == null)
			tempLine = null;
		else {
			firstShape = shape;
			tempLine = new CompositionLine();
			int portIndex = firstShape.choosePort(e.getX(), e.getY(), tempLine,
					true, false);
			tempLine.setPortLink(portIndex);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (tempLine == null)
			return;
		UmlShape shape = PaintPanel.getInstance().checkShape(e.getPoint());
		if (shape == null) {
			PaintPanel.getInstance().tempLine = tempLine = null;
			return;
		} else {
			shape.choosePort(e.getX(), e.getY(), tempLine,
					false, true);
			firstShape.choosePort(pressPoint.x, pressPoint.y, tempLine, true,
					true);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (tempLine != null) {
			PaintPanel.getInstance().tempLine = tempLine;
			tempLine.setEnd(e.getPoint());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
