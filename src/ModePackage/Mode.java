package ModePackage;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ShapePackage.UmlShape;


public abstract class Mode implements MouseListener,
		MouseMotionListener {
	protected Point pressPoint;	//ÂIÀ»®y¼Ð
	protected UmlShape firstShape; //¼È¦sShape
	public Mode() {
		// TODO Auto-generated constructor stub
	}
}
