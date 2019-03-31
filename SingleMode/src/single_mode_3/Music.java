package single_mode_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player; //음악 관련 라이브러리
	private boolean isLoop;  //음악이 무한반복재생인지 한번재생인지 확인해주는 변수
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop; //변수 초기화
			file = new File(Main.class.getResource("../music/"+name).toURI()); //해당 name의 파일을 url로 위치를 가져옴
			//파일을 버퍼에 담에 읽어올 수 있게 함.
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//현재 실행되고 있는 음악이 얼마나의 시간이 실행됐는지
	//노트를 떨어뜨릴때 시간 분석
	public int getTime() {
		if (player == null) return 0;
		return player.getPosition();
	}
	
	//음악을 항상 종료시켜주는 함수
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
			}while(isLoop);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
