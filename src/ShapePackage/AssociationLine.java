package ShapePackage;
/**
 * line下層的普通直線
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
	 * 算出直線的路徑
	 * 
	 */
	@Override
	public void calcPath() {
		// TODO Auto-generated method stub
		path.reset(); // 初始化路徑
		path.moveTo(start.x, start.y);
		path.lineTo(end.x, end.y);
	}
}
