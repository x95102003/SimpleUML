package ContainerPackage;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new JFrame();
		frame.setSize(900, 700);
		BasePanel bgPanel = new BasePanel(frame.getWidth(), frame.getHeight()); //
		frame.getContentPane().add(bgPanel);
		frame.setLocationRelativeTo(null); // 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}