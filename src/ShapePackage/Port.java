package ShapePackage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import ContainerPackage.PaintPanel;



/**
 * 基本物件下的port屬性類別
 * 
 * @author smallwhite
 * 
 */
public class Port {
	private GeneralPath checkRange; // port管理的range
	private Point obStart; // 物件的位置
	private int obWidth; // 物件的寬度
	private int obHeigh; // 物件的高度
	private int index; // port為第幾個
	private int pWidth = 6;
	private int pHeight = 6;
	private UmlLine line;
	private boolean arrow;
	private ArrayList<UmlLine> lineList = new ArrayList<UmlLine>();
	private ArrayList<Boolean> lineArrow = new ArrayList<Boolean>();

	public Port(Point obL, int obW, int obH, int i) {
		// TODO Auto-generated constructor stub
		obStart = obL;
		obWidth = obW;
		obHeigh = obH;
		index = i;
		checkRange = new GeneralPath();
		setPortRange();

	}

	/**
	 * 移動port的位置
	 * 
	 * 
	 */
	public void portMove(Point start) {
		obStart = start;
		Point portLocation = getLocation();
		for (int i = 0; i < lineList.size(); i++) {
			if (lineArrow.get(i))
				lineList.get(i).setStart(portLocation);
			else
				lineList.get(i).setEnd(portLocation);
		}
		setPortRange();
	}

	/**
	 * 設置不同port管理的range範圍
	 * 
	 */
	private void setPortRange() {
		Point center = new Point();
		center.x = ((4 * obStart.x) + 2 * obWidth) / 4;
		center.y = ((4 * obStart.y) + 2 * obHeigh) / 4;
		checkRange.reset();
		checkRange.moveTo(center.x, center.y);
		switch (index) {
		case 0:
			checkRange.lineTo(obStart.x, obStart.y);
			checkRange.lineTo(obStart.x, obStart.y + obHeigh);
			break;
		case 1:
			checkRange.lineTo(obStart.x, obStart.y);
			checkRange.lineTo(obStart.x + obWidth, obStart.y);
			break;
		case 2:
			checkRange.lineTo(obStart.x + obWidth, obStart.y);
			checkRange.lineTo(obStart.x + obWidth, obStart.y + obHeigh);
			break;
		case 3:
			checkRange.lineTo(obStart.x + obWidth, obStart.y + obHeigh);
			checkRange.lineTo(obStart.x, obStart.y + obHeigh);
			break;
		default:
			break;
		}
	}

	/**
	 * 獲得Port點的位置
	 * 
	 */
	public Point getLocation() {
		Point location = new Point();
		switch (index) {
		case 0:
			location.setLocation(obStart.x - 6, obStart.y + (obHeigh / 2) - 3);
			break;
		case 1:
			location.setLocation(obStart.x + (obWidth / 2) - 3, obStart.y - 6);
			break;
		case 2:
			location.setLocation(obStart.x + obWidth, obStart.y + (obHeigh / 2)
					- 3);
			break;
		case 3:
			location.setLocation(obStart.x + (obWidth / 2) - 3, obStart.y
					+ obHeigh);
			break;
		default:
			break;
		}
		return location;
	}
	/**
	 * 控制線段，設置線段連接位置
	 * @param l UmlLine
	 * @param arr direction of UmlLine
	 */
	public void linkLine(UmlLine l, boolean arr) {
		line = l;
		arrow = arr;
		if (arr) {
			line.setStart(getLocation());
		} else {
			line.setEnd(getLocation());
		}
	}
	/**
	 * 創造線段，加入至畫布上及自己的List內
	 * @param check if true 建立 else 清除
	 */
	public void createLine(boolean check) {
		if (check) {
			lineList.add(line);
			lineArrow.add(arrow);
			if (!arrow)
				PaintPanel.getInstance().addShape(line);
		} else {
			line = null;
			arrow = false;
		}
	}

	/**
	 * 獲得Port的index
	 * 
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * 畫出port
	 * @param g2d
	 */
	public void paintComponent(Graphics2D g2d) {
		g2d.drawRect(getLocation().x, getLocation().y, pWidth, pHeight);
	}

	/**
	 * 判斷點座標有無在此Port管理的range上
	 * 
	 * @return true或false
	 */
	public boolean inisdePort(int x, int y) {
		if (checkRange.contains(x, y))
			return true;
		return false;
	}
}
