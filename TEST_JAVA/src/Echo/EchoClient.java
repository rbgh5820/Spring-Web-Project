package Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private Socket clientSocket; // 클라이언트 소켓
	private BufferedReader br; // 클라이언트로부터 전달받은 메시지를 읽어드릴 버퍼 메모리
	private PrintWriter pw; // 클라이언트로 메시지를 보냄
	private Scanner sc; // 데이터 입력
	
	public static void main(String[] args) {
		new EchoClient();
	}
	
	public EchoClient() {
		init();
	}
	
	public void init() {
		try {
			clientSocket =new Socket("127.0.0.1",9999); // 클라이언트 소캣 아이피,포트 생성후 서버연결
			System.out.println("Server Connect");
			
			br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //  
			pw = new PrintWriter(clientSocket.getOutputStream()); // 서버로 데이터를 전송
			
			sc = new Scanner(System.in); // 입력한 데이터를 읽는다
			
			String inputData =""; //입력 데이터 저장공간
			
			while(true) {
				System.out.print("to Server");
				String msg = sc.next(); // 보낼 내용을 읽고 서버로 보내는 코드.
				if(msg.equals("exit")) {
					break;
				}
				pw.println(msg);
				pw.flush();
				
				System.out.println("from server : "+br.readLine());
				// 서버에서 받은 데이터를 표기
			}
			clientSocket.close(); // exit를 누를시 소캣을 닫는다. 
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
