package ContainerPackage;

import javax.swing.*;
import java.awt.*;

/**
 * �̰�panel ����List JmenuBar �H�εe��
 *
 * @author smallwhite
 */
@SuppressWarnings("serial")
public class BasePanel extends JPanel {
    private ToolList toolList;
    private MenuBar menuBar;

    public BasePanel(int width, int height) {
        toolList = new ToolList();    //tool
        menuBar = new MenuBar();    //Menu
        setBorder(BorderFactory.createLineBorder(Color.black));// �إ�border
        setSize(width, height);
        setLayout(new BorderLayout());
        add(toolList, BorderLayout.WEST);
        add(menuBar, BorderLayout.NORTH);
        add(PaintPanel.getInstance(), BorderLayout.CENTER);
    }
}
