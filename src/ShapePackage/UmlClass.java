package ShapePackage;

import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * �~��baseObject��UML class�򥻪���
 *
 * @author smallwhite
 */
public class UmlClass extends BasicObject {
    private Font font = new Font("Consolas", Font.BOLD, 20);

    public UmlClass(Point p) {
        super(p, 120, 90);
        setName("B");// ��l�ƪ���W��
    }

    /**
     * ����class�����|�A
     */
    @Override
    public GeneralPath creatPath() {
        GeneralPath tpath = new GeneralPath();
        tpath.moveTo(start.x, start.y);
        tpath.lineTo(start.x + width, start.y);
		tpath.lineTo(start.x + width, start.y + height);
        tpath.lineTo(start.x, start.y + height);
        tpath.lineTo(start.x, start.y);
        tpath.moveTo(start.x, start.y + (height / 3));
        tpath.lineTo(start.x + width, start.y + (height / 3));
        tpath.moveTo(start.x, start.y + (2 * height / 3));
        tpath.lineTo(start.x + width, start.y + (2 * height / 3));
        return tpath;
    }

    @Override
    public void paintString(Graphics2D g, String name) {
        g.setFont(font);
        if (name != null)
            g.drawString(name, start.x + width / 3, start.y + height / 3 - 5);
    }

    @Override
    public void paint(Graphics2D g) {
        // TODO Auto-generated method stub
        g.setColor(Color.blue);
        g.draw(getPath()); // �e�Xobject�A�a���|
        g.setColor(Color.black);
        paintString(g, getName());
        if (getSelectStatus()) {
            // �e�Xport��m
            for (int i = 0; i < myPort.length; i++) {
                myPort[i].paintComponent(g);
                // g.drawRect(myPort[i].getLocation().x,myPort[i].getLocation().y,pWidth,pHeight);
                // g.drawRect(port[i].x, port[i].y, pWeight, pHeight);
                // g.draw(portRange[i]);
            }
        }
    }

}
