package ShapePackage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
/**
 * Shape最上層父類別
 *  
 * @author smallwhite
 *
 */
public abstract class UmlShape {

	public UmlShape() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Shape實做畫自己本身
	 * @param g
	 */
	public abstract void paint(Graphics2D g);
	/**
	 * 將點擊的座標傳入，回傳該Shape
	 * @param click
	 * @return shape
	 */
	public abstract UmlShape inSide(Point click);
	/**
	 * 物件移動
	 * @param x offset
	 * @param y offset
	 */
	public abstract void move(int x, int y);
	/**
	 * 移除Shape
	 */
	public abstract void remove();
	/**
	 * 將Shape設為選取
	 */
	public abstract void setOnSelect();
	/**
	 * 將選擇的路徑傳入，Shape回傳是否被選取 
	 * @param select
	 * @return true|false
	 */
	public abstract boolean isSurround(GeneralPath select);
	/**
	 * 將Shape取消選取
	 */
	public abstract void setOffSelect();
	/**
	 * 得到Shape目前選取的狀態
	 * @return
	 */
	public abstract boolean getSelectStatus();
	/**
	 * choose Shape's Port 
	 * @param x pressX
	 * @param y pressY
	 * @param l UML Line which create
	 * @param arr direction of Line
	 * @param create if createLine
	 * @return Port's index
	 */
	public abstract int choosePort(int x, int y, UmlLine l, boolean arr,boolean create);
	/**
	 * change Shape's Name
	 * @param s
	 */
	public abstract void setName(String s);
}
