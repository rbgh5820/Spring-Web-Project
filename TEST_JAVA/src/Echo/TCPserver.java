package Echo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class TCPserver {
	static final int SERVER_PORT = 9999; // 서버 포트를 9999로 설정
	 public static void main(String[] args){
		 try {
			 //포트 번호를 사용하는 서버 소캣을 생성한다 클라이언트로부터의 요청을 기다림
			 ServerSocket serversocket = new ServerSocket(9999);
			 System.out.println("서버 : waiting for Client");
		 //서버의 유지를 위해 소켓 서버가 종료될때까지 while문으로 루프를 돌려준다.
	     while(true) {
	    	 
	    	 Socket socket = serversocket.accept(); //클라이언트로 소캣으로 부터 연결 대기
	    	 System.out.println("Console : "+socket.getInetAddress()+" 랑 "+socket.getLocalPort()+" 포트로 연결 됐습니다 ");
	     try {
	    	 //서버에서 클라이언트의 입력값을 받아들이고 클라이언트에 쏘아올린다.
	    	 OutputStream stream = socket.getOutputStream();
	    	 stream.write(new Date().toString().getBytes()); // 날짜를 받아와서 클라이언트에 출력한다.
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 socket.close(); // 소켓을 닫는다.
	    	 System.out.println("연결이 끊어졌습니다.");
	     }
	     }
	     //예외처리
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	}
}