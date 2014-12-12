package ModePackage;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

import ContainerPackage.PaintPanel;
import ShapePackage.UmlShape;

public class SelectMode extends Mode {
	private boolean selectStatus = false; //�O�_������Ҧ�
	private int onSelectIndex;  //�ثe�����shape index
	private Point releasePoint; //��}���y��
	private Point dragPoint;    //�I���즲���y��
	private UmlShape shape;     //�Ȧs��Shape

	public SelectMode() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * �I����Shape�h�]��������A�A�Y�L�h���ʧ@
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		shape = PaintPanel.getInstance().checkShape(e.getPoint());
		if (shape == null)
			return;
		else
			shape.setOnSelect();
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
		selectStatus = false;
		pressPoint = e.getPoint();
		dragPoint = e.getPoint();
		shape = PaintPanel.getInstance().checkShape(pressPoint);
		if (shape == null) {
			createSelectRange(pressPoint);
			selectStatus = true;
		} else {
			shape.setOnSelect();
		}
	}
	/**
	 * ����Ҧ��h�N����쪺Shape�]��������A�A
	 * �Y�D����Ҧ��h�N�I�����󭫳]�y�СC
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		releasePoint = e.getPoint();
		if (selectStatus) {
			PaintPanel.getInstance().selectRange = linkSelectRange(releasePoint);
			selectObject(PaintPanel.getInstance().selectRange);	
			return;
		}
		if (onSelectIndex != -1) {
			selectStatus = false;
			shape.move(releasePoint.x - dragPoint.x, releasePoint.y
					- dragPoint.y);
		}

	}
	/**
	 * ����Ҧ��h���Ϳ�����x��
	 * �Y�D����Ҧ��h�N�I�����󭫳]�y�СC
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (selectStatus)
			PaintPanel.getInstance().selectRange = linkSelectRange(e.getPoint());
		else
			shape.move(e.getPoint().x - dragPoint.x, e.getPoint().y
					- dragPoint.y);
		dragPoint = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void createSelectRange(Point p) {
		pressPoint = p;
	}

	/**
	 * �إߧ��㪺����x��
	 * 
	 * @param
	 * @return GeneralPath
	 */
	private GeneralPath linkSelectRange(Point p) {
		GeneralPath selectRange = new GeneralPath();
		releasePoint = p;
		int w = releasePoint.x - pressPoint.x;
		int h = releasePoint.y - pressPoint.y;
		selectRange.moveTo(pressPoint.x, pressPoint.y);
		selectRange.lineTo(pressPoint.x + w, pressPoint.y);
		selectRange.lineTo(pressPoint.x + w, pressPoint.y + h);
		selectRange.lineTo(pressPoint.x, pressPoint.y + h);
		selectRange.lineTo(pressPoint.x, pressPoint.y);
		return selectRange;
	}

	/**
	 * �P�_����O�_�b�ۤv�ԥX���x�Τ��A�O�h�i�J������A
	 * 
	 */
	private void selectObject(GeneralPath selectRange) {
		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			if (shape.isSurround(selectRange))
				shape.setOnSelect();
		}
		selectRange.reset();
	}
}
