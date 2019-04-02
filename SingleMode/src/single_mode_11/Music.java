package single_mode_11;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player; // ���� ���� ���̺귯��
	private boolean isLoop; // ������ ���ѹݺ�������� �ѹ�������� Ȯ�����ִ� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop; // ���� �ʱ�ȭ
			file = new File(Main.class.getResource("../music/" + name).toURI()); // �ش� name�� ������ url�� ��ġ�� ������
			// ������ ���ۿ� �㿡 �о�� �� �ְ� ��.
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ���� ����ǰ� �ִ� ������ �󸶳��� �ð��� ����ƴ���
	// ��Ʈ�� ����߸��� �ð� �м�
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}

	// ������ �׻� ��������ִ� �Լ�
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
