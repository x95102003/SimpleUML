package ShapePackage;
/**
 * line�U�h�����q���u
 * 
 * @author smallwhite
 * 
 */
public class AssociationLine extends UmlLine {
	public AssociationLine()
	{
		super();
	}
	/**
	 * ��X���u�����|
	 * 
	 */
	@Override
	public void calcPath() {
		// TODO Auto-generated method stub
		path.reset(); // ��l�Ƹ��|
		path.moveTo(start.x, start.y);
		path.lineTo(end.x, end.y);
	}
}
