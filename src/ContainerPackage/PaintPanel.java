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
 * 畫布
 * 
 * @author smallwhite
 * 
 */
public class PaintPanel extends JPanel {
	private ArrayList<UmlShape> shapeList = new ArrayList<UmlShape>();
	private static PaintPanel paintPanel;
	public UmlLine tempLine;	//暫存線，
	public GeneralPath selectRange; //選取範圍
	private Mode currentMode;  //目前mode
/**
 * SingleTon 建構子
 */
	private PaintPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.white);
		setLayout(null);
		addMouseListener(new mouse());
		addMouseMotionListener(new mouseMotion());

	}
/**
 * 獲得畫步，若為null則創造
 * @return paintPanel
 */
	public static PaintPanel getInstance() {
		if (paintPanel == null)
			paintPanel = new PaintPanel();
		return paintPanel;
	}
/**
 * 改變畫布Mode狀態
 * @param mode
 */
	public void setMode(Mode mode) {
		currentMode = mode;
	}

	/**
	 * 畫布(Jpanel)被點擊時的動作
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
	 *  將所有物件的選取狀況取消
	 */
	public void setOffAll() {
		for (UmlShape b : shapeList) {
			b.setOffSelect();
		}
	}

	/**
	 *  判斷點取的point是否在某物件上，回傳該物件在List的index
	 * @param p
	 * @return 回傳畫布上的該物件，若無則回傳null
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
	 * 得到畫布上所有的Shape
	 * @return Vector
	 */
	public ArrayList<UmlShape> getList() {
		return shapeList;
	}
	/**
	 * 加入shape至畫布上
	 * @param shape
	 */
	public void addShape(UmlShape shape) {
		shapeList.add(shape);
	}

	/**
	 * 所有的繪圖
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(4); // 畫筆粗細
		g2d.setStroke(stroke);
		if (selectRange != null) {
			g2d.setColor(new Color(187, 255, 255, 150));
			g2d.fill(selectRange);
		}
		// 繪出暫時的Line
		g2d.setColor(Color.black);
		if (tempLine != null)	
			tempLine.paint(g2d);
		for (UmlShape s : shapeList)
			s.paint(g2d);
	}

}
