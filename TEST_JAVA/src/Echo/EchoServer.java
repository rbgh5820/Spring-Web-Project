package Echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket serverSocket; // 서버 소켓
	private BufferedReader br;// 클라이언트로부터 전달받은 메시지를 읽어올 버퍼 메모리
	private PrintWriter pw; // 클라이언트로 메세지를 보냄.
	private Socket clientSocket;
	

	public static void main(String[] args) {
		new EchoServer(); // 클래스 생성
	}
	public EchoServer() {
		init();
	}
	
	public void init() {
		try {
			serverSocket = new ServerSocket(9999); // 포트번호가 9999인 소켓 생성 
			System.out.println("Server is ready");
			System.out.println("connect client");
			
			clientSocket =serverSocket.accept(); // 클라이언트에서 보내오는 데이터 대기상태
			System.out.println("Client has accepted");
			
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			pw = new PrintWriter(clientSocket.getOutputStream());
			
			String readData=""; // 클라이언트로 부터 읽은 데이터를 저장할 공간.
			
			while(!(readData=br.readLine()).equals(null)) {
				System.out.println("from Client : "+readData);
				pw.println(readData); //읽은 메시지를 클라이언트에 다시보냄
				pw.flush();
			}
			clientSocket.close(); //클라이언트 소캣 닫기.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
