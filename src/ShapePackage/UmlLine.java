package ShapePackage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 * 所有線段的父類別
 * 
 * @author smallwhite
 * 
 */
public abstract class UmlLine extends UmlShape {
	protected GeneralPath path;
	protected Point start;
	protected Point end;
	protected boolean port[] = new boolean[4];
	
	public UmlLine() {
		path = new GeneralPath();
	}
	/**
	 * 運算線的路徑
	 * 
	 */
	public abstract void calcPath();

	/**
	 * 建立起點
	 * 
	 * @param x
	 * @param y
	 */
	public void setStart(Point stP) {
		start = stP;
		if (end != null)
			calcPath();
	}

	/**
	 * 建立終點
	 * 
	 * @param p
	 *            point
	 */
	public void setEnd(Point enP) {
		end = enP;
		if (start != null)
			calcPath();
	}

	/**
	 * 移動起點
	 * 
	 * @param offsetX
	 * @param offsetY
	 */
	public void moveLineStart(int offsetX, int offsetY) {
		start.x += offsetX;
		start.y += offsetY;
		calcPath();
	}

	/**
	 * 移動終點
	 * 
	 * @param offsetX
	 * @param offsetY
	 */
	public void moveLineEnd(int offsetX, int offsetY) {
		end.x += offsetX;
		end.y += offsetY;
		calcPath();
	}

	/**
	 * 判斷線連接的port是哪個
	 * 
	 * @param n
	 */
	public void setPortLink(int n) {
		port[n] = true;
	}

	/**
	 * 畫出線的路徑
	 * 
	 * @param g
	 *            上層的繪圖板
	 */
	public void paint(Graphics2D g) {
		if (path != null) {
			g.draw(path);
		}
	}

	@Override
	public UmlShape inSide(Point p) {
		return null;
	}

	@Override
	public void move(int x, int y) {
	}

	@Override
	public void remove() {
	}

	@Override
	public void setOffSelect() {
	}

	@Override
	public void setOnSelect() {
	}

	@Override
	public boolean getSelectStatus() {
		return false;
	}

	@Override
	public boolean isSurround(GeneralPath s) {
		return false;
	}

	@Override
	public int choosePort(int x, int y, UmlLine l, boolean arr,boolean create) {
		return -1;
	}
	@Override
	public void setName(String s){
		
	}
}
