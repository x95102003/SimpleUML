package ShapePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 * �~��baseObject����UML useClass�򥻪���
 * 
 * @author smallwhite
 * 
 */
public class UseClass extends BasicObject {
	private Font font = new Font("Consolas", Font.BOLD, 20);

	public UseClass(Point p) {
		// TODO Auto-generated constructor stub
		super(p, 140, 100);
		setName("A");// ��l�ƸӪ���W
	}

	/**
	 * ��ꪺpath�A�ΨӧP�_port��m
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
	 * �e�r�b�ϤW
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
		g.drawOval(start.x, start.y, width, height);// �e���
		g.setColor(new Color(250, 110, 180)); // �]�C��
		g.fillOval(start.x + 1, start.y + 1, width - 2, height - 2);// �񺡾��
		g.setColor(Color.BLACK);
		paintString(g, getName());// �e�Xobject��name
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
