package ShapePackage;
public class CompositionLine extends UmlLine {
	public CompositionLine()
	{
		super();
	}
	/**
	 * 建立菱形式頭的線段
	 * 
	 */
	@Override
	public void calcPath() {
		// TODO Auto-generated method stub
		path.reset(); // 初始化路徑
		path.moveTo(start.x, start.y);
		if (port[0]) {
			path.lineTo(start.x - 16, start.y - 12);
			path.lineTo(start.x - 32, start.y);
			path.lineTo(start.x - 16, start.y + 12);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x - 32, start.y);
		} else if (port[1]) {
			path.lineTo(start.x + 12, start.y - 16);
			path.lineTo(start.x, start.y - 32);
			path.lineTo(start.x - 12, start.y - 16);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x, start.y - 32);
		} else if (port[2]) {
			path.lineTo(start.x + 16, start.y + 12);
			path.lineTo(start.x + 32, start.y);
			path.lineTo(start.x + 16, start.y - 12);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x + 32, start.y);
		} else {
			path.lineTo(start.x - 12, start.y + 16);
			path.lineTo(start.x, start.y + 32);
			path.lineTo(start.x + 12, start.y + 16);
			path.lineTo(start.x, start.y);
			path.moveTo(start.x, start.y + 32);
		}
		path.lineTo(end.x, end.y);
	}

}
