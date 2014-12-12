package ShapePackage;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 * UML�򥻪��󪺤����O
 * 
 * @author smallwhite
 * 
 */
public abstract class BasicObject extends UmlShape {
	protected Point start;
	protected int width;
	protected int height;
	private GeneralPath path;
	private boolean onselect = false;
	private String name;
	protected Port myPort[] = new Port[4];

	public abstract void paintString(Graphics2D g, String name);
	/**
	 * �гy�ۤv��������|
	 * @return Path
	 */
	protected abstract GeneralPath creatPath();

	/**
	 * �]�m����W��
	 * 
	 * @param na
	 */
	@Override
	public void setName(String na) {
		name = na;
	}

	/**
	 * �o�쪫��W��
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public BasicObject(Point p) {
		// TODO Auto-generated constructor stub
		start = p;
	}

	public BasicObject(Point p, int w, int h) {
		start=p;
		width = w;
		height = h;
		path=creatPath();
		createPort();
	}

	/**
	 * ���ʪ���
	 * 
	 * @param x1
	 * @param y1
	 */
	public void move(int x1, int y1) {
		start.x += x1;
		start.y += y1;
		path = creatPath();
		for (Port p : myPort)
			p.portMove(start);
	}

	/**
	 * �гy����A��l�Ƹ��|
	 * 
	 * @param w
	 * @param h
	 * 
	 */
	protected void creatObject(int w, int h) {
		width = w;
		height = h;
		path = creatPath();
		createPort();
	}

	/**
	 * �}�ҿ�����A
	 * 
	 */
	@Override
	public void setOnSelect() {
		onselect = true;
	}

	/**
	 * ����������A
	 * 
	 */
	@Override
	public void setOffSelect() {
		onselect = false;
	}

	/**
	 * �o�������A
	 * 
	 * @return onselcet
	 */
	// @Override
	public boolean getSelectStatus() {
		return onselect;
	}

	/**
	 * �o����|
	 * 
	 * @return path
	 */
	protected GeneralPath getPath() {
		return path;
	}

	/**
	 * �гy������|�ò���port ���������|
	 * 
	 */
	protected void createPort() {
		for (int i = 0; i < 4; i++)
			myPort[i] = new Port(start, width, height, i);
	}

	/**
	 * �P�_���I�b����port�W�A�]�m�s��port��index
	 * 
	 * @param x
	 * @param y
	 * @return portPoint || null
	 */
	@Override
	public int choosePort(int x, int y, UmlLine l, boolean arr, boolean create) {
		for (Port p : myPort) {
			if (p.inisdePort(x, y)) {
				p.linkLine(l, arr);
				p.createLine(create);
				return p.getIndex();
			}
		}
		return -1;
	}

	/**
	 * �P�_���I�O�_�b�����m�W�A�ç���I�]��������A
	 * 
	 * @param Point
	 * @return Shape
	 */
	@Override
	public UmlShape inSide(Point p) {
		if (path.contains(p))
			return this;
		return null;
	}

	@Override
	public void remove() {
	}

	@Override
	public boolean isSurround(GeneralPath selectRagne) {

		if (selectRagne.contains(start)
				&& selectRagne.contains(start.x + width, start.y + height))
			return true;

		return false;
	}
}
