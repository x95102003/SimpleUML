package ContainerPackage;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ModePackage.AssociateLineMode;
import ModePackage.ClassMode;
import ModePackage.CompositeLineMode;
import ModePackage.GeneralLineMode;
import ModePackage.Mode;
import ModePackage.SelectMode;
import ModePackage.UseCaseMode;

@SuppressWarnings("serial")
public class ToolList extends JList<ImageIcon> {
	private ImageIcon toolImage[] = new ImageIcon[6];// toolList image

	public ToolList() {
		for (int i = 0; i < toolImage.length; i++)
			toolImage[i] = new ImageIcon("images/" + i + ".png");
		setListData(toolImage);
		addListSelectionListener(new ImageListListener());
	}
	/**
	 * �гy�����Mode
	 * @param index of Mode
	 * @return
	 */
	private Mode createMode(int index) {
		Mode mode = null;
		switch (index) {
		case 0:
			mode = new SelectMode();
			break;
		case 1:
			mode = new AssociateLineMode();
			break;
		case 2:
			mode = new GeneralLineMode();
			break;
		case 3:
			mode = new CompositeLineMode();
			break;
		case 4:
			mode = new ClassMode();
			break;
		case 5:
			mode = new UseCaseMode();
			break;
		default:
			break;
		}
		return mode;
	}
/**
 * �P�_List���C��imageIcon�Q�I��������
 * @author smallwhite
 *
 */
	class ImageListListener implements ListSelectionListener {
		// �P�_Jlist����ƬO�_�Q����
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			// ��o���ܪ�index�A�ó]�m���e�O���A�C
			PaintPanel.getInstance().setMode(createMode(getSelectedIndex()));
		}

	}
}
