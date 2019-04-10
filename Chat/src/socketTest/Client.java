package socketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {// 서버 접속
			Socket socket = new Socket("127.0.0.1", 9000);

			// Server에 보낼 데이터
			BufferedWriter bufWriter =
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufWriter.write("hello world");
			bufWriter.newLine();
			bufWriter.flush();

			// Server가 보낸 데이터 출력
			BufferedReader bufReader =
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = bufReader.readLine();
			System.out.println("Message : " + message);
			socket.close();
			bufReader.close();
			bufWriter.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}