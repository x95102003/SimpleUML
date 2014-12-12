package ShapePackage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import ContainerPackage.PaintPanel;


public class UmlGroup extends UmlShape {
	private ArrayList<UmlShape> shapeList;
	private boolean onSelect = false;

	public UmlGroup() {
		// TODO Auto-generated constructor stub
		shapeList = new ArrayList<UmlShape>();
	}
	/**
	 * �إ�Group�A�����e���W���lShape
	 */
	public void CreateAccomplish() {
		for (UmlShape shape : shapeList)
			PaintPanel.getInstance().getList().remove(shape);
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		for (UmlShape shape : shapeList)
			shape.paint(g);

	}

	@Override
	public UmlShape inSide(Point p) {
		// TODO Auto-generated method stub
		for (UmlShape shape : shapeList) {
			if (shape.inSide(p) != null) {
				return this;
			}
		}
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		while (!shapeList.isEmpty()) {
			PaintPanel.getInstance().addShape(
					shapeList.remove(shapeList.size() - 1));
		}
	}
	/**
	 * 
	 * @param s
	 */
	public void addShape(UmlShape s) {
		shapeList.add(s);
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		for (UmlShape shape : shapeList)
			shape.move(x, y);
	}

	@Override
	public void setOnSelect() {
		onSelect = true;
		for (UmlShape shape : shapeList)
			shape.setOnSelect();
	}

	@Override
	public void setOffSelect() {
		onSelect = false;
		for (UmlShape shape : shapeList)
			shape.setOffSelect();
	}

	@Override
	public boolean getSelectStatus() {
		return onSelect;
	}

	@Override
	public boolean isSurround(GeneralPath selectRange) {
		for (UmlShape shape : shapeList) {
			if (shape.isSurround(selectRange))
				return true;
		}

		return false;
	}

	@Override
	public int choosePort(int x, int y, UmlLine l, boolean arr, boolean create) {
		Point p = new Point(x, y);
		for (UmlShape shape : shapeList) {
			if (shape.inSide(p) != null) {
				return shape.choosePort(x, y, l, arr, create);
			}

		}
		return -1;
	}

	@Override
	public void setName(String name) {
		for (UmlShape shape : shapeList)
			shape.setName(name);
	}

}
