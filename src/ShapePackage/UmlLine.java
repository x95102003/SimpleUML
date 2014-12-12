package ShapePackage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 * �Ҧ��u�q�������O
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
	 * �B��u�����|
	 * 
	 */
	public abstract void calcPath();

	/**
	 * �إ߰_�I
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
	 * �إ߲��I
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
	 * ���ʰ_�I
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
	 * ���ʲ��I
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
	 * �P�_�u�s����port�O����
	 * 
	 * @param n
	 */
	public void setPortLink(int n) {
		port[n] = true;
	}

	/**
	 * �e�X�u�����|
	 * 
	 * @param g
	 *            �W�h��ø�ϪO
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
