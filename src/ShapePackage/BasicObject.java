package ShapePackage;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 * UML基本物件的父類別
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
	 * 創造自己的物件路徑
	 * @return Path
	 */
	protected abstract GeneralPath creatPath();

	/**
	 * 設置物件名稱
	 * 
	 * @param na
	 */
	@Override
	public void setName(String na) {
		name = na;
	}

	/**
	 * 得到物件名稱
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
	 * 移動物件
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
	 * 創造物件，初始化路徑
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
	 * 開啟選取狀態
	 * 
	 */
	@Override
	public void setOnSelect() {
		onselect = true;
	}

	/**
	 * 取消選取狀態
	 * 
	 */
	@Override
	public void setOffSelect() {
		onselect = false;
	}

	/**
	 * 得到選取狀態
	 * 
	 * @return onselcet
	 */
	// @Override
	public boolean getSelectStatus() {
		return onselect;
	}

	/**
	 * 得到路徑
	 * 
	 * @return path
	 */
	protected GeneralPath getPath() {
		return path;
	}

	/**
	 * 創造物件路徑並產生port 的偵測路徑
	 * 
	 */
	protected void createPort() {
		for (int i = 0; i < 4; i++)
			myPort[i] = new Port(start, width, height, i);
	}

	/**
	 * 判斷該點在哪個port上，設置連結port的index
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
	 * 判斷該點是否在選取位置上，並把該點設為選取狀態
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
