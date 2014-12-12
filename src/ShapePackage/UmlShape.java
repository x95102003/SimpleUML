package ShapePackage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
/**
 * Shape�̤W�h�����O
 *  
 * @author smallwhite
 *
 */
public abstract class UmlShape {

	public UmlShape() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Shape�갵�e�ۤv����
	 * @param g
	 */
	public abstract void paint(Graphics2D g);
	/**
	 * �N�I�����y�жǤJ�A�^�Ǹ�Shape
	 * @param click
	 * @return shape
	 */
	public abstract UmlShape inSide(Point click);
	/**
	 * ���󲾰�
	 * @param x offset
	 * @param y offset
	 */
	public abstract void move(int x, int y);
	/**
	 * ����Shape
	 */
	public abstract void remove();
	/**
	 * �NShape�]�����
	 */
	public abstract void setOnSelect();
	/**
	 * �N��ܪ����|�ǤJ�AShape�^�ǬO�_�Q��� 
	 * @param select
	 * @return true|false
	 */
	public abstract boolean isSurround(GeneralPath select);
	/**
	 * �NShape�������
	 */
	public abstract void setOffSelect();
	/**
	 * �o��Shape�ثe��������A
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
