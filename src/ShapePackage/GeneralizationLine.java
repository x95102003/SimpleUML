package ShapePackage;
/**
 * 具有箭頭樣子的線段
 * 
 * @author smallwhite
 * 
 */
public class GeneralizationLine extends UmlLine {
	public GeneralizationLine()
	{
		super();
	}
	
	/**
	 * 建立箭頭式的線段
	 * 
	 */
	@Override
	public void calcPath() {
		// TODO Auto-generated method stub
		path.reset(); // 初始化路徑
		path.moveTo(start.x, start.y);
		if (port[0]) {
			path.lineTo(start.x - 16, start.y - 12);
			path.lineTo(start.x - 16, start.y + 12);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x - 16, start.y);
		} else if (port[1]) {
			path.lineTo(start.x + 12, start.y - 16);
			path.lineTo(start.x - 12, start.y - 16);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x, start.y - 16);
		} else if (port[2]) {
			path.lineTo(start.x + 16, start.y + 12);
			path.lineTo(start.x + 16, start.y - 12);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x + 16, start.y);
		} else {
			path.lineTo(start.x - 12, start.y + 16);
			path.lineTo(start.x + 12, start.y + 16);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x, start.y + 16);
		}
		path.lineTo(end.x, end.y);
	}

}
