package single_mode_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SingleMode extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic;

	private Image Background;

	public SingleMode() {
		setTitle("Singel Mode");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Background = new ImageIcon(Main.class.getResource("../images/Background.jpg")).getImage();

		//�����ϸ� intro���� �ڵ� �����
		//mp3Ȯ���ڸ� �����ϴ� ���̺귯��
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background,0,0,null);
		this.repaint();
	}
}

//���� ���۸�-���� ���α׷��� ��üȭ�鿡 �´� �̹����� �� ���� �����Ͽ� �̹����� ��������
//���ۿ� �̹����� ��Ƶ�
