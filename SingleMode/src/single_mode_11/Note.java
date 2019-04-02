package single_mode_11;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	// 노트 이미지
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	private int x, y; // 노트의 현재 위치
	private String noteType;

	public Note(int x, int y, String noteType) {
		this.x = x;
		this.y = y;
		this.noteType = noteType;
	}

	// 노트에 대한 이미지 그려주기
	public void screenDraw(Graphics2D g) {
		// 노트 타입이 "short"=짧은 노트
		if (noteType.equals("short")) {
			g.drawImage(noteBasicImage, x, y, null);
		}
		//긴 노트(가로가 긴 노트) 기본 노트의 폭이 100이므로 +100해서 두배 긴 노트
		else if(noteType.equals("long")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}
	}
	
	@Override
	public void run() {}

}
