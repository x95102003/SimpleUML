package ContainerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ShapePackage.UmlGroup;
import ShapePackage.UmlShape;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private JMenu fileMenu;
	private JMenu editMenu;

	private JMenuItem menuItem[] = new JMenuItem[3];
	private String itemName[] = new String[] { "Group", "UnGroup",
			"change object name" };// Edit menu的物件

	public MenuBar() {
		// TODO Auto-generated constructor stub
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemName[i]);
			editMenu.add(menuItem[i]);
			menuItem[i].addActionListener(new menuAction());
		}
		add(fileMenu);
		add(editMenu);
	}

	/**
	 * 將輸入的名稱set至shape內
	 * 
	 */
	private void changeObjectName(String s) {
		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			if (shape.getSelectStatus())
				shape.setName(s);
		}
	}

	/**
	 *  將選取的shape解構
	 */
	private void deGroup() {

		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			// 判斷物件被選取
			if (shape.getSelectStatus()) {
				shape.remove();	//解group
				PaintPanel.getInstance().getList().remove(shape);//移除在畫布上的自己
				return;
			}
		}
	}

	/**
	 * 創造一個group
	 * 
	 */
	private void creatGroup() {
		// GroupObject gOb = new GroupObject(relation);
		UmlGroup group = new UmlGroup();
		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			if (shape.getSelectStatus()) {
				// 判斷是否所選物件是否存在於其中一個group內，則將其他物件加入至該group
				group.addShape(shape);
			}
		}
		group.CreateAccomplish();
		PaintPanel.getInstance().addShape(group);
	}
	/**
	 * 各menuItem 被選取時的動作
	 * @author smallwhite
	 *
	 */
	class menuAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String menuAction = e.getActionCommand();
			// action 判斷哪個item Name被選取
			if (menuAction == itemName[0])
				creatGroup(); // 群組化
			else if (menuAction == itemName[1])
				deGroup(); // 解組
			else {
				String input = JOptionPane
						.showInputDialog("change object name");
				if (input == null) // 按下取消會NULL，取消改名
					return;
				changeObjectName(input);
				PaintPanel.getInstance().repaint();
			}
		}

	}

}
