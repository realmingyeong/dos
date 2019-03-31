package single_mode;

import javax.swing.JFrame;

public class SingleMode extends JFrame{
	
	public SingleMode() {
		setTitle("Singel Mode");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
