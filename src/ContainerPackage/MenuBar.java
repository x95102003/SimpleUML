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
			"change object name" };// Edit menu������

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
	 * �N��J���W��set��shape��
	 * 
	 */
	private void changeObjectName(String s) {
		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			if (shape.getSelectStatus())
				shape.setName(s);
		}
	}

	/**
	 *  �N�����shape�Ѻc
	 */
	private void deGroup() {

		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			// �P�_����Q���
			if (shape.getSelectStatus()) {
				shape.remove();	//��group
				PaintPanel.getInstance().getList().remove(shape);//�����b�e���W���ۤv
				return;
			}
		}
	}

	/**
	 * �гy�@��group
	 * 
	 */
	private void creatGroup() {
		// GroupObject gOb = new GroupObject(relation);
		UmlGroup group = new UmlGroup();
		for (UmlShape shape : PaintPanel.getInstance().getList()) {
			if (shape.getSelectStatus()) {
				// �P�_�O�_�ҿ磌��O�_�s�b��䤤�@��group���A�h�N��L����[�J�ܸ�group
				group.addShape(shape);
			}
		}
		group.CreateAccomplish();
		PaintPanel.getInstance().addShape(group);
	}
	/**
	 * �UmenuItem �Q����ɪ��ʧ@
	 * @author smallwhite
	 *
	 */
	class menuAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String menuAction = e.getActionCommand();
			// action �P�_����item Name�Q���
			if (menuAction == itemName[0])
				creatGroup(); // �s�դ�
			else if (menuAction == itemName[1])
				deGroup(); // �Ѳ�
			else {
				String input = JOptionPane
						.showInputDialog("change object name");
				if (input == null) // ���U�����|NULL�A������W
					return;
				changeObjectName(input);
				PaintPanel.getInstance().repaint();
			}
		}

	}

}
