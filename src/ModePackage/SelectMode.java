package ModePackage;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

import ContainerPackage.PaintPanel;
import ShapePackage.UmlShape;

public class SelectMode extends Mode {
	private boolean selectStatus = false; //是否為選取模式
	private int onSelectIndex;  //目前選取的shape index
	private Point releasePoint; //放開的座標
	private Point dragPoint;    //點擊拖曳的座標
	private UmlShape shape;     //暫存的Shape

	public SelectMode() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 點擊有Shape則設為選取狀態，若無則不動作
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
	 * 選取模式則將有選到的Shape設為選取狀態，
	 * 若非選取模式則將點擊物件重設座標。
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
	 * 選取模式則產生選取的矩形
	 * 若非選取模式則將點擊物件重設座標。
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
	 * 建立完整的選取矩形
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
	 * 判斷物件是否在自己拉出的矩形中，是則進入選取狀態
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
