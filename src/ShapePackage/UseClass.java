package ShapePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 * 繼承baseObject的的UML useClass基本物件
 * 
 * @author smallwhite
 * 
 */
public class UseClass extends BasicObject {
	private Font font = new Font("Consolas", Font.BOLD, 20);

	public UseClass(Point p) {
		// TODO Auto-generated constructor stub
		super(p, 140, 100);
		setName("A");// 初始化該物件名
	}

	/**
	 * 橢圓的path，用來判斷port位置
	 * 
	 */
	@Override
	public GeneralPath creatPath() {
		GeneralPath tpath = new GeneralPath();
		tpath.moveTo(start.x, start.y);
		tpath.lineTo(start.x + width, start.y);
		tpath.lineTo(start.x + width, start.y + height);
		tpath.lineTo(start.x, start.y + height);
		tpath.lineTo(start.x, start.y);
		return tpath;
	}

	/**
	 * 畫字在圖上
	 * 
	 */
	@Override
	public void paintString(Graphics2D g, String name) {
		g.setFont(font);
		if (name != null)
			g.drawString(name, start.x + width / 3, start.y + height / 2);
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawOval(start.x, start.y, width, height);// 畫橢圓
		g.setColor(new Color(250, 110, 180)); // 設顏色
		g.fillOval(start.x + 1, start.y + 1, width - 2, height - 2);// 填滿橢圓
		g.setColor(Color.BLACK);
		paintString(g, getName());// 畫出object的name
		if (getSelectStatus()) {
			// changePort();
			for (int i = 0; i < myPort.length; i++) {
				myPort[i].paintComponent(g);
				// g.drawRect(myPort[i].getLocation().x,
				// myPort[i].getLocation().y, pWidth, pHeight);
				// g.draw(portRange[i]);
			}
		}
	}
}
