package Echo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPclient {
  static final int port = 9999;
    public static void main(String[] args) {
    	try {
    		//클라이언트 소캣 생성(본인 IP,Port)
    		Socket socket = new Socket("localhost",9999);
    		System.out.println("Console Port("+port+")로 접속을 시도합니다.");
    		
    		//데이터를 입력할 스트림을 얻어온다.
    		//stream은 socket의 값을 읽어온다.
    		InputStream stream = socket.getInputStream();
    		
    		
    		//BufferedReader br = new BufferedReader(new InputStreamReader(stream));
    		//InputStreamReader라는 생성자를 만들고 stream 값을 읽어온다.
    		//BufferedReader는 br이라는 생성자를 만들고 inputStreamReader의 값을 읽는다.
    		InputStreamReader inputStreamReader = new InputStreamReader(stream);
    		BufferedReader br = new BufferedReader(inputStreamReader);
    		
    		String response = br.readLine(); //String response는 br의 값을 사용
    		System.out.println("console 수신 response : "+response);
    		socket.close();//소캣을 닫는다
    		
    		System.exit(0); // 시스템 종료
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}