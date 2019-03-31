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

		//실행하면 intro음악 자동 실행됨
		//mp3확장자를 실행하는 라이브러리
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

//더블 버퍼링-현재 프로그램의 전체화면에 맞는 이미지를 매 순간 생성하여 이미지를 갱신해줌
//버퍼에 이미지를 담아둠
