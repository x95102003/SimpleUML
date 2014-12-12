package ContainerPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ModePackage.Mode;
import ShapePackage.UmlLine;
import ShapePackage.UmlShape;

/**
 * �e��
 * 
 * @author smallwhite
 * 
 */
public class PaintPanel extends JPanel {
	private ArrayList<UmlShape> shapeList = new ArrayList<UmlShape>();
	private static PaintPanel paintPanel;
	public UmlLine tempLine;	//�Ȧs�u�A
	public GeneralPath selectRange; //����d��
	private Mode currentMode;  //�ثemode
/**
 * SingleTon �غc�l
 */
	private PaintPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.white);
		setLayout(null);
		addMouseListener(new mouse());
		addMouseMotionListener(new mouseMotion());

	}
/**
 * ��o�e�B�A�Y��null�h�гy
 * @return paintPanel
 */
	public static PaintPanel getInstance() {
		if (paintPanel == null)
			paintPanel = new PaintPanel();
		return paintPanel;
	}
/**
 * ���ܵe��Mode���A
 * @param mode
 */
	public void setMode(Mode mode) {
		currentMode = mode;
	}

	/**
	 * �e��(Jpanel)�Q�I���ɪ��ʧ@
	 * 
	 * @author smallwhite
	 * 
	 */
	class mouse implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			setOffAll();
			if(currentMode!=null)
			currentMode.mouseClicked(e);
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setOffAll();
			if(currentMode!=null)
			currentMode.mousePressed(e);
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(currentMode!=null)
			currentMode.mouseReleased(e);
			repaint();
		}
	}

	class mouseMotion implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			if(currentMode!=null)
			currentMode.mouseDragged(e);
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 *  �N�Ҧ����󪺿�����p����
	 */
	public void setOffAll() {
		for (UmlShape b : shapeList) {
			b.setOffSelect();
		}
	}

	/**
	 *  �P�_�I����point�O�_�b�Y����W�A�^�ǸӪ���bList��index
	 * @param p
	 * @return �^�ǵe���W���Ӫ���A�Y�L�h�^��null
	 */
	public UmlShape checkShape(Point p) {
		if (shapeList.isEmpty())
			return null;
		for (UmlShape shape : shapeList) {
			if (shape.inSide(p) != null)
				return shape.inSide(p);
		}
		return null;
	}
	/**
	 * �o��e���W�Ҧ���Shape
	 * @return Vector
	 */
	public ArrayList<UmlShape> getList() {
		return shapeList;
	}
	/**
	 * �[�Jshape�ܵe���W
	 * @param shape
	 */
	public void addShape(UmlShape shape) {
		shapeList.add(shape);
	}

	/**
	 * �Ҧ���ø��
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(4); // �e���ʲ�
		g2d.setStroke(stroke);
		if (selectRange != null) {
			g2d.setColor(new Color(187, 255, 255, 150));
			g2d.fill(selectRange);
		}
		// ø�X�Ȯɪ�Line
		g2d.setColor(Color.black);
		if (tempLine != null)	
			tempLine.paint(g2d);
		for (UmlShape s : shapeList)
			s.paint(g2d);
	}

}
