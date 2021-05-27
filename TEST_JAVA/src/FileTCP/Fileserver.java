package FileTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fileserver {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999); // 서버 소캣 생성
        System.out.println("서버 준비완료");
		 
		 Socket socket = serverSocket.accept(); //클라이언트접속 대기
	        System.out.println("소켓준비 완료");
		 
		 InputStream in = socket.getInputStream(); // 입력 스트림 얻기
		 DataInputStream dis = new DataInputStream(in); // InputStream에 데이터 값을 얻어온다.
		 
		 OutputStream out = socket.getOutputStream();
	     DataOutputStream dos = new DataOutputStream(out);
	     
	     String fileNameStr = dis.readUTF(); //클라이언트로부터 파일명얻기
	     System.out.println("사용자가 요청한 파일 :"+fileNameStr); //서버프로그램이 실행되는 컴퓨터에 파일폴더로 사용할 폴더 생성.
	     FileInputStream fin = new FileInputStream("J:\\A.txt");
	     while(true){ //FileInputStream을 통해 파일을 읽어들여서 소켓의 출력스트림을 통해 출력.
	            int data=fin.read();
	            if(data == -1) break;
	            dos.write(data);
	        }
	     fin.close(); // 35~39 닫기
	     dis.close();
	     dos.close();
	     socket.close();
	     serverSocket.close();
	}

}
