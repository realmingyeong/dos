package socketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {// 서버 생성

			ServerSocket serverSocket = new ServerSocket(9000);

			// client 접속 accept

			Socket socket = serverSocket.accept();

			// client가 보낸 데이터 출력

			BufferedReader bufReader =

					new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String message = bufReader.readLine();

			System.out.println("Message : " + message);

			// client에 데이터 전송

			BufferedWriter bufWriter =

					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			bufWriter.write("hello world");

			bufWriter.newLine();

			bufWriter.flush();

			socket.close();

			serverSocket.close();

			bufReader.close();

			bufWriter.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
